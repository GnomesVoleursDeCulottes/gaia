/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gaia.controller;

import gaia.entity.Chevre;
import gaia.entity.Joueur;
import gaia.service.ChevreServiceCRUD;
import gaia.service.JoueurServiceCRUD;
import gaia.service.LuneService;
import java.util.List;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/*
 *
 * @author admin
 */
@Controller
public class JoueurController {

    @Autowired
    private JoueurServiceCRUD service;
    @Autowired
    private ChevreServiceCRUD serviceChevre;

    @Autowired
    private LuneService serviceLune;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String ajouterGET(Model model, HttpSession s) {
        if (s != null) {
            s.invalidate();
        }

        model.addAttribute("JoueurAttr", new Joueur());
        return "index.jsp";
    }

    @RequestMapping(value = "/dashboard", method = RequestMethod.POST)
    public String ajouterMdp(@ModelAttribute("JoueurAttr") Joueur joueur, HttpSession s) {

        Joueur leJoueur = service.findOneByLogin(joueur.getLogin());
        if (leJoueur == null) {

            //ajouter valeur de départ dépendant des cycles
            leJoueur = joueur;
            Chevre chevre = new Chevre();

            Long laLune = serviceLune.getLune();
            leJoueur.setProchainRepas(laLune + 4L);
            chevre.setProchainAll(laLune);
            service.save(leJoueur);
            chevre.setLeJoueur(leJoueur);
            serviceChevre.save(chevre);
            leJoueur.getChevres().add(chevre);
            service.save(leJoueur);

        } else if (!leJoueur.getMdp().equals(joueur.getMdp())) {
            throw new RuntimeException("Vous avez entré un mauvais mot de passe, le système vous réclamera 5 euro ===> Cordialement");

        }
        s.setAttribute("idUser", leJoueur.getId());

        return "redirect:/dashboard";
    }

    @RequestMapping(value = "/dashboard", method = RequestMethod.GET)
    public String jeu(Model model, HttpSession s) {
        Long joueur = (Long) s.getAttribute("idUser");
        model.addAttribute("joueur", service.findOne(joueur));
        model.addAttribute("lune", serviceLune.getLune());
        return "gaiaDashboard.jsp";
    }

    @RequestMapping(value = "/classement", method = RequestMethod.GET)
    public String classement(Model model) {

        model.addAttribute("lesJoueurs", service.findAllByOrderByQuantiteBleDesc());
        return "classement.jsp";
    }

    @RequestMapping(value = "/ressource", method = RequestMethod.GET)
    public String ressources(Model model, HttpSession s) {
        Long joueur = (Long) s.getAttribute("idUser");
        model.addAttribute("joueur", service.findOne(joueur));
        return "_ressource.jsp";
    }
}

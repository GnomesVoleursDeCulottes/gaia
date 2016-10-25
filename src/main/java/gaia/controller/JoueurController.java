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
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

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
        model.addAttribute("chevrePourManger", serviceChevre.findAllByLeJoueurIdAndProchainRepas(joueur, serviceLune.getLune()));
        model.addAttribute("nbChevresReprod", serviceChevre.countByLeJoueurIdAndProchaineGestationLessThan(joueur, serviceLune.getLune() + 1L));
        return "_ressource.jsp";
    }

    @RequestMapping(value = "/materniter", method = RequestMethod.GET)
    public String materniter(Model model, HttpSession s) {
        Long joueur = (Long) s.getAttribute("idUser");
        model.addAttribute("chevreauxJoueur", service.findOne(joueur).getChevraux());
        return "_materniter.jsp";
    }

    @RequestMapping(value = "/plantation", method = RequestMethod.GET)
    public String plantation(Model model, HttpSession s) {
        Long joueur = (Long) s.getAttribute("idUser");
        model.addAttribute("ble", service.findOne(joueur).getBlePlante());
        model.addAttribute("carotte", service.findOne(joueur).getCarottePlantee());
        return "_plantation.jsp";
    }

    @RequestMapping(value = "/cycle", method = RequestMethod.GET)
    public String cycle(Model model, HttpSession s) {
        Long joueur = (Long) s.getAttribute("idUser");
        model.addAttribute("lune", serviceLune.getLune());
        return "_cycle.jsp";
    }

    @RequestMapping(value = "/sous_menu", method = RequestMethod.GET)
    public String sousMenu(Model model, HttpSession s) {
        Long idUser = (Long) s.getAttribute("idUser");
        Joueur joueur = service.findOne(idUser);
        model.addAttribute("lune", serviceLune.getLune());
        model.addAttribute("prochainRepas", (4L - (joueur.getProchainRepas() - serviceLune.getLune())));
        model.addAttribute("affiche", serviceLune.getLune() == joueur.getProchainRepas());
        String tab = "";

        if (joueur.getQuantiteBle() > 2) {
            tab += "<input type=\"button\" value=\"Manger blé\" onclick=\"seNourrir('ble')\"/>\n";
        }
        if (joueur.getQuantiteCarotte() > 1) {
            tab += "<input type=\"button\" value=\"Manger carotte\" onclick=\"seNourrir('carotte')\"/>\n";
        }
        if (joueur.getQuantiteFromage() > 1) {
            tab += "<input type=\"button\" value=\"Manger fromage\" onclick=\"seNourrir('fromage')\"/>\n";
        }
        if (joueur.getChevres().size() > 0) {
            tab += "<input type=\"button\" value=\"Manger chévre\" onclick=\"seNourrir('chevre')\"/>\n";
        }

        model.addAttribute("dispo", tab);
        return "_sous_menu.jsp";
    }

    @RequestMapping(value = "/banque", method = RequestMethod.GET)
    public String banque(Model model, HttpSession s) {
        Long joueur = (Long) s.getAttribute("idUser");
        model.addAttribute("joueur", service.findOne(joueur));
        model.addAttribute("nbChevres" ,serviceChevre.countByLeJoueurId(joueur));
        return "_banque.jsp";
    }
    
    @RequestMapping(value = "/reproduction/{nbBebe}", method = RequestMethod.POST)
    @ResponseBody
    public String reproduction(HttpSession s, @PathVariable("nbBebe") Long nbBebe) {
        Long leJoueur = (Long) s.getAttribute("idUser");
        serviceLune.faireSeReproduire(leJoueur, nbBebe);
        return "";
    }

    @RequestMapping(value = "/nourrirChevre/{nbANourrir}", method = RequestMethod.POST)
    @ResponseBody
    public String nourrirChevre(HttpSession s, @PathVariable("nbANourrir") Long nbANourrir) {
        Long leJoueur = (Long) s.getAttribute("idUser");
        serviceLune.nourrir(leJoueur, nbANourrir);
        return "";

    }

    @RequestMapping(value = "/seNourrir/{leRepas}", method = RequestMethod.POST)
    @ResponseBody
    public String seNourrir(HttpSession s, @PathVariable("leRepas") String leRepas) {
        Long leJoueur = (Long) s.getAttribute("idUser");
        serviceLune.seNourrir(leJoueur, leRepas);
        return "";
    }

    @RequestMapping(value = "/planterBle/{nbPlante}", method = RequestMethod.POST)
    @ResponseBody
    public String planterBle(HttpSession s, @PathVariable("nbPlante") Long nbPlante) {
        Long leJoueur = (Long) s.getAttribute("idUser");
        serviceLune.planterBle(leJoueur, nbPlante);
        return "";
    }

    @RequestMapping(value = "/planterCarotte/{nbPlante}", method = RequestMethod.POST)
    @ResponseBody
    public String planterCarotte(HttpSession s, @PathVariable("nbPlante") Long nbPlante) {
        Long leJoueur = (Long) s.getAttribute("idUser");
        serviceLune.planterCarotte(leJoueur, nbPlante);
        return "";
    }

    @RequestMapping(value = "/banque/{transa}", method = RequestMethod.POST)
    @ResponseBody
    public String echange(HttpSession s, @PathVariable("transa") String transa) {
        Long joueur = (long) s.getAttribute("idUser");
        serviceLune.echange(joueur, transa);
        
        return "";
    }
}

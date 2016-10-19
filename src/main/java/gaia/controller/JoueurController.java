/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gaia.controller;

import gaia.entity.Joueur;
import gaia.service.JoueurServiceCRUD;
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

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String ajouterGET(Model model) {
        model.addAttribute("JoueurAttr", new Joueur());
        return "index.jsp";
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public String ajouterMdp(@ModelAttribute("nouveauJoueur") Joueur joueur, HttpSession s) {

        Joueur leJoueur = service.findOneByLogin(joueur.getLogin());
        if (leJoueur == null){
            
            //ajouter valeur de départ dépendant des cycles
            leJoueur = joueur;
            service.save(leJoueur);
            
        }
           
        s.setAttribute("idUser", leJoueur.getId());
        
        return "index.jsp";
    }
    
    @RequestMapping(value = "/jeu", method = RequestMethod.GET)
    public String jeu(){
        return "gaiaDashboard.jsp";
    }
}

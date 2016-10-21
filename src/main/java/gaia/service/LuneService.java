/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gaia.service;

import gaia.entity.Chevre;
import gaia.entity.Joueur;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

/**
 *
 * @author admin
 */
@Service
public class LuneService {

    private long lune = 0;
    @Autowired
    private JoueurServiceCRUD service;
    @Autowired
    private ChevreServiceCRUD serviceChevre;

    @Scheduled(fixedDelay = 10000)
    public void incrementeLune() {
        lune++;
        System.out.println("*** FIN LUNE : " + (lune - 1L) + " ***");
        cycleDeVie();
        System.out.println("*** CYCLE LUNE : " + lune + " OK ***");

    }

    public long getLune() {
        return lune;
    }

    private void cycleDeVie() {
        //parcours tous les joueurs
        List<Joueur> lesJoueurs = service.findAll();
        for (Joueur joueur : lesJoueurs) {
            List<Chevre> toSup = new ArrayList<>();
            ////Mort
            //Fin de partie
            if (joueur.getProchainRepas() < lune) {
                ////?????
            }
            //Mort chévre + fromage
            for (Chevre chevre : joueur.getChevres()) {
                if (chevre.getProchainRepas() < lune) {
                    toSup.add(chevre);
                } else if (chevre.getProchainFromage() == lune) {
                    chevre.setProchainFromage(lune + 6L);
                    joueur.setQuantiteFromage(joueur.getQuantiteFromage() + 2L + (long) Math.floor(Math.random() * 2));
                }
            }
            ////Naissance (sauf fromage)
            //Recolte Blé
            if (joueur.getBlePlante().containsKey(lune)) {
                Long nouvelle = (long) Math.floor((joueur.getBlePlante().get(lune)) * (3d + Math.random()));
                joueur.setQuantiteBle(joueur.getQuantiteBle() + nouvelle);
                joueur.getBlePlante().remove(lune);
            }

            //Recolte Carotte
            if (joueur.getCarottePlantee().containsKey(lune)) {
                Long nouvelle = (long) Math.floor((joueur.getCarottePlantee().get(lune)) * (2d + Math.random()));
                joueur.setQuantiteCarotte(joueur.getQuantiteCarotte() + nouvelle);
                joueur.getCarottePlantee().remove(lune);
            }
            //Maturation Chevraux
            if (joueur.getChevraux().containsKey(lune)) {
                for (long i = 0L; i < joueur.getChevraux().get(lune); i++) {
                    Chevre nouvelleChevre = new Chevre();
                    nouvelleChevre.setLeJoueur(joueur);
                    nouvelleChevre.setProchainAll(lune);
                    serviceChevre.save(nouvelleChevre);
                    joueur.getChevres().add(nouvelleChevre);
                }
                joueur.getChevraux().remove(lune);
            }
            //Pour éviter une erreur (supprimer un élément de la liste parcouru)
            //corriger avec it ?
            for (Chevre chevre : toSup) {
                serviceChevre.delete(chevre);
                joueur.getChevres().remove(chevre);
            }
            service.save(joueur);
        }
    }

    public void planterBle(Long idJoueur, Long nbPlante) {
        Joueur leJoueur = service.findOne(idJoueur);

        leJoueur.setQuantiteBle(leJoueur.getQuantiteBle() - nbPlante);
        Long dejaPlante = 0L;
        if (leJoueur.getBlePlante().containsKey(lune + 6L)) {
            dejaPlante = leJoueur.getBlePlante().get(lune + 6L);
        }
        leJoueur.getBlePlante().put(lune + 6L, dejaPlante + nbPlante);

        service.save(leJoueur);
    }

    public void planterCarotte(Long idJoueur, Long nbPlante) {
        Joueur leJoueur = service.findOne(idJoueur);

        leJoueur.setQuantiteCarotte(leJoueur.getQuantiteCarotte() - nbPlante);
        Long dejaPlante = 0L;
        if (leJoueur.getCarottePlantee().containsKey(lune + 6L)) {
            dejaPlante = leJoueur.getCarottePlantee().get(lune + 6L);
        }
        leJoueur.getCarottePlantee().put(lune + 6L, dejaPlante + nbPlante);

        service.save(leJoueur);
    }

    public void faireSeReproduire(Long idJoueur, Long nbAFaireNaitre) {
        Joueur leJoueur = service.findOne(idJoueur);

        int i = 0;
        for (Chevre chevre : leJoueur.getChevres()) {
            if (chevre.getProchaineGestation() <= lune && i < nbAFaireNaitre) {
                chevre.setProchaineGestation(lune + 12L);
                i++;
            }
        }

        if (i < nbAFaireNaitre) {
            throw new RuntimeException("il n'y a pas assez de chevres pour faire " + nbAFaireNaitre + " bébés !");
        }
        leJoueur.getChevraux().put(lune + 12L, nbAFaireNaitre);
        //persiste en base si tout va bien
        serviceChevre.save(leJoueur.getChevres());
        service.save(leJoueur);
    }

    public void nourrir(Long idJoueur, Long nbANourrir) {
        Joueur leJoueur = service.findOne(idJoueur);

        long i = 0;
        for (Chevre chevre : leJoueur.getChevres()) {
            if (chevre.getProchainRepas() == lune && i < nbANourrir) {
                chevre.setProchainRepas(lune + 4L);
                leJoueur.setQuantiteBle(leJoueur.getQuantiteBle() - 1L);
            }
        }
        //erreur de requête
        if (leJoueur.getQuantiteBle() < 0L) {
            throw new RuntimeException("Pas assez de blé");
        }

        if (i < nbANourrir) {
            throw new RuntimeException("Erreur pas assez de chèvres à nourrir");
        }

        //sauvegarde Si tout OK
        serviceChevre.save(leJoueur.getChevres());
        service.save(leJoueur);
    }

    //se nourrir d'autre chose
    public void seNourrir(Long idJoueur, String ressource) {
        Joueur leJoueur = service.findOne(idJoueur);
        switch (ressource) {
            case "carotte":
                leJoueur.setQuantiteCarotte(leJoueur.getQuantiteCarotte() - 2L);
                break;
            case "ble":
                leJoueur.setQuantiteBle(leJoueur.getQuantiteBle() - 3L);
                break;
            case "fromage":
                leJoueur.setQuantiteFromage(leJoueur.getQuantiteFromage() - 2L);
                break;
            case "chevre":
                Chevre chevre = leJoueur.getChevres().remove(0);
                serviceChevre.delete(chevre);
            default:
                throw new RuntimeException("Erreur: la nourriture est : " + ressource);
        }
        leJoueur.setProchainRepas(lune + 4L);
        service.save(leJoueur);
    }
}

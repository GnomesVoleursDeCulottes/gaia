/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gaia.service;

import gaia.entity.Chevre;
import gaia.entity.Joueur;
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

    @Scheduled(fixedDelay = 300000)
    public void incrementeLune() {

        System.out.println("*** FIN LUNE : " + (lune - 1L) + " ***");
        cycleDeVie();
        System.out.println("*** CYCLE LUNE : " + lune + " OK ***");
        lune++;
        
    }

    public long getLune() {
        return lune;
    }

    private void cycleDeVie() {
        //parcours tous les joueurs
        List<Joueur> lesJoueurs = service.findAll();
        for (Joueur joueur: lesJoueurs){
            ////Mort
            //Fin de partie
            if (joueur.getProchainRepas() < lune){
                ////?????
            }
            //Mort chévre + fromage
            for (Chevre chevre: joueur.getChevres()){
                if (chevre.getProchainRepas() < lune){
                    serviceChevre.delete(chevre);
                } else {
                    if (chevre.getProchainFromage() == lune){
                        chevre.setProchainFromage(lune + 6L);
                        joueur.setQuantiteFromage(joueur.getQuantiteFromage() + 2L + (long)Math.floor(Math.random()*2));
                    }
                }
            }
            ////Naissance (sauf fromage)
            //Recolte Blé
            if (joueur.getBlePlante().containsKey(lune)){
                joueur.setQuantiteBle(joueur.getQuantiteBle() + joueur.getBlePlante().get(lune));
                joueur.getBlePlante().remove(lune);
            }
            
            //Recolte Carotte
            if (joueur.getCarottePlantee().containsKey(lune)){
                joueur.setQuantiteCarotte(joueur.getQuantiteCarotte()+ joueur.getCarottePlantee().get(lune));
                joueur.getCarottePlantee().remove(lune);
            }
            //Maturation Chevraux
            if (joueur.getChevraux().containsKey(lune)){
                for (long i = 0L; i < joueur.getChevraux().get(lune); i++){
                    Chevre nouvelleChevre = new Chevre();
                    nouvelleChevre.setLeJoueur(joueur);
                    nouvelleChevre.setProchainAll(lune);
                    serviceChevre.save(nouvelleChevre);
                    joueur.getChevres().add(nouvelleChevre);
                }
                joueur.getChevraux().remove(lune);
            }
            service.save(joueur);
        }
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gaia.service;

import gaia.entity.Joueur;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author admin
 */
public interface JoueurServiceCRUD extends CrudRepository<Joueur, Long>{
    
    public Joueur findOneByLogin(String login);
    
    public List<Joueur> findAll();
}

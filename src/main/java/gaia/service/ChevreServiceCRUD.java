/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gaia.service;

import gaia.entity.Chevre;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author admin
 */
public interface ChevreServiceCRUD extends CrudRepository<Chevre, Long>{
    
}

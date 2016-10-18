/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gaia.service;

import gaia.entity.Plantation;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author admin
 */
public interface PlantationServiceCRUD extends CrudRepository<Plantation, Long>{
    
}

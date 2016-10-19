/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gaia.service;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

/**
 *
 * @author admin
 */
@Service
public class LuneService {
 
    private long lune=0;
    
    @Scheduled(fixedDelay = 600000)
    public void inscrementeLune(){
        
        System.out.println( "*** LUNE : " + lune );
        lune++;
    }

    public long getLune() {
        return lune;
    }
    
    
}

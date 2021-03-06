/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gaia.entity;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 *
 * @author admin
 */
@Entity
public class Chevre implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    private Long prochaineGestation;
    
    private Long prochainRepas;
    
    private Long prochainFromage;
    
    @ManyToOne
    @JoinColumn(name="ID_JOUEUR")
    private Joueur leJoueur;
    

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Chevre)) {
            return false;
        }
        Chevre other = (Chevre) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "gaia.entity.Chevre[ id=" + id + " ]";
    }

    public Long getProchaineGestation() {
        return prochaineGestation;
    }

    public void setProchaineGestation(Long prochaineGestation) {
        this.prochaineGestation = prochaineGestation;
    }

    public Long getProchainRepas() {
        return prochainRepas;
    }

    public void setProchainRepas(Long prochainRepas) {
        this.prochainRepas = prochainRepas;
    }

    public Long getProchainFromage() {
        return prochainFromage;
    }

    public void setProchainFromage(Long prochainFromage) {
        this.prochainFromage = prochainFromage;
    }

    public Joueur getLeJoueur() {
        return leJoueur;
    }

    public void setLeJoueur(Joueur leJoueur) {
        this.leJoueur = leJoueur;
    }
    
    public void setProchainAll(Long laLune){
        this.prochainFromage = laLune + 6L;
        this.prochainRepas = laLune + 4L;
        this.prochaineGestation = laLune;
    }
}

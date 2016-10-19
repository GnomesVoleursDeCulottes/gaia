/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gaia.entity;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapKeyColumn;
import javax.persistence.OneToMany;

/**
 *
 * @author admin
 */
@Entity
public class Joueur implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false, unique = true)
    private String login;

    @Column(nullable = false)
    private String mdp;

    private Long prochainRepas;

    private Long quantiteCarotte;

    private Long quantiteBle;

    private Long quantiteFromage;

    @OneToMany(mappedBy="leJoueur")
    public List<Chevre> chevres;

    @ElementCollection
    @MapKeyColumn(name="CYCLE_MATURITE")
    @Column(name="NB_MATURE")
    @CollectionTable(name="CHEVRAUX", joinColumns=@JoinColumn(name="JOUEUR_ID"))
    public Map<Long, Long> chevraux = new HashMap();

    @ElementCollection
    @MapKeyColumn(name="CYCLE_RECOLTE")
    @Column(name="NB_RECOLTE")
    @CollectionTable(name="CAROTTE_PLANTEE", joinColumns=@JoinColumn(name="JOUEUR_ID"))
    public Map<Long, Long> carottePlantee = new HashMap();;
    
    @ElementCollection
    @MapKeyColumn(name="CYCLE_RECOLTE")
    @Column(name="NB_RECOLTE")
    @CollectionTable(name="BLE_PLANTE", joinColumns=@JoinColumn(name="JOUEUR_ID"))
    public Map<Long, Long> blePlante = new HashMap();;
    
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
        if (!(object instanceof Joueur)) {
            return false;
        }
        Joueur other = (Joueur) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "gaia.entity.Joueur[ id=" + id + " ]";
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getMdp() {
        return mdp;
    }

    public void setMdp(String mdp) {
        this.mdp = mdp;
    }

    public Long getProchainRepas() {
        return prochainRepas;
    }

    public void setProchainRepas(Long prochainRepas) {
        this.prochainRepas = prochainRepas;
    }

    public Long getQuantiteCarotte() {
        return quantiteCarotte;
    }

    public void setQuantiteCarotte(Long quantiteCarotte) {
        this.quantiteCarotte = quantiteCarotte;
    }

    public Long getQuantiteBle() {
        return quantiteBle;
    }

    public void setQuantiteBle(Long quantiteBle) {
        this.quantiteBle = quantiteBle;
    }

    public Long getQuantiteFromage() {
        return quantiteFromage;
    }

    public void setQuantiteFromage(Long quantiteFromage) {
        this.quantiteFromage = quantiteFromage;
    }

    public List<Chevre> getChevres() {
        return chevres;
    }

    public Map<Long, Long> getChevraux() {
        return chevraux;
    }

    public Map<Long, Long> getCarottePlantee() {
        return carottePlantee;
    }

    public Map<Long, Long> getBlePlante() {
        return blePlante;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }
    
}

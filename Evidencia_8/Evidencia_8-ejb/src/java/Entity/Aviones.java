/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Zaragoza
 */
@Entity
@Table(name = "Aviones")

@NamedQueries({
    @NamedQuery(name = "findAviones", query = "SELECT h FROM Aviones h"),
    @NamedQuery(name = "findNoDeAvion", query = "SELECT p FROM Aviones p WHERE p.noDeAvion=:noDeAvion and p.capacidadDePasajeros=:capacidad")
})

public class Aviones implements Serializable {

    
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "NoDeAvion", length = 20, nullable = false)
    private int noDeAvion;
    
    @Column(name = "CapacidadDePasajeros", nullable = false)
    private int capacidadDePasajeros;
    
    @Column(name = "Modelo", length = 25, nullable = false)
    private String modelo;
    
    @Column(name = "Aerolinea", length = 35, nullable = false)
    private String aerolinea;
    
    @OneToMany(cascade = CascadeType.MERGE, mappedBy = "NoDeAvion")
    private List <Vuelos> vuelosList;

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
        if (!(object instanceof Aviones)) {
            return false;
        }
        Aviones other = (Aviones) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.Aviones[ id=" + id + " ]";
    }

    /**
     * @return the noDeAvion
     */
    public int getNoDeAvion() {
        return noDeAvion;
    }

    /**
     * @param noDeAvion the noDeAvion to set
     */
    public void setNoDeAvion(int noDeAvion) {
        this.noDeAvion = noDeAvion;
    }

    /**
     * @return the capacidadDePasajeros
     */
    public int getCapacidadDePasajeros() {
        return capacidadDePasajeros;
    }

    /**
     * @param capacidadDePasajeros the capacidadDePasajeros to set
     */
    public void setCapacidadDePasajeros(int capacidadDePasajeros) {
        this.capacidadDePasajeros = capacidadDePasajeros;
    }

    /**
     * @return the modelo
     */
    public String getModelo() {
        return modelo;
    }

    /**
     * @param modelo the modelo to set
     */
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    /**
     * @return the aerolinea
     */
    public String getAerolinea() {
        return aerolinea;
    }

    /**
     * @param aerolinea the aerolinea to set
     */
    public void setAerolinea(String aerolinea) {
        this.aerolinea = aerolinea;
    }
    
    /**
     * @return the vuelosList
     */
    public List <Vuelos> getVuelosList() {
        return vuelosList;
    }

    /**
     * @param vuelosList the vuelosList to set
     */
    public void setVuelosList(List <Vuelos> vuelosList) {
        this.vuelosList = vuelosList;
    }
    
}

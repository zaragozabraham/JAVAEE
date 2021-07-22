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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Zaragoza
 */
@Entity
@Table(name = "Ciudades")

@NamedQueries({
    @NamedQuery(name = "findCiudades", query = "SELECT h FROM Ciudades h"),
    @NamedQuery(name = "findByPais", query = "SELECT p FROM Ciudades p WHERE p.estado.pais.nombre=:pais")
})

public class Ciudades implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "Nombre", length = 35, nullable = false)
    private String nombre;

    @JoinColumn(name = "Estado", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private Estados estado;

    @OneToMany(cascade = CascadeType.MERGE, mappedBy = "Origen")
    private List<Vuelos> origenList;

    @OneToMany(cascade = CascadeType.MERGE, mappedBy = "Destino")
    private List<Vuelos> destinosList;

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
        if (!(object instanceof Ciudades)) {
            return false;
        }
        Ciudades other = (Ciudades) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.Ciudades[ id=" + id + " ]";
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the estado
     */
    public Estados getEstado() {
        return estado;
    }

    /**
     * @param estado the estado to set
     */
    public void setEstado(Estados estado) {
        this.estado = estado;
    }

    /**
     * @return the origenList
     */
    public List<Vuelos> getOrigenList() {
        return origenList;
    }

    /**
     * @param origenList the origenList to set
     */
    public void setOrigenList(List<Vuelos> origenList) {
        this.origenList = origenList;
    }

    /**
     * @return the destinosList
     */
    public List<Vuelos> getDestinosList() {
        return destinosList;
    }

    /**
     * @param destinosList the destinosList to set
     */
    public void setDestinosList(List<Vuelos> destinosList) {
        this.destinosList = destinosList;
    }

}

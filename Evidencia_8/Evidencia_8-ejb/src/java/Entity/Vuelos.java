/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;

/**
 *
 * @author Zaragoza
 */
@Entity
@Table(name = "Vuelos")

@NamedQueries({
    @NamedQuery(name = "findVuelos", query = "SELECT h FROM Vuelos h")
})

public class Vuelos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "NoDeVuelo", length = 20, nullable = false)
    private int noVuelo;
    
    @JoinColumn(name = "NoDeAvion", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private Aviones noDeAvion;
    
    @JoinColumn(name = "Origen", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private Ciudades origen;
    
    @JoinColumn(name = "Destino", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private Ciudades destino;
    
    @Column(name = "NoPasajeros")
    private int noPasajeros;
    
    @Column(name = "FechaInicio")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date fechaInicio;
    
    @Column(name = "FechaFin")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date fechaFin;
    
    @Column(name = "HoraInicio")
    @Temporal(javax.persistence.TemporalType.TIME)
    private Date horaInicio;
    
    @Column(name = "HoraFin")
    @Temporal(javax.persistence.TemporalType.TIME)
    private Date horaFin;
    

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
        if (!(object instanceof Vuelos)) {
            return false;
        }
        Vuelos other = (Vuelos) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.Vuelos[ id=" + id + " ]";
    }

    /**
     * @return the noVuelo
     */
    public int getNoVuelo() {
        return noVuelo;
    }

    /**
     * @param noVuelo the noVuelo to set
     */
    public void setNoVuelo(int noVuelo) {
        this.noVuelo = noVuelo;
    }

    /**
     * @return the noAvion
     */
    public Aviones getNoDeAvion() {
        return noDeAvion;
    }

    /**
     * @param noAvion the noAvion to set
     */
    public void setNoDeAvion(Aviones noAvion) {
        this.noDeAvion = noAvion;
    }

    /**
     * @return the origen
     */
    public Ciudades getOrigen() {
        return origen;
    }

    /**
     * @param origen the origen to set
     */
    public void setOrigen(Ciudades origen) {
        this.origen = origen;
    }

    /**
     * @return the destino
     */
    public Ciudades getDestino() {
        return destino;
    }

    /**
     * @param destino the destino to set
     */
    public void setDestino(Ciudades destino) {
        this.destino = destino;
    }

    /**
     * @return the noPasajeros
     */
    public int getNoPasajeros() {
        return noPasajeros;
    }

    /**
     * @param noPasajeros the noPasajeros to set
     */
    public void setNoPasajeros(int noPasajeros) {
        this.noPasajeros = noPasajeros;
    }

    /**
     * @return the fechaInicio
     */
    public Date getFechaInicio() {
        return fechaInicio;
    }

    /**
     * @param fechaInicio the fechaInicio to set
     */
    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    /**
     * @return the fechaFin
     */
    public Date getFechaFin() {
        return fechaFin;
    }

    /**
     * @param fechaFin the fechaFin to set
     */
    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    /**
     * @return the horaInicio
     */
    public Date getHoraInicio() {
        return horaInicio;
    }

    /**
     * @param horaInicio the horaInicio to set
     */
    public void setHoraInicio(Date horaInicio) {
        this.horaInicio = horaInicio;
    }

    /**
     * @return the horaFin
     */
    public Date getHoraFin() {
        return horaFin;
    }

    /**
     * @param horaFin the horaFin to set
     */
    public void setHoraFin(Date horaFin) {
        this.horaFin = horaFin;
    }
    
}

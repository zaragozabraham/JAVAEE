/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Entity.Ciudades;
import Facade.CiudadesFacade;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

/**
 *
 * @author Zaragoza
 */
@Named(value = "ciudadesController")
@SessionScoped
public class CiudadesController implements Serializable {

    @EJB
    private CiudadesFacade ciudadesFacade;
    private Ciudades ciudades = new Ciudades();
    private boolean conrifm = false;

    public List<Ciudades> findAll() {
        return ciudadesFacade.finAllTyped();
    }

    public List<Ciudades> findAllNQ() {
        return ciudadesFacade.findAllNamed();
    }

    public Ciudades findByEstado() {
        return ciudadesFacade.findByEstado("Nuevo Leon");
    }

    public Ciudades findByPais() {
        return ciudadesFacade.findByPais("Chile");
    }

    public String insert() {
        FacesMessage msj;
        try {
            if (!ciudadesFacade.findNombre(ciudades.getNombre(), ciudades.getEstado().getId()).isEmpty()) {
                msj = new FacesMessage(FacesMessage.SEVERITY_ERROR, "La ciudad " + ciudades.getNombre() + " ya existe en el estado " + ciudades.getEstado().getNombre() + ".", "ERROR: operación invalida.");
                FacesContext.getCurrentInstance().addMessage("ciudadesAlta", msj);
            } else {

                ciudadesFacade.insert(ciudades);
                clean();
                msj = new FacesMessage(FacesMessage.SEVERITY_INFO, "El registro ha sido agragado correctamente.", "El registro ha sido añadido correctamente.");
                FacesContext.getCurrentInstance().addMessage("ciudadesAlta", msj);
            }

        } catch (Exception e) {
            msj = new FacesMessage(FacesMessage.SEVERITY_ERROR, "El registro no ha podido ser agregado a la base de datos.", "ERROR: operación invalida.");
            FacesContext.getCurrentInstance().addMessage("ciudadesAlta", msj);
        }
        return "";
    }

    public String prepareEdit(Ciudades p) {
        ciudades = p;
        return "ciudadesEdit";
    }

    public String update() {
        FacesMessage msj;
        try {
            ciudadesFacade.update(ciudades);
            clean();
            msj = new FacesMessage(FacesMessage.SEVERITY_INFO, "El registro " + ciudades.getNombre() + "ha sido actualizado correctamente.", "El registro ha sido actualizado correctamente");
            FacesContext.getCurrentInstance().addMessage("ciudadesEdit", msj);
        } catch (Exception e) {
            msj = new FacesMessage(FacesMessage.SEVERITY_ERROR, "El registro " + ciudades.getNombre() + "no ha podido ser guardado correctamente.", "El registro no pudo ser actualizado. Contacte a soporte.");
            FacesContext.getCurrentInstance().addMessage("ciudadesEdit", msj);
        }
        return "";
    }

    public String prepareConfirm() {
        setConrifm(true);
        return "ciudadesList";
    }

    public void delete(Ciudades p) {
        FacesMessage msj;
        try {
            if (p.getDestinosList().isEmpty() || p.getOrigenList().isEmpty()) {
                ciudades = p;
                ciudadesFacade.delete(ciudades);
                msj = new FacesMessage(FacesMessage.SEVERITY_INFO, "El registro ha sido eliminado correctamente.", "El registro " + ciudades.getNombre() + "fue eliminado.");
                FacesContext.getCurrentInstance().addMessage("ciudadesList", msj);
            } else {
                msj = new FacesMessage(FacesMessage.SEVERITY_ERROR, "El registro de ciudad no puede ser eliminado. Presenta vuelos vinculados.", "Registro de " + ciudades.getNombre() + "no pudo ser eliminado.");
                FacesContext.getCurrentInstance().addMessage("ciudadesList", msj);
            }

        } catch (Exception e) {
            msj = new FacesMessage(FacesMessage.SEVERITY_ERROR, "El registro de ciudad no puede ser eliminado.", "El registro " + ciudades.getNombre() + "no pudo ser eliminado.");
            FacesContext.getCurrentInstance().addMessage("ciudadesList", msj);
        }
        mainClean("ciudadesList");
    }

    public Ciudades find(Long id) {
        return ciudadesFacade.find(id);
    }

    public void clean() {
        ciudades = new Ciudades();
    }

    public String mainClean(String url) {
        ciudades = new Ciudades();
        setConrifm(false);
        return url;
    }

    // Getter & Setter 
    public Ciudades getCiudades() {
        return ciudades;
    }

    public void setCiudades(Ciudades ciudades) {
        this.ciudades = ciudades;
    }

    /**
     * @return the conrifm
     */
    public boolean isConrifm() {
        return conrifm;
    }

    /**
     * @param conrifm the conrifm to set
     */
    public void setConrifm(boolean conrifm) {
        this.conrifm = conrifm;
    }

}

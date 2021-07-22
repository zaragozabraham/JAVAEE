/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Entity.Aviones;
import Facade.AvionesFacade;
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
@Named(value = "avionesController")
@SessionScoped
public class AvionesController implements Serializable {

    @EJB
    private AvionesFacade avionesFacade;
    private Aviones aviones = new Aviones();
    private boolean confirm = false;

    public List<Aviones> findAll() {
        return avionesFacade.findAllTyped();
    }

    public List<Aviones> findAllNQ() {
        return avionesFacade.fineAllNamed();
    }

    public Aviones findByNoDeAvion() {
        return avionesFacade.findBynoDeAvion(1601773);
    }

    public Aviones findByNoyCapacidad() {
        return avionesFacade.findByNoyCapacidad(1601773, 20);
    }

    public String insert() {
        FacesMessage msj;
        try {
            if (avionesFacade.findNoAvion(aviones.getNoDeAvion()).isEmpty()) {
                avionesFacade.insert(aviones);
                clean();
                msj = new FacesMessage(FacesMessage.SEVERITY_INFO, "El registro ha sido agregado correctamente.", "El registro " + aviones.getNoDeAvion() + "fue agregado de forma correcta.");
                FacesContext.getCurrentInstance().addMessage("avionesAlta", msj);
            } else {
                msj = new FacesMessage(FacesMessage.SEVERITY_ERROR, "El no. de avión " + aviones.getNoDeAvion() + " ya existe.", "ERROR: operación invalida.");
                FacesContext.getCurrentInstance().addMessage("avionesAlta", msj);
            }

        } catch (Exception e) {
            msj = new FacesMessage(FacesMessage.SEVERITY_ERROR, "El registro no ha podido ser agregado a la base de datos.", "ERROR: operación invalida.");
            FacesContext.getCurrentInstance().addMessage("avionesAlta", msj);
        }
        return "";
    }

    public String prepareEdit(Aviones p) {
        aviones = p;
        return "avionesEdit";
    }

    public String update() {
        FacesMessage msj;
        try {
            avionesFacade.update(aviones);
            msj = new FacesMessage(FacesMessage.SEVERITY_INFO, "El regostro ha sido actualizado.", "El registro " + aviones.getNoDeAvion() + "ha sido actualizado correctamente.");
            FacesContext.getCurrentInstance().addMessage("avionesEdit", msj);
            clean();
        } catch (Exception e) {
            msj = new FacesMessage(FacesMessage.SEVERITY_ERROR, "El registro no pudo ser actualizado.", "El registro no pudo ser actualizado. Contacte a soporte.");
            FacesContext.getCurrentInstance().addMessage("avionesEdit", msj);
        }

        return "";
    }

    public String prepareConfirm() {
        setConfirm(true);
        return "avionesList";
    }

    public void delete(Aviones p) {
        FacesMessage msj;
        try {
            if (p.getVuelosList().isEmpty()) {
                aviones = p;
                avionesFacade.delete(aviones);
                msj = new FacesMessage(FacesMessage.SEVERITY_INFO, "El registro ha sido eliminado correctamente.", "Registro de avion con el no. de avión " + aviones.getNoDeAvion() + "fue eliminado.");
                FacesContext.getCurrentInstance().addMessage("avionesList", msj);
            } else {
                msj = new FacesMessage(FacesMessage.SEVERITY_ERROR, "El registro de avión no puede ser eliminado. Presenta vuelos vinculados.", "Registro de avion con el no. de avión " + aviones.getNoDeAvion() + "no pudo ser eliminado.");
                FacesContext.getCurrentInstance().addMessage("avionesList", msj);
            }
        } catch (Exception e) {
            msj = new FacesMessage(FacesMessage.SEVERITY_ERROR, "El registro de avión no puede ser eliminado.", "Registro de avion con el no. de avión " + aviones.getNoDeAvion() + "no pudo ser eliminado.");
            FacesContext.getCurrentInstance().addMessage("avionesList", msj);
        }

        mainClean("avionesList");
    }

    public Aviones find(Long id) {
        return avionesFacade.find(id);
    }

    public void clean() {
        aviones = new Aviones();
    }

    public String mainClean(String url) {
        aviones = new Aviones();
        setConfirm(false);
        return url;
    }

    // Getter & Setter
    public Aviones getAviones() {
        return aviones;
    }

    public void setAviones(Aviones aviones) {
        this.aviones = aviones;
    }

    /**
     * @return the confirm
     */
    public boolean isConfirm() {
        return confirm;
    }

    /**
     * @param confirm the confirm to set
     */
    public void setConfirm(boolean confirm) {
        this.confirm = confirm;
    }

}

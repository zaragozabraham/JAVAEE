/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Entity.Paises;
import Facade.PaisesFacade;
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
@Named(value = "paisesController")
@SessionScoped
public class PaisesController implements Serializable {

    @EJB
    private PaisesFacade paisesFacade;
    private Paises paises = new Paises();
    private boolean confirm = false;

    public List<Paises> findAll() {
        return paisesFacade.findAllTyped();
    }

    public List<Paises> findAllNQ() {
        return paisesFacade.findAllNamed();
    }

    public Paises findByName() {
        return paisesFacade.findByName("Chile");
    }

    public String insert() {
        FacesMessage msj;
        try {
            paisesFacade.insert(paises);
            clean();
            msj = new FacesMessage(FacesMessage.SEVERITY_INFO, "El registro " + paises.getNombre() + "ha sido agragado correctamente.", "El registro ha sido añadido correctamente.");
            FacesContext.getCurrentInstance().addMessage("paisesAlta", msj);
        } catch (Exception e) {
            msj = new FacesMessage(FacesMessage.SEVERITY_ERROR, "El registro no ha podido ser agregado a la base de datos.", "ERROR: operación invalida.");
            FacesContext.getCurrentInstance().addMessage("paisesAlta", msj);
        }
        return "paisesList";
    }

    public String prepareEdit(Paises p) {
        paises = p;
        return "paisesEdit";
    }

    public String update() {
        FacesMessage msj;
        try {
            paisesFacade.update(paises);
            clean();
            msj = new FacesMessage(FacesMessage.SEVERITY_INFO, "El registro " + paises.getNombre() + "ha sido actualizado correctamente.", "El registro ha sido actualizado correctamente");
            FacesContext.getCurrentInstance().addMessage("paisesEdit", msj);
        } catch (Exception e) {
            msj = new FacesMessage(FacesMessage.SEVERITY_ERROR, "El registro " + paises.getNombre() + "no ha podido ser guardado correctamente.", "El registro no pudo ser actualizado. Contacte a soporte.");
            FacesContext.getCurrentInstance().addMessage("paisesEdit", msj);
        }
        return "";
    }

    public String prepareConfirm() {
        setConfirm(true);
        return "paisesList";
    }

    public void delete(Paises p) {
        FacesMessage msj;
        try {
            if (p.getEstadosList().isEmpty()) {
                paises = p;
                paisesFacade.delete(paises);
                msj = new FacesMessage(FacesMessage.SEVERITY_INFO, "El registro ha sido eliminado correctamente.", "El registro " + paises.getNombre() + "fue eliminado.");
                FacesContext.getCurrentInstance().addMessage("paisesList", msj);
            } else {
                msj = new FacesMessage(FacesMessage.SEVERITY_ERROR, "El registro de pais no puede ser eliminado. Presenta estados vinculados.", "El registro " + paises.getNombre() + "no pudo ser eliminado.");
                FacesContext.getCurrentInstance().addMessage("paisesList", msj);
            }
        } catch (Exception e) {
            msj = new FacesMessage(FacesMessage.SEVERITY_ERROR, "El registro de pais no puede ser eliminado.", "El registro " + paises.getNombre() + "no pudo ser eliminado.");
            FacesContext.getCurrentInstance().addMessage("paisesList", msj);
        }

        mainClean("paisesList");
    }

    public Paises find(Long id) {
        return paisesFacade.find(id);
    }

    public void clean() {
        paises = new Paises();
    }

    public String mainClean(String url) {
        paises = new Paises();
        setConfirm(false);
        return url;
    }

    // Getter & Setter 
    public Paises getPaises() {
        return paises;
    }

    public void setPaises(Paises paises) {
        this.paises = paises;
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

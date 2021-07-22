/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Entity.Estados;
import Facade.EstadosFacade;
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
@Named(value = "estadosController")
@SessionScoped
public class EstadosController implements Serializable {

    @EJB
    private EstadosFacade estadosFacade;
    private Estados estados = new Estados();
    private boolean confirm = false;

    public List<Estados> findAll() {
        return estadosFacade.findAllTyped();
    }

    public List<Estados> findAllNQ() {
        return estadosFacade.findAllNamed();
    }

    public String insert() {
        FacesMessage msj;
        try {
            estadosFacade.insert(estados);
            clean();
            msj = new FacesMessage(FacesMessage.SEVERITY_INFO, "El registro de " + estados.getNombre() + " ha sido agreado exitosamente", "El registro ha sido añadido correctamente.");
            FacesContext.getCurrentInstance().addMessage("estadosAlta", msj);
        } catch (Exception e) {
            msj = new FacesMessage(FacesMessage.SEVERITY_ERROR, "El registro no ha podido ser agregado a la base de datos.", "ERROR: operación invalida.");
            FacesContext.getCurrentInstance().addMessage("estadosAlta", msj);
        }
        return "";
    }

    public String prepareEdit(Estados p) {
        estados = p;
        return "estadosEdit";
    }

    public String update() {
        FacesMessage msj;
        try {
            estadosFacade.update(estados);
            clean();
            msj = new FacesMessage(FacesMessage.SEVERITY_INFO, "El registro " + estados.getNombre() + "ha sido actualizado correctamente.", "El registro ha sido actualizado correctamente");
            FacesContext.getCurrentInstance().addMessage("estadosEdit", msj);
        } catch (Exception e) {
            msj = new FacesMessage(FacesMessage.SEVERITY_ERROR, "El registro " + estados.getNombre() + "no ha podido ser guardado correctamente.", "El registro no pudo ser actualizado. Contacte a soporte.");
            FacesContext.getCurrentInstance().addMessage("estadosEdit", msj);
        }
        return "";
    }

    public String prepareConfirm() {
        setConfirm(true);
        return "estadosList";
    }

    public void delete(Estados p) {
        FacesMessage msj;
        try {
            if (p.getCiudadList().isEmpty()) {
                estados = p;
                estadosFacade.delete(estados);
                msj = new FacesMessage(FacesMessage.SEVERITY_INFO, "El registro ha sido eliminado correctamente.", "El registro  " + estados.getNombre() + "fue eliminado.");
                FacesContext.getCurrentInstance().addMessage("estadosList", msj);
            } else {
                msj = new FacesMessage(FacesMessage.SEVERITY_ERROR, "El registro de estado no puede ser eliminado. Presenta ciudades vinculadas.", "Registro de " + estados.getNombre() + "no pudo ser eliminado.");
                FacesContext.getCurrentInstance().addMessage("estadosList", msj);
            }
        } catch (Exception e) {
            msj = new FacesMessage(FacesMessage.SEVERITY_ERROR, "El registro de estado no pudo ser eliminado.", "El registro " + estados.getNombre() + "no pudo ser eliminado.");
            FacesContext.getCurrentInstance().addMessage("estadosList", msj);
        }
        mainClean("estadosList");
    }

    public Estados find(Long id) {
        return estadosFacade.find(id);
    }

    public void clean() {
        estados = new Estados();
    }

    public String mainClean(String url) {
        estados = new Estados();
        setConfirm(false);
        return url;
    }

    // Getter & Setter 
    public Estados getEstados() {
        return estados;
    }

    public void setEstados(Estados estados) {
        this.estados = estados;
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

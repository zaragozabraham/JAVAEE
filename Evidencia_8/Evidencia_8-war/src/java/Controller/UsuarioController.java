/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Entity.Usuario;
import Facade.UsuarioFacade;
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
@Named(value = "usuarioController")
@SessionScoped
public class UsuarioController implements Serializable {

    @EJB
    private UsuarioFacade usuarioFacade;
    private Usuario usuario = new Usuario();
    private boolean confirm = false;

    public List<Usuario> findAll() {
        return usuarioFacade.findAll();
    }

    public String insert() {
        FacesMessage msj;
        try {
            if (Integer.toString(usuario.getPerfil()).matches("[0-3]")) {
                usuarioFacade.insert(getUsuario());
                msj = new FacesMessage(FacesMessage.SEVERITY_INFO, "El usuario ha sido agregado correctamente", "El usuario " + getUsuario().getNombreUsuario() + "ha sido añadido correctamente.");
                FacesContext.getCurrentInstance().addMessage("usuarioAlta", msj);
                clean();
            } else {
                msj = new FacesMessage(FacesMessage.SEVERITY_ERROR, "El registro no ha podido ser agregado. El perfil debe ser 0, 1, 2 o 3.", "El registro no pudo ser agregado");
                FacesContext.getCurrentInstance().addMessage("usuarioAlta", msj);
            }

        } catch (Exception e) {
            msj = new FacesMessage(FacesMessage.SEVERITY_ERROR, "El registro no ha podido ser agregado.", "El registro no pudo ser agregado");
            FacesContext.getCurrentInstance().addMessage("usuarioAlta", msj);
        }

        return "";
    }

    public String prepareEdit(Usuario p) {
        setUsuario(p);
        return "usuarioEdit";
    }

    public String update() {
        FacesMessage msj;
        try {
            usuarioFacade.update(getUsuario());
            msj = new FacesMessage(FacesMessage.SEVERITY_INFO, "El registro ha sido actualizado correctamente.", "El registro ha sido actualizado");
            FacesContext.getCurrentInstance().addMessage("usuarioEdit", msj);
        } catch (Exception e) {
            msj = new FacesMessage(FacesMessage.SEVERITY_ERROR, "El registro no puso ser actualizado.", "El registro no puso ser editaro");
            FacesContext.getCurrentInstance().addMessage("usuarioEdit", msj);
        }

        return "";
    }

    public String prepareConfirm() {
        setConfirm(true);
        return "usuarioList";
    }

    public void delete(Usuario p) {
        FacesMessage msj;
        try {
            setUsuario(p);
            usuarioFacade.delete(getUsuario());
            msj = new FacesMessage(FacesMessage.SEVERITY_INFO, "El usuario ha sido eliminado correctamente.", "el registro de usuario ha sido eliminado correctamente.");
            FacesContext.getCurrentInstance().addMessage("usuarioList", msj);
        } catch (Exception e) {
            msj = new FacesMessage(FacesMessage.SEVERITY_ERROR, "El usuario no ha podido ser eliminado.", "El registro de usuario no ha sido eliminado.");
            FacesContext.getCurrentInstance().addMessage("usuarioList", msj);
        }

        mainClean("usuarioList");
    }

    public void clean() {
        setUsuario(new Usuario());
    }

    public String mainClean(String url) {
        setUsuario(new Usuario());
        setConfirm(false);
        return url;
    }

    public UsuarioController() {
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

    /**
     * @return the usuario
     */
    public Usuario getUsuario() {
        return usuario;
    }

    /**
     * @param usuario the usuario to set
     */
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

}

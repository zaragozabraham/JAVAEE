/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Entity.Vuelos;
import Facade.VuelosFacade;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.Instant;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

/**
 *
 * @author Zaragoza
 */
@Named(value = "vuelosController")
@SessionScoped
public class VuelosController implements Serializable {

    @EJB
    private VuelosFacade vuelosFacade;
    private Vuelos vuelos = new Vuelos();
    private boolean confirm = false;

    public List<Vuelos> findAll() {
        return vuelosFacade.findAllTyped();
    }

    public List<Vuelos> findAllNQ() {
        return vuelosFacade.findAllNamed();
    }

    public Vuelos findByNoVuelo() {
        return vuelosFacade.findByNoDeVuelo(1564);
    }

    public String insert() {
        FacesMessage msj;
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("hh:mm");
            String hInicio = sdf.format(vuelos.getHoraInicio());
            String hFin = sdf.format(vuelos.getHoraFin());

            long diferencia = TimeUnit.MILLISECONDS.toHours(sdf.parse(hFin).getTime() - sdf.parse(hInicio).getTime());
            System.out.println(diferencia);

            if (vuelosFacade.findNoVuelo(vuelos.getNoVuelo()).isEmpty()) {
                if (!vuelos.getDestino().getId().toString().equals(vuelos.getOrigen().getId().toString())) {
                    if (vuelos.getFechaInicio().before(vuelos.getHoraFin()) || vuelos.getFechaInicio().equals(vuelos.getFechaFin())) {
                        if (vuelos.getFechaInicio().equals(vuelos.getFechaFin()) && diferencia < 1) {
                            msj = new FacesMessage(FacesMessage.SEVERITY_ERROR, "El registro no ha podido ser agregado, la hora de inicio no puede diferir por menos de una hora con la hora de fin.", "ERROR: operación invalida.");
                            FacesContext.getCurrentInstance().addMessage("vuelosAlta", msj);
                        } else {
                            vuelosFacade.insert(vuelos);
                            msj = new FacesMessage(FacesMessage.SEVERITY_INFO, "El registro de vuelo " + vuelos.getNoVuelo() + " ha sido agragado correctamente.", "El registro ha sido añadido correctamente.");
                            FacesContext.getCurrentInstance().addMessage("vuelosAlta", msj);
                            clean();
                        }

                    } else {
                        msj = new FacesMessage(FacesMessage.SEVERITY_ERROR, "El registro no ha podido ser agregado, la fecha de inicio no puede ser después de la fecha de fin.", "ERROR: operación invalida.");
                        FacesContext.getCurrentInstance().addMessage("vuelosAlta", msj);
                    }
                } else {
                    msj = new FacesMessage(FacesMessage.SEVERITY_ERROR, "El registro no ha podido ser agregado, la ciudad de origen no puede ser la misma que la ciudad destino.", "ERROR: operación invalida.");
                    FacesContext.getCurrentInstance().addMessage("vuelosAlta", msj);
                }

            } else {
                msj = new FacesMessage(FacesMessage.SEVERITY_ERROR, "El registro no ha podido ser agregado, el no. de vuelo " + vuelos.getNoVuelo() + " ya existe.", "ERROR: operación invalida.");
                FacesContext.getCurrentInstance().addMessage("vuelosAlta", msj);
            }
        } catch (Exception e) {
            msj = new FacesMessage(FacesMessage.SEVERITY_ERROR, "El registro no ha podido ser agregado a la base de datos.", "ERROR: operación invalida.");
            FacesContext.getCurrentInstance().addMessage("vuelosAlta", msj);
        }
        return "";
    }

    public String prepareEdit(Vuelos p) {
        vuelos = p;
        return "vuelosEdit";
    }

    public String update() {
        FacesMessage msj;
        try {
            vuelosFacade.update(vuelos);
            clean();
            msj = new FacesMessage(FacesMessage.SEVERITY_INFO, "El registro de vuelo " + vuelos.getNoVuelo() + "ha sido actualizado correctamente.", "El registro ha sido actualizado correctamente");
            FacesContext.getCurrentInstance().addMessage("vuelosEdit", msj);
        } catch (Exception e) {
            msj = new FacesMessage(FacesMessage.SEVERITY_ERROR, "El registro de vuelo " + vuelos.getNoVuelo() + "no ha podido ser guardado correctamente.", "El registro no pudo ser actualizado. Contacte a soporte.");
            FacesContext.getCurrentInstance().addMessage("vuelosEdit", msj);
        }
        return "";
    }

    public String prepareConfirm() {
        setConfirm(true);
        return "vuelosList";
    }

    public void delete(Vuelos p) {
        FacesMessage msj;
        try {
            vuelos = p;
            vuelosFacade.delete(vuelos);
            msj = new FacesMessage(FacesMessage.SEVERITY_INFO, "El registro ha sido eliminado correctamente.", "Registro de de vuelo " + vuelos.getNoVuelo() + "fue eliminado.");
            FacesContext.getCurrentInstance().addMessage("vuelosList", msj);
        } catch (Exception e) {
            msj = new FacesMessage(FacesMessage.SEVERITY_ERROR, "El registro de vuelo no puede ser eliminado.", "Registro de vuelo " + vuelos.getNoVuelo() + "no pudo ser eliminado.");
            FacesContext.getCurrentInstance().addMessage("vuelosList", msj);
        }

        mainClean("vuelosList");
    }

    public void clean() {
        vuelos = new Vuelos();
    }

    public String mainClean(String url) {
        vuelos = new Vuelos();
        setConfirm(false);
        return url;
    }

    // Getter & Setter 
    public Vuelos getVuelos() {
        return vuelos;
    }

    public void setVuelos(Vuelos vuelos) {
        this.vuelos = vuelos;
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

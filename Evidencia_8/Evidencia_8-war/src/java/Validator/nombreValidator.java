/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Validator;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

/**
 *
 * @author Zaragoza
 */
@FacesValidator(value = "nombreValidator")
public class nombreValidator implements Validator{

    @Override
    public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
        if (value instanceof String){
            String str = (String) value;
            if(!str.matches("[a-zA-Z ]*")){
                throw new ValidatorException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "El nombre "+ value.toString() + " no debe contener simbolos, ni números.", "Solo debe incluir letras a-z, A-Z"));
            }
        }else {
            throw new ValidatorException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "El valor ingresado no es válido.", "Solo debe incluir letras a-z, A-Z"));
        }
    }
    
}

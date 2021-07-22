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
@FacesValidator(value = "codigoValidator")
public class codigoValidator implements Validator{

    @Override
    public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
        if (value instanceof String){
            String str = (String) value;
            if(!str.matches("[a-zA-Z_0-9]*")){
                throw new ValidatorException(new FacesMessage(FacesMessage.SEVERITY_ERROR,
                "El campo "+ value.toString() +" no debe contener espacios, ni caracteres raros.", "Error: solo se aceptan números y letras."));
            }
        }else {
            throw new ValidatorException(new FacesMessage(FacesMessage.SEVERITY_ERROR,
            "El campo ingresado debe ser una palabra.", "Error: valor ingresado no valido."));
        }
    }
    
}

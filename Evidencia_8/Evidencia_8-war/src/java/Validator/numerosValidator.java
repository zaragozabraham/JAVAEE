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
@FacesValidator(value = "numerosValidator")
public class numerosValidator implements Validator{

    @Override
    public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
        if (value instanceof Number) {
            String str = Integer.toString((Integer) value);
            if(!str.matches("[0-9]*")){
                throw new ValidatorException(new FacesMessage(FacesMessage.SEVERITY_ERROR,
                "El valor ingresado " + value.toString() + " no es valido, solo se aceptan números.", "ERROR: El valor solo debe contener números."));
            }
        }else {
            throw new ValidatorException(new FacesMessage(FacesMessage.SEVERITY_ERROR,
            "Debe ingresar un número, sin espacios.", "ERROR: Solo debe contener números."));
        }
    }
    
}

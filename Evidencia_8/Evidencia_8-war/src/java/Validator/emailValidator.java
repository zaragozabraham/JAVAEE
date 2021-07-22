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
@FacesValidator(value = "emailValidator")
public class emailValidator implements Validator{

    @Override
    public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
        if (value instanceof String){
            String str = (String) value;
            if(!str.matches("^[^@]+@[^@]+\\.[^@]+$")){
                throw new ValidatorException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "El email " + value.toString() + "ingresado no es valido", "El email ingresado no es valido"));
            }
        }else {
            throw new ValidatorException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "El campo ingresado no es válido.", "El email ingresado no es valido"));
        }
    }
    
}

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
@FacesValidator(value = "palabrasValidator")
public class palabrasValidator implements Validator{
    @Override
    public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
        if (value instanceof String){
            String str = (String) value;
            if(!str.matches("[a-zA-Z0-9 ]*")){
                throw new ValidatorException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "El campo "+ value.toString() + " no debe contener simbolos, ni números.", "Solo debe incluir letras a-z, A-Z y números"));
            }
        }else {
            throw new ValidatorException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "El campo ingresado no es válido.", "Solo debe incluir letras a-z, A-Z y números"));
        }
    }
}


package AjaxValidators;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;


@FacesValidator("confirmPasswordValidator")
public class PasswordValidator implements Validator
{
    @Override
    public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException 
    {
        String password = (String) value;
        String confirm = (String) component.getAttributes().get("j_idt9:j_idt10:m_confirm");
        
        System.out.println("Triggered : ");
        
        if (password == null || confirm == null) {
            return; // Just ignore and let required="true" do its job.
        }

        if (!password.equals(confirm)) {
            throw new ValidatorException(new FacesMessage("Passwords are not equal."));
        }
    }

}

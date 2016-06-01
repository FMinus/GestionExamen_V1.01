/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AjaxValidators;

import java.util.Calendar;
import java.util.Date;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

/**
 *
 * @author Ayoub
 */
@FacesValidator("dateRangeValidator")
public class DateRangeValidator  implements Validator
{
    @Override
    public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException 
    {
        if (value == null) 
        {
            return;
        }
         
        Object startDateValue = component.getAttributes().get("dateDebut");
        
        if (startDateValue==null) 
        {
            System.out.println("null date :");
            return;
            
        }
        System.out.println("date not null : "+startDateValue);
        
        Date startDate = (Date)startDateValue;
        Date endDate = (Date)value; 
        
        if (endDate.before(startDate)) 
        {
            //throw new ValidatorException(FacesMessageUtil.newBundledFacesMessage(FacesMessage.SEVERITY_ERROR, "", "msg.dateRange", ((Calendar)component).getLabel(), startDate));
        }
    }
    
    public void correctDateEnd()
    {
        
    }
}

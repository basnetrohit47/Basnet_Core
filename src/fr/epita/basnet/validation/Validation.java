package fr.epita.basnet.validation;



import java.util.regex.Matcher;
import java.util.regex.Pattern;


import javafx.scene.control.TextField;

/**
 * this class is to validation part of project
 * @author basnet 
 *@version 
 */
public class Validation {
	/**
	 * this is the methods to validate the empty field
	 * @param name this is the name text field
	 * @param age  this is the age text field
	 * @param number this is the number text field
	 * @param email this is the email text field
	 * @return if text field is empty it will return false and if it is not empty it return false
	 */

	public static boolean  validempty(TextField name,TextField age,TextField number,TextField email)
	{
		if(!name.getText().isEmpty()||!age.getText().isEmpty()||!number.getText().isEmpty()||!email.getText().isEmpty()){
		return true;
	}
		
		else{
			
			return false;
		}

}    
	/**
	 * to check  wheater input is string or not
	 * @param name name text field
	 * @return if input is string returns true or if not return false
	 */
	public static boolean validname(TextField name){
    	Pattern p=Pattern.compile("[a-zA-Z]+");
    	Matcher m=p.matcher(name.getText());
    	if(m.find()&&m.group().equals(name.getText())){
    	return true;
    	}
    	else{
    		
    		return false;
    	}
    }
	/**
	 * to check number input by user is valid or not
	 * @param num number text field;
	 * @return if it is integer with 10 digit real number it return true otherwise return false
	 */
	public static boolean validnumber(TextField num){
		
    	Pattern p=Pattern.compile("^[0-9]{10}$");
    	
    	Matcher m=p.matcher(num.getText());
    	        
       if(m.find()&&m.group().equals(num.getText())){
    		return true;
    	}
    	else{
    		
    		return false;
    	}
    }
	/**
	 * to check age fied is valid or not
	 * @param age
	 * @return if input is  digit integer it return true otherwise return false
	 */
public static boolean validage(TextField age){
		
    	Pattern p=Pattern.compile("^[0-9]{2}$");
    	
    	Matcher m=p.matcher(age.getText());
    	        
       if(m.find()&&m.group().equals(age.getText())){
    		return true;
    	}
    	else{
    		
    		return false;
    	}
    }
public static boolean validid(TextField id){
	
	Pattern p=Pattern.compile("^[0-9]");
	
	Matcher m=p.matcher(id.getText());
	        
   if(m.find()&&m.group().equals(id.getText())){
		return true;
	}
	else{
		
		return false;
	}
}
/**
 * to check valid email address
 * @param email
 * @return if user input is valid email address return true 
 * if not returns false
 */
public static boolean validemail(TextField email){
	
	Pattern p=Pattern.compile("[a-zA-Z0-9][a-zA-Z0-9._]*@[a-zA-Z0-9]+([.][a-zA-Z]+)+");
	
	Matcher m=p.matcher(email.getText());
	        
   if(m.find()&&m.group().equals(email.getText())){
		return true;
	}
	else{
		
		return false;
	}
}
}
package exceptions;
/**
 * Is thrown, if the desired variable could not be found.
 * @author Nils Rohde
 */
public class VariableNotFoundException extends Exception{

	private static final long serialVersionUID = 1L;
	
	public VariableNotFoundException(){
		
	}
	public VariableNotFoundException(String s){
		super(s);
	}
}

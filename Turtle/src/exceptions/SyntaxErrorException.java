package exceptions;
/**
 *@author Nils Rohde
 * Is thrown, if a syntax error was found.
 */
public class SyntaxErrorException extends Exception {

	private static final long serialVersionUID = 1L;
	
	public SyntaxErrorException(){
		
	}
	public SyntaxErrorException(String s){
		super(s);
	}
		
}

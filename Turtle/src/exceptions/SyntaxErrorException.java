package exceptions;

public class SyntaxErrorException extends Exception {
	public SyntaxErrorException(){
		
	}
	public SyntaxErrorException(String s){
		super(s);
	}
		
}
package logic;
/**
 * @author Nils Rohde
 * Interface for all  parsers except the repeat parser.
 */

public interface Parseable {
	/**
	 * Returns the name of the parser. The name is the keyword of the Logo language.
	 * @return Name of the parser
	 */
	public String getName();
	/**
	 * Does all the needed changes to the Turtle.
	 * @param workTurtle The turtle that should be altered
	 * @param args The line of code which should be executed
	 * @throws Exception If an error occurs it throws either ParserNotFoundException, SyntaxErrorException, VariableAlreadyInUseException or VariableNotFoundException.
	 */
	public void handleTurtle(Turtle workTurtle, String[] args) throws Exception;
}

package logic;
import java.util.List;

import exceptions.ParserNotFoundException;
import parsers.Backwards;
import parsers.Clear;
import parsers.Forward;
import parsers.Left;
import parsers.Let;
import parsers.PenDown;
import parsers.PenUp;
import parsers.Reset;
import parsers.Right;
import parsers.SetColor;
/**
 * Coordinates the parsing of the Logo code. It calls the different parsers.
 *
 */
public class Parser {
	private List<Parseable> parserList;
	private Turtle turtle;
	
	/**
	 * Initializes the Parser and an internal Turtle. Also adds all available parsers.
	 */
	public Parser(){
		turtle=new Turtle();
		parserList.add(new Backwards());
		parserList.add(new Forward());
		parserList.add(new Left());
		parserList.add(new Right());
		parserList.add(new Let());
		parserList.add(new PenDown());
		parserList.add(new PenUp());
		parserList.add(new Reset());
		parserList.add(new SetColor());
		parserList.add(new Clear()); 	
	}
	
	/**
	 * Returns the Positions of the compiled code stepwise. If no code is executed, only the start Position is returned.
	 * @return Stepwise array of all Positions
	 */
	public Position[] getTurtlePositions(){
		return turtle.getPositions();
	}
	
	/**
	 * Internal method to call the desired Parser.
	 * @param arguments Line of code to parse
	 * @throws Exception If an error occurs it throws either ParserNotFoundException, SyntaxErrorException, VariableAlreadyInUseException or VariableNotFoundException.
	 */
	private void parse(String arguments) throws Exception{
		String[] args=arguments.split(" ");
		for (Parseable item : parserList) {
			if(item.getName()==args[0]){
				try {
					item.handleTurtle(turtle, args);
				} catch (Exception e) {
					throw e;
				}
				return;
			}
		}
		//You only get here, if there is no Parser with the called name.
		throw new ParserNotFoundException();
	}
	
	/**
	 * Method called from outside to compile the Logo code. Calls all parsers and handles the loop command.
	 * @param arguments Logo code (As linewise String array)
	 * @return Stepwise Positions of the Turtle
	 * @throws Exception If an error occurs it throws either ParserNotFoundException, SyntaxErrorException, VariableAlreadyInUseException or VariableNotFoundException.
	 */
	public Position[] parseAll(String[] arguments) throws Exception{
		for(int i=0;i<arguments.length;i++){
			String[] args=arguments[i].split(" ");
			//Repeat is the only expression which is handled directly by the parser
			if(args[0]=="repeat"){
			//Hier muss dann der Loop gebastelt werden
				
			}
			else{
				try{
					parse(arguments[i]);
				}
				catch (Exception e){
					throw e;
				}
			}
		}
		
		return null;
	}

}

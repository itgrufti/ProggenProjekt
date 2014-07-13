package parsers;

import exceptions.SyntaxErrorException;
import exceptions.VariableNotFoundException;
import logic.Parseable;
import logic.Position;
import logic.Turtle;
/**
 * Sets the new color for the Turtle.
 * throws SyntaxErrorException if the specified color is out of range. If a variable could not be found, a VariableNotFoundException is thrown
 * @author Nils Rohde
 */
public class SetColor implements Parseable {

	@Override
	public String getName() {
		return "setcolor";
	}

	@Override
	public void handleTurtle(Turtle workTurtle, String[] args) throws Exception {
		//Preventing overflow
		if(args.length<2){
			throw new SyntaxErrorException();
		}
		Position wp=workTurtle.getActualPosition();
		Position tmp=new Position(wp.getPositionX(),wp.getPositionY(),wp.getAngle(),wp.getPenState(),wp.getClearScreen(),wp.getColor());
		int color;
		try{
			color=Integer.parseInt(args[1]);
		}//Else its assumed to be a variable --> Fail: Throw unknowVariableException
		catch(NumberFormatException e){
			try{
				color=workTurtle.getVariable(args[1]);
			}
			catch(VariableNotFoundException e2){
				throw e2;
			}
		}
		if(color<0 || color>3){
			throw new SyntaxErrorException();
		}
		tmp.setColor(color);
		tmp.setClearScreen(false);
		workTurtle.setPosition(tmp);
	}

}
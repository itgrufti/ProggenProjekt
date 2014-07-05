package logic;

import java.util.HashMap;

import exceptions.VariableAlreadyInUseException;
import exceptions.VariableNotFoundException;

public class Turtle {
	//Variablen hierher
	private Position actualPosition;
	private Position lastPosition;
	private boolean penState;
	private String color;
	private HashMap<String, Integer> variables;
	
	//Throws exeption for commands oder gitb wert zur�ck
	public int parse(String arguments){
		return 1;
	}
	
	public Turtle() {
		this.actualPosition = new Position();
		this.lastPosition = new Position();
		penState=false;
		color="black";
		
	}
	public void addVariable(String name, int startValue) throws Exception{
		if(variables.get(name)==null){
			if(startValue!=0){
				variables.put(name, startValue);
			}
			else{
				variables.put(name, 0);
			}
		}
		else{
			throw new VariableAlreadyInUseException();
		}
	}

	public int getVariable(String name) throws VariableNotFoundException{
		int tmp=(int) variables.get(name);
		if(tmp!=0){
			return tmp;
		}
		throw new VariableNotFoundException();
	}
	public void setPosition(Position position){
		this.lastPosition=this.actualPosition;
		this.actualPosition=position;
	}

	public Position getActualPosition() {
		return actualPosition;
	}

	public Position getLastPosition() {
		return lastPosition;
	}
	public boolean getPenState(){
		return penState;
	}
	public String getColor(){ 
		return color;
	}

	public void setPenState(boolean penState) {
		this.penState = penState;
	}

	public void setColor(String color) {
		this.color = color;
	}
}

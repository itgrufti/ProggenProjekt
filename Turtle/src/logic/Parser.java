package logic;
import java.util.List;

import exceptions.ParserNotFoundException;
import parsers.Backwards;
import parsers.Forward;
import parsers.Left;
import parsers.Right;

public class Parser {
	//Hier noch die Variablen tuen
	//Hier liste aller Parseable objekte
	private List<Parseable> parserList;
	private Turtle turtle;
	
	
	public Parser(){
		turtle=new Turtle();
		parserList.add(new Backwards());
		parserList.add(new Forward());
		parserList.add(new Left());
		parserList.add(new Right());
		//TODO
		//Add all other parsers
		
	}
	Position[] getTurtlePositions(){
		//Returns the Position Array
		return null;
		
	}
	
	private void parse(String arguments) throws Exception{
		String[] args=arguments.split(" ");
		for (Parseable item : parserList) {
			if(item.getName()==args[0]){
				try {
					item.moveTurtle(turtle, args);
				} catch (Exception e) {
					throw e;
				}
				return;
			}
		}
		//You only get here, if there is no Parser with the called name.
		throw new ParserNotFoundException();
	}
	
	
	public Position[] parseAll(String[] arguments) throws Exception{
		for(int i=0;i<arguments.length;i++){
			String[] args=arguments[i].split(" ");
			//Repeat is the only expression whcih is handled directly by the parser
			if(args[0]=="repeat"){
				//Hier muss dann der Lopp gebastelt werden
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

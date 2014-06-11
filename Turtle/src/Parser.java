import java.util.List;

public class Parser {
	//Hier noch die Variablen tuen
	//Hier liste aller Parseable objekte
	private List<Parseable> parserList;
	
	public int parse(String arguments, Turtle workTurtle){
		String[] args=arguments.split(" ");
		for (Parseable item : parserList) {
			if(item.getName()==args[0]){
				return item.moveTurtle(workTurtle, args);
			}
			else{
				return 666;
			}
		}
	}

}
 

import java.util.ArrayList;

public class PizzaTitanic extends Pizza{

	public PizzaTitanic(ArrayList<String> sabores) {
		
		//Poderão ser passados até 6 sabores
		
		super("Pizza Titanic", 100.0, sabores);
	}

}

 

import java.util.ArrayList;

public class PizzaPequena extends Pizza{
	
	public PizzaPequena(ArrayList<String> sabores) {
		
		//A pizza já inicia com o preço fixo e um sabor
		
		super("Pizza Pequena", 20.0, sabores);
	}

}

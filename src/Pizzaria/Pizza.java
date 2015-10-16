 

import java.util.ArrayList;

public class Pizza extends Produto{
	
	//Toda a pizza terá uma lista de sabores e um pre�o fixo
	
	protected ArrayList<String> sabores;
	
	public Pizza(String nome, double preco, ArrayList<String> sabores) {
		super(preco, nome);
		this.sabores = sabores;
	}
	
	protected ArrayList<String> getSabores(){
		return this.sabores;
	}
}

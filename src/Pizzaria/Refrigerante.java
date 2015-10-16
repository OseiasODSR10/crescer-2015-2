 

public class Refrigerante extends Produto{
	String nomeRefrigerante;
	public Refrigerante(String nome, String nomeDoRefri, double preco) {
		super(preco, nome);
		this.nomeRefrigerante = nomeDoRefri;
	}

}

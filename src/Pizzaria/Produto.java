 

public class Produto {
	protected double preco;
	protected String nomeProduto;
	public Produto(double preco, String nome){
		this.preco = preco;
		this.nomeProduto = nome;
	}
	
	protected double getPreco(){
		return this.preco;
	}

	public String toString(){
		return String.format("%s: R$ %.2f", this.nomeProduto, this.preco);
	}
}

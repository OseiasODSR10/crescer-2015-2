 

public class Cliente {
	
	private String nome;
	private String endereco;
	private String telefone;
	
	public Cliente(String nome, String telefone, String endereco){
		this.nome = nome;
		this.endereco = endereco;
		this.telefone = telefone;
	}
	
	public String getTelefone(){
		return this.telefone;
	}
	public String getNome(){
		return this.nome;
	}
	public String getEndereco(){
		return this.endereco;
	}
}

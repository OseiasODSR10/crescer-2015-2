package br.com.cwi.crescer.dto;

import br.com.cwi.crescer.domain.Cliente;

public class ClienteResumoDto {
	
	private Long id;
	private String nome;
	private String cpf;
	private String email;
	
	public ClienteResumoDto(String nome, String email, String cpf, Long id){
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.cpf = cpf;
	}
	
	public ClienteResumoDto(Cliente entity){
		this.id = entity.getIdCliente();
		this.nome = entity.getNome();
		this.email = entity.getEmail();
		this.cpf = entity.getCpf();
	}
	
	public ClienteResumoDto(){
		
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

}

package Entidades;

import java.util.ArrayList;

public class Usuario {
	
	private int idUsuario;
	private String nome;
	private String senha;
	private String tipo;
	private ArrayList<Turma> turmas;
	
	public Usuario(){
		this.turmas = new ArrayList<Turma>();
	}
	
	public Usuario(int id){
		this();
		this.idUsuario = id;
	}
	
	public int getIdUsuario() {
		return idUsuario;
	}
		
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getSenha() {
		return senha;
	}
	
	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	public ArrayList<Turma> getTurmas(){
		return this.turmas;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
//	public void adicionarTurma(Turma turma){
//		this.turmas.add(turma);
//	}
//	
//	public void removerTurma(Turma turma){
//		this.turmas.remove(turma);
//	}
}

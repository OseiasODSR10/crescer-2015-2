package entidades;

import java.util.ArrayList;

import util.ServicoCriptografia;

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
		try {
			this.senha = ServicoCriptografia.criptografar(senha);
		} catch (Exception e) {
			e.printStackTrace();
		}
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

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}
	
	public void adicionarTurma(Turma turma){
		this.turmas.add(turma);
	}
}

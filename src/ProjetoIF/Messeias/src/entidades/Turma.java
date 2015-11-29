package entidades;

import java.util.ArrayList;

public class Turma {
	
	private int idTurma;
	private String nome;
	private ArrayList<Usuario> usuarios;
	
	public Turma(){
		usuarios = new ArrayList<Usuario>();
	}
	
	public Turma(int id){
		this();
		this.idTurma = id;
	}

	public int getIdTurma() {
		return idTurma;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public ArrayList<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setIdTurma(int idTurma) {
		this.idTurma = idTurma;
	}

//	public void adicionarUsuario(Usuario Usuario){
//		this.Usuarios.add(Usuario);		
//	}
//	
//	public void removerUsuario(Usuario Usuario){
//		this.Usuarios.remove(Usuario);
//	}

}

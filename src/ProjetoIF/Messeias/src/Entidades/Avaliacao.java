package Entidades;

import java.util.ArrayList;
import java.util.Date;

public class Avaliacao {
	
	private int idAvaliacao;
	private String tipo;
	private Date data;
	private String conteudo;
	private String disciplina;
	private Turma turma;
	private Usuario Usuario;
	private ArrayList<Comentario> comentarios;
	
	public Avaliacao(){
		comentarios = new ArrayList<Comentario>();
	}
	
	public Avaliacao(int id){
		this();
		this.idAvaliacao = id;
	}
	
	public String getConteudo(){
		return this.conteudo;
	}
	
	public void setConteudo(String conteudo){
		this.conteudo = conteudo;
	}
	
	public int getIdAvaliacao() {
		return idAvaliacao;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public String getDisciplina() {
		return disciplina;
	}

	public void setDisciplina(String disciplina) {
		this.disciplina = disciplina;
	}

	public Turma getTurma() {
		return turma;
	}

	public void setTurma(Turma turma) {
		this.turma = turma;
	}

	public Usuario getUsuario() {
		return Usuario;
	}

	public void setUsuario(Usuario Usuario) {
		this.Usuario = Usuario;
	}

	public ArrayList<Comentario> getComentarios() {
		return comentarios;
	}
	
	public void adicionarComentario(Comentario comentario){
		this.comentarios.add(comentario);
	}
}
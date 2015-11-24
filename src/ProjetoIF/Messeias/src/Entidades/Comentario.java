package Entidades;

public class Comentario {
	
	private int idComentario;
	private String texto;
	private Usuario usuario;
	private Avaliacao avaliacao;
	
	public Comentario(){
		
	}
	
	public Comentario(int id){
		this.idComentario = id;
	}
	
	public int getIdComentario() {
		return idComentario;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Avaliacao getAvaliacao() {
		return avaliacao;
	}

	public void setAvaliacao(Avaliacao avaliacao) {
		this.avaliacao = avaliacao;
	}
}

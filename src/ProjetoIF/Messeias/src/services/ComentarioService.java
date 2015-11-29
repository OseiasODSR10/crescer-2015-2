package services;

import javax.swing.JOptionPane;

import persistencia.ComentarioDao;
import entidades.Avaliacao;
import entidades.Comentario;
import entidades.Usuario;

public class ComentarioService {
	
	private static ComentarioDao comentarioDao = new ComentarioDao();
	
	public static Comentario criarComentario(String texto, Usuario usuario, Avaliacao avaliacao){
		Comentario comentario = new Comentario();
		comentario.setTexto(texto);
		comentario.setUsuario(usuario);
		comentario.setAvaliacao(avaliacao);
		try {
			return comentarioDao.criar(comentario);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Comentário inválido");
			return null;
		}
	}
}

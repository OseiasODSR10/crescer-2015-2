package services;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import persistencia.ComentarioDao;
import entidades.Avaliacao;
import entidades.Comentario;

public class AvaliacaoService {
	
	private static ComentarioDao comentarioDao = new ComentarioDao();
	
	public static ArrayList<Comentario> buscarComentarios(Avaliacao avaliacao){
		try {
			return comentarioDao.buscarPorAvaliacao(avaliacao.getIdAvaliacao());
		} catch (Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Ocorreu um erro ao buscar os comentário");
			return null;
		}
	}	
}

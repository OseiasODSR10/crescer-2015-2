package services;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;

import javax.swing.JOptionPane;

import persistencia.AvaliacaoDao;
import persistencia.ComentarioDao;
import persistencia.TurmaDao;
import entidades.Avaliacao;
import entidades.Comentario;
import entidades.Turma;
import entidades.Usuario;

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
	
	public static int criar(String tipo, String dia, String mes, String ano, String disciplina, String turmaNome, String conteudo, Usuario usuario){
		Avaliacao avaliacao = new Avaliacao();
		avaliacao.setConteudo(conteudo);
		avaliacao.setTipo(tipo);
		avaliacao.setUsuario(usuario);
		avaliacao.setDisciplina(disciplina);	
		try {
			Turma turma = new TurmaDao().buscarPorNome(turmaNome);
			avaliacao.setTurma(turma);
			Calendar calendario = Calendar.getInstance();
			calendario.set(Integer.parseInt(ano), Integer.parseInt(mes) - 1, Integer.parseInt(dia));
			Date data = new Date(calendario.getTimeInMillis());
			avaliacao.setData(data);
			new AvaliacaoDao().criar(avaliacao);
			return 0;
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Ocorreu um erro ao cadastrar a avalição");
			return -1;
		}
	}
}

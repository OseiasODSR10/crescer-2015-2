package services;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import persistencia.AvaliacaoDao;
import persistencia.TurmaDao;
import entidades.Avaliacao;
import entidades.Turma;

public class TurmaService {
	
	private static TurmaDao turmaDao = new TurmaDao();
	private static AvaliacaoDao avaliacaoDao = new AvaliacaoDao();
	
	public static void cadastrarTurma(String nome){
		Turma turma = new Turma();
		turma.setNome(nome);
		try{
			turmaDao.criar(turma);				
		}catch(Exception e){
			JOptionPane.showMessageDialog(null, "Não foi possível cadastrar.");
		}
	}
	
	public static ArrayList<Avaliacao> buscarAvaliacoes(String nomeTurma){
		try{
			return avaliacaoDao.buscarPorTurma(nomeTurma);
		}catch(Exception e){
			JOptionPane.showMessageDialog(null, "Ocorreu um erro ao buscar as avaliações");
			return null;
		}
	}
}

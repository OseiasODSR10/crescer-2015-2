package persistencia;


import java.math.*;
import java.security.*;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;

import util.ServicoCriptografia;
import entidades.*;

public class Teste {

	public static void main(String[] args) throws Exception{
		UsuarioDao userDown = new UsuarioDao();
		
//		Usuario user1 = new Usuario();
//		user1.setNome("Oséias R");
//		user1.setSenha("dscvd");
//		user1.setTipo("Aluno");
//		
//		Usuario user2 = new Usuario();
//		user2.setNome("Marcos");
//		user2.setSenha("visovhs");
//		user2.setTipo("Aluno");
//		
//		
//		Usuario user3 = new Usuario();
//		user3.setNome("Rodrigo Remor");
//		user3.setSenha("davbfdvjk");
//		user3.setTipo("Professor");
//		
//		userDown.criar(user1);
//		userDown.criar(user2);
//		userDown.criar(user3);
		

//		ArrayList<Usuario> users = userDown.buscarTodos();
//		for(Usuario user : users){
//			System.out.printf("\n%d - %s - %s - %s",
//					user.getIdUsuario(),
//					user.getNome(),
//					user.getTipo(),
//					user.getSenha());
//		}
//		System.out.println("\nate aki foi...");
//		
//		
		
		
//		TurmaDao turmaDown = new TurmaDao();
//		ArrayList<Turma> turmas = turmaDown.buscarTodos();
//		for(Turma turma : turmas){
//			System.out.printf("\n%d - %s",
//					turma.getIdTurma(),
//					turma.getNome());
//		}
		
//		Turma turma = new Turma();
//		turma.setNome("2I");
//		new TurmaDao().criar(turma);
//		System.out.println("Criou");

//		AvaliacaoDao avDao = new AvaliacaoDao();
//		Avaliacao avaliacao = new Avaliacao();
//		Usuario Usuario = new Usuario(3);
//		Turma turma = new Turma(1);
//		Calendar calendario = Calendar.getInstance();
//		calendario.set(2015, 11, 24);
//		Date data = new Date(calendario.getTimeInMillis());
//		avaliacao.setConteudo("Herança");
//		avaliacao.setDisciplina("LP");
//		avaliacao.setTipo("Prova");
//		avaliacao.setData(data);
//		avaliacao.setUsuario(Usuario);
//		avaliacao.setTurma(turma);
//		avDao.criar(avaliacao);
		
//		AvaliacaoDao avDao = new AvaliacaoDao();
//		ArrayList<Avaliacao> avaliacoes = avDao.buscarTodos();
//		for(Avaliacao avaliacao : avaliacoes){
//			System.out.printf("\n%d - %s - %s - %s - %s - %d - %s - %d - %s",
//					avaliacao.getIdAvaliacao(),
//					avaliacao.getTipo(),
//					avaliacao.getData().toString(),
//					avaliacao.getConteudo(),
//					avaliacao.getDisciplina(),
//					avaliacao.getTurma().getIdTurma(),
//					avaliacao.getTurma().getNome(),
//					avaliacao.getUsuario().getIdUsuario(),
//					avaliacao.getUsuario().getNome());
//		}
		
		
		
		//System.out.println(ServicoCriptografia.criptografar("mito"));
		//TODO fazer o MD5
//		String s="Texto de Exemplo";
//		MessageDigest m=MessageDigest.getInstance("MD5");
//		m.update(s.getBytes(),0,s.length());
//		System.out.println(new BigInteger(1,m.digest()).toString(16));
//		AvaliacaoDao avdao = new AvaliacaoDao();
//		Integer[] ids = {1, 2};
//		for(Avaliacao avaliacao : avdao.buscarPorTurmas(ids)){
//			System.out.printf("\n%d - %s - %s - %.10s - %s - %d - %s - %d - %s",
//					avaliacao.getIdAvaliacao(),
//					avaliacao.getTipo(),
//					avaliacao.getData().toString(),
//					avaliacao.getConteudo(),
//					avaliacao.getDisciplina(),
//					avaliacao.getTurma().getIdTurma(),
//					avaliacao.getTurma().getNome(),
//					avaliacao.getUsuario().getIdUsuario(),
//					avaliacao.getUsuario().getNome());			
//		}
//		
//		for(Turma turma : userDown.buscarPorId(1).getTurmas()){
//			System.out.printf("\n%d - %s", turma.getIdTurma(), turma.getNome());
//		}
	}

}

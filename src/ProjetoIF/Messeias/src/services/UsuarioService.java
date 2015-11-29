package services;


import java.util.ArrayList;

import entidades.Avaliacao;
import entidades.Turma;
import entidades.Usuario;
import persistencia.AvaliacaoDao;
import persistencia.UsuarioDao;

public class UsuarioService {
	
	private static UsuarioDao usuarioDao = new UsuarioDao();
	
	public static Usuario criar(String nome, String senha, String tipo){
		Usuario usuario = new Usuario();
		usuario.setNome(nome);
		usuario.setSenha(senha);
		usuario.setTipo(tipo);
		return usuarioDao.criar(usuario);
	}
	
	public static ArrayList<Avaliacao> buscarAvaliacoes(Usuario usuario){
		ArrayList<Integer> idsTurmas = new ArrayList<Integer>();
		for(Turma turma : usuario.getTurmas()){
			idsTurmas.add(turma.getIdTurma());
		}
		Integer[] ids = new Integer[idsTurmas.size()];
		idsTurmas.toArray(ids);
		return new AvaliacaoDao().buscarPorTurmas(ids);
	}
	
	public static Usuario buscar(String nome, String senha){
		Usuario usuario = new Usuario();
		usuario.setNome(nome);
		usuario.setSenha(senha);
		usuario = usuarioDao.buscar(usuario);
		return usuario;
	}
}

package services;


import java.util.ArrayList;

import javax.swing.JOptionPane;

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
		try {
			return usuarioDao.criar(usuario);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Ocorreu um erro ao tentar cadastrar");
			return null;
		}
	}
	
	public static ArrayList<Avaliacao> buscarAvaliacoes(Usuario usuario){
		if(usuario.getTipo().equals("Aluno")){
			ArrayList<Integer> idsTurmas = new ArrayList<Integer>();
			for(Turma turma : usuario.getTurmas()){
				idsTurmas.add(turma.getIdTurma());
			}
			Integer[] ids = new Integer[idsTurmas.size()];
			idsTurmas.toArray(ids);		
			try {
				return new AvaliacaoDao().buscarPorTurmas(ids);
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "Ocorreu um erro ao buscar as avaliações deste usuário");
				return null;
			}
		}else{
			try {
				return new AvaliacaoDao().buscarPorUsuario(usuario.getIdUsuario());
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "Ocorreu um erro ao buscar as avaliações deste usuário");
				return null;
			}
		}
	}
	
	public static Usuario buscar(String nome, String senha){
		Usuario usuario = new Usuario();
		usuario.setNome(nome);
		usuario.setSenha(senha);
		try {
			usuario = usuarioDao.buscar(usuario);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Ocorreu um erro ao buscar o usuário");
		}
		return usuario;
	}
}

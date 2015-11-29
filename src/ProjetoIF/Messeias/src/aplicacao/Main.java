package aplicacao;

import persistencia.UsuarioDao;
import util.LookAndFeel;
import view.Login;
import view.MenuAluno;
import entidades.Usuario;

public class Main {

	public static void main(String[] args){
		try{
		LookAndFeel.setLookAndFeel();
		}catch(Exception e){
			System.out.println("Apenas alguns probleminhas com o layout...");
		}
		Login menu = new Login();
//		Usuario usuario = new UsuarioDao().buscarPorId(1);
//		new MenuAluno(usuario);
	}
}

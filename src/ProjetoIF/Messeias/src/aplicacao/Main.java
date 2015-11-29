package aplicacao;

import util.LookAndFeel;
import view.Cadastro;

public class Main {

	public static void main(String[] args) throws Exception{
		try{
		LookAndFeel.setLookAndFeel();
		}catch(Exception e){
			System.out.println("Apenas alguns probleminhas com o layout...");
		}
//		Login menu = new Login();
		new Cadastro();
//		Usuario usuario = new UsuarioDao().buscarPorId(5);
//		new MenuAluno(usuario);
//		new MenuProfessor(usuario);
//		Integer[] ids = {1};
//		Avaliacao avaliacao = new AvaliacaoDao().buscarPorTurmas(ids).get(0);
//		new InformacoesAvaliacao(avaliacao, usuario);
//		new CadastroTurma(usuario);
	}
}

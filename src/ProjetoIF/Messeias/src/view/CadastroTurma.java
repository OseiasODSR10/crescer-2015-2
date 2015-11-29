package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import services.TurmaService;
import util.LookAndFeel;
import entidades.Usuario;

public class CadastroTurma {
	
	private Usuario usuario;
	private JFrame frame;
	private JButton finalizar, voltar;
	private JLabel nome;
	private JTextField textoNome;
	
	public CadastroTurma(Usuario usuario){
		this.usuario = usuario;
		configurarFrame();
		configurarBody();
		frame.revalidate();
		frame.repaint();
	}
	
	private void configurarFrame(){
		frame = new JFrame("Cadastro de turma");
		frame.setVisible(true);
		frame.setBounds(300, 50, 350, 350);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(null);
	}
	
	private void configurarBody(){
		nome = new JLabel("Nome da turma: ");
		nome.setFont(LookAndFeel.TEXT_FONT);
		nome.setBounds(90, 50, 250, 50);
		frame.add(nome);
		
		textoNome = new JTextField();
		textoNome.setFont(LookAndFeel.TEXT_FONT);
		textoNome.setBorder(BorderFactory.createEmptyBorder(5, 80, 5, 80));
		textoNome.setBounds(60, 120, 225, 40);
		frame.add(textoNome);
		
		finalizar = new JButton("Finalizar");
		finalizar.setFont(LookAndFeel.BTN_FONT);
		finalizar.setBounds(60, 195, 115, 35);
		finalizar.addActionListener(new AcaoFinalizar());
		frame.add(finalizar);
		
		voltar = new JButton("Voltar");
		voltar.setFont(LookAndFeel.BTN_FONT);
		voltar.setBounds(185, 195, 100, 35);
		voltar.addActionListener(new AcaoVoltar());
		frame.add(voltar);
	}
	
	private class AcaoVoltar implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			if(usuario.getTipo().equals("Aluno")){
				new MenuAluno(usuario);
				frame.dispose();
			}else{
				new MenuProfessor(usuario);
				frame.dispose();
			}
		}		
	}
	
	private class AcaoFinalizar implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			String nome = textoNome.getText();
			TurmaService.cadastrarTurma(nome);
			if(usuario.getTipo().equals("Aluno")){
				new MenuAluno(usuario);
				frame.dispose();
			}else{
				new MenuProfessor(usuario);
				frame.dispose();
			}
		}		
	}
}

package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import entidades.Usuario;
import services.UsuarioService;
import util.LookAndFeel;

public class Cadastro {
	
	private JFrame frame;
	private JLabel nome, senha, tipo;
	private JTextField textoNome, textoSenha;
	private JButton voltar, finalizar;
	private JRadioButton professor, aluno;
	private RadioButtonHandler handler = new RadioButtonHandler();
	private ButtonGroup group = new ButtonGroup();
	
	public Cadastro(){
		configurarFrame();
		configurarCampos();
		configurarBotoes();
		frame.revalidate();
		frame.repaint();
	}
	
	private void configurarFrame(){
		frame = new JFrame("Cadastro de Usuario");
		frame.setVisible(true);
		frame.setBounds(300, 100, 400, 450);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(null);
	}
	
	private void configurarCampos(){
		nome = new JLabel("Nome: ");
		nome.setBounds(50, 50, 100, 50);
		nome.setFont(LookAndFeel.TEXT_FONT);
		frame.add(nome);
		
		senha = new JLabel("Senha: ");
		senha.setBounds(45, 150, 100, 50);
		senha.setFont(LookAndFeel.TEXT_FONT);
		frame.add(senha);
		
		tipo = new JLabel("Tipo: ");
		tipo.setBounds(60, 230, 100, 50);
		tipo.setFont(LookAndFeel.TEXT_FONT);
		frame.add(tipo);
		
		textoNome = new JTextField();
		textoNome.setFont(LookAndFeel.TEXT_FONT);
		textoNome.setBounds(150, 60, 200, 30);
		frame.add(textoNome);
		
		textoSenha = new JTextField();
		textoSenha.setFont(LookAndFeel.TEXT_FONT);
		textoSenha.setBounds(150, 160, 200, 30);
		frame.add(textoSenha);
	}
	
	private void configurarBotoes(){
		voltar = new JButton("Voltar");
		voltar.addActionListener(new AcaoVoltar());
		voltar.setFont(LookAndFeel.BTN_FONT);
		voltar.setBounds(90, 315, 100, 30);
		frame.add(voltar);
		
		finalizar = new JButton("Finalizar");
		finalizar.addActionListener(new AcaoFinalizar());
		finalizar.setFont(LookAndFeel.BTN_FONT);
		finalizar.setBounds(200, 315, 115, 30);
		frame.add(finalizar);
		
		professor = new JRadioButton("Professor");
		professor.setFont(LookAndFeel.BTN_FONT);
		professor.setBounds(135, 230, 125, 50);
		professor.addItemListener(handler);
		group.add(professor);
		frame.add(professor);
		
		aluno = new JRadioButton("Aluno");
		aluno.setFont(LookAndFeel.BTN_FONT);
		aluno.setBounds(260, 230, 125, 50);
		aluno.addItemListener(handler);
		group.add(aluno);
		aluno.setSelected(true);
		frame.add(aluno);
	}
	
	private class AcaoVoltar implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			new Login();
			frame.dispose();
		}		
	}
	
	private class AcaoFinalizar implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			String nomeUsuario = textoNome.getText();
			String senhaUsuario = textoSenha.getText();	
			String tipoUsuario = handler.getTipoUsuario();
			Usuario usuario = UsuarioService.criar(nomeUsuario, senhaUsuario, tipoUsuario);
			if(usuario != null){
				if(tipoUsuario.equals("Aluno")){
					new MenuAluno(usuario);
					frame.dispose();
				}else{
					new MenuProfessor(usuario);
					frame.dispose();
				}
			}
		}
	}
	
	private class RadioButtonHandler implements ItemListener{
		String tipoUsuario = "Aluno";
		@Override
		public void itemStateChanged(ItemEvent event) {
			if(professor.isSelected()){
				tipoUsuario = "Professor";
			}
			if(aluno.isSelected()){
				tipoUsuario = "Aluno";
			}
		}
		
		public String getTipoUsuario(){
			return this.tipoUsuario;
		}		
	}
}




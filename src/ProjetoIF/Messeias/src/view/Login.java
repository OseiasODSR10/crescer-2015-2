package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import services.UsuarioService;
import util.LookAndFeel;
import entidades.Usuario;

public class Login {
	
	private JFrame frame;
	private JButton entrar, cadastrar;
	private JLabel nome, senha, titulo;
	private JPasswordField textoSenha;
	private JTextField textoNome;
	
	public Login(){		
		configurarFrame();
		configurarCampos();
		configurarButtons();
		frame.revalidate();
		frame.repaint();
	}
	
	public void configurarFrame(){
		frame = new JFrame("Messeias - Oséias e Marcos - 2I");
		frame.setVisible(true);
		frame.setBounds(300, 100, 500, 500);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(null);
	}
	
	private void configurarCampos(){
		titulo = new JLabel("MESSEIAS");
		titulo.setFont(LookAndFeel.APP_TITLE_FONT);
		titulo.setBounds(150,25,300,100);
		frame.add(titulo);
		
		nome = new JLabel("Nome: ");
		nome.setFont(LookAndFeel.TEXT_FONT);
		nome.setBounds(90, 150, 150, 30);
		frame.add(nome);
		
		senha = new JLabel("Senha: ");
		senha.setFont(LookAndFeel.TEXT_FONT);
		senha.setBounds(85, 200, 150, 30);
		frame.add(senha);
		
		textoNome = new JTextField();
		textoNome.setFont(LookAndFeel.TEXT_FONT);
		textoNome.setBounds(200, 150, 200, 30);
		frame.add(textoNome);
		
		textoSenha = new JPasswordField(16);
		textoSenha.setBounds(200, 200, 200, 30);
		frame.add(textoSenha);
	}
	
	private void configurarButtons(){
		entrar = new JButton("Entrar");
		entrar.setFont(LookAndFeel.BTN_FONT);
		entrar.setBounds(145, 275, 100, 30);
		entrar.addActionListener(new AcaoEntrar());
		frame.add(entrar);
		
		cadastrar = new JButton("Cadastrar");
		cadastrar.setFont(LookAndFeel.BTN_FONT);
		cadastrar.setBounds(260, 275, 115, 30);
		cadastrar.addActionListener(new AcaoCadastrar());
		frame.add(cadastrar);
	}
	
	private class AcaoCadastrar implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {			
			new Cadastro();
			frame.dispose();
		}		
	}
	
	private class AcaoEntrar implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {			
			Usuario usuario = UsuarioService.buscar(textoNome.getText(), textoSenha.getText());
			if(usuario == null){
				JOptionPane.showMessageDialog(null, "Usuário não encontrado");
				textoNome.setText(null);
				textoSenha.setText(null);
			}else{
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
}

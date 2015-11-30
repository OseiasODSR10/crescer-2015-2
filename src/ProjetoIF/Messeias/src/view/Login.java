package view;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
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
	private JLabel nome, senha, titulo, subtitulo, footer;
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
		frame.getContentPane().setBackground(Color.BLACK);
		frame.setLayout(null);
	}
	
	private void configurarCampos(){		
		titulo = new JLabel();
		ImageIcon img = new ImageIcon(getClass().getResource("messeiasIco.png"));
		titulo.setIcon(img);
		titulo.setBackground(Color.BLACK);
		titulo.setBounds(80, 15, frame.getWidth(), 80);
		frame.getContentPane().add(titulo);
		
		subtitulo = new JLabel("O nome não tem nada a ver com o programa :)");
		subtitulo.setBounds(110, 100, 300, 20);
		subtitulo.setFont(LookAndFeel.TABLE_FONT);
		subtitulo.setForeground(Color.WHITE);
		frame.add(subtitulo);
		
		footer = new JLabel("© 2015 Bonde Publishing Inc.");
		footer.setFont(LookAndFeel.COPYRIGHT_FONT);
		footer.setForeground(Color.LIGHT_GRAY);
		footer.setBounds(190, 430, 300, 20);
		frame.add(footer);
		
		nome = new JLabel("Nome: ");
		nome.setFont(LookAndFeel.TEXT_FONT);
		nome.setForeground(Color.RED);
		nome.setBounds(80, 170, 150, 30);
		frame.add(nome);
		
		senha = new JLabel("Senha: ");
		senha.setFont(LookAndFeel.TEXT_FONT);
		senha.setForeground(Color.RED);
		senha.setBounds(75, 220, 150, 30);
		frame.add(senha);
		
		textoNome = new JTextField();
		textoNome.setFont(LookAndFeel.TEXT_FONT);
		textoNome.setBounds(180, 170, 200, 30);
		frame.add(textoNome);
		
		textoSenha = new JPasswordField(16);
		textoSenha.setBounds(180, 220, 200, 30);
		frame.add(textoSenha);
	}
	
	private void configurarButtons(){
		entrar = new JButton("Entrar");
		entrar.setFont(LookAndFeel.BTN_FONT);
		entrar.setBounds(135, 295, 100, 30);
		entrar.addActionListener(new AcaoEntrar());
		frame.add(entrar);
		
		cadastrar = new JButton("Cadastrar");
		cadastrar.setFont(LookAndFeel.BTN_FONT);
		cadastrar.setBounds(250, 295, 115, 30);
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

package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import services.AvaliacaoService;
import services.ComentarioService;
import util.LookAndFeel;
import entidades.Avaliacao;
import entidades.Comentario;
import entidades.Usuario;

public class InformacoesAvaliacao {
	
	private Avaliacao avaliacao;
	private Usuario usuario;
	private JFrame frame;
	private JLabel data, tipo, disciplina, turma, professor, labConteudo;
	private JTextArea comentarios, conteudo, textoComentario;
	private JButton enviar, voltar, atualizar;
	
	public InformacoesAvaliacao(Avaliacao avaliacao, Usuario usuario){
		this.avaliacao = avaliacao;
		this.usuario = usuario;
		configurarFrame();
		configurarHeader();
		configurarComentarios();
		configurarCampoComentario();
		frame.revalidate();
		frame.repaint();
	}
	
	private void configurarFrame(){
		frame = new JFrame("Detalhes da avaliação");
		frame.setVisible(true);
		frame.setBounds(300, 100, 720, 500);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(null);
	}
	
	private void configurarHeader(){
		data = new JLabel(new SimpleDateFormat("dd/MM/yyyy").format(avaliacao.getData()));
		data.setFont(LookAndFeel.BTN_FONT);
		data.setBounds(25, 45, 300, 25);
		frame.add(data);
		
		labConteudo = new JLabel("Conteúdo");
		labConteudo.setFont(LookAndFeel.BTN_FONT);
		labConteudo.setBounds(375, 15, 100, 25);
		frame.add(labConteudo);
				
		tipo = new JLabel(avaliacao.getTipo());
		tipo.setFont(LookAndFeel.BTN_FONT);
		tipo.setBounds(25, 65, 185, 20);
		frame.add(tipo);
		
		disciplina = new JLabel(avaliacao.getDisciplina());
		disciplina.setFont(LookAndFeel.BTN_FONT);
		disciplina.setBounds(25, 85, 185, 20);
		frame.add(disciplina);
		
		turma = new JLabel("Turma " +avaliacao.getTurma().getNome());
		turma.setFont(LookAndFeel.BTN_FONT);
		turma.setBounds(25, 105, 185, 20);
		frame.add(turma);
		
		professor = new JLabel(avaliacao.getUsuario().getNome());
		professor.setFont(LookAndFeel.BTN_FONT);
		professor.setBounds(25, 125, 185, 20);
		frame.add(professor);
		
		conteudo = new JTextArea();
		conteudo.setFont(LookAndFeel.COMMENT_FONT);
		conteudo.setEditable(false);
		conteudo.setLineWrap(true);
		conteudo.setWrapStyleWord(true);
		conteudo.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		JScrollPane scroll = new JScrollPane(conteudo);
		scroll.setBounds(220, 45, 470, 105);
		frame.add(scroll);
		conteudo.setText(avaliacao.getConteudo());
		scroll.repaint();
	}
	
	private void configurarComentarios(){
		comentarios = new JTextArea();
		comentarios.setFont(LookAndFeel.COMMENT_FONT);
		comentarios.setBorder(BorderFactory.createEmptyBorder(10,5,10,5));
		comentarios.setEditable(false);
		comentarios.setLineWrap(true);
		comentarios.setWrapStyleWord(true);
		JScrollPane scroll = new JScrollPane(comentarios);
		scroll.setBounds(25, 160, 665, 200);
		frame.add(scroll);
		scroll.repaint();
		atualizarComentarios();
		
	}
	
	private void atualizarComentarios(){
		comentarios.setText(null);
		avaliacao.setComentarios(AvaliacaoService.buscarComentarios(avaliacao));		
		for(Comentario comentario : avaliacao.getComentarios()){			
			comentarios.append(montarModeloComentario(comentario));
		}
	}
	
	private void configurarCampoComentario(){
		textoComentario = new JTextArea();
		textoComentario.setFont(LookAndFeel.BTN_FONT);
		textoComentario.setLineWrap(true);
		textoComentario.setWrapStyleWord(true);
		JScrollPane scroll = new JScrollPane(textoComentario);
		scroll.setBounds(25, 370, 550, 85);
		frame.add(scroll);
		scroll.repaint();
		
		enviar = new JButton("Enviar");
		enviar.setFont(LookAndFeel.COMMENT_FONT);
		enviar.setBounds(590, 370, 100, 25);
		enviar.addActionListener(new AcaoEnviar());
		frame.add(enviar);
		
		voltar = new JButton("Voltar");
		voltar.setFont(LookAndFeel.COMMENT_FONT);
		voltar.setBounds(590, 430, 100, 25);
		voltar.addActionListener(new AcaoVoltar());
		frame.add(voltar);
		
		atualizar = new JButton("Atualizar");
		atualizar.setFont(LookAndFeel.COMMENT_FONT);
		atualizar.setBounds(590, 400, 100, 25);
		atualizar.addActionListener(new AcaoAtualizar());
		frame.add(atualizar);
	}
	
	private String montarModeloComentario(Comentario comentario){
		String nomeDoUsuario = comentario.getUsuario().getNome().toUpperCase();
		String textoDoComentario = comentario.getTexto();
		String strFormatada = String.format("%s: %s\n", nomeDoUsuario, textoDoComentario);
		return strFormatada;
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
	
	private class AcaoEnviar implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			boolean strVazia = textoComentario.getText() == null || textoComentario.getText().isEmpty();
			if(strVazia){
				JOptionPane.showMessageDialog(null, "Comentario inválido");
			}else{
				String texto = textoComentario.getText();
				Comentario comentario = ComentarioService.criarComentario(texto, usuario, avaliacao);
				if(comentario != null){
					comentarios.append(montarModeloComentario(comentario));	
				}
			}
			textoComentario.setText(null);
		}
	}
	
	private class AcaoAtualizar implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			atualizarComentarios();
		}		
	}
}

package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import services.AvaliacaoService;
import util.LookAndFeel;
import entidades.Usuario;

public class CriacaoAvaliacao {
	
	private JFrame frame;
	private Usuario usuario;
	private JLabel tipo, data, conteudo, disciplina, turma;
	private JTextField textoTipo, textoDia, textoMes, textoAno, textoTurma, textoDisciplina;
	private JTextArea textoConteudo;
	private JButton finalizar, voltar;
	
	public CriacaoAvaliacao(Usuario usuario){
		this.usuario = usuario;
		configurarFrame();
		configurarCorpo();
		configurarCampos();
		frame.revalidate();
		frame.repaint();
	}
	
	private void configurarFrame(){
		frame = new JFrame("Cadastro de Avaliação");
		frame.setVisible(true);
		frame.setBounds(300, 100, 400, 460);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(null);
	}
	
	private void configurarCorpo(){
		tipo = new JLabel("Tipo: ");
		tipo.setFont(LookAndFeel.TEXT_FONT);
		tipo.setBounds(20, 20, 100, 50);
		frame.add(tipo);
		
		data = new JLabel("Data: ");
		data.setFont(LookAndFeel.TEXT_FONT);
		data.setBounds(20, 60, 100, 50);
		frame.add(data);
		
		disciplina = new JLabel("Disciplina: ");
		disciplina.setFont(LookAndFeel.TEXT_FONT);
		disciplina.setBounds(20, 100, 125, 50);
		frame.add(disciplina);
		
		turma = new JLabel("Turma: ");
		turma.setFont(LookAndFeel.TEXT_FONT);
		turma.setBounds(20, 140, 125, 50);
		frame.add(turma);
		
		conteudo = new JLabel("Conteudo: ");
		conteudo.setFont(LookAndFeel.TEXT_FONT);
		conteudo.setBounds(150, 180, 125, 50);
		frame.add(conteudo);
		
		voltar = new JButton("Voltar");
		voltar.setFont(LookAndFeel.BTN_FONT);
		voltar.setBounds(200, 360, 100, 30);
		voltar.addActionListener(new AcaoVoltar());
		frame.add(voltar);
		
		finalizar = new JButton("Finalizar");
		finalizar.setFont(LookAndFeel.BTN_FONT);
		finalizar.setBounds(75, 360, 115, 30);
		finalizar.addActionListener(new AcaoFinalizar());
		frame.add(finalizar);
	}
	
	private void configurarCampos(){
		textoTipo = new JTextField();
		textoTipo.setFont(LookAndFeel.TEXT_FONT);
		textoTipo.setBounds(150, 33, 200, 30);
		frame.add(textoTipo);
		
		textoTurma = new JTextField("ex 2I");
		textoTurma.setFont(LookAndFeel.TEXT_FONT);
		textoTurma.setBounds(150, 148, 200, 30);
		frame.add(textoTurma);
		
		textoDia = new JTextField("Dia");
		textoDia.setFont(LookAndFeel.TEXT_FONT);
		textoDia.setBounds(150, 71, 50, 30);
		frame.add(textoDia);
		
		textoMes = new JTextField("Mês");
		textoMes.setFont(LookAndFeel.TEXT_FONT);
		textoMes.setBounds(215, 71, 50, 30);
		frame.add(textoMes);
		
		textoAno = new JTextField("Ano");
		textoAno.setFont(LookAndFeel.TEXT_FONT);
		textoAno.setBounds(280, 71, 70, 30);
		frame.add(textoAno);
		
		textoDisciplina = new JTextField();
		textoDisciplina.setFont(LookAndFeel.TEXT_FONT);
		textoDisciplina.setBounds(150, 108, 200, 30);
		frame.add(textoDisciplina);
		
		textoConteudo = new JTextArea();
		textoConteudo.setFont(LookAndFeel.COMMENT_FONT);
		textoConteudo.setLineWrap(true);
		textoConteudo.setWrapStyleWord(true);
		textoConteudo.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		JScrollPane scroll = new JScrollPane(textoConteudo);
		scroll.setBounds(20, 230, 330, 100);
		frame.add(scroll);
	}
	
	private class AcaoVoltar implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			new MenuProfessor(usuario);
			frame.dispose();
		}		
	}
	
	private class AcaoFinalizar implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			String tipoAv = textoTipo.getText();
			String diaAv = textoDia.getText();
			String mesAv = textoMes.getText();
			String anoAv = textoAno.getText();
			String conteudoAv = textoConteudo.getText();
			String DisciplinaoAv = textoDisciplina.getText();
			String turmaAv = textoTurma.getText();
			int resultado = AvaliacaoService.criar(tipoAv, diaAv, mesAv, anoAv, DisciplinaoAv, turmaAv, conteudoAv, usuario);
			if(resultado == 0){
				new MenuProfessor(usuario);
				frame.dispose();
			}
		}		
	}
}

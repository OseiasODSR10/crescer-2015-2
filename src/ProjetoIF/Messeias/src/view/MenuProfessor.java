package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import services.TurmaService;
import services.UsuarioService;
import util.LookAndFeel;
import entidades.Avaliacao;
import entidades.Usuario;

public class MenuProfessor{
	
	private JFrame frame;
	private JMenu usuarioMenu, avaliacaoMenu, cronogramaMenu;
	private JMenuBar menuBar;
	private Usuario usuario;
	private ArrayList<Avaliacao> avaliacoes;
	private JLabel usuarioNome, titulo, pesquisa, info;
	private JTextField campoId;
	private JScrollPane body;
	private JButton buscar;
	
	public MenuProfessor(Usuario usuario){
		this.usuario = usuario;				
		this.avaliacoes = UsuarioService.buscarAvaliacoes(usuario);
		configurarFrame();
		configurarMenu();
		configurarCorpo();
		configurarHeader();
		frame.revalidate();
		frame.repaint();
	}

	private void configurarFrame(){
		frame = new JFrame("Menu");
		frame.setVisible(true);
		frame.setBounds(300, 100, 720, 500);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(null);
	}
	
	private void configurarMenu(){
		menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		usuarioMenu = new JMenu(usuario.getNome());
		menuBar.add(usuarioMenu);
		JMenuItem cadastrarNovaTurma = new JMenuItem("Cadastrar nova turma");
		cadastrarNovaTurma.addActionListener(new AcaoCadastrarTurma());
		usuarioMenu.add(cadastrarNovaTurma);
		
		JMenuItem sair = new JMenuItem("Sair");
		sair.addActionListener(new AcaoSair());
		usuarioMenu.add(sair);
		
		avaliacaoMenu = new JMenu("Avaliação");
		menuBar.add(avaliacaoMenu);
		JMenuItem criarAvaliacao = new JMenuItem("Criar avaliação");
		criarAvaliacao.addActionListener(new AcaoCadastrarAvaliacao());
		avaliacaoMenu.add(criarAvaliacao);
		
		
		cronogramaMenu = new JMenu("Cronograma");
		menuBar.add(cronogramaMenu);
		JMenuItem meuCronograma = new JMenuItem("Meu cronograma");
		meuCronograma.addActionListener(new AcaoBuscarMinhasAvaliacoes());
		cronogramaMenu.add(meuCronograma);
		JMenuItem turmaCronograma = new JMenuItem("Cronograma da turma");
		turmaCronograma.addActionListener(new AcaoBuscarAvaliacoesDaTurma());
		cronogramaMenu.add(turmaCronograma);
		
	}
	
	private void configurarHeader(){
		usuarioNome = new JLabel("Usuário: "+usuario.getNome());
		usuarioNome.setFont(LookAndFeel.TEXT_FONT);
		usuarioNome.setBounds(25, 25, 250, 30);
		frame.add(usuarioNome);
		
		titulo = new JLabel("Avaliações");
		titulo.setFont(LookAndFeel.TITLE_FONT);
		titulo.setBounds(300, 70, 200, 50);
		frame.add(titulo);
		
		info = new JLabel("Mais informações: digite o id da avaliação");
		info.setBounds(410, 55, 250, 20);
		frame.add(info);
		
		pesquisa = new JLabel("Pesquisar: ");
		pesquisa.setFont(LookAndFeel.BTN_FONT);
		pesquisa.setBounds(410, 23, 100, 30);
		frame.add(pesquisa);
		
		campoId = new JTextField();
		campoId.setFont(LookAndFeel.TEXT_FONT);
		campoId.setBounds(510, 27, 50, 25);
		frame.add(campoId);
		
		buscar = new JButton("Buscar");
		buscar.setBounds(575, 25, 80, 30);
		buscar.setFont(LookAndFeel.BTN_FONT);
		buscar.addActionListener(new AcaoBuscar());
		frame.add(buscar);
	}
	
	private void configurarCorpo(){
		String[] columnNames = {"ID", "Data", "Tipo", "Disciplina", "Turma", "Professor", "Conteudo"};
		
		Object[][] dados = new Object[avaliacoes.size()][columnNames.length];
		for(int i=0; i<dados.length; i++){
			Avaliacao avaliacao = avaliacoes.get(i);
			Object[] dadosAvaliacao = new String[columnNames.length];
			dadosAvaliacao[0] = ""+avaliacao.getIdAvaliacao();
			dadosAvaliacao[1] = new SimpleDateFormat("dd/MM/yyyy").format(avaliacao.getData()).toString();
			dadosAvaliacao[2] = avaliacao.getTipo();
			dadosAvaliacao[3] = avaliacao.getDisciplina();
			dadosAvaliacao[4] = avaliacao.getTurma().getNome();
			dadosAvaliacao[5] = avaliacao.getUsuario().getNome();
			dadosAvaliacao[6] = avaliacao.getConteudo();
			dados[i] = dadosAvaliacao;
		}
		JTable table = new JTable(dados, columnNames);
		configurarTable(table, dados, columnNames);	
		body = new JScrollPane(table);
		body.setBounds(10, 120, 690, 300);
		frame.add(body);
	}
	
	private void configurarTable(JTable table, Object[][] dados, String[] columnNames){
		@SuppressWarnings("serial")
		DefaultTableModel model = new DefaultTableModel(dados, columnNames)
		{
		    @Override
		    public boolean isCellEditable(int row, int column)
		    {
		        return false;
		    }
		};
		table.setModel(model);
		table.setFont(LookAndFeel.TABLE_FONT);	
		table.getColumnModel().getColumn(0).setPreferredWidth(5);
		table.getColumnModel().getColumn(1).setPreferredWidth(50);
		table.getColumnModel().getColumn(2).setPreferredWidth(45);
		table.getColumnModel().getColumn(3).setPreferredWidth(50);
		table.getColumnModel().getColumn(4).setPreferredWidth(25);
		table.getColumnModel().getColumn(5).setPreferredWidth(80);
		table.getColumnModel().getColumn(6).setPreferredWidth(250);
	}
	
	private class AcaoBuscar implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			String textoid = campoId.getText();
			try{
				int id = Integer.parseUnsignedInt(textoid);
				Avaliacao avaliacao = avaliacoes.get(avaliacoes.indexOf(new Avaliacao(id)));
				new InformacoesAvaliacao(avaliacao, usuario);
				frame.dispose();
			}catch(Exception ex){
				JOptionPane.showMessageDialog(null, "Digite um ID válido");
				campoId.setText(null);
			}
		}		
	}
	
	private class AcaoCadastrarTurma implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			new CadastroTurma(usuario);
			frame.dispose();
		}		
	}
	
	private class AcaoCadastrarAvaliacao implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			new CriacaoAvaliacao(usuario);
			frame.dispose();
		}		
	}
	
	private class AcaoSair implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			new Login();
			frame.dispose();
		}		
	}
	
	private class AcaoBuscarAvaliacoesDaTurma implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			String turma = JOptionPane.showInputDialog("Digite o nome da turma que deseja buscar:");
			if(turma != null){				
				ArrayList<Avaliacao> novasAvaliacoes = TurmaService.buscarAvaliacoes(turma);
				if(novasAvaliacoes != null && novasAvaliacoes.size() > 0){
					avaliacoes = novasAvaliacoes;
					frame.remove(body);
					configurarCorpo();
					
				}else{
					JOptionPane.showMessageDialog(null, "Nenhma avaliação encontrada");
				}
			}
		}		
	}
	
	private class AcaoBuscarMinhasAvaliacoes implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			ArrayList<Avaliacao> novasAvaliacoes = UsuarioService.buscarAvaliacoes(usuario);
			if(novasAvaliacoes != null && novasAvaliacoes.size() > 0){
				avaliacoes = novasAvaliacoes;
				frame.remove(body);
				configurarCorpo();
				
			}else{
				JOptionPane.showMessageDialog(null, "Nenhma avaliação encontrada");
			}
		}	
	}
}

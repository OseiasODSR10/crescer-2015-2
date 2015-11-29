package persistencia;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.mysql.jdbc.Statement;

import entidades.Avaliacao;
import entidades.Turma;
import entidades.Usuario;

public class AvaliacaoDao extends BaseDao<Avaliacao>{

	public AvaliacaoDao(){
		super();
	}
	
	@Override
	public Avaliacao criar(Avaliacao avaliacao) {
		String sqlInsert = "INSERT INTO Messeias.Avaliacao"
				+ "(tipo, data_avaliacao, conteudo, disciplina, id_turma, id_Usuario)"
				+ " VALUES (?, ?, ?, ?, ?, ?)";
		try{
			conexao.abrirBanco();
			PreparedStatement statement = this.conexao.getConexao().prepareStatement(sqlInsert, Statement.RETURN_GENERATED_KEYS);
			statement.setString(1, avaliacao.getTipo());
			statement.setDate(2, new java.sql.Date(avaliacao.getData().getTime()));
			statement.setString(3, avaliacao.getConteudo());
			statement.setString(4, avaliacao.getDisciplina());
			statement.setInt(5, avaliacao.getTurma().getIdTurma());
			statement.setInt(6, avaliacao.getUsuario().getIdUsuario());
			statement.execute();
			ResultSet resultado = statement.getGeneratedKeys();
			if(resultado.next()){
				avaliacao.setIdAvaliacao(resultado.getInt(1));
			}
		}catch(Exception e){
			e.printStackTrace();
		}	
		return avaliacao;
	}

	@Override
	public void atualizar(Avaliacao avaliacao) {
		String sqlUpdate = "UPDATE Messeias.Avaliacao "
				+ "SET tipo = ?, data_avaliacao = ?, conteudo = ?, disciplina = ?, id_turma = ?, id_Usuario = ?"
				+ " WHERE id_avaliacao = ?";
		try{
			conexao.abrirBanco();
			PreparedStatement statement = this.conexao.getConexao().prepareStatement(sqlUpdate);
			statement.setString(1, avaliacao.getTipo());
			statement.setDate(2, new java.sql.Date(avaliacao.getData().getTime()));
			statement.setString(3, avaliacao.getConteudo());
			statement.setString(4, avaliacao.getDisciplina());
			statement.setInt(5, avaliacao.getTurma().getIdTurma());
			statement.setInt(6, avaliacao.getUsuario().getIdUsuario());
			statement.setInt(7, avaliacao.getIdAvaliacao());
			statement.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	@Override
	public void deletar(Avaliacao avaliacao) {
		String sqlDelete = "DELETE FROM Messeias.Avaliacao WHERE id_avaliacao = ? AND "
				+ "tipo = ? AND data_avaliacao = ? AND conteudo = ? AND disciplina = ? "
				+ "AND id_turma = ? AND id_Usuario = ?";
		try{
			conexao.abrirBanco();
			PreparedStatement statement = this.conexao.getConexao().prepareStatement(sqlDelete);
			statement.setInt(1, avaliacao.getIdAvaliacao());
			statement.setString(2, avaliacao.getTipo());
			statement.setDate(3, new java.sql.Date(avaliacao.getData().getTime()));
			statement.setString(4, avaliacao.getConteudo());
			statement.setString(5, avaliacao.getDisciplina());
			statement.setInt(6, avaliacao.getTurma().getIdTurma());
			statement.setInt(7, avaliacao.getUsuario().getIdUsuario());
			statement.execute();
		}catch(Exception e){
			
		}
	}

	@Override
	public ArrayList<Avaliacao> buscarTodos() {
		conexao.abrirBanco();
		ArrayList<Avaliacao> avaliacoes = new ArrayList<Avaliacao>();
		String sqlSelect = "SELECT a.id_avaliacao, a.tipo, a.data_avaliacao, a.conteudo, a.disciplina,"
				+ " a.id_turma, t.nome, "
				+ "a.id_Usuario, p.nome "
				+ "FROM Messeias.Avaliacao a "
				+ "INNER JOIN Messeias.Usuario p ON a.id_Usuario = p.id_Usuario "
				+ "INNER JOIN Messeias.Turma t ON t.id_turma = a.id_turma";
		try{
			PreparedStatement statement = this.conexao.getConexao().prepareStatement(sqlSelect);
			ResultSet resultado = statement.executeQuery();
			while(resultado.next()){
				int idAvaliacao = resultado.getInt(1);
				
				int idTurma = resultado.getInt(6);
				String nomeTurma = resultado.getString(7);
				
				int idUsuario = resultado.getInt(8);
				String nomeUsuario = resultado.getString(9);
				
				Avaliacao avaliacao = new Avaliacao(idAvaliacao);
				avaliacao.setTipo(resultado.getString(2));
				avaliacao.setData(resultado.getDate(3));
				avaliacao.setConteudo(resultado.getString(4));
				avaliacao.setDisciplina(resultado.getString(5));
				Turma turma = new Turma(idTurma);
				turma.setNome(nomeTurma);
				avaliacao.setTurma(turma);
				Usuario Usuario = new Usuario(idUsuario);
				Usuario.setNome(nomeUsuario);
				avaliacao.setUsuario(Usuario);
				
				avaliacoes.add(avaliacao);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return avaliacoes;
	}
	
	public ArrayList<Avaliacao> buscarPorTurmas(Integer[] ids) {
		conexao.abrirBanco();
		ArrayList<Avaliacao> avaliacoes = new ArrayList<Avaliacao>();
		String sqlSelect = "SELECT a.id_avaliacao, a.tipo, a.data_avaliacao, a.conteudo, a.disciplina,"
				+ " a.id_turma, t.nome, "
				+ "a.id_Usuario, p.nome "
				+ "FROM Messeias.Avaliacao a "
				+ "INNER JOIN Messeias.Usuario p ON a.id_Usuario = p.id_Usuario "
				+ "INNER JOIN Messeias.Turma t ON t.id_turma = a.id_turma "
				+ "WHERE 1=1";
		for(int i=1; i<=ids.length; i++){
			sqlSelect = sqlSelect + " OR a.id_turma = ?";
		}
		try{
			PreparedStatement statement = this.conexao.getConexao().prepareStatement(sqlSelect);
			for(int i=0; i<ids.length; i++){
				int id = ids[i];
				statement.setInt(i+1, id);
			}
			ResultSet resultado = statement.executeQuery();
			while(resultado.next()){
				int idAvaliacao = resultado.getInt(1);
				
				int idTurma = resultado.getInt(6);
				String nomeTurma = resultado.getString(7);
				
				int idUsuario = resultado.getInt(8);
				String nomeUsuario = resultado.getString(9);
				
				Avaliacao avaliacao = new Avaliacao(idAvaliacao);
				avaliacao.setTipo(resultado.getString(2));
				avaliacao.setData(resultado.getDate(3));
				avaliacao.setConteudo(resultado.getString(4));
				avaliacao.setDisciplina(resultado.getString(5));
				Turma turma = new Turma(idTurma);
				turma.setNome(nomeTurma);
				avaliacao.setTurma(turma);
				Usuario Usuario = new Usuario(idUsuario);
				Usuario.setNome(nomeUsuario);
				avaliacao.setUsuario(Usuario);
				
				avaliacoes.add(avaliacao);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return avaliacoes;
	}
	
	public ArrayList<Avaliacao> buscarPorUsuario(int id) {
		conexao.abrirBanco();
		ArrayList<Avaliacao> avaliacoes = new ArrayList<Avaliacao>();
		String sqlSelect = "SELECT a.id_avaliacao, a.tipo, a.data_avaliacao, a.conteudo, a.disciplina,"
				+ " a.id_turma, t.nome, "
				+ "a.id_Usuario, p.nome "
				+ "FROM Messeias.Avaliacao a "
				+ "INNER JOIN Messeias.Usuario p ON a.id_Usuario = p.id_Usuario "
				+ "INNER JOIN Messeias.Turma t ON t.id_turma = a.id_turma "
				+ "WHERE p.id_Usuario = ?";
		try{
			PreparedStatement statement = this.conexao.getConexao().prepareStatement(sqlSelect);
			statement.setInt(1, id);
			ResultSet resultado = statement.executeQuery();
			while(resultado.next()){
				int idAvaliacao = resultado.getInt(1);
				
				int idTurma = resultado.getInt(6);
				String nomeTurma = resultado.getString(7);
				
				int idUsuario = resultado.getInt(8);
				String nomeUsuario = resultado.getString(9);
				
				Avaliacao avaliacao = new Avaliacao(idAvaliacao);
				avaliacao.setTipo(resultado.getString(2));
				avaliacao.setData(resultado.getDate(3));
				avaliacao.setConteudo(resultado.getString(4));
				avaliacao.setDisciplina(resultado.getString(5));
				Turma turma = new Turma(idTurma);
				turma.setNome(nomeTurma);
				avaliacao.setTurma(turma);
				Usuario Usuario = new Usuario(idUsuario);
				Usuario.setNome(nomeUsuario);
				avaliacao.setUsuario(Usuario);
				
				avaliacoes.add(avaliacao);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return avaliacoes;
	}
	
//	public ArrayList<Avaliacao> buscarPorId(int id) {
//		conexao.abrirBanco();
//		ArrayList<Avaliacao> avaliacoes = new ArrayList<Avaliacao>();
//		String sqlSelect = "SELECT a.id_avaliacao, a.tipo, a.data_avaliacao, a.conteudo, a.disciplina,"
//				+ " a.id_turma, t.nome, "
//				+ "a.id_Usuario, p.nome "
//				+ "FROM Messeias.Avaliacao a "
//				+ "INNER JOIN Messeias.Usuario p ON a.id_Usuario = p.id_Usuario "
//				+ "INNER JOIN Messeias.Turma t ON t.id_turma = a.id_turma "
//				+ "WHERE a.id_avaliacao = ?";
//		try{
//			PreparedStatement statement = this.conexao.getConexao().prepareStatement(sqlSelect);
//			statement.setInt(1, id);
//			ResultSet resultado = statement.executeQuery();
//			while(resultado.next()){
//				int idAvaliacao = resultado.getInt(1);
//				
//				int idTurma = resultado.getInt(6);
//				String nomeTurma = resultado.getString(7);
//				
//				int idUsuario = resultado.getInt(8);
//				String nomeUsuario = resultado.getString(9);
//				
//				Avaliacao avaliacao = new Avaliacao(idAvaliacao);
//				avaliacao.setTipo(resultado.getString(2));
//				avaliacao.setData(resultado.getDate(3));
//				avaliacao.setConteudo(resultado.getString(4));
//				avaliacao.setDisciplina(resultado.getString(5));
//				Turma turma = new Turma(idTurma);
//				turma.setNome(nomeTurma);
//				avaliacao.setTurma(turma);
//				Usuario Usuario = new Usuario(idUsuario);
//				Usuario.setNome(nomeUsuario);
//				avaliacao.setUsuario(Usuario);
//				
//				avaliacoes.add(avaliacao);
//			}
//		}catch(Exception e){
//			e.printStackTrace();
//		}
//		return avaliacoes;
//	}
}

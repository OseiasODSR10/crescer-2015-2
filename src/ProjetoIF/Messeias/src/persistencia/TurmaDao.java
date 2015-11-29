package persistencia;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.mysql.jdbc.Statement;

import entidades.Turma;

public class TurmaDao extends BaseDao<Turma>{
	
	public TurmaDao(){
		super();
	}

	@Override
	public Turma criar(Turma turma) throws Exception {
		String sqlInsert = "INSERT INTO Messeias.Turma(nome) VALUES (?)";
		this.conexao.abrirBanco();
		PreparedStatement statement = this.conexao.getConexao().prepareStatement(sqlInsert, Statement.RETURN_GENERATED_KEYS);
		statement.setString(1, turma.getNome());
		statement.execute();
		ResultSet resultado = statement.getGeneratedKeys();
		if(resultado.next()){
			turma.setIdTurma(resultado.getInt(1));
		}
		return turma;
	}

	@Override
	public void atualizar(Turma turma) throws Exception{
		String sqlUpdate = "UPDATE Messeias.Turma SET nome = ? WHERE id_turma = ?";
		this.conexao.abrirBanco();
		PreparedStatement statement = this.conexao.getConexao().prepareStatement(sqlUpdate);
		statement.setString(1, turma.getNome());
		statement.setInt(2, turma.getIdTurma());
		statement.executeUpdate();	
	}

	@Override
	public void deletar(Turma turma) throws Exception{
		String sqlDelete = "DELETE FROM Messeias.Turma WHERE id_turma = ? AND nome = ?";
		this.conexao.abrirBanco();
		PreparedStatement statement = this.conexao.getConexao().prepareStatement(sqlDelete);
		statement.setInt(1, turma.getIdTurma());
		statement.setString(2, turma.getNome());
		statement.execute();		
	}
	
	public Turma buscarPorNome(String nome) throws Exception{
		Turma turma = null;
		String sqlDelete = "SELECT id_turma, nome FROM Messeias.Turma WHERE nome = ?";
		this.conexao.abrirBanco();
		PreparedStatement statement = this.conexao.getConexao().prepareStatement(sqlDelete);
		statement.setString(1, nome);
		ResultSet resultado = statement.executeQuery();	
		if(resultado.next()){
			turma = new Turma(resultado.getInt(1));
			turma.setNome(resultado.getString(2));
		}
		return turma;
	}
}

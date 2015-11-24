package persistencia;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Entidades.Turma;

public class TurmaDao extends BaseDao<Turma>{
	
	public TurmaDao(){
		super();
	}

	@Override
	public void criar(Turma turma) {
		String sqlInsert = "INSERT INTO Messeias.Turma(nome) VALUES (?)";
		try{
			this.conexao.abrirBanco();
			PreparedStatement statement = this.conexao.getConexao().prepareStatement(sqlInsert);
			statement.setString(1, turma.getNome());
			statement.execute();
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	@Override
	public void atualizar(Turma turma) {
		String sqlUpdate = "UPDATE Messeias.Turma SET nome = ? WHERE id_turma = ?";
		try{
			this.conexao.abrirBanco();
			PreparedStatement statement = this.conexao.getConexao().prepareStatement(sqlUpdate);
			statement.setString(1, turma.getNome());
			statement.setInt(2, turma.getIdTurma());
			statement.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
		}		
	}

	@Override
	public void deletar(Turma turma) {
		String sqlDelete = "DELETE FROM Messeias.Turma WHERE id_turma = ? AND nome = ?";
		try {
			this.conexao.abrirBanco();
			PreparedStatement statement = this.conexao.getConexao().prepareStatement(sqlDelete);
			statement.setInt(1, turma.getIdTurma());
			statement.setString(2, turma.getNome());
			statement.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public ArrayList<Turma> buscarTodos() {
		ArrayList<Turma> turmas = new ArrayList<Turma>();
		String sqlSelect = "SELECT id_turma, nome FROM Messeias.Turma";
		try{
			this.conexao.abrirBanco();
			PreparedStatement statement = this.conexao.getConexao().prepareStatement(sqlSelect);
			ResultSet resultado = statement.executeQuery();
			while(resultado.next()){
				int id = resultado.getInt(1);
				String nome = resultado.getString(2);
				Turma turma = new Turma(id);
				turma.setNome(nome);
				turmas.add(turma);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return turmas;
	}

}

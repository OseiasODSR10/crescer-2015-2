package persistencia;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import entidades.Turma;
import entidades.Usuario;

public class UsuarioTurmaDao {

	private ConexaoMysql conexao;
	
	public UsuarioTurmaDao(){
		try{
			conexao = new ConexaoMysql("localhost", "messeias", "root", "");
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public void criar(Usuario usuario, Turma turma) throws Exception{
		String sqlInsert = "INSERT INTO Messeias.Usuario_Turma (Id_Usuario, Id_Turma) VALUES (?, ?)";
		try{
			this.conexao.abrirBanco();
			PreparedStatement statement = this.conexao.getConexao().prepareStatement(sqlInsert);
			statement.setInt(1, usuario.getIdUsuario());
			statement.setInt(2, turma.getIdTurma());
			statement.execute();
		}catch(Exception e){
			throw e;
		}finally{
			conexao.fecharBanco();
		}
	}
	
	public ArrayList<Usuario> buscarUsuarios(Turma turma) throws Exception{
		ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
		String sqlSelect = "SELECT usuario.id_usuario, usuario.nome, usuario.tipo "
				+ "FROM Messeias.Usuario_Turma u_t "
				+ "RIGHT JOIN Messeias.Usuario usuario ON usuario.id_usuario = u_t.id_usuario "
				+ "WHERE u_t.id_turma = ?";
		try{
			conexao.abrirBanco();
			PreparedStatement statement = this.conexao.getConexao().prepareStatement(sqlSelect);
			statement.setInt(1, turma.getIdTurma());
			ResultSet resultado = statement.executeQuery();
			while(resultado.next()){
				int idUsuario = resultado.getInt(1);
				Usuario usuario = new Usuario(idUsuario);
				usuario.setNome(resultado.getString(2));
				usuario.setTipo(resultado.getString(3));
				usuarios.add(usuario);
			}	
		}catch(Exception e){
			throw e;
		}finally{
			conexao.fecharBanco();
		}
		return usuarios;
	}
}

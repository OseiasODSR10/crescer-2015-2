package persistencia;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import Entidades.Usuario;

public class UsuarioDao extends BaseDao<Usuario>{
	
	public UsuarioDao(){
		super();
	}

	@Override
	public void criar(Usuario usuario) {
		String sqlInsert = "INSERT INTO Messeias.Usuario(nome, senha, tipo) VALUES (?, ?, ?)";
		try{
			this.conexao.abrirBanco();
			PreparedStatement statement = this.conexao.getConexao().prepareStatement(sqlInsert);
			statement.setString(1, usuario.getNome());
			statement.setString(2, usuario.getSenha());
			statement.setString(3, usuario.getTipo());
			statement.execute();
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	@Override
	public void atualizar(Usuario usuario) {
		String sqlUpdate = "UPDATE Messeias.Usuario SET nome = ?, senha = ?, tipo = ? WHERE id_Usuario = ?";
		try{
			this.conexao.abrirBanco();
			PreparedStatement statement = this.conexao.getConexao().prepareStatement(sqlUpdate);
			statement.setString(1, usuario.getNome());
			statement.setString(2, usuario.getSenha());
			statement.setString(3, usuario.getTipo());
			statement.setInt(4, usuario.getIdUsuario());
			statement.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	@Override
	public void deletar(Usuario usuario) {
		String sqlUpdate = "DELETE FROM Messeias.Usuario WHERE nome = ? AND senha = ? AND id_Usuario = ? AND tipo = ?";
		try{
			this.conexao.abrirBanco();
			PreparedStatement statement = this.conexao.getConexao().prepareStatement(sqlUpdate);
			statement.setString(1, usuario.getNome());
			statement.setString(2, usuario.getSenha());
			statement.setInt(3, usuario.getIdUsuario());
			statement.setString(4, usuario.getTipo());
			statement.execute();
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	@Override
	public ArrayList<Usuario> buscarTodos() {
		ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
		String sqlSelect = "SELECT id_Usuario, nome, senha, tipo FROM Messeias.Usuario";
		try{
			this.conexao.abrirBanco();
			PreparedStatement statement = this.conexao.getConexao().prepareStatement(sqlSelect);
			ResultSet resultado = statement.executeQuery();
			
			while(resultado.next()){
				int id = resultado.getInt(1);
				Usuario usuario = new Usuario(id);
				usuario.setNome(resultado.getString(2));
				usuario.setSenha(resultado.getString(3));
				usuario.setTipo(resultado.getString(4));
				usuarios.add(usuario);
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
		return usuarios;
	}
}

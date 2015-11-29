package persistencia;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.mysql.jdbc.Statement;

import entidades.Turma;
import entidades.Usuario;

public class UsuarioDao extends BaseDao<Usuario>{
	
	public UsuarioDao(){
		super();
	}

	@Override
	public Usuario criar(Usuario usuario) throws Exception {
		String sqlInsert = "INSERT INTO Messeias.Usuario(nome, senha, tipo) VALUES (?, ?, ?)";
		this.conexao.abrirBanco();
		PreparedStatement statement = this.conexao.getConexao().prepareStatement(sqlInsert, Statement.RETURN_GENERATED_KEYS);
		statement.setString(1, usuario.getNome());
		statement.setString(2, usuario.getSenha());
		statement.setString(3, usuario.getTipo());
		statement.execute();
		ResultSet resultado = statement.getGeneratedKeys();
		if(resultado.next()){
			usuario.setIdUsuario(resultado.getInt(1));
		}
		return usuario;
	}

	@Override
	public void atualizar(Usuario usuario) throws Exception {
		String sqlUpdate = "UPDATE Messeias.Usuario SET nome = ?, senha = ?, tipo = ? WHERE id_Usuario = ?";
		this.conexao.abrirBanco();
		PreparedStatement statement = this.conexao.getConexao().prepareStatement(sqlUpdate);
		statement.setString(1, usuario.getNome());
		statement.setString(2, usuario.getSenha());
		statement.setString(3, usuario.getTipo());
		statement.setInt(4, usuario.getIdUsuario());
		statement.executeUpdate();
	}

	@Override
	public void deletar(Usuario usuario) throws Exception {
		String sqlUpdate = "DELETE FROM Messeias.Usuario WHERE nome = ? AND senha = ? AND id_Usuario = ? AND tipo = ?";
		this.conexao.abrirBanco();
		PreparedStatement statement = this.conexao.getConexao().prepareStatement(sqlUpdate);
		statement.setString(1, usuario.getNome());
		statement.setString(2, usuario.getSenha());
		statement.setInt(3, usuario.getIdUsuario());
		statement.setString(4, usuario.getTipo());
		statement.execute();
	}
	
	public Usuario buscarPorId(int idUsuario) throws Exception {
		Usuario usuario = new Usuario(idUsuario);
		String sqlSelect = "SELECT u.id_Usuario, u.nome, u.senha, u.tipo FROM Messeias.Usuario u "
				+ "WHERE u.id_usuario = ?";
		this.conexao.abrirBanco();
		PreparedStatement statement = this.conexao.getConexao().prepareStatement(sqlSelect);
		statement.setInt(1, idUsuario);
		ResultSet resultado = statement.executeQuery();
		while(resultado.next()){
			usuario.setNome(resultado.getString(2));
			usuario.setSenha(resultado.getString(3));
			usuario.setTipo(resultado.getString(4));
		}
		return usuario;
	}	
	
	public Usuario buscar(Usuario usuarioBusca) throws Exception {
		Usuario usuario = null;
		String sqlSelect = "SELECT u.id_Usuario, u.nome, u.senha, u.tipo, t.id_Turma, t.Nome FROM Messeias.Usuario u "
				+ "LEFT JOIN Messeias.usuario_turma us ON us.Id_Usuario = u.Id_Usuario "
				+ "LEFT JOIN Messeias.turma t ON t.Id_Turma = us.Id_Turma "
				+ "WHERE u.nome = ? AND u.senha = ?";
		this.conexao.abrirBanco();
		PreparedStatement statement = this.conexao.getConexao().prepareStatement(sqlSelect);
		statement.setString(1, usuarioBusca.getNome());
		statement.setString(2, usuarioBusca.getSenha());
		ResultSet resultado = statement.executeQuery();
		while(resultado.next()){
			if(usuario == null){
				usuario = new Usuario(resultado.getInt(1));
			}
			usuario.setNome(resultado.getString(2));
			usuario.setSenha(resultado.getString(3));
			usuario.setTipo(resultado.getString(4));
			Turma turma = new Turma(resultado.getInt(5));
			turma.setNome(resultado.getString(6));
			usuario.adicionarTurma(turma);
		}
		return usuario;
	}
}

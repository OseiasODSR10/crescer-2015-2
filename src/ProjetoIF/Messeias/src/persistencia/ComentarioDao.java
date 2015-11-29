package persistencia;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.mysql.jdbc.Statement;

import entidades.Comentario;
import entidades.Usuario;

public class ComentarioDao extends BaseDao<Comentario>{

	@Override
	public Comentario criar(Comentario comentario) throws Exception {	
		String sqlInsert = "INSERT INTO Messeias.Comentario(texto, id_usuario, id_avaliacao) VALUES (?, ?, ?)";
		conexao.abrirBanco();
		PreparedStatement statement = conexao.getConexao().prepareStatement(sqlInsert, Statement.RETURN_GENERATED_KEYS);
		statement.setString(1, comentario.getTexto());
		statement.setInt(2, comentario.getUsuario().getIdUsuario());
		statement.setInt(3, comentario.getAvaliacao().getIdAvaliacao());
		statement.execute();
		ResultSet resultado = statement.getGeneratedKeys();
		if(resultado.next()){
			comentario.setIdComentario(resultado.getInt(1));
		}
		return comentario;
	}

	@Override
	public void atualizar(Comentario comentario) {
		//TODO Adicionar possibilidade de edição de comentários
	}

	@Override
	public void deletar(Comentario comentario) {	
		//TODO Adicionar possibilidade de esxlusão de comentarios
	}
	
	public ArrayList<Comentario> buscarPorAvaliacao(int idAvaliacao) throws Exception{
		ArrayList<Comentario> comentarios = new ArrayList<Comentario>();
		String sqlSelect = "SELECT c.id_comentario, c.texto, u.Nome FROM Messeias.Comentario c "
				+ "INNER JOIN Messeias.Usuario u ON c.Id_Usuario = u.Id_Usuario "
				+ "WHERE c.id_avaliacao = ? "
				+ "ORDER BY c.id_comentario";
		conexao.abrirBanco();
		PreparedStatement statement = conexao.getConexao().prepareStatement(sqlSelect);
		statement.setInt(1, idAvaliacao);
		ResultSet resultado = statement.executeQuery();
		while(resultado.next()){
			Comentario comentario = new Comentario(resultado.getInt(1));
			comentario.setTexto(resultado.getString(2));
			Usuario usuario = new Usuario();
			usuario.setNome(resultado.getString(3));
			comentario.setUsuario(usuario);
			comentarios.add(comentario);
		}
		return comentarios;
	}
}

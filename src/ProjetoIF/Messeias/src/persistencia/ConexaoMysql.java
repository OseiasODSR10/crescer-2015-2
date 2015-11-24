package persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class ConexaoMysql {
	protected Connection conexao;
	private String ip;
	private String bd;
	private String usuario;
	private String senha;

	public ConexaoMysql(String ip, String bd, String usuario, String senha) throws SQLException {
		this.ip = ip;
		this.bd = bd;
		this.usuario = usuario;
		this.senha = senha;
	}

	public Connection getConexao() {
		return conexao;
	}

	public void setConexao(Connection conexao) {
		this.conexao = conexao;
	}
	
	public void abrirBanco() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String endereco = "jdbc:mysql://" + ip + "/" + bd;

			this.conexao = DriverManager.getConnection(endereco, usuario, senha);
			
		} catch (Exception e) {
			System.out.println("Ocorreu o seguinte erro ao efetuar a conexão com o banco: "+ e.getMessage());
			e.printStackTrace();
		}
	}

	public void fecharBanco() {
		try {
			if (conexao != null) {
				conexao.close();
			}
		} catch (Exception e) {
			System.out.println("Ocorreu o seguinte erro ao fechar o banco: "
					+ e.getMessage());
		}
	}
	
}

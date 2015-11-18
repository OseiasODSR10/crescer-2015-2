package br.com.cwi.crescer.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.cw.crescer.jdbc.ConnectionFactory;
import br.com.cwi.crescer.model.Cliente;
import br.com.cwi.crescer.model.Servico;

public class ServicoDao {
	public void insert(Servico servico) throws Exception{
		try {
			Connection conexao = new ConnectionFactory().getConnection();
			String sql = "INSERT INTO servico (idServico, dsServico) VALUES (?, ?)";
			PreparedStatement statement = conexao.prepareStatement(sql);
			statement.setLong(1, servico.getIdServico());
			statement.setString(2, servico.getDsServico());
			statement.execute();
			statement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void update(Servico servico) throws Exception{
		try {
			Connection conexao = new ConnectionFactory().getConnection();
			String sql = "UPDATE servico SET dsServico=? WHERE idServico = ?";
			PreparedStatement statement = conexao.prepareStatement(sql);
			statement.setString(1, servico.getDsServico());
			statement.setLong(2, servico.getIdServico());
			statement.execute();
			statement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void delete(int idServico) throws Exception{
		try {
			Connection conexao = new ConnectionFactory().getConnection();
			String sql = "DELETE FROM servico WHERE idServico=?";
			PreparedStatement statement = conexao.prepareStatement(sql);
			statement.setLong(1, idServico);
			statement.execute();
			statement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public List<Servico> listAll() throws Exception{
		List<Servico> lista = new ArrayList<Servico>();
		try {
			Connection conexao = new ConnectionFactory().getConnection();
			String sql = "SELECT idServico, dsServico FROM servico";
			PreparedStatement statement = conexao.prepareStatement(sql);
			ResultSet resultSet = statement.executeQuery();
			while(resultSet.next()){
				Servico servico = new Servico();
				servico.setIdServico(resultSet.getLong(1));
				servico.setDsServico(resultSet.getNString(2));
				lista.add(servico);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return lista;
	}
	
	public Servico load(long idServico) throws Exception{
		Servico servico = new Servico();
		try {
			Connection conexao = new ConnectionFactory().getConnection();
			String sql = "SELECT idServico, dsServico FROM servico WHERE idServico=?";
			PreparedStatement statement = conexao.prepareStatement(sql);
			statement.setLong(1, idServico);
			ResultSet resultSet = statement.executeQuery();
			if(resultSet.next()){
				servico.setIdServico(resultSet.getLong(1));
				servico.setDsServico(resultSet.getNString(2));
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return servico;
	}
}

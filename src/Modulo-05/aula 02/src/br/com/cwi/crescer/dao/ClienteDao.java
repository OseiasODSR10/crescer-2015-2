package br.com.cwi.crescer.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.cw.crescer.jdbc.ConnectionFactory;
import br.com.cwi.crescer.model.Cliente;

public class ClienteDao {
	
	public void insert(Cliente cliente) throws Exception{
		try {
			Connection conexao = new ConnectionFactory().getConnection();
			String sql = "INSERT INTO cliente (idCliente, nmCliente, nrCpf) VALUES (cliente_seq.nextVal, ?, ?)";
			PreparedStatement statement = conexao.prepareStatement(sql);
			statement.setString(1, cliente.getNmCliente());
			statement.setString(2, cliente.getNrCpf());
			statement.execute();
			statement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void update(Cliente cliente) throws Exception{
		try {
			Connection conexao = new ConnectionFactory().getConnection();
			String sql = "UPDATE cliente SET nmCliente=?, nrCpf=? WHERE idCliente = ?";
			PreparedStatement statement = conexao.prepareStatement(sql);
			statement.setString(1, cliente.getNmCliente());
			statement.setString(2, cliente.getNrCpf());
			statement.setLong(3, cliente.getIdCliente());
			statement.execute();
			statement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void delete(int idCliente) throws Exception{
		try {
			Connection conexao = new ConnectionFactory().getConnection();
			String sql = "DELETE FROM cliente WHERE idCliente=?";
			PreparedStatement statement = conexao.prepareStatement(sql);
			statement.setLong(1, idCliente);
			statement.execute();
			statement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public List<Cliente> listAll() throws Exception{
		List<Cliente> lista = new ArrayList<Cliente>();
		try {
			Connection conexao = new ConnectionFactory().getConnection();
			String sql = "SELECT idCliente, nmCliente, nrCpf FROM cliente";
			PreparedStatement statement = conexao.prepareStatement(sql);
			ResultSet resultSet = statement.executeQuery();
			while(resultSet.next()){
				Cliente cliente = new Cliente();
				cliente.setIdCliente(resultSet.getLong(1));
				cliente.setNmCliente(resultSet.getNString(2));
				cliente.setNrCpf(resultSet.getString(3));
				lista.add(cliente);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return lista;
	}
	
	public List<Cliente> find(Cliente cliente) throws Exception{
		List<Cliente> lista = new ArrayList<Cliente>();
		try {
			Connection conexao = new ConnectionFactory().getConnection();
			StringBuilder sql = new StringBuilder();
			sql.append("SELECT idCliente, nmCliente, nrCpf FROM cliente WHERE 1=1");
			List<Object> parameters = new ArrayList<Object>();
			if(cliente.getNmCliente() != null){
				sql.append(" AND nmCliente = ?");
				parameters.add(cliente.getNmCliente());
			}
			if(cliente.getNrCpf() != null){
				sql.append(" AND nrCpf = ?");
				parameters.add(cliente.getNrCpf());
			}
			if(cliente.getIdCliente() > 0){
				sql.append(" AND idCliente = ?");
				parameters.add(cliente.getIdCliente());
			}
			
			PreparedStatement statement = conexao.prepareStatement(sql.toString());
			
			for(int i=0; i < parameters.size(); i++){
				statement.setObject(i+1, parameters.get(i));
			}
			
			ResultSet resultSet = statement.executeQuery();
			
			while(resultSet.next()){
				Cliente clienteAdd = new Cliente();
				clienteAdd.setIdCliente(resultSet.getLong(1));
				clienteAdd.setNmCliente(resultSet.getNString(2));
				clienteAdd.setNrCpf(resultSet.getString(3));
				lista.add(clienteAdd);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return lista;
	}
	
	public Cliente load(int idCliente) throws Exception{
		Cliente cliente = new Cliente();
		try {
			Connection conexao = new ConnectionFactory().getConnection();
			String sql = "SELECT idCliente, nmCliente, nrCpf FROM cliente WHERE idCliente=?";
			PreparedStatement statement = conexao.prepareStatement(sql);
			statement.setLong(1, idCliente);
			ResultSet resultSet = statement.executeQuery();
			if(resultSet.next()){
				cliente.setIdCliente(resultSet.getLong(1));
				cliente.setNmCliente(resultSet.getNString(2));
				cliente.setNrCpf(resultSet.getString(3));
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return cliente;
	}
}

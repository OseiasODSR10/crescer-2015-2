package br.com.cwi.crescer.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.cw.crescer.jdbc.ConnectionFactory;
import br.com.cwi.crescer.model.Cliente;
import br.com.cwi.crescer.model.Pedido;

public class PedidoDao {
	
	public void insert(Pedido pedido) throws Exception{
		if(pedido.getCliente() == null){
			System.out.println("É necessário um cliente para inserir o pedido");
		}else{
			try {
				Connection conexao = new ConnectionFactory().getConnection();
				String sql = "INSERT INTO pedido (idPedido, idcliente, dsPedido) VALUES (pedido_seq.nextVal, ?, ?)";
				PreparedStatement statement = conexao.prepareStatement(sql);
				statement.setLong(1, pedido.getCliente().getIdCliente());
				statement.setString(2, pedido.getDsPedido());
				statement.execute();
				statement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public List<Pedido> listAllByClient(long idCliente) throws Exception{
		List<Pedido> lista = new ArrayList<Pedido>();
		try {
			Connection conexao = new ConnectionFactory().getConnection();
			String sql = "SELECT idPedido, idCliente, dsPedido FROM pedido WHERE idCliente = ?";
			PreparedStatement statement = conexao.prepareStatement(sql);
			statement.setLong(1, idCliente);
			ResultSet resultSet = statement.executeQuery();
			while(resultSet.next()){
				Cliente clienteDestePedido;
				clienteDestePedido = new ClienteDao().load(resultSet.getLong(2));
				Pedido pedido = new Pedido(clienteDestePedido);
				pedido.setIdPedido(resultSet.getLong(1));
				pedido.setDsPedido(resultSet.getNString(3));
				lista.add(pedido);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return lista;
	}
}

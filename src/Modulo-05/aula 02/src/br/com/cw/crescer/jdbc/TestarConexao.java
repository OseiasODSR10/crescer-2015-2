package br.com.cw.crescer.jdbc;

import java.util.ArrayList;

import br.com.cwi.crescer.dao.*;
import br.com.cwi.crescer.model.*;

public class TestarConexao {
	
	public static void main(String [] args){
		
//		try{
//			for(Pedido ped : new PedidoDao().listAllByClient(2)){
//				System.out.println("Id do pedido: "+ped.getIdPedido());
//				System.out.println("Descricao do pedido: "+ped.getDsPedido());
//				System.out.println("Cliente do pedido: "+ped.getCliente().getNmCliente());		
//			}
//		}catch(Exception e){
//			e.printStackTrace();
//		}
		
//		try{
//			Cliente cliente = new Cliente();
//			cliente.setIdCliente(2);
//			cliente.setNmCliente("oseias");
//			cliente.setNrCpf("dsvsv");
//			Pedido pedido = new Pedido(cliente);
//			pedido.setDsPedido("um pedido");
//			new PedidoDao().insert(pedido);
//			System.out.println("Inseriu !!");
//		}catch(Exception e){
//			e.printStackTrace();
//		}
//		
//		try{
//			Servico servico = new Servico();
//			servico.setIdServico(2);
//			servico.setDsServico("um servico");
//			new ServicoDao().insert(servico);
//		}catch(Exception e){
//			e.printStackTrace();
//		}
//		try{
//			Cliente cliente = new Cliente();
//			cliente.setIdCliente(1);
//			cliente.setNmCliente("Oseias Rdgs");
//			cliente.setNrCpf("043213");
//			new ClienteDao().update(cliente);
//		}catch(Exception e){
//			e.printStackTrace();
//		}
//		
//		try {
//			new ConnectionFactory().getConnection();
//			System.out.println("conectou");
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		
		
//		try{
//			Cliente cliente = new Cliente();
//			cliente.setIdCliente(1);
//			cliente.setNmCliente("Oseias");
//			cliente.setNrCpf("fwrdfv");
//			ArrayList<Cliente> clientes = new ArrayList<Cliente>();
//			clientes = (ArrayList<Cliente>) new ClienteDao().find(cliente);
//			for(Cliente cli : clientes){
//				System.out.println(cli.getNmCliente());
//				System.out.println(cli.getIdCliente());
//				System.out.println(cli.getNrCpf());
//			}
//			System.out.println("Finalizou");
//		}catch(Exception e){
//			e.printStackTrace();
//		}
		
//		Servico servico = new Servico();
//		servico.setDsServico("desc");
//		servico.setIdServico(1);
//		try{
//			new ServicoDao().insert(servico);
//			System.out.println("foi...");
//		}catch(Exception e){
//			e.printStackTrace();
//		}
		
//		try{
//			Cliente cliente = new ClienteDao().load(1);
//			System.out.println(cliente.getNmCliente());
//			System.out.println(cliente.getIdCliente());
//			System.out.println(cliente.getNrCpf());
//		}catch(Exception e){
//			e.printStackTrace();
//		}
		
//		try{
//			new ClienteDao().delete(1);
//			System.out.println("deletou");			
//		} catch(Exception e){
//			e.printStackTrace();
//		}
		
//		Cliente cliente = new Cliente();
//		cliente.setIdCliente(1);
//		cliente.setNmCliente("Oseias RRT");
//		cliente.setNrCpf("04839");
//		
//		try {
//			new ClienteDao().insert(cliente);
//			System.out.println("ate aki foi");
//		} catch (Exception e) {
//			e.printStackTrace();
//		}		
	}
}

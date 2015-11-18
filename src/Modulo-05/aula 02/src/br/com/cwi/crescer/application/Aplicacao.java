package br.com.cwi.crescer.application;
import java.util.Scanner;

import br.com.cwi.crescer.dao.*;
import br.com.cwi.crescer.model.*;

public class Aplicacao {
	
	
	public static void main(String[] args){
		int escolha = 0;
		Aplicacao app = new Aplicacao();
		Scanner teclado = new Scanner(System.in);
		while(true){
			System.out.println("\n\n==============MENU=============="
					+ "\n1 - Cadastrar Pedido"
					+ "\n2 - Buscar Pedidos de cliente");
			escolha = teclado.nextInt();
			switch(escolha){
			case 1: 
				app.cadastrarPedido();
				break;
			case 2: 
				try{
					app.listarPedidosDeCliente();
				}catch(Exception e){
					e.printStackTrace();
				}
				break;
			default: System.exit(0);
			}
		}
	}
	
	public void cadastrarPedido(){
		Scanner teclado = new Scanner(System.in);
		System.out.println("Digite o id do cliente que fez o pedido:");
		long idCliente = teclado.nextLong();
		teclado.nextLine();
		Cliente clienteDestepedido = null;
		try {
			clienteDestepedido = new ClienteDao().load(idCliente);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if(clienteDestepedido == null){
			System.out.println("Este cliente é invalido");
			return;
		}
		System.out.println("Digite a descricao deste pedido");
		String desc = teclado.nextLine();
		Pedido pedido = new Pedido(clienteDestepedido);
		pedido.setDsPedido(desc);
		try {
			new PedidoDao().insert(pedido);
			System.out.println("Pedido cadastrado com sucesso");
		} catch (Exception e) {
			System.out.println("Erro ao cadastrar pedido");
			e.printStackTrace();
		}
	}
	
	public void listarPedidosDeCliente() throws Exception{
		Scanner teclado = new Scanner(System.in);
		System.out.println("\r\r===== Lista de clientes ======");
		System.out.printf("\n|%5.5s | %25.25s | %25.25s |", "ID CLIENTE", "NOME DO CLIENTE", "CPF DO CLIENTE");
		for(Cliente cliente : new ClienteDao().listAll()){
			System.out.printf("\n|%5d | %25.25s | %25.25s |", 
					cliente.getIdCliente(),
					cliente.getNmCliente(),
					cliente.getNrCpf());
		}
		System.out.println("\nDigite o id do cliente do qual você deseja buscar os pedidos");
		long idCliente = teclado.nextLong();
		System.out.printf("\n|%10.10s | %25.25s | %25.25s | %.25s ", "ID PEDIDO", "ID CLIENTE", "NOME DO CLIENTE", "DESCRICAO DO PEDIDO");
		for(Pedido pedido : new PedidoDao().listAllByClient(idCliente)){
			System.out.printf("\n|%10d | %25.25s | %25.25s | %.200s ",
				pedido.getIdPedido(), 
				pedido.getCliente().getIdCliente(),
				pedido.getCliente().getNmCliente(),
				pedido.getDsPedido());
		}
	}
}

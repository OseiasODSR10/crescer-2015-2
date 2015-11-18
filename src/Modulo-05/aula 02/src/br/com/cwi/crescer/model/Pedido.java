package br.com.cwi.crescer.model;

public class Pedido {
	
	private long idPedido;
	private Cliente cliente;
	private String dsPedido;
	
	public Pedido(Cliente cliente){
		this.cliente = cliente;
	}
	
	public long getIdPedido() {
		return idPedido;
	}
	public void setIdPedido(long idPedido) {
		this.idPedido = idPedido;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public String getDsPedido() {
		return dsPedido;
	}
	public void setDsPedido(String dsPedido) {
		this.dsPedido = dsPedido;
	}

}

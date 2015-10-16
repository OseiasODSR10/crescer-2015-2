 
import java.util.ArrayList;

public class Pedido {
		private double valorTotal;
		private double valorInformadoPeloCliente;
		private double teleEntrega;
		private double desconto;
		private ArrayList<Produto> produtos = new ArrayList<Produto>();
		private Cliente cliente;
		
		public void informarCliente(Cliente cliente){
			this.cliente = cliente;
		}
		
		public void adicionarProduto(Produto produto){
			this.produtos.add(produto);
		}
		
		public void calcularPreco(){
			for(Produto produto: produtos){
				
				this.valorTotal += produto.getPreco();
				
			}
			if(valorTotal < 60){
				
				this.teleEntrega = 4.50;
				this.valorTotal += this.teleEntrega;
				
			} else if(valorTotal >= 100){
				
				this.desconto = (valorTotal*0.1);
				this.valorTotal -= this.desconto;
				
			}
		}
				
		public void informarValorEmMaos(double valor){
			this.valorInformadoPeloCliente = valor;
		}
		
		public double getDesconto(){
		    return this.desconto;
		}
		
		public double getTeleEntrega(){
		    return this.teleEntrega;
		}
		
		public double getValorTotal(){
			return this.valorTotal;
		}
		
		public double getValorInformadoPeloCliente(){
			return this.valorInformadoPeloCliente;
		}
		
		public String imprimirComprovante(){
			String comprovante;
			comprovante = String.format("Nome do Cliente: %s\n"
									  + "Endereço: %s\n"
									  + "Telefone: %s\n"
									  + "Valor total do pedido: R$ %.2f\n"
									  + "Valor informado pelo Cliente: R$ %.2f\n"
									  + "Valor do troco: R$ %.2f\n", 
									  cliente.getNome(),
									  cliente.getEndereco(),
									  cliente.getTelefone(),
									  this.getValorTotal(),
									  this.getValorInformadoPeloCliente(),
									  (this.getValorInformadoPeloCliente() - this.getValorTotal()));
			
			return comprovante 
					+ "---- Descrição do Serviço -----\n" 
					+ this.imprimirServicos();
		}
		
		public String imprimirServicos(){
			String listaServicos = "";
			for(Produto produto: produtos){
				listaServicos += produto.toString()+"\n";
			}
			String possuiTeleEntrega = this.getTeleEntrega()>0? String.format("Tele Entrega: R$ %.2f\n", this.getTeleEntrega()): "";
			String possuiDesconto = this.getDesconto()>0? String.format("Desconto: R$ %.2f", this.getDesconto()): "";
			return listaServicos
					+possuiDesconto
					+possuiTeleEntrega;
		}
		
}



import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;


public class PedidoTest
{
    @Test
    public void compraUmaPizzaPequenaEPagaAPizzaEATeleEntrega(){
        ArrayList<String> meusSabores = new ArrayList<String>();
        meusSabores.add("Sabor 1");
        Pizza pizzaPequena = new PizzaPequena(meusSabores);
        
        Pedido pedido = new Pedido();
        pedido.adicionarProduto(pizzaPequena);
        pedido.calcularPreco();
        
        assertEquals(24.50, pedido.getValorTotal(), 0);
        assertEquals(4.50, pedido.getTeleEntrega(), 0);
    }
    
    @Test
    public void compraUmaPizzaTitanicEGanhaDescontoAlemDeNãoPagarTeleEntrega(){
        ArrayList<String> meusSabores = new ArrayList<String>();
        meusSabores.add("Sabor 1");
        meusSabores.add("Sabor 2");
        meusSabores.add("Sabor 3");
        meusSabores.add("Sabor 4");
        meusSabores.add("Sabor 5");
        meusSabores.add("Sabor 6");
        Pizza pizzaPequena = new PizzaTitanic(meusSabores);
        
        Pedido pedido = new Pedido();
        pedido.adicionarProduto(pizzaPequena);
        pedido.calcularPreco();
        
        assertEquals(90.00, pedido.getValorTotal(), 0);
        assertEquals(0.0, pedido.getTeleEntrega(), 0);
    }
    
    @Test
    public void compraTresPizzasPequenasEElasFicamNaListaDeServicos(){
        ArrayList<String> meusSabores = new ArrayList<String>();
        meusSabores.add("Sabor 1");
        Pizza pizzaPequena = new PizzaPequena(meusSabores);
        Pizza pizzaPequena2 = new PizzaPequena(meusSabores);
        Pizza pizzaPequena3 = new PizzaPequena(meusSabores);
        
        Pedido pedido = new Pedido();
        pedido.adicionarProduto(pizzaPequena);
        pedido.adicionarProduto(pizzaPequena2);
        pedido.adicionarProduto(pizzaPequena3);
        pedido.calcularPreco();
        
        assertEquals(60.00, pedido.getValorTotal(), 0);
        assertEquals(0.00, pedido.getTeleEntrega(), 0);
        assertEquals("Pizza Pequena: R$ 20,00"
        +"\nPizza Pequena: R$ 20,00"
        +"\nPizza Pequena: R$ 20,00\n"
        ,pedido.imprimirServicos());
    }
    
    @Test
    public void compraSetePizzasPequenasEElasFicamNaListaDeServicosJuntoComODesconto(){
        ArrayList<String> meusSabores = new ArrayList<String>();
        meusSabores.add("Sabor 1");
        Pizza pizzaPequena = new PizzaPequena(meusSabores);
        Pizza pizzaPequena2 = new PizzaPequena(meusSabores);
        Pizza pizzaPequena3 = new PizzaPequena(meusSabores);
        Pizza pizzaPequena4 = new PizzaPequena(meusSabores);
        Pizza pizzaPequena5 = new PizzaPequena(meusSabores);
        
        Pedido pedido = new Pedido();
        pedido.adicionarProduto(pizzaPequena);
        pedido.adicionarProduto(pizzaPequena2);
        pedido.adicionarProduto(pizzaPequena3);
        pedido.adicionarProduto(pizzaPequena4);
        pedido.adicionarProduto(pizzaPequena5);
        pedido.calcularPreco();
        
        assertEquals(90.00, pedido.getValorTotal(), 0);
        assertEquals(0.00, pedido.getTeleEntrega(), 0);
        assertEquals(10.00, pedido.getDesconto(),0);
        assertEquals("Pizza Pequena: R$ 20,00"
        +"\nPizza Pequena: R$ 20,00"
        +"\nPizza Pequena: R$ 20,00"
        +"\nPizza Pequena: R$ 20,00"
        +"\nPizza Pequena: R$ 20,00"
        +"\nDesconto: R$ 10,00"
        ,pedido.imprimirServicos());
    }
    
    @Test
    public void pizzariaImprimeAsInformaçõesDoPedidoCorretamente(){
        Cliente cliente = new Cliente("Oséias", "12345678", "Rua x do bairro y");
		
		ArrayList<String> meusSabores = new ArrayList<String>();
		meusSabores.add("Sabor 1");
		Pizza pizzaP = new PizzaPequena(meusSabores);
		
		Refrigerante refri = new Refri2L("Coca-Cola");
		
		Pedido pedido = new Pedido();
		pedido.informarCliente(cliente);
		pedido.adicionarProduto(refri);
		pedido.adicionarProduto(pizzaP);
		pedido.informarValorEmMaos(100.0);
		pedido.calcularPreco();
		
		assertEquals("Nome do Cliente: Oséias"
		+"\nEndereço: Rua x do bairro y"
		+"\nTelefone: 12345678"
		+"\nValor total do pedido: R$ 31,50"
		+"\nValor informado pelo Cliente: R$ 100,00"
		+"\nValor do troco: R$ 68,50"
		+"\n---- Descrição do Serviço -----"
		+"\nRefrigerante 2 Litros: R$ 7,00"
		+"\nPizza Pequena: R$ 20,00"
		+"\nTele Entrega: R$ 4,50\n"
		,pedido.imprimirComprovante());
    }
    
    @Test
    public void pizzariaImprimeAsInformaçõesDoPedidoCorretamentePizzaTitanicComDesconto(){
        Cliente cliente = new Cliente("Oséias", "12345678", "Rua x do bairro y");
		
		ArrayList<String> meusSabores = new ArrayList<String>();
		meusSabores.add("Sabor 1");
		meusSabores.add("Sabor 3");
		meusSabores.add("Sabor 2");
		Pizza pizzaP = new PizzaTitanic(meusSabores);
		
		Refrigerante refri = new Refri2L("Coca-Cola");
		
		Pedido pedido = new Pedido();
		pedido.informarCliente(cliente);
		pedido.adicionarProduto(refri);
		pedido.adicionarProduto(pizzaP);
		pedido.informarValorEmMaos(100.0);
		pedido.calcularPreco();
		
		assertEquals("Nome do Cliente: Oséias"
		+"\nEndereço: Rua x do bairro y"
		+"\nTelefone: 12345678"
		+"\nValor total do pedido: R$ 96,30"
		+"\nValor informado pelo Cliente: R$ 100,00"
		+"\nValor do troco: R$ 3,70"
		+"\n---- Descrição do Serviço -----"
		+"\nRefrigerante 2 Litros: R$ 7,00"
		+"\nPizza Titanic: R$ 100,00"
		+"\nDesconto: R$ 10,70"
		,pedido.imprimirComprovante());
    }
}



import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class InventárioTest
{
    @Test
    public void umItemÉAdicionadoAoInventário(){
        Item faca = new Item ("Faca", 2);
        Inventario inventario = new Inventario();
        inventario.adicionarItem(faca);
        assertEquals(inventario.getItem(0), faca);
    }
    
    @Test
    public void inventárioImprimeADescriçãoDeTodosOsItensCorretamente(){
        Item faca = new Item("Faca", 2);
        Item anel = new Item("Anel",1);
        Inventario inventario = new Inventario();
        inventario.adicionarItem(faca);
        inventario.adicionarItem(anel);
        assertEquals("Faca,Anel", inventario.getDescricoesItens());
    }
    
    @Test
    public void inventárioMostraItemComMaiorQuantidade(){
        Item faca = new Item("Faca", 2);
        Item anel = new Item("Anel",1);
        Inventario inventario = new Inventario();
        inventario.adicionarItem(faca);
        inventario.adicionarItem(anel);
        assertEquals(faca, inventario.getItemComMaiorQuantidade());
    }
    
    @Test
    public void inventárioMostraNullParaItemComMaiorQuantidadeQuandoEleEstáVazio(){
        Inventario inventário = new Inventario();
        assertEquals(null, inventário.getItemComMaiorQuantidade());
    }
    
    @Test
    public void inventárioOrdenaItensCorretamenteDeAcordoComOTamanhaEmOrdemAscendente(){
        Inventario inventario = new Inventario();
        Item faca = new Item("Faca", 2);
        Item anel = new Item("Anel",1);
        Item espada = new Item("Espada", 20);
        Item bota = new Item("Bota",10);
        inventario.adicionarItem(bota);
        inventario.adicionarItem(espada);
        inventario.adicionarItem(faca);
        inventario.adicionarItem(anel);
        inventario.ordenarItens();
        assertEquals("Anel,Faca,Bota,Espada", inventario.getDescricoesItens());
    }
    
    @Test
    public void inventárioOrdenaItensCorretamenteDeAcordoComOTamanhaEmOrdemAscendenteCom10Itens(){
        Inventario inventario = new Inventario();
        Item item[] = new Item[10];
        for(int i=0; i<10; i++){
            String nomeDoItem = "item"+i;
            item[i] = new Item(nomeDoItem, i);
            inventario.adicionarItem(item[i]);
        }
        inventario.ordenarItens();
        assertEquals("item0,item1,item2,item3,item4,item5,item6,item7,item8,item9", inventario.getDescricoesItens());
    }
}

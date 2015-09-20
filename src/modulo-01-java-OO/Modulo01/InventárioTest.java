

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class InventárioTest
{
    @Test
    public void umItemÉAdicionadoAoInventário(){
        Item faca = new Item ("Faca", 2);
        Inventário inventário = new Inventário();
        inventário.adicionarItem(faca);
        assertEquals(inventário.getItem(0), faca);
    }
    
    @Test
    public void inventárioImprimeADescriçãoDeTodosOsItensCorretamente(){
        Item faca = new Item("Faca", 2);
        Item anel = new Item("Anel",1);
        Inventário inventário = new Inventário();
        inventário.adicionarItem(faca);
        inventário.adicionarItem(anel);
        assertEquals("Faca, Anel", inventário.getDescricoesItens());
    }
    
    @Test
    public void inventárioMostraItemComMaiorQuantidade(){
        Item faca = new Item("Faca", 2);
        Item anel = new Item("Anel",1);
        Inventário inventário = new Inventário();
        inventário.adicionarItem(faca);
        inventário.adicionarItem(anel);
        assertEquals(faca, inventário.getItemComMaiorQuantidade());
    }
    
    @Test
    public void inventárioMostraNullParaItemComMaiorQuantidadeQuandoEleEstáVazio(){
        Inventário inventário = new Inventário();
        assertEquals(null, inventário.getItemComMaiorQuantidade());
    }
    
    @Test
    public void inventárioOrdenaItensCorretamenteDeAcordoComOTamanhaEmOrdemAscendente(){
        Inventário inventário = new Inventário();
        Item faca = new Item("Faca", 2);
        Item anel = new Item("Anel",1);
        Item espada = new Item("Espada", 20);
        Item bota = new Item("Bota",10);
        inventário.adicionarItem(bota);
        inventário.adicionarItem(espada);
        inventário.adicionarItem(faca);
        inventário.adicionarItem(anel);
        inventário.ordenarItens();
        assertEquals("Anel, Faca, Bota, Espada", inventário.getDescricoesItens());
    }
}

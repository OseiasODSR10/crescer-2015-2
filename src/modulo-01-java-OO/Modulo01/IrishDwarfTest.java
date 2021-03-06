

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class IrishDwarfTest
{
   @Test
   public void irishDwarfGanhaVariosItensComSorte(){
       IrishDwarf irish = new IrishDwarf("Anão", new DataTerceiraEra(1,1,2000));
       Item item = new Item ("Item", 3);
       Item itemEsperado = new Item("Item", 6003);
       
       irish.adicionarItemAoInventario(item);
       
       irish.perderVida();
       irish.perderVida();
       irish.tentarSorte();
       assertEquals(itemEsperado.getQuantidade(), irish.getQuantidadeDeItemDoInventario(0));
    }
    
    
    @Test
   public void irishDwarfGanhaVariosItensDiferentesComSorte(){
       IrishDwarf irish = new IrishDwarf("Anão", new DataTerceiraEra(1,1,2000));
       Item item = new Item ("Item", 3);
       Item item2 = new Item ("Item2", 40);
       Item item3 = new Item ("Item3", 300);
       Item itemEsperado = new Item("Item", 6003);
       
       irish.adicionarItemAoInventario(item);
       irish.adicionarItemAoInventario(item2);
       irish.adicionarItemAoInventario(item3);
       
       irish.perderVida();
       irish.perderVida();
       irish.tentarSorte();
       assertEquals(itemEsperado.getQuantidade(), irish.getQuantidadeDeItemDoInventario(0));
       assertEquals(820040, irish.getQuantidadeDeItemDoInventario(1));
       assertEquals(45150300, irish.getQuantidadeDeItemDoInventario(2));
    }
}



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
       
       irish.adicionarItemAoInventário(item);
       
       irish.perderVida();
       irish.perderVida();
       irish.tentarSorte();
       assertEquals(itemEsperado.getQuantidade(), irish.getItem(0).getQuantidade());
    }
    
    
    @Test
   public void irishDwarfGanhaVariosItensDiferentesComSorte(){
       IrishDwarf irish = new IrishDwarf("Anão", new DataTerceiraEra(1,1,2000));
       Item item = new Item ("Item", 3);
       Item item2 = new Item ("Item2", 40);
       Item item3 = new Item ("Item3", 300);
       Item itemEsperado = new Item("Item", 6003);
       
       irish.adicionarItemAoInventário(item);
       irish.adicionarItemAoInventário(item2);
       irish.adicionarItemAoInventário(item3);
       
       irish.perderVida();
       irish.perderVida();
       irish.tentarSorte();
       assertEquals(itemEsperado.getQuantidade(), irish.getItem(0).getQuantidade());
       assertEquals(820040, irish.getItem(1).getQuantidade());
       assertEquals(45150300, irish.getItem(2).getQuantidade());
    }
}

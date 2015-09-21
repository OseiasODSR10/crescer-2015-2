

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
}

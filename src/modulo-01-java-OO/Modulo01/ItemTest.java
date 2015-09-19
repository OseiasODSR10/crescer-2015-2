

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class ItemTest
{
   @Test
   public void itemÉCriadoInformandoAQuantidadeEADescrição(){
       Item item = new Item("Faca", 1);
       assertEquals(1, item.getQuantidade());
       assertEquals("Faca", item.getDescrição());
    }
    
    @Test
    public void itemPossuiQuantidadeCorretaDeItemInformado(){
        Item vinteFacas = new Item("Faca", 20);
        assertEquals(20, vinteFacas.getQuantidade());
    }
    
    @Test
    public void itemPossuiONomeInformado(){
        Item anel = new Item ("Anel", 1);
        assertEquals("Anel", anel.getDescrição());
    }
}

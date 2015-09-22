

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ElfoVerdeTest
{
    @Test
    public void elfoVerdeGanha2DeExperiencia(){
        ElfoVerde elfoVerde = new ElfoVerde("Elfo V");
        elfoVerde.atirarFlecha();
        assertEquals(2, elfoVerde.getExperiencia());
    }
    
    @Test
    public void elfoVerdeGanhaBastanteExperiencia(){
        ElfoVerde elfoVerde = new ElfoVerde("Elfo V");
        for(int i=0; i<10;i++){
            elfoVerde.atirarFlecha();
        }
        assertEquals(20, elfoVerde.getExperiencia());
    }
    
    @Test
    public void elfoVerdeAdicionaItemAoInventarioEspadaAçoValiriano(){
        ElfoVerde elfoVerde = new ElfoVerde("Elfo V"); 
        elfoVerde.adicionarItemAoInventário(new Item("Espada de aço valiriano", 1));
        Item itemEsperado = new Item("Espada de aço valiriano", 1);
        assertEquals(itemEsperado, elfoVerde.getItem(0));
    }
    
    @Test
    public void elfoVerdeAdicionaItemAoInventarioArcoEFlechaDeVidro(){
        ElfoVerde elfoVerde = new ElfoVerde("Elfo V"); 
        elfoVerde.adicionarItemAoInventário(new Item("Arco e Flecha de Vidro", 1));
        Item itemEsperado = new Item("Arco e Flecha de Vidro", 1);
        assertEquals(itemEsperado, elfoVerde.getItem(0));
    }
    
    @Test
    public void elfoVerdeNaoAdicionaItemAoInventario(){
        ElfoVerde elfoVerde = new ElfoVerde("Elfo V"); 
        elfoVerde.adicionarItemAoInventário(new Item("Arco não Valiriano", 1));
        assertEquals(0, elfoVerde.getItens().getItens().size());
    }
}

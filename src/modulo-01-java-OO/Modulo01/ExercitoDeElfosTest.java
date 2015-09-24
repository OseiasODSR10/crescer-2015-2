

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.*;


public class ExercitoDeElfosTest
{
    @Test
    public void elfoNãoÉAlistado(){
        ExercitoDeElfos exercito = new ExercitoDeElfos();
        exercito.alistarElfo(new Elfo("Legolas"));
        assertEquals(null, exercito.buscarNomeDoElfo("Legolas"));
    }
    
    @Test
    public void elfoÉAlistadoElfoVerde(){
        ExercitoDeElfos exercito = new ExercitoDeElfos();
        ElfoVerde elfinho = new ElfoVerde("Legolas");
        exercito.alistarElfo(elfinho);
        assertEquals(elfinho, exercito.buscarNomeDoElfo("Legolas"));
    }
    
    @Test
    public void elfoÉAlistadoElfoNoturno(){
        ExercitoDeElfos exercito = new ExercitoDeElfos();
        ElfoNoturno elfinho = new ElfoNoturno("Legolas");
        exercito.alistarElfo(elfinho);
        assertEquals(elfinho, exercito.buscarNomeDoElfo("Legolas"));
    }
    
    @Test
    public void doisElfosSãoAlistados(){
        ExercitoDeElfos exercito = new ExercitoDeElfos();
        ElfoNoturno elfinho = new ElfoNoturno("Legolas");
        ElfoNoturno elfinho2 = new ElfoNoturno("Legolas2");
        exercito.alistarElfo(elfinho);
        exercito.alistarElfo(elfinho2);
        assertEquals(elfinho, exercito.buscarNomeDoElfo("Legolas"));
        assertEquals(elfinho2, exercito.buscarNomeDoElfo("Legolas2"));
    }
    
    
}

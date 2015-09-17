import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class ElfoTest
{
    @Test
    public void elfoInformandoApenasONomeNasceCom42Flechas(){
        Elfo elfinho = new Elfo("Elfinho");
        assertEquals(42, elfinho.getFlechas());
    }
    
    @Test
    public void elfoCriadoComNomeNullNasceComNomeNull(){
        Elfo elfinho = new Elfo(null);
        assertNull(elfinho.getNome());
    }
        
    @Test
    public void elfoNasceComONomeVazioSeInformarONomeVazio(){
        Elfo elfinho = new Elfo("");
        assertEquals("", elfinho.getNome());
    }
    
    @Test
    public void elfoNasceComONomeInformado(){
        Elfo elfinho = new Elfo("Elfinho");
        assertEquals("Elfinho", elfinho.getNome());
    }
    
    @Test
    public void elfoNasceComPoucasFlechas(){
        Elfo elfo = new Elfo("Elfo humilde",2);
        assertEquals("Elfo humilde", elfo.getNome());
        assertEquals(2, elfo.getFlechas());
    }
    
    @Test
    public void elfoNasceComMuitasFlechas(){
        Elfo elfo = new Elfo("Elfo humilde",200);
        assertEquals("Elfo humilde", elfo.getNome());
        assertEquals(200, elfo.getFlechas());
    }
    
    @Test
    public void elfoNasceComFlechasNegativas(){
        Elfo elfo = new Elfo("Elfo humilde",-1);
        assertEquals("Elfo humilde", elfo.getNome());
        assertEquals(-1, elfo.getFlechas());
    }
    
    @Test
    public void elfoCriadoNasceCom0DeExperiência(){
        Elfo elfo = new Elfo("Elfinho");
        assertEquals(0, elfo.getExperiencia());
    }
    
    @Test
    public void elfoNasceComONomeEFlechasInformados(){
        Elfo elfinho = new Elfo("Elfinho", 100);
        assertEquals("Elfinho", elfinho.getNome());
        assertEquals(100, elfinho.getFlechas());
    }
    
    @Test
    public void elfoPerdeUmaFlechaAoAtirarFlecha(){
        Elfo elfinho = new Elfo("Elfinho");
        elfinho.atirarFlecha();
        assertEquals(41, elfinho.getFlechas());
    }
    
    @Test
    public void elfoRetornaInformaçõesCorretamente(){
        Elfo elfinho = new Elfo("Elfinho");
        assertEquals("Elfinho possui 42 flechas e 0 níveis de experiência.", elfinho.toString());
    }
    
    @Test
    public void elfoPerdeUmaFlechaAoCaçaeDwarf(){
        Elfo elfinho = new Elfo("Elfinho");
        elfinho.caçarDwarf(new Dwarf("Anão"));
        assertEquals(41, elfinho.getFlechas());
    }
    
    @Test
    public void elfoAtiraFlechaEmDwarf(){
        Elfo elfo = new Elfo("Elfinho");
        Dwarf anao = new Dwarf("Anão");
        elfo.caçarDwarf(anao);
        assertEquals(41, elfo.getFlechas());
        assertEquals(1,elfo.getExperiencia());
        assertEquals(100, anao.getVida());
    }
    
    @Test
    public void elfoComNomeEFlechasInformadosToString(){
        Elfo elfo = new Elfo("Elfinho", 1000);
        assertEquals("Elfinho possui 1000 flechas e 0 níveis de experiência.", elfo.toString());
    }
    
    @Test
    public void elfoComNomeE1FlechasInformadosToString(){
        Elfo elfo = new Elfo("MonoFlecha", 1);
        assertEquals("MonoFlecha possui 1 flecha e 0 níveis de experiência.", elfo.toString());
    }
    
    @Test
    public void elfoComNomeEFlechasInformadosToStringDepoisDeAtirarFlecha(){
        Elfo elfo = new Elfo("MonoFlecha", 10);
        elfo.atirarFlecha();
        assertEquals("MonoFlecha possui 9 flechas e 1 nível de experiência.", elfo.toString());
    }
    
    @Test
    public void elfoNasceComStatusVIVO(){
        Elfo elfinho = new Elfo("Elfinho");
        assertEquals(Status.VIVO, elfinho.getStatus());
    }
    
    
}

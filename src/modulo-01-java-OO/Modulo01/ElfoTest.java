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
    public void elfoRetornaInformacõesCorretamente(){
        Elfo elfinho = new Elfo("Elfinho");
        assertEquals("Elfinho possui 42 flechas e 0 níveis de experiência.", elfinho.toString());
    }
    
    @Test
    public void elfoPerdeUmaFlechaAoCacaeDwarf(){
        Elfo elfinho = new Elfo("Elfinho");
        elfinho.cacarDwarf(new Dwarf("Anão"));
        assertEquals(41, elfinho.getFlechas());
    }
    
    @Test
    public void elfoAtiraFlechaEmDwarf(){
        Elfo elfo = new Elfo("Elfinho");
        Dwarf anao = new Dwarf("Anão");
        elfo.cacarDwarf(anao);
        assertEquals(41, elfo.getFlechas());
        assertEquals(1,elfo.getExperiencia());
        assertEquals(100, anao.getVida(),0.0);
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
    
    @Test
    public void elfoNasceRecebeDano(){
        Elfo elfinho = new Elfo("Elfinho");
        elfinho.perderVida(10);
        assertEquals(90, elfinho.getVida(),0.0);
    }
    
    @Test
    public void elfoAcrescentaUmAposCriarNovoElfo(){
        int contAtual = Elfo.getContadorDeElfos();
        Elfo elfinho = new Elfo("Elfinho");
        int esperado = contAtual+1;
        assertEquals(esperado, Elfo.getContadorDeElfos());
    }
    
    @Test
    public void contadorDeEldosAcrescentaDoisAoCriarDoisElfosNovos(){
        int contAtual = Elfo.getContadorDeElfos();
        Elfo elfinho = new Elfo("Elfinho");
        Elfo elfinho2 = new Elfo("Elfinho");
        int esperado = contAtual+2;
        assertEquals(esperado, Elfo.getContadorDeElfos());     
    }
    
    @Test
    public void contadorDeEldosAcrescentaDoisAoCriarDoisElfosVerdesENoturnosNovos(){
        int contAtual = Elfo.getContadorDeElfos();
        Elfo elfinho = new ElfoVerde("Elfinho");
        Elfo elfinho2 = new ElfoNoturno("Nome");
        int esperado = contAtual+2;
        assertEquals(esperado, Elfo.getContadorDeElfos());     
    }
}

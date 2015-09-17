

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class ElfoTest
{
    @Test
    public void elfoNasceCom42Flechas(){
        Elfo elfinho = new Elfo("Elfinho");
        assertEquals(42, elfinho.getFlechas());
    }
    
    @Test
    public void elfoNasceComONomeInformado(){
        Elfo elfinho = new Elfo("Elfinho");
        assertEquals("Elfinho", elfinho.getNome());
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
    public void elfoPerdeFlechaEDwarfPerdeVida(){
        Elfo elfinho = new Elfo("Elfinho");
        Dwarf anao = new Dwarf();
        elfinho.caçarDwarf(anao);
        assertEquals(41, elfinho.getFlechas());
        assertEquals(100, anao.getVida());
    }
}

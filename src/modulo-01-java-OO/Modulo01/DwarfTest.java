
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class DwarfTest
{

    @Test 
    public void dwarfNasceCom110DeVida(){
        Dwarf dwarf = new Dwarf();
        assertEquals(110, dwarf.getVida());
    }
    
    @Test 
    public void dwarfRecebe10DeDano(){
        // AAA
        //Arrange
        Dwarf anao = new Dwarf();
        int vidaEsperada = 100;
        //Act
        anao.perderVida();
        //Assert
        assertEquals(vidaEsperada, anao.getVida());
    }
    
    @Test
    public void dwarfRecebeFlechas11VezesEVidaÉ0(){
        Dwarf anao = new Dwarf();
        anao.perderVida();
        anao.perderVida();
        anao.perderVida();
        anao.perderVida();
        anao.perderVida();
        anao.perderVida();
        anao.perderVida();
        anao.perderVida();
        anao.perderVida();
        anao.perderVida();
        anao.perderVida();
        assertEquals(0, anao.getVida());
    }
    
    @Test
    public void dwarfRecebeFlechas7VezesEVidaÉ0(){
        Dwarf anao = new Dwarf();
        anao.perderVida();
        anao.perderVida();
        anao.perderVida();
        anao.perderVida();
        anao.perderVida();
        anao.perderVida();
        anao.perderVida();
        assertEquals(40, anao.getVida());
    }
    
    
}
    

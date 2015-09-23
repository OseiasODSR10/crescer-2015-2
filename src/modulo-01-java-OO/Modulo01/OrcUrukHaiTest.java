

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class OrcUrukHaiTest
{
    @Test
    public void orcNasceComSeusItensPredefinidos(){
        OrcUrukHai orcUrukHai = new OrcUrukHai();
        assertEquals("Espada,Escudo Uruk Hai", orcUrukHai.getDescricoesDeItensDoInventario());
    }
    
    @Test
    public void orcPossuiEspadaPredefinido(){
        OrcUrukHai orcUrukHai = new OrcUrukHai();
        assertEquals("Espada", orcUrukHai.getDescricaoDeItemDoInventario(0));
    }
    
    @Test
    public void orcPossuiEscudoPredefinido(){
        OrcUrukHai orcUrukHai = new OrcUrukHai();
        assertEquals("Escudo Uruk Hai", orcUrukHai.getDescricaoDeItemDoInventario(1));
    }
    
    @Test
    public void orcNasceCom150DeVida(){
        OrcUrukHai orcUrukHai = new OrcUrukHai();
        assertEquals(150, orcUrukHai.getVida());
    }
}

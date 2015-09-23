

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class OrcSnagaTest
{
    @Test
    public void orcNasceComSeusItensPredefinidos(){
        OrcSnaga orcSnaga = new OrcSnaga();
        assertEquals("Arco,Flecha", orcSnaga.getDescricoesDeItensDoInventario());
    }
    
    @Test
    public void orcPossuiArcoPredefinido(){
        OrcSnaga orcSnaga = new OrcSnaga();
        assertEquals("Arco", orcSnaga.getDescricaoDeItemDoInventario(0));
    }
    
    @Test
    public void orcPossuiFlechaPredefinido(){
        OrcSnaga orcSnaga = new OrcSnaga();
        assertEquals("Flecha", orcSnaga.getDescricaoDeItemDoInventario(1));
    }
    
    @Test
    public void orcPossui5FlechasPredefinidas(){
        OrcSnaga orcSnaga = new OrcSnaga();
        assertEquals(5, orcSnaga.getQuantidadeDeItemDoInventario(1));
    }
    
    @Test
    public void orcNasceCom70DeVida(){
        OrcSnaga orcSnaga = new OrcSnaga();
        assertEquals(70, orcSnaga.getVida(), 0.0);
    }
}

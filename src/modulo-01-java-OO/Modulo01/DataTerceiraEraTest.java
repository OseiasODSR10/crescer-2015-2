

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class DataTerceiraEraTest
{
   @Test 
   public void dataRecebeOsValoresInformadosComoDiaMêsEAno(){
       DataTerceiraEra dataT = new DataTerceiraEra(1, 1, 2015);
       assertEquals(1, dataT.getDia());
       assertEquals(1, dataT.getMês());
       assertEquals(2015, dataT.getAno());
    }
    
    @Test
    public void anoBissextoÉReconhecidoNoMétodoEhBissextoDaClasseDataTerceiraEra(){
        DataTerceiraEra data = new DataTerceiraEra(1, 1, 2012);
        assertEquals(true, data.ehBissexto());
    }
    
    @Test
    public void outroAnoBissextoÉReconhecidoNoMétodoEhBissextoDaClasseDataTerceiraEra(){
        DataTerceiraEra data = new DataTerceiraEra(1, 1, 2000);
        assertEquals(true, data.ehBissexto());
    }
    
    @Test
    public void anoQueNãoÉBissextoNãoÉReconhecidoNoMétodoEhBissextoDaClasseDataTerceiraEra(){
        DataTerceiraEra data = new DataTerceiraEra(1, 1, 1900);
        assertEquals(false, data.ehBissexto());
    }
    
    @Test
    public void outroAnoQueNãoÉBissextoNãoÉReconhecidoNoMétodoEhBissextoDaClasseDataTerceiraEra(){
        DataTerceiraEra data = new DataTerceiraEra(1, 1, 2015);
        assertEquals(false, data.ehBissexto());
    }
}

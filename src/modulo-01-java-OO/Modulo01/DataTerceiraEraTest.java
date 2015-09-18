

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class DataTerceiraEraTest
{
   @Test 
   public void dataRecebeOsValoresInformadosComoDiaMêsEAno(){
       DataTerceiraEra dataTerceiraEra = new DataTerceiraEra(1, 1, 2015);
       DataTerceiraEra dataEsperada = new DataTerceiraEra(1, 1, 2015);
       assertEquals(dataEsperada, dataTerceiraEra);
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
    
    @Test
    public void dataTerceiraEraRetornaTrueComDuasDatasIguais(){
        DataTerceiraEra dataEsperada = new DataTerceiraEra(2,2,2);
        DataTerceiraEra dataObtida = new DataTerceiraEra(2,2,2);
        assertEquals(dataEsperada, dataObtida);
    }
}

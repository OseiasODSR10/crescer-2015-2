
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class DwarfTest
{

    @Test 
    public void dwarfNasceCom110DeVida(){
        Dwarf dwarf = new Dwarf("Anão");
        assertEquals(110, dwarf.getVida());
    }
    
    @Test 
    public void dwarfRecebe10DeDano(){
        // AAA
        //Arrange
        Dwarf anao = new Dwarf("Anão");
        int vidaEsperada = 100;
        //Act
        anao.perderVida();
        //Assert
        assertEquals(vidaEsperada, anao.getVida());
    }
    
    @Test
    public void dwarfRecebeFlechas11VezesEVidaÉ0(){
        Dwarf anao = new Dwarf("Anão");
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
        Dwarf anao = new Dwarf("Anão");
        anao.perderVida();
        anao.perderVida();
        anao.perderVida();
        anao.perderVida();
        anao.perderVida();
        anao.perderVida();
        anao.perderVida();
        assertEquals(40, anao.getVida());
    }
    
    @Test
    public void dwarfMorreQuandoVidaÉIgualAZero(){
        Dwarf anao = new Dwarf("Anão");
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
        assertEquals(Status.MORTO, anao.getStatus());
    }
    
    @Test 
    public void dwarfNasceComONomeAtribuído(){
        Dwarf anao = new Dwarf ("Anão");
        assertEquals("Anão", anao.getNome());
    }
    
    @Test
    public void dwarfNãoFicaComVidaNegativa(){
        Dwarf anao = new Dwarf ("Anão");
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
        anao.perderVida();
        assertEquals(Status.MORTO, anao.getStatus());    
    }
    
    @Test
    public void dwarfNasceComDataNascimentoPadrão(){
        Dwarf anao = new Dwarf("Anão");
        DataTerceiraEra dataEsperada = new DataTerceiraEra(1,1,1);
        assertEquals(dataEsperada, anao.getDataNascimento());
    }
    
    @Test
    public void dwarfNasceComDataNascimentoInformada(){
        Dwarf anao = new Dwarf("Anão", new DataTerceiraEra(1,7,1999));
        DataTerceiraEra dataEsperada = new DataTerceiraEra(1,7,1999);
        assertEquals(dataEsperada, anao.getDataNascimento());
    }
    
    @Test
    public void dwarfPossuiAnoBissextoEVidaEntre90E80PortantoNúmeroDaSorteRetornaMenos3333(){
        Dwarf anao = new Dwarf ("Anão",new DataTerceiraEra(1,1,2012));
        anao.perderVida();
        anao.perderVida();
        anao.perderVida();
        assertEquals(-3333, anao.getNúmeroSorte(), 0.5);
    }
    
    @Test
    public void dwarfNãoNasceuEmAnoBissextoESeChamaSeixasPortantoNúmeroDaSorteRetorna33(){
        Dwarf anao = new Dwarf ("Seixas",new DataTerceiraEra(1,1,2013));
        assertEquals(33.0, anao.getNúmeroSorte(), 0.5);
    }
    
    @Test
    public void dwarfNãoNasceuEmAnoBissextoESeChamaMeirelesPortantoNúmeroDaSorteRetorna33(){
        Dwarf anao = new Dwarf ("Meireles",new DataTerceiraEra(1,1,2013));
        assertEquals(33.0, anao.getNúmeroSorte(), 0.5);
    }
    
    @Test
    public void dwarfNãoNasceuEmAnoBissextoESeuNomeNãoÉSeixasNemMeirelesPortantoMétodoNúmeroDaSorteRetornaValorPadrão101(){
        Dwarf anao = new Dwarf ("Anão",new DataTerceiraEra(1,1,2013));
        assertEquals(101.0, anao.getNúmeroSorte(), 0.5);
    }
    
    @Test
    public void dwarfNãoRecebeFlechadaEAindaGanhaExperiênciaPorqueEleTemNúmeroDeSorteMenorQueZero(){
        Dwarf anao = new Dwarf("Anão", new DataTerceiraEra(1,1,2012));
        //Desta vez ele perderá vida
        anao.perderVida();
        assertEquals(100, anao.getVida());
        //Desta vez ele perderá vida
        anao.perderVida();
        assertEquals(90, anao.getVida());
        //Agora seu número da sorte o salvará!!
        anao.perderVida();
        //Ele deve continuar com 90 de vida...
        assertEquals(90, anao.getVida());
        //E ainda ganhar 2 de experiência!
        assertEquals(2, anao.getExperiência());
    }
    
    @Test
    public void dwarfNãoRecebeFlechadaPorqueEleTemNúmeroDeSorteEntreZeroECem(){
        Dwarf anao = new Dwarf ("Meireles",new DataTerceiraEra(1,1,2013));
        anao.perderVida();
        assertEquals(0, anao.getExperiência());
        assertEquals(110, anao.getVida());
    }
    
     @Test
    public void dwarfRecebeFlechadaPorqueEleTemNúmeroDeSorteMaiorQueCem(){
        Dwarf anao = new Dwarf ("Anão",new DataTerceiraEra(1,1,2013));
        anao.perderVida();
        assertEquals(100, anao.getVida());
    }
    
    @Test
    public void dwarfGanha1000ItensComOmétodoTentarSorte(){
        DataTerceiraEra dataBissexto = new DataTerceiraEra(01, 01, 2012);
		Dwarf dwarf = new Dwarf("Anão", dataBissexto);
		Item faca = new Item("Faca", 2);
		Item anel = new Item("Anel", 2);
		dwarf.adicionarItemAoInventário(faca);
		dwarf.adicionarItemAoInventário(anel);
		dwarf.perderVida();
		dwarf.perderVida();
		dwarf.perderVida();
		dwarf.tentarSorte();

		assertEquals(1002, dwarf.getQuantidadeDeItemDoInventário(1));
    }
    
    @Test
    public void dwarfNãoGanha1000ItensComOmétodoTentarSorte(){
        DataTerceiraEra dataNãoBissexto = new DataTerceiraEra(01, 01, 2013);
		Dwarf dwarf = new Dwarf("Anão", dataNãoBissexto);
		Item faca = new Item("Faca", 2);
		Item anel = new Item("Anel", 2);
		dwarf.adicionarItemAoInventário(faca);
		dwarf.adicionarItemAoInventário(anel);
		dwarf.perderVida();
		dwarf.perderVida();
		dwarf.perderVida();
		dwarf.tentarSorte();
		assertEquals(2, dwarf.getQuantidadeDeItemDoInventário(0));
		assertEquals(2, dwarf.getQuantidadeDeItemDoInventário(1));
    }
    
    @Test
    public void dwarfRemoveItemDoInventário(){
		Dwarf dwarf = new Dwarf("Anão");
		Item faca = new Item("Faca", 2);
		Item anel = new Item("Anel", 2);
		dwarf.adicionarItemAoInventário(faca);
		dwarf.adicionarItemAoInventário(anel);
		dwarf.removerItemDoInventário(anel);
		assertEquals("Faca", dwarf.getDescriçãoItens());
    }
    

}
    

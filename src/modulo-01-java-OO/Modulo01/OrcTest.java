

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class OrcTest
{
   @Test
   public void orcPerde6VidaSeEleTemEscudo(){
       Orc orc = new Orc();
       orc.adicionarItemAoInventário(new Item("Escudo Uruk Hai",2));
       orc.perderVida();
       assertEquals(-6,orc.getVida());
   }
   
   @Test
   public void orcPerde16VidaSeEleTemEscudoMasPerdeEscudoDepoisDoSegundoAtaque(){
       Orc orc = new Orc();
       orc.adicionarItemAoInventário(new Item("Escudo Uruk Hai",1));
       orc.perderVida();
       orc.perderVida();
       assertEquals(-16,orc.getVida());
   }
   
   @Test
   public void orcPerde10VidaSeEleNãoTemEscudo(){
       Orc orc = new Orc();
       orc.perderVida();
       assertEquals(-10,orc.getVida());
   }
   
   @Test
   public void orcPerde30VidaSeEleNãoTemEscudoERecebeTresAtaques(){
       Orc orc = new Orc();
       orc.perderVida();
       orc.perderVida();
       orc.perderVida();
       assertEquals(-30,orc.getVida());
   }
   
   @Test
   public void orcMorreAoReceberAtaqueQuandoSuaVidaEraPouca(){
       Orc orc = new Orc();
       orc.perderVida();
       assertEquals(Status.MORTO, orc.getStatus());
   }
   
   @Test
   public void orcAtacaOutroPersonagemQuandoPossuiEspadaECausa12DeDano(){
       Orc orc = new Orc();
       orc.adicionarItemAoInventário(new Item("Espada",1));
       Elfo elfo = new Elfo("Elfinho",1);
       orc.atacarOutroPersonagem(elfo);
       assertEquals(68, elfo.getVida());
   }
   
   @Test
   public void orcPerdeEspadaEmPrimeiroAtaque(){
       Orc orc = new Orc();
       orc.adicionarItemAoInventário(new Item("Espada",1));
       Elfo elfo = new Elfo("Elfinho",1);
       orc.atacarOutroPersonagem(elfo);
       orc.atacarOutroPersonagem(elfo);
       assertEquals(68, elfo.getVida());
   }
   
   @Test
   public void orcNaoRealizaSegundoAtaqueEFoge(){
       Orc orc = new Orc();
       orc.adicionarItemAoInventário(new Item("Espada",1));
       Elfo elfo = new Elfo("Elfinho",1);
       orc.atacarOutroPersonagem(elfo);
       orc.atacarOutroPersonagem(elfo);
       assertEquals(Status.FUGINDO, orc.getStatus());
   }
   
   @Test
   public void orcAtacaOutroPersonagemElfoPorqueTemArcoEFlechasECausa8DeDano(){
       Orc orc = new Orc();
       orc.adicionarItemAoInventário(new Item("Arco",1));
       orc.adicionarItemAoInventário(new Item("Flecha",1));
       Elfo elfo = new Elfo("Elfinho",1);
       orc.atacarOutroPersonagem(elfo);
       //orc.atacarOutroPersonagem(elfo);
       assertEquals(72, elfo.getVida());
   }
   
   @Test
   public void orcAtacaOutroPersonagemDwarfPorqueTemArcoEFlechasECausa8DeDano(){
       Orc orc = new Orc();
       orc.adicionarItemAoInventário(new Item("Arco",1));
       orc.adicionarItemAoInventário(new Item("Flecha",1));
       Dwarf dwarf = new Dwarf("Anao");
       orc.atacarOutroPersonagem(dwarf);
       //orc.atacarOutroPersonagem(elfo);
       assertEquals(102, dwarf.getVida());
   }
   
   @Test
   public void orcNaoRealizaSegundoAtaquePorFaltaDeFlechas(){
       Orc orc = new Orc();
       orc.adicionarItemAoInventário(new Item("Arco",1));
       orc.adicionarItemAoInventário(new Item("Flecha",1));
       Elfo elfo = new Elfo("Elfinho",1);
       orc.atacarOutroPersonagem(elfo);
       orc.atacarOutroPersonagem(elfo);
       assertEquals(72, elfo.getVida());
   }
   
   @Test
   public void orcTemFlechaMasNaoArcoENaoAtaca(){
       Orc orc = new Orc();
       orc.adicionarItemAoInventário(new Item("Flecha",1));
       Elfo elfo = new Elfo("Elfinho",1);
       orc.atacarOutroPersonagem(elfo);
       orc.atacarOutroPersonagem(elfo);
       assertEquals(80, elfo.getVida());
       assertEquals(Status.FUGINDO, orc.getStatus());
   }
   
   @Test
   public void orcTemArcoMasNaoFlechaENaoAtaca(){
       Orc orc = new Orc();
       orc.adicionarItemAoInventário(new Item("Flecha",1));
       Elfo elfo = new Elfo("Elfinho",1);
       orc.atacarOutroPersonagem(elfo);
       orc.atacarOutroPersonagem(elfo);
       assertEquals(80, elfo.getVida());
       assertEquals(Status.FUGINDO, orc.getStatus());
   }
}

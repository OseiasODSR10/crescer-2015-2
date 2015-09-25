

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.*;


public class ExercitoDeElfosTest
{
    @Test
    public void elfoNãoÉAlistado(){
        ExercitoDeElfos exercito = new ExercitoDeElfos();
        exercito.alistarElfo(new Elfo("Legolas"));
        assertEquals(null, exercito.buscarNomeDoElfo("Legolas"));
    }
    
    @Test
    public void elfoÉAlistadoElfoVerde(){
        ExercitoDeElfos exercito = new ExercitoDeElfos();
        ElfoVerde elfinho = new ElfoVerde("Legolas");
        exercito.alistarElfo(elfinho);
        assertEquals(elfinho, exercito.buscarNomeDoElfo("Legolas"));
    }
    
    @Test
    public void elfoÉAlistadoElfoNoturno(){
        ExercitoDeElfos exercito = new ExercitoDeElfos();
        ElfoNoturno elfinho = new ElfoNoturno("Legolas");
        exercito.alistarElfo(elfinho);
        assertEquals(elfinho, exercito.buscarNomeDoElfo("Legolas"));
    }
    
    @Test
    public void doisElfosSãoAlistados(){
        ExercitoDeElfos exercito = new ExercitoDeElfos();
        ElfoNoturno elfinho = new ElfoNoturno("Legolas");
        ElfoNoturno elfinho2 = new ElfoNoturno("Legolas2");
        exercito.alistarElfo(elfinho);
        exercito.alistarElfo(elfinho2);
        assertEquals(elfinho, exercito.buscarNomeDoElfo("Legolas"));
        assertEquals(elfinho2, exercito.buscarNomeDoElfo("Legolas2"));
    }
    
    @Test 
    public void elfosSãoAgrupadosPorStatus(){
        ExercitoDeElfos exercito = new ExercitoDeElfos();
        ElfoNoturno elfinho = new ElfoNoturno("Legolas");
        ElfoNoturno elfinho2 = new ElfoNoturno("Legolas2");
        exercito.alistarElfo(elfinho);
        exercito.alistarElfo(elfinho2);
        exercito.agruparElfosPorStatus();
        boolean teste = exercito.buscarElfosPorStatus(Status.VIVO).contains(elfinho) && exercito.buscarElfosPorStatus(Status.VIVO).contains(elfinho2);
        assertEquals(true, teste);
    }
    
    @Test 
    public void elfosSãoAgrupadosPorStatusEApenasUmEstáNoStatusVivo(){
        ExercitoDeElfos exercito = new ExercitoDeElfos();
        ElfoNoturno elfinho = new ElfoNoturno("Legolas");
        ElfoNoturno elfinho2 = new ElfoNoturno("Legolas2");
        exercito.alistarElfo(elfinho);
        exercito.alistarElfo(elfinho2);
        elfinho2.perderVida(200);
        boolean teste = exercito.buscarElfosPorStatus(Status.VIVO).contains(elfinho) && exercito.buscarElfosPorStatus(Status.VIVO).contains(elfinho2);
        assertEquals(false, teste);
    }
    
    @Test 
    public void elfosSãoAgrupadosPorStatusEUmEstaNoStatusMorto(){
        ExercitoDeElfos exercito = new ExercitoDeElfos();
        ElfoNoturno elfinho = new ElfoNoturno("Legolas");
        ElfoNoturno elfinho2 = new ElfoNoturno("Legolas2");
        exercito.alistarElfo(elfinho);
        exercito.alistarElfo(elfinho2);
        elfinho2.perderVida(200);
        boolean teste = exercito.buscarElfosPorStatus(Status.MORTO).contains(elfinho2);
        assertEquals(true, teste);
    }
    
    @Test 
    public void elfosSãoAgrupadosPorStatusEMudaParaOArrayListDeMortos(){
        ExercitoDeElfos exercito = new ExercitoDeElfos();
        ElfoNoturno elfinho = new ElfoNoturno("Legolas");
        ElfoNoturno elfinho2 = new ElfoNoturno("Legolas2");
        exercito.alistarElfo(elfinho);
        exercito.alistarElfo(elfinho2);
        boolean teste1 = exercito.buscarElfosPorStatus(Status.VIVO).contains(elfinho2) && exercito.buscarElfosPorStatus(Status.VIVO).contains(elfinho);
        assertEquals(true, teste1);
        elfinho2.perderVida(200);
        boolean teste2 = exercito.buscarElfosPorStatus(Status.MORTO).contains(elfinho2) && exercito.buscarElfosPorStatus(Status.VIVO).contains(elfinho);
        assertEquals(true, teste2);
    }
    
    @Test 
    public void ataqueDe5ElfosACincoAnoes(){
        ExercitoDeElfos exercito = new ExercitoDeElfos();
        ArrayList<Dwarf> dwarves = new ArrayList<Dwarf> ();
        for(int i=0; i<5; i++){
            dwarves.add(new Dwarf(""+i));
            exercito.alistarElfo(new ElfoVerde(""+i));
        }
        exercito.reunirElfosVivoEAtacarDwarves(dwarves);
        for(int i=0; i<5; i++){
            assertEquals(60.0, dwarves.get(i).getVida(), .0);
        }
    }
    
    @Test 
    public void ataqueDe10ElfosA10Anoes(){
        ExercitoDeElfos exercito = new ExercitoDeElfos();
        ArrayList<Dwarf> dwarves = new ArrayList<Dwarf> ();
        for(int i=0; i<10; i++){
            dwarves.add(new Dwarf(""+i));
            exercito.alistarElfo(new ElfoVerde(""+i));
        }
        exercito.reunirElfosVivoEAtacarDwarves(dwarves);
        for(int i=0; i<10; i++){
            assertEquals(10.0, dwarves.get(i).getVida(), .0);
        }
    }
    
    @Test 
    public void ataqueDe10ElfosNoturnosA10AnosSo3AtacamE29AnoesRecebemAtaques(){
        ExercitoDeElfos exercito = new ExercitoDeElfos();
        ArrayList<Dwarf> dwarves = new ArrayList<Dwarf> ();
        for(int i=0; i<10; i++){
            dwarves.add(new Dwarf(""+i));
            exercito.alistarElfo(new ElfoNoturno(""+i));
        }
        exercito.reunirElfosVivoEAtacarDwarves(dwarves);
        for(int i=0; i<10; i++){
            if(i==9){
                assertEquals(90.0, dwarves.get(i).getVida(), .0);
                break;
            }
            assertEquals(80.0, dwarves.get(i).getVida(), .0);
        }
    }
}

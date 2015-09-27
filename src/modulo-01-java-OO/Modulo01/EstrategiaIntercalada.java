import java.util.*;
public class EstrategiaIntercalada implements EstrategiaDeAtaque{
    
    ArrayList<Elfo> ordemDoUltimoAtaque = new ArrayList<Elfo>();
    
    public void atacar(ArrayList<Elfo> elfos, ArrayList<Dwarf> dwarves){
        this.ordemDoUltimoAtaque.clear();
        ArrayList<Elfo> elfosAptosAAtacar = new ArrayList<Elfo>();
        int contadorDeVerdes = 0;
        int contadorDeNoturnos = 0;
        //Verifica quantos elfos tem de cada tipo
        for(Elfo elfo : elfos){
            if(elfo instanceof ElfoVerde){
                contadorDeVerdes++;
            }
            else{
                contadorDeNoturnos++;
            }
        }
        //a menor quantidade será a que cada tipo terá no arrayList
        int menor = contadorDeVerdes < contadorDeNoturnos ? contadorDeVerdes : contadorDeNoturnos;
        contadorDeVerdes = 0;
        contadorDeNoturnos = 0;
        //adiciona numa lista os elfos de cada tipo até este chegar na quantidade máxima que cada um terá no arrayist
        for(Elfo elfo : elfos){
            if(elfo instanceof ElfoVerde){
                if(contadorDeVerdes == menor){ continue; } //se algum tipo atingir a meta não é mais possível adicionar elfos deste tipo
                elfosAptosAAtacar.add(0,elfo);   
                contadorDeVerdes++;
            }
            else{
                if(contadorDeNoturnos == menor){ continue; }
                elfosAptosAAtacar.add(elfo);   
                contadorDeNoturnos++;
            }
        }
        for(int i=0; i<menor; i++){
        	if(i%2!=0){
        		Collections.swap(elfosAptosAAtacar, i, (elfosAptosAAtacar.size()-1)-i); //organiza os elfos: Verdes em posicões pares, Noturnos nas ímpares
        	}
        }
        //agora o dwarf é selecionado e atacado por toda a lista de uma vez de forma intercalada
        for(Dwarf dwarf : dwarves){
            for(Elfo elfo: elfosAptosAAtacar){
                elfo.cacarDwarf(dwarf);
                this.ordemDoUltimoAtaque.add(elfo);
            }
        }
    }
    
    public ArrayList<Elfo> getOrdemDoUltimoAtaque(){
        return this.ordemDoUltimoAtaque;
    }
}

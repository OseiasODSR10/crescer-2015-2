import java.util.ArrayList;

public class EstrategiaFFA implements EstrategiaDeAtaque{
    
    ArrayList<Elfo> ordemDoUltimoAtaque = new ArrayList<Elfo>();
    
    public void atacar(ArrayList<Elfo> elfos, ArrayList<Dwarf> dwarves){
        ArrayList<Elfo> elfosAptosAAtacar = new ArrayList<Elfo>();
        this.ordemDoUltimoAtaque.clear();
        for(Elfo elfo : elfos){
            if(elfo.getStatus() == Status.VIVO)
            elfosAptosAAtacar.add(elfo);
        }
        int intencoesDeAtaque = elfosAptosAAtacar.size() * dwarves.size();
        int contNoturnos = 0;
        for(Elfo elfo : elfosAptosAAtacar){
            for(Dwarf dwarf : dwarves){
                if(elfo instanceof ElfoNoturno){
                    contNoturnos++;
                    if(contNoturnos >= ((int)(intencoesDeAtaque * 0.3))){
                        continue;
                    }
                }
                elfo.cacarDwarf(dwarf);
                this.ordemDoUltimoAtaque.add(elfo);
            }
        }
    }
    
    public ArrayList<Elfo> getOrdemDoUltimoAtaque(){
        return this.ordemDoUltimoAtaque;
    }
}

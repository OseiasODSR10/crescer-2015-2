import java.util.ArrayList;

public class EstrategiaFFA implements EstrategiaDeAtaque{
    
    public void atacar(ArrayList<Elfo> elfos, ArrayList<Dwarf> dwarves){
        int intencoesDeAtaque = elfos.size() * dwarves.size();
        int contNoturnos = 0;
        for(Elfo elfo : elfos){
            for(Dwarf dwarf : dwarves){
                if(elfo instanceof ElfoNoturno){
                    contNoturnos++;
                    if(contNoturnos >= ((int)(intencoesDeAtaque * 0.3))){
                        continue;
                    }
                }
                elfo.caçarDwarf(dwarf);
            }
        }
    }
}

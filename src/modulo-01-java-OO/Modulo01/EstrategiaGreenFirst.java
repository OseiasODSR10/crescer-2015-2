import java.util.ArrayList;
public class EstrategiaGreenFirst implements EstrategiaDeAtaque {
    
    ArrayList<Elfo> ordemDoUltimoAtaque = new ArrayList<Elfo>();
    
    public void atacar(ArrayList<Elfo> elfos, ArrayList<Dwarf> dwarves){
        ArrayList<Elfo> elfosAptosAAtacar = new ArrayList<Elfo>();
        for(Elfo elfo : elfos){
            this.ordemDoUltimoAtaque.clear();
            if(Status.VIVO == elfo.getStatus()){
                if(elfo instanceof ElfoVerde){
                    elfosAptosAAtacar.add(0, elfo);
                }
                else{
                    elfosAptosAAtacar.add(elfo);
                }
            }
        }
        for(Elfo elfo : elfosAptosAAtacar){
            for(Dwarf dwarf : dwarves){
                elfo.cacarDwarf(dwarf);
                this.ordemDoUltimoAtaque.add(elfo);
            }
        }
    }
    
    public ArrayList<Elfo> getOrdemDoUltimoAtaque(){
        return this.ordemDoUltimoAtaque;
    }
}

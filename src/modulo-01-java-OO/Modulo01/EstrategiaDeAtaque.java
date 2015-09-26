import java.util.ArrayList;

public interface EstrategiaDeAtaque{
    
    void atacar(ArrayList<Elfo> elfos, ArrayList<Dwarf> dwarves);
    ArrayList<Elfo> getOrdemDoUltimoAtaque ();
}

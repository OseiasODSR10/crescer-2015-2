import java.util.*;
public class ExercitoDeElfos
{
    private HashMap<String, Elfo> exercito = new HashMap<>();
    private HashMap<Status, ArrayList<Elfo>> exercitoAgrupadoPorStatus = new HashMap<>();
    private EstrategiaDeAtaque estrategia = new EstrategiaFFA();
    
    public void alistarElfo(Elfo umElfo){
        boolean podeAlistar = umElfo instanceof ElfoVerde
            || umElfo instanceof ElfoNoturno;
        if (podeAlistar) {
            exercito.put(umElfo.getNome(), umElfo);
        }
    }
    
    public void agruparElfosPorStatus() {
        exercitoAgrupadoPorStatus.clear();
        for (Map.Entry<String, Elfo> itemDeExercitoESuaChave : exercito.entrySet()) {
            Elfo elfo = itemDeExercitoESuaChave.getValue();
            Status status = elfo.getStatus();
            if (exercitoAgrupadoPorStatus.containsKey(status)) {
                exercitoAgrupadoPorStatus.get(status).add(elfo);
            } else {
                this.exercitoAgrupadoPorStatus.put(status, new ArrayList<> (Arrays.asList(elfo)));
            }
        }
    }
    
    public Elfo buscarNomeDoElfo(String nome) {
        return exercito.get(nome);
    }
    
    public ArrayList<Elfo> buscarElfosPorStatus(Status status) {
        agruparElfosPorStatus();
        return exercitoAgrupadoPorStatus.get(status);
    }
    
    public void reunirElfosVivoEAtacarDwarves(ArrayList<Dwarf> dwarves){
        ArrayList<Elfo> elfosAptosAAtacar = new ArrayList<Elfo>(this.buscarElfosPorStatus(Status.VIVO));
        this.estrategia.atacar(elfosAptosAAtacar, dwarves);
    }
}

public class IrishDwarf extends Dwarf
{
    
    public IrishDwarf (String nome){
        super(nome, new DataTerceiraEra(1,1,1));
    }
    
    public IrishDwarf (String nome, DataTerceiraEra dataNascimento){
        super(nome, dataNascimento);
    }
    
    public void tentarSorte(){
        if(-3333 == this.getNumeroSorte()){
            for(int i=0; i<inventario.getInventario().size();i++){
                inventario.adicionarNVezes1000Itens(i);
            }
       }
    }
}

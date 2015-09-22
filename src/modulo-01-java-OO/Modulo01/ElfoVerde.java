public class ElfoVerde extends Elfo
{
    public ElfoVerde(String nome){
        super(nome);
    }
    
    @Override
    public void atirarFlecha(){
        this.flechas--;
        this.experiencia+=2;
    }
    
    @Override
    public void adicionarItemAoInventário(Item item){
        if(item.getDescricao().equals("Espada de aço valiriano") || item.getDescricao().equals("Arco e Flecha de Vidro")){
            this.inventario.adicionarItem(item);
        }
    }
}

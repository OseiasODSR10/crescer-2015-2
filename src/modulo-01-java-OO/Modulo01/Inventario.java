import java.util.ArrayList;
public class Inventario
{
    private ArrayList<Item> inventario = new ArrayList<Item>();
    
    public void adicionarItem(Item item){
        inventario.add(item);
    }
    
    public void removerItem(Item item){
        inventario.remove(item);
    }
    
    public void ganharUmItem(Item item, int quantidade){
        inventario.get(inventario.indexOf(item)).adicionar1000Itens();
    }
    
    public void ganharUmItem(int index, int quantidade){
        inventario.get(index).adicionar1000Itens();
    }
    
    public void perderUmItem(Item item, int quantidade){
        inventario.get(inventario.indexOf(item)).perderItem(quantidade);
    }
    
    public void perderUmItem(int index, int quantidade){
        inventario.get(index).perderItem(quantidade);
    }
        
    public void ordenarItens(){
        ArrayList<Item> listaOrganizada = new ArrayList<Item>();
        while(!this.inventario.isEmpty()){
            Item itemComMenorQuantidade = this.inventario.get(0);
            for(int j = 0; j < this.inventario.size(); j++){
                if(this.inventario.get(j).getQuantidade() <= itemComMenorQuantidade.getQuantidade()){
                    itemComMenorQuantidade = this.inventario.get(j);
                }
            }
            this.inventario.remove(itemComMenorQuantidade);
            listaOrganizada.add(itemComMenorQuantidade);
        }
        this.inventario = listaOrganizada;
    }
    
    public String getDescricaoDeItem(int index){
        return this.inventario.get(index).getDescricao();
    }
    
    public int getQuantidadeDeItem(int index){
        return this.inventario.get(index).getQuantidade();
    }
    
    public ArrayList<Item> getItens(){
           return inventario;
    }
    
    public Item getItem(Item item){
        return inventario.get(inventario.indexOf(item));
    }
    
    public Item getItem(int index){
        return inventario.get(index);
    }
    
    public String getDescricoesItens(){
        String descricaoItens = "";
        for (int i = 0; i < inventario.size(); i++){
            descricaoItens = descricaoItens+ "," +inventario.get(i).getDescricao();
        }
        return descricaoItens.substring(1);
    }
    
    public Item getItemComMaiorQuantidade(){
        Item itemComMaiorQuantidade = new Item("",0);
        for(int i = 0; i < this.inventario.size(); i++){
            if (this.inventario.get(i).getQuantidade() > itemComMaiorQuantidade.getQuantidade()){
                itemComMaiorQuantidade = this.inventario.get(i);
            }
        }
        return this.inventario.isEmpty()? null : itemComMaiorQuantidade;
    }
    
    
}

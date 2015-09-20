import java.util.ArrayList;
public class Inventário
{
    private ArrayList<Item> inventário = new ArrayList<Item>();
    
    public void adicionarItem(Item item){
        inventário.add(item);
    }
    
    public void removerItem(Item item){
        inventário.remove(item);
    }
    
    public void ganharUmItem(Item item, int quantidade){
        inventário.get(inventário.indexOf(item)).adicionarItem(quantidade);
    }
    
    public void ganharUmItem(int index, int quantidade){
        inventário.get(index).adicionarItem(quantidade);
    }
    
    public void perderUmItem(Item item, int quantidade){
        inventário.get(inventário.indexOf(item)).perderItem(quantidade);
    }
    
    public void perderUmItem(int index, int quantidade){
        inventário.get(index).perderItem(quantidade);
    }
        
    public void ordenarItens(){
        ArrayList<Item> listaOrganizada = new ArrayList<Item>();
        while(!this.inventário.isEmpty()){
            Item itemComMenorQuantidade = this.inventário.get(0);
            for(int j = 0; j < this.inventário.size(); j++){
                if(this.inventário.get(j).getQuantidade() <= itemComMenorQuantidade.getQuantidade()){
                    itemComMenorQuantidade = this.inventário.get(j);
                }
            }
            this.inventário.remove(itemComMenorQuantidade);
            listaOrganizada.add(itemComMenorQuantidade);
        }
        this.inventário = listaOrganizada;
    }
    
    public String getDescriçãoDeItem(int index){
        return this.inventário.get(index).getDescrição();
    }
    
    public int getQuantidadeDeItem(int index){
        return this.inventário.get(index).getQuantidade();
    }
    
    public ArrayList<Item> getItens(){
           return inventário;
    }
    
    public Item getItem(Item item){
        return inventário.get(inventário.indexOf(item));
    }
    
    public Item getItem(int index){
        return inventário.get(index);
    }
    
    public String getDescricoesItens(){
        String descricaoItens = "";
        for (int i = 0; i < inventário.size(); i++){
            descricaoItens = descricaoItens+ ", " +inventário.get(i).getDescrição();
        }
        return descricaoItens.substring(2);
    }
    
    public Item getItemComMaiorQuantidade(){
        Item itemComMaiorQuantidade = new Item("",0);
        for(int i = 0; i < this.inventário.size(); i++){
            if (this.inventário.get(i).getQuantidade() > itemComMaiorQuantidade.getQuantidade()){
                itemComMaiorQuantidade = this.inventário.get(i);
            }
        }
        return this.inventário.isEmpty()? null : itemComMaiorQuantidade;
    }
    
    
}

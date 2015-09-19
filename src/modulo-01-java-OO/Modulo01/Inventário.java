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
    
    public ArrayList<Item> getItens(){
        return inventário;
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

import java.util.ArrayList;

public class Inventario {
	private ArrayList<Item> inventario = new ArrayList<Item>();
	
	public void adicionarItem(Item item){
		if(this.inventarioPossuiItem(item)){
			this.adicionarQuantidadeDeItem(item);
		}
		else{
			inventario.add(item);
		}
    }
	
	private void adicionarQuantidadeDeItem(Item item){
		this.inventario.get(inventario.indexOf(item)).adicionarUnidadesDeItem(item.getQuantidade());
	}
	
	public void adicionarNVezes1000Itens(int index){
        inventario.get(index).adicionarNVezes1000Itens();
    }
	
	public void adicionar1000UnidadesDeUmItem(int index){
        inventario.get(index).adicionar1000UnidadesDeItem();
    }
	
	public void perderItem(Item item){
        this.inventario.get(inventario.indexOf(item)).perderItem();
        if(this.inventario.get(inventario.indexOf(item)).getQuantidade()<=0){
        	this.inventario.remove(item);
        }
    }
	
	public void removerItem(Item item){
        inventario.remove(item);
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
	
    public int getQuantidadeDeItem(int index){
        return this.inventario.get(index).getQuantidade();
    }
    
    public boolean inventarioPossuiItem(Item item){
    	return this.inventario.contains(item);
    }
    
	public String getDescricaoDeItem(int index){
        return this.inventario.get(index).getDescricao();
    }
	
	public ArrayList<Item> getInventario(){
        return this.inventario;
	}
	
	public Item getItem(int index){
        return inventario.get(index);
    }
    
    public Item getItem(Item item){
        return inventario.get(inventario.indexOf(item));
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

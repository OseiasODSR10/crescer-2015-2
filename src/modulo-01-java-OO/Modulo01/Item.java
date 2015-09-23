public class Item {
	
	private int quantidade;
	private String descricao;
	
	public Item (String descricao, int quantidade){
		this.descricao = descricao;
		this.quantidade = quantidade;
	}
	
	public void adicionarUnidadesDeItem(int quant){
		this.quantidade += quant;
	}
	//Métodos necessários para exercicios 
	public void adicionar1000UnidadesDeItem(){
		this.quantidade += 1000;
	}
	
	public void adicionarNVezes1000Itens(){
        int pa = (this.quantidade * (this.quantidade + 1)) / 2;
        this.quantidade += 1000 * pa;
    }
	
	public void perderItem(){
        this.quantidade --;
    }
	
	//Métodos gets para retornar os campos dos itens
	public int getQuantidade(){
		return this.quantidade;
	}
	
	public String getDescricao(){
		return this.descricao;
	}
	
	//Se um item possui o mesmo nome que outro ele é igual a este
	@Override
	public boolean equals(Object obj){
		Item outroItem = (Item) obj;
		return this.descricao.equals(outroItem.getDescricao());
	}
}

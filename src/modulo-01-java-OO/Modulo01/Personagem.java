public class Personagem {
	
	 protected String nome;
	 protected int vida;
	 protected int experiencia;
	 protected Status status = Status.VIVO;
	 protected Inventario inventario = new Inventario();
	 
	 public void perderVida(int dano){
		 this.vida -= dano;
	 }
	 
	 public void adicionarItemAoInventário(Item item){
		 this.inventario.adicionarItem(item);
	 }
	 
	 public void perderItem(Item item){
		 this.inventario.perderItem(item);
	 }
	    
	 public void removerItemDoInventário(Item item){
		 this.inventario.removerItem(item);
	 }
	 
	 public void OrdenarItensDoInventario(){
		 this.inventario.ordenarItens();
	 }
	 
	 public void adicionar1000UnidadesDeUmItem(int index){
	        inventario.adicionar1000UnidadesDeUmItem(index);
	 }
	 
	 public void adicionarNVezes1000Itens(int index){
		 inventario.adicionarNVezes1000Itens(index);
	 }
	    
	 public int getQuantidadeDeItemDoInventario(int index){
	     return this.inventario.getQuantidadeDeItem(index);
	 }
	 
	 public int getVida(){
		 return this.vida;
	 }
	    
	 public int getExperiencia(){
		 return this.experiencia;
	 }
	 
	 public boolean inventarioPossuiItem(Item item){
		 return this.inventario.inventarioPossuiItem(item);
	 }
	 
	 public Status getStatus(){
		 return this.status;
	 }
	    
	 public String getNome(){
		 return this.nome;
	 }
	 
	 public String getDescricaoDeItemDoInventario(int index){
	     return this.inventario.getDescricaoDeItem(index);
	 }
	 
	 public Item getItemComMaiorQuantidade(){
		 return this.inventario.getItemComMaiorQuantidade();
	 }
	 
	 public Item getItem(Item item){
	     return this.inventario.getItem(item);
	 }
	 
	 public String getDescricoesDeItensDoInventario(){
		 return this.inventario.getDescricoesItens();
	 }
}

public class Personagem
{
    protected String nome;
    protected int vida;
    protected int experiencia;
    protected Status status = Status.VIVO;
    protected Inventario inventario = new Inventario();
   
    public void adicionarItemAoInventário(Item item){
        this.inventario.adicionarItem(item);
    }
    
    public void removerItemDoInventário(Item item){
        this.inventario.removerItem(item);
    }
    
    public void ganharUmItem(Item item, int quantidade){
        this.inventario.ganharUmItem(item, quantidade);
    }
    
    public void perderUmItem(Item item, int quantidade){
        this.inventario.perderUmItem(item, quantidade);
    }
    
    public void ganharUmItem(int index, int quantidade){
        this.inventario.ganharUmItem(index, quantidade);
    }
    
    public void perderUmItem(int index, int quantidade){
        this.inventario.perderUmItem(index, quantidade);
    }
    
    public void OrdenarItensDoInventario(){
        this.inventario.ordenarItens();
    }
    
    public int getVida(){
        return this.vida;
    }
    
    public Inventario getItens(){
    	return this.inventario;
    }
    
    public Item getItem(Item item){
        return this.inventario.getItem(item);
    }
    
    public Item getItem(int itemIndex){
        return this.inventario.getItem(itemIndex);
    }
    
    public String getDescriçãoItens(){
        return this.inventario.getDescricoesItens();
    }
    
    public Item getItemComMaiorQuantidade(){
        return this.inventario.getItemComMaiorQuantidade();
    }
    
    public String getDescriçãoDeItemDoInventário(int index){
        return this.inventario.getDescricaoDeItem(index);
    }
    
    public int getQuantidadeDeItemDoInventário(int index){
        return this.inventario.getQuantidadeDeItem(index);
    }
    
    public Status getStatus(){
        return this.status;
    }
    
    public String getNome(){
        return this.nome;
    }
    
    public int getExperiencia(){
        return this.experiencia;
    }
}

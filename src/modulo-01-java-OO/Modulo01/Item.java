
public class Item
{
    private String descricao;
    private int quantidade;
    
    public Item (String descricao, int quantidade){
        this.descricao = descricao;
        this.quantidade = quantidade;
    }
    
    public void adicionar1000Itens(){
        this.quantidade += 1000;
    }
    
    public void perderItem(int quantidade){
        this.quantidade -= quantidade;
    }
    
    public String getDescricao(){
        return this.descricao;
    }
    
    public int getQuantidade(){
        return this.quantidade;
    }
}


public class Item
{
    private String descrição;
    private int quantidade;
    
    public Item (String descrição, int quantidade){
        this.descrição = descrição;
        this.quantidade = quantidade;
    }
    
    public void adicionarItem(int quantidade){
        this.quantidade += quantidade;
    }
    
    public void perderItem(int quantidade){
        this.quantidade -= quantidade;
    }
    
    public String getDescrição(){
        return this.descrição;
    }
    
    public int getQuantidade(){
        return this.quantidade;
    }
}

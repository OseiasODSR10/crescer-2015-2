
public class Item
{
    private String tipo;
    private String descrição;
    private int quantidade;
    
    public Item (String tipo, String descrição, int quantidade){
        this.tipo = tipo;
        this.descrição = descrição;
        this.quantidade = quantidade;
    }
    
    public String getTipo(){
        return this.tipo;
    }
    
    public void adicionarItem(int quantidade){
        this.quantidade += quantidade;
    }
    
    public String getDescrição(){
        return this.descrição;
    }
    
    public int getQuantidade(){
        return this.quantidade;
    }
}


public class IrishDwarf 
{
    private String nome;
    private int vida, experiencia;
    private Status status = Status.VIVO;
    private DataTerceiraEra dataNascimento;
    private Inventario inventario = new Inventario();
          
    public IrishDwarf (String nome){
        this(nome, new DataTerceiraEra(1,1,1));        
    }
    
    public IrishDwarf (String nome, DataTerceiraEra dataNascimento){
        this.vida = 110;
        this.nome = nome;
        this.dataNascimento = dataNascimento;
    }
    
    public void perderVida(){
        double numeroDeSorte = this.getNumeroSorte();
        if(numeroDeSorte<0){
            this.experiencia += 2;
        }
        else {
            if (numeroDeSorte>100){
                if(this.vida>0){
                    this.vida -= 10;
                }
                if(vida==0){
                    this.status = Status.MORTO;
                }
            }
        }
        
    }
    
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
    
    public void tentarSorte(){
        if(-3333 == this.getNumeroSorte()){
            for(int i=0; i<inventario.getItens().size();i++){
                this.adicionarNVezes1000Itens(i);
            }
       }
    }
    
    public void adicionarNVezes1000Itens(int index){
        inventario.adicionarNVezes1000Itens(index);
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
    
    public DataTerceiraEra getDataNascimento(){
        return this.dataNascimento;
    }
    
    public Double getNumeroSorte(){
        double valor = 101.0;
        valor = (this.dataNascimento.ehBissexto() && 80<=this.vida && this.vida<=90)? 101.0*-33 : this.nome!=null && (this.nome.equals("Seixas") || this.nome.equals("Meireles"))? (101.0*33)%100 : 101.0; 
        return valor;
    }



}

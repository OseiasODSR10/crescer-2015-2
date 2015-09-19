

public class Dwarf
{
    private String nome;
    private int vida, experiencia;
    private Status status = Status.VIVO;
    private DataTerceiraEra dataNascimento;
    private Inventário inventário = new Inventário();
    
    public Dwarf (String nome){
        this(nome, new DataTerceiraEra(1,1,1));        
    }
    
    public Dwarf (String nome, DataTerceiraEra dataNascimento){
        this.vida = 110;
        this.nome = nome;
        this.dataNascimento = dataNascimento;
    }
    
    public void perderVida(){
        double numeroDeSorte = this.getNúmeroSorte();
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
        this.inventário.adicionarItem(item);
    }
    
    public void removerItemDoInventário(Item item){
        this.inventário.removerItem(item);
    }
    
    public void ganharUmItem(Item item, int quantidade){
        this.inventário.ganharUmItem(item, quantidade);
    }
    
    public void tentarSorte(){
        if(-3333.0 == this.getNúmeroSorte()){
            for(int i = 0; i < this.inventário.getItens().size(); i++){
               this.inventário.getItens().get(i).adicionarItem(1000);
            }
        }
    }
    
    public int getVida(){
        return this.vida;
    }
    
    public Inventário getItens(){
    	return this.inventário;
    }
    
    public Status getStatus(){
        return this.status;
    }
    
    public String getNome(){
        return this.nome;
    }
    
    public int getExperiência(){
        return this.experiencia;
    }
    
    public DataTerceiraEra getDataNascimento(){
        return this.dataNascimento;
    }
    
    public Double getNúmeroSorte(){
        double valor = 101.0;
        valor = (this.dataNascimento.ehBissexto() && 80<=this.vida && this.vida<=90)? 101.0*-33 : this.nome!=null && (this.nome.equals("Seixas") || this.nome.equals("Meireles"))? (101.0*33)%100 : 101.0; 
        return valor;
    }
}




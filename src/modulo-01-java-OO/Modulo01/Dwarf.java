

public class Dwarf extends Personagem
{
    protected DataTerceiraEra dataNascimento;
    
    public Dwarf(){
        
    }
    
    public Dwarf (String nome){
        this(nome, new DataTerceiraEra(1,1,1));        
    }
    
    public Dwarf (String nome, DataTerceiraEra dataNascimento){
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
    
    public void tentarSorte(){
        if(-3333.0 == this.getNumeroSorte()){
            for(int i = 0; i < this.inventario.getItens().size(); i++){
               this.ganharUmItem(i, 1000);
            }
        }
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




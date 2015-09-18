

public class Dwarf
{
    private String nome;
    private int vida, experiencia;
    private Status status = Status.VIVO;
    private DataTerceiraEra dataNascimento;
    
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
    
    public int getVida(){
        return this.vida;
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




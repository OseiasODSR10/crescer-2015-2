

public class Dwarf
{
    private String nome;
    private int vida, experiencia;
    private Status status;
    public Dwarf (String nome){
        this.nome = nome;
        this.vida = 110;
    }
    
    public void perderVida(){
            this.vida -= 10;
            if(vida==0){
                status = Status.MORTO;
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
}




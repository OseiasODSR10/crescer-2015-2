

public class Dwarf
{
    private int vida;
    
    public Dwarf (){
        this.vida = 110;
    }
    
    public void perderVida(){
            this.vida -= 10;
    }
    
    public int getVida(){
        return this.vida;
    }
}




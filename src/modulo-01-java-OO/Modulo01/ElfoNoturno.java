public class ElfoNoturno extends Elfo
{
   
    public ElfoNoturno(String nome){
        super(nome);
    }
    
    @Override
    public void atirarFlecha(){
        super.atirarFlecha();
        this.experiencia += 2;
        this.perder5PorCentoDaVida();
    }
    
    public void perder5PorCentoDaVida(){
        this.vida =  this.vida * 0.05;
        this.status = (int) this.vida <= 0? Status.MORTO : this.status;
    }
}

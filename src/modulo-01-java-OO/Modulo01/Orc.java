
public class Orc extends Personagem{

	@Override
	public void perderVida(int dano){
		this.perderVida();
	}
	
	public void perderVida(){
        if(this.inventarioPossuiItem(new Item("Escudo Uruk Hai",1))){
            this.vida -= 6;
            this.perderItem(new Item("Escudo Uruk Hai",1));
        }
        else{
            this.vida -= 10;
        }
        this.status = this.vida <= 0? Status.MORTO : this.status;
    }
	
	public void atacarOutroPersonagem(Personagem alvo){
        if(this.inventarioPossuiItem(new Item("Espada",1))){
            alvo.perderVida(12);
            this.perderItem(new Item("Espada",1));
        }
        else if (this.inventarioPossuiItem(new Item("Flecha",1)) && this.inventarioPossuiItem(new Item("Arco",1))){
            alvo.perderVida(8);
            this.perderItem(new Item("Flecha",1));
            this.perderItem(new Item("Arco",1));
        }
        else{
            this.status = Status.FUGINDO;
        }
    }

}
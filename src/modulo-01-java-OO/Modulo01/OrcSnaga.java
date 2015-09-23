public class OrcSnaga extends Orc{
	
	public OrcSnaga(){
		this.vida = 70;
		this.adicionarItemAoInventário(new Item ("Arco",1));
		this.adicionarItemAoInventário(new Item ("Flecha",5));
	}

}

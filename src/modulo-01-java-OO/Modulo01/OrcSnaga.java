public class OrcSnaga extends Orc{
	
	public OrcSnaga(){
		this.vida = 70;
		this.adicionarItemAoInventario(new Item ("Arco",1));
		this.adicionarItemAoInventario(new Item ("Flecha",5));
	}

}

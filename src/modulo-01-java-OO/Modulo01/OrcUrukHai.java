public class OrcUrukHai extends Orc {
	
	public OrcUrukHai(){
		this.vida = 150;
		this.adicionarItemAoInventario(new Item ("Espada",1));
		this.adicionarItemAoInventario(new Item ("Escudo Uruk Hai",1));
	}

}

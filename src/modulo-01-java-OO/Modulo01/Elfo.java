public class Elfo {
    private String nome;
    private int flechas;
    private int experiencia;
    
    public Elfo(String n, int flech) {
        nome = n;
        flechas = flech;
    }
    
    public Elfo(String n){
    	nome = n;
    	flechas = 42;
    }
   
    public boolean acertar(){
		int x = (int) Math.random() * 100; 
		return x<50;
	}

	public void atirarFlecha(){
		flechas--;
		if(acertar() == true){
			experiencia++;
		}  
	}
    
    public void mostrarInformações(){
    	System.out.println("Elfo: "+nome);
    	System.out.println("Experiência: "+experiencia);
    	System.out.println("Flechas: "+flechas);
    }
}

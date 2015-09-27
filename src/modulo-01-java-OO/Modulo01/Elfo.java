/**
 * Representa objetos do tipo Elfo.
 */
public class Elfo extends Personagem {
    protected int flechas;
    private static int contadorDeElfos = 0;
    /* Type initializer
     * Executa antes de cada construtor
    {
        flechas = 42;
    }
    */
    public Elfo(String nome, int flechas) {
        this.nome = nome;
        this.flechas = flechas;
        this.status = Status.VIVO;
        this.vida = 100;
        this.contadorDeElfos++;
    }
    
   /* public Elfo(String nome, Integer flechas) {
        this(nome);

        if (flechas == null) {
            this.flechas = 89;
        }
    }*/
    
    public Elfo(String nome){
        this(nome,42);
    }
   
   

    /* PascalCase (C#, VB.NET)
     *      public void AtirarFlechaDeFogo
     * camelCase (Java, JavaScript)
     *      public void atirarFlechaDeFogo
    */
   

    public void atirarFlecha() {
        this.flechas--;
        this.experiencia++;
    }

    /*
     * 
     * public atirarFlechaRefactory(this.flechas, this.experiencia){
     *     if(boolean acertar == true){
     *         flechas--;
     *         experiencia++;
     *      }else{
     *          flechas--;
     *      }
     *  }
     */
    /*
    public void atirarFlechaRefactory(){
        boolean acertar = true;
        if (acertar) {
            experiencia++;
        }
        flechas--;
    }
    */

    public void cacarDwarf(Dwarf anao){
        this.atirarFlecha();
        anao.perderVida();
    }
    
    public int getFlechas() {
        return this.flechas;
    }
    
    public static int getContadorDeElfos(){
        return contadorDeElfos;
    }
    
    /* 
    public void setFlechas(int flechas) {
        if (flechas > this.flechas)
            this.flechas = flechas;
    }
    */
   
@Override
   public String toString(){
       boolean flechaENoSingular = Math.abs(this.flechas) == 1;
       String textoFlecha = flechaENoSingular? "flecha" : "flechas";
       
       boolean nivelENoSingular = Math.abs(this.experiencia) == 1;
       String textoNivel = nivelENoSingular? "nível" : "níveis";
              
       String textoCompleto = String.format("%s possui %d %s e %d %s de experiência.", this.nome, this.flechas, textoFlecha, this.experiencia, textoNivel);
       return textoCompleto;
    }
}

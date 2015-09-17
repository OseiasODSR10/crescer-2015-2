/**
 * Representa objetos do tipo Elfo.
 */
public class Elfo {
    private String nome;
    private int flechas, experiencia;
    
    /* Type initializer
     * Executa antes de cada construtor
    {
        flechas = 42;
    }
    */
    public Elfo(String nome, int flechas) {
        this.nome = nome;
        this.flechas = flechas;
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
        flechas--;
        experiencia++;
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
    public void atirarFlechaRefactory(){
        boolean acertar = true;
        if (acertar) {
            experiencia++;
        }
        flechas--;
    }
    

    public void caçarDwarf(Dwarf anao){
        this.atirarFlecha();
        anao.perderVida();
    }
    

    public String getNome() {
        return nome;
    }
    
    public int getFlechas() {
        return this.flechas;
    }
    
    public int getExperiencia(){
        return this.experiencia;
    }
    
    /* 
    public void setFlechas(int flechas) {
        if (flechas > this.flechas)
            this.flechas = flechas;
    }
    */
   
   @Override
   public String toString(){
       boolean flechaÉNoSingular = Math.abs(this.flechas) == 1;
       String textoFlecha = flechaÉNoSingular? "flecha" : "flechas";
       
       boolean nivelÉNoSingular = Math.abs(this.experiencia) == 1;
       String textoNivel = nivelÉNoSingular? "nível" : "níveis";
              
       String textoCompleto = String.format("%s possui %d %s e %d %s de experiência.", this.nome, this.flechas, textoFlecha, this.experiencia, textoNivel);
       return textoCompleto;
    }
}

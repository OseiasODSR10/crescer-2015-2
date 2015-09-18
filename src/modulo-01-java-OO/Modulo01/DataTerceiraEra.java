
public class DataTerceiraEra
{
    private int dia;
    private int mês;
    private int ano;
    
    public DataTerceiraEra(int dia, int mês, int ano){
        this.ano = ano;
        this.mês = mês;
        this.dia = dia;
    }
    
    public int getDia(){
        return this.dia;
    }
    
    public int getMês(){
        return this.mês;
    }
    
    public int getAno(){
        return this.ano;
    }
    
    public boolean ehBissexto(){
        boolean ehBissexto;
        if((ano%4==0) && (ano%100!=0)){
            ehBissexto = true;
        }
        else if (ano%400==0){
            ehBissexto = true;
        }else{
            ehBissexto = false;
        }
        return ehBissexto; 
    }
}

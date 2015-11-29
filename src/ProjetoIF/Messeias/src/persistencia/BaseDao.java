package persistencia;


public abstract class BaseDao<T> {
	
	protected ConexaoMysql conexao;
	
	public BaseDao(){
		try{
			conexao = new ConexaoMysql("localhost", "messeias", "root", "");
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public abstract T criar(T objeto) throws Exception;
	
	public abstract void atualizar(T objeto) throws Exception;
	
	public abstract void deletar(T objeto) throws Exception;
}

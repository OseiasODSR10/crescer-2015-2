package persistencia;

import java.util.ArrayList;

public abstract class BaseDao<T> {
	
	protected ConexaoMysql conexao;
	
	public BaseDao(){
		try{
			conexao = new ConexaoMysql("localhost", "messeias", "root", "");
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public abstract void criar(T objeto);
	
	public abstract void atualizar(T objeto);
	
	public abstract void deletar(T objeto);
	
	public abstract ArrayList<T> buscarTodos();
}

package br.com.cwi.crescer.exceptions;

public class EmptyListException extends RuntimeException{
	
	public EmptyListException(String msg){
		super(msg);
	}
	
	public EmptyListException(){
		super();
	}
}

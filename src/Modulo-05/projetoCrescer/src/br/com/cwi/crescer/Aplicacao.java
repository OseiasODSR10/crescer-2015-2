package br.com.cwi.crescer;

import java.util.List;

public class Aplicacao {
	
	public static void main(String[] args) {
		LinkedList linkedList = new LinkedList();
		linkedList.addFirst("primeiro");
		linkedList.addLast("segundo");
		linkedList.addLast("terceiro");
		linkedList.addLast("quarto");
		linkedList.addLast("quinto");
		linkedList.addFirst("zero");
		List<String> lista = linkedList.list();
		for(String s : lista){
			System.out.println(s);
		}
		linkedList.remove(2);
		lista = linkedList.list();
		for(String s : lista){
			System.out.println(s);
		}
		linkedList.add(2, "segundo");
		lista = linkedList.list();
		for(String s : lista){
			System.out.println(s);
		}
	}
}

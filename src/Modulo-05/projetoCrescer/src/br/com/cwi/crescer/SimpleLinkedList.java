package br.com.cwi.crescer;

import java.util.ArrayList;
import java.util.List;

public class SimpleLinkedList<T> implements LinkedList<T>{
	
	protected Node last, first;
	
	@Override
	public void addFirst(T value){
		Node node = new Node(value, first);	
		if(first == null){
			last = node;
		}
		first = node;
	}
	
	@Override
	public void addLast(T value){
		Node node = new Node(value, null);
		last.setNext(node);
		last = node;
	}
	
	@Override
	public List<T> list(){
		ArrayList<T> lista = new ArrayList<T>(); 
		Node node = first;
		lista.add(node.getValue());
		while(node != last){
			node = node.getNext();
			lista.add(node.getValue());
		}
		return lista;
	}
	
	public T getFirst(){
		return first.getValue();
	}	
	
	public T getLast(){
		return this.last.getValue();
	}
	
	@Override
	public void removeFirst(){
		first = first.getNext();
	}	
	
	@Override
	public void remove (int index){
		Node node = this.getIndex(index);
		if(node.getNext() == last){
			last = node;
		}
		Node nodeRemovido = node.getNext();
		node.setNext(nodeRemovido.getNext());
	}
	
	@Override
	public void add(int index, T value){
		if(index == 0){
			this.addFirst(value);
		}else{
			Node node = this.getIndex(index);
			Node newNode = new Node(value);
			newNode.setNext(node.getNext());
			node.setNext(newNode);
			if(newNode.getNext() == null){
				last = newNode;
			}
		}
	}
	
	@Override
	public boolean isEmpty(){
		return first == null;
	}
	
	public Node getIndex(int index){
		Node node = first;
		int cont = 0;
		while((cont + 1) != index){
			cont++;
			node = node.getNext();
		}
		return node;
	}
	
	protected class Node {
		
		private T value;
		
		private Node next;
		
		public Node(T value){
			this.value = value;
		}
		
		public Node(T value, Node node){
			this.next = node;
			this.value = value;
		}

		public T getValue() {
			return value;
		}

		public void setValue(T value) {
			this.value = value;
		}

		public Node getNext() {
			return next;
		}

		public void setNext(Node next) {
			this.next = next;
		}
	}
}

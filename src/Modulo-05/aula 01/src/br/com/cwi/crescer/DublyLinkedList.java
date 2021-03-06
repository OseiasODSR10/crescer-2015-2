package br.com.cwi.crescer;

import java.util.ArrayList;
import java.util.List;

import br.com.cwi.crescer.SimpleLinkedList.Node;

public class DublyLinkedList<T> implements  LinkedList<T>{
	
	protected Node first, last;

	@Override
	public void addFirst(T value) {
		Node node = new Node(value, null, first);
		if(first == null){
			last = node;
		}else{
			first.setPrevious(node);
		}
		first = node;
	}

	@Override
	public void add(int index, T value) {
		if(index == 0){
			this.addFirst(value);
		}else{
			Node previous = this.getIndex(index-1);
			Node next = this.getIndex(index);
			if(next == null){
				this.addLast(value);
			}else{
				Node newNode = new Node(value, previous, next);
				previous.setNext(newNode);
				next.setPrevious(newNode);
			}
		}
	}

	@Override
	public void addLast(T value) {
		Node node = new Node(value, last, null);
		last.setNext(node);
		last = node;
	}

	@Override
	public void removeFirst() {
		Node newFirst = first.getNext();
		newFirst.setPrevious(null);
		first = newFirst;
	}

	@Override
	public void remove(int index) {		
		Node nodeRemovido = this.getIndex(index);
		if(nodeRemovido == first){
			this.removeFirst();
		}else {
			Node previous = this.getIndex(index-1);
			if(nodeRemovido == last){
				last = previous;
			}else{
				Node next = this.getIndex(index+1);			
				next.setPrevious(previous);
				previous.setNext(next);						
			}		
		}	
	}

	@Override
	public List<T> list() {
		ArrayList<T> lista = new ArrayList<T>(); 
		Node node = first;
		lista.add(node.getValue());
		while(node != last){
			node = node.getNext();
			lista.add(node.getValue());
		}
		return lista;
	}

	@Override
	public boolean isEmpty() {
		return first == null;
	}
	
	public T getFirst() {
		return first.getValue();
	}

	public T getLast() {
		return last.getValue();
	}
	
	public Node getIndex(int index){
		if(this.isEmpty()){
			return null;
		}else{
			Node node = first;
			int cont = 0;
			while(cont != index){
				cont++;
				node = node.getNext();
			}
			return node;
		}		
	}

	public class Node {
		
		private T value;		
		private Node next;
		private Node previous;
		
		public Node(T value){
			this.value = value;
		}
		
		public Node(T value, Node previousNode, Node nextNode){
			this.next = nextNode;
			this.previous = previousNode;
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
		
		public Node getPrevious() {
			return previous;
		}
		
		public void setPrevious(Node previous) {
			this.previous = previous;
		}
	}
}
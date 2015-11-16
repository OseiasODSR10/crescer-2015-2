package br.com.cwi.crescer;

public class DublyLinkedList<T> {
	
	protected Node first, last;
	
	public void addFirst(T value){
		
	}
	
	protected class Node {
		
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
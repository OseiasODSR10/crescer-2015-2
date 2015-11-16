package br.com.cwi.crescer;

public class DublyLinkedList {
	
	protected Node first, last;
	
	public void addFirst(String value){
		
	}
	
	protected class Node {
		
		private String value;		
		private Node next;
		private Node previous;
		
		public Node(String value){
			this.value = value;
		}
		
		public Node(String value, Node previousNode, Node nextNode){
			this.next = nextNode;
			this.previous = previousNode;
			this.value = value;
		}

		public String getValue() {
			return value;
		}

		public void setValue(String value) {
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
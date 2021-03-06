package br.com.cwi.crescer;

import java.util.List;

public interface LinkedList<T> {
	
	abstract void add(int index, T value);
	
	abstract void addFirst(T value);
	
	abstract void addLast(T value);
	
	abstract void removeFirst();
	
	abstract void remove(int index);
	
	public List<T> list();
	
	public boolean isEmpty();
}

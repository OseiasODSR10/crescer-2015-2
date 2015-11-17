package br.com.cwi.crescer.test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import br.com.cwi.crescer.SimpleLinkedList;

public class LinkedListTest {

	@Test
	public void adicionarprimeiroNaLista() {
		SimpleLinkedList<String> linkedList = new SimpleLinkedList<String>();
		linkedList.addFirst("primeiro");
		assertEquals(linkedList.getFirst(), "primeiro");
	}
	
	@Test
	public void adicionarprimeiroNaListaEUltimo() {
		SimpleLinkedList<String> linkedList = new SimpleLinkedList<String>();
		linkedList.addFirst("primeiro");
		linkedList.addFirst("segundo");
		linkedList.addFirst("terceiro");
		assertEquals(linkedList.getFirst(), "terceiro");
		assertEquals(linkedList.getLast(), "primeiro");
	}
	
	@Test
	public void listarTodosOsValores() {
		SimpleLinkedList<String> linkedList = new SimpleLinkedList<String>();
		linkedList.addFirst("primeiro");
		linkedList.addLast("segundo");
		linkedList.addLast("terceiro");
		assertEquals(linkedList.getFirst(), "primeiro");
		assertEquals(linkedList.getLast(), "terceiro");
		assertEquals(linkedList.list().toString(), "[primeiro, segundo, terceiro]");
	}
	
	@Test
	public void removerSegundoValor() {
		SimpleLinkedList<String> linkedList = new SimpleLinkedList<String>();
		linkedList.addFirst("primeiro");
		linkedList.addLast("segundo");
		linkedList.addLast("terceiro");
		linkedList.addLast("quarto");
		linkedList.remove(1);
		assertEquals(linkedList.getFirst(), "primeiro");
		assertEquals(linkedList.getLast(), "quarto");
		assertFalse(linkedList.list().contains("segundo"));
	}
	
	@Test
	public void removerPrimeiroValor() {
		SimpleLinkedList<String> linkedList = new SimpleLinkedList<String>();
		linkedList.addFirst("primeiro");
		linkedList.addLast("segundo");
		linkedList.addLast("terceiro");
		linkedList.addLast("quarto");
		linkedList.removeFirst();
		assertEquals(linkedList.getFirst(), "segundo");
		assertEquals(linkedList.getLast(), "quarto");
		assertFalse(linkedList.list().contains("primeiro"));
	}
	
	@Test
	public void removerUltimoValor() {
		SimpleLinkedList<String> linkedList = new SimpleLinkedList<String>();
		linkedList.addFirst("primeiro");
		linkedList.addLast("segundo");
		linkedList.addLast("terceiro");
		linkedList.addLast("quarto");
		linkedList.remove(3);
		assertEquals(linkedList.getFirst(), "primeiro");
		assertEquals(linkedList.getLast(), "terceiro");
		assertFalse(linkedList.list().contains("quarto"));
	}
	
	@Test
	public void addValorNaSegundaPosicao() {
		SimpleLinkedList<String> linkedList = new SimpleLinkedList<String>();
		linkedList.addFirst("primeiro");
		linkedList.addLast("terceiro");
		linkedList.addLast("quarto");
		linkedList.add(1, "segundo");
		assertEquals(linkedList.getFirst(), "primeiro");
		assertEquals(linkedList.getLast(), "quarto");
		assertTrue(linkedList.list().contains("segundo"));
	}	
	
	@Test
	public void addValorNaUltimaPosicao() {
		SimpleLinkedList<String> linkedList = new SimpleLinkedList<String>();
		linkedList.addFirst("primeiro");
		linkedList.addLast("terceiro");
		linkedList.addLast("quarto");
		linkedList.add(1, "segundo");
		linkedList.add(4, "quinto");
		assertEquals(linkedList.getFirst(), "primeiro");
		assertEquals(linkedList.getLast(), "quinto");
		assertTrue(linkedList.list().contains("segundo"));
		assertTrue(linkedList.list().contains("quinto"));
	}	
	
	@Test
	public void addValorNaPrimeiraPosicao() {
		SimpleLinkedList<String> linkedList = new SimpleLinkedList<String>();
		linkedList.addFirst("primeiro");
		linkedList.addLast("terceiro");
		linkedList.addLast("quarto");
		linkedList.add(1, "segundo");
		linkedList.add(0, "zero");
		assertEquals(linkedList.getFirst(), "zero");
		assertEquals(linkedList.getLast(), "quarto");
		assertTrue(linkedList.list().contains("segundo"));
		assertTrue(linkedList.list().contains("zero"));
	}
}

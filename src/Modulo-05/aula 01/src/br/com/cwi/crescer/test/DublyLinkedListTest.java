package br.com.cwi.crescer.test;

import static org.junit.Assert.*;

import org.junit.Test;

import br.com.cwi.crescer.DublyLinkedList;
import br.com.cwi.crescer.SimpleLinkedList;

public class DublyLinkedListTest {

	@Test
	public void adicionarprimeiro() {
		DublyLinkedList<String> linkedList = new DublyLinkedList<String>();
		linkedList.addFirst("primeiro");
		assertEquals(linkedList.getFirst(), "primeiro");
	}
	
	@Test
	public void adicionarprimeiroComUmPrimeiroExistente() {
		DublyLinkedList<String> linkedList = new DublyLinkedList<String>();
		linkedList.addFirst("primeiro");
		linkedList.addFirst("zero");
		assertEquals(linkedList.getFirst(), "zero");
	}
	
	@Test
	public void adicionarprimeiroComUmPrimeiroExistenteEPreviousApontaParaEsteNovoPrimeiro() {
		DublyLinkedList<String> linkedList = new DublyLinkedList<String>();
		linkedList.addFirst("primeiro");
		linkedList.addFirst("zero");
		assertEquals(linkedList.getIndex(1).getValue(), "primeiro");
		assertEquals(linkedList.getIndex(1).getPrevious().getValue(), "zero");
	}
	
	@Test
	public void adicionarUltimo() {
		DublyLinkedList<String> linkedList = new DublyLinkedList<String>();
		linkedList.addFirst("primeiro");
		linkedList.addLast("segundo");
		assertEquals(linkedList.getFirst(), "primeiro");
		assertEquals(linkedList.getLast(), "segundo");
	}
	
	@Test
	public void adicionarUltimoPorIndice() {
		DublyLinkedList<String> linkedList = new DublyLinkedList<String>();
		linkedList.addFirst("primeiro");
		linkedList.add(1, "segundo");
		assertEquals(linkedList.getFirst(), "primeiro");
		assertEquals(linkedList.getLast(), "segundo");
	}
	
	@Test
	public void adicionarPrimeiroPorIndice() {
		DublyLinkedList<String> linkedList = new DublyLinkedList<String>();
		linkedList.addFirst("primeiro");
		linkedList.add(0, "zero");
		assertEquals(linkedList.getFirst(), "zero");
		assertEquals(linkedList.getLast(), "primeiro");
	}
	
	@Test
	public void adicionarNaSegundaPosicao() {
		DublyLinkedList<String> linkedList = new DublyLinkedList<String>();
		linkedList.addFirst("primeiro");
		linkedList.addLast("terceiro");
		linkedList.add(1, "segundo");
		assertEquals(linkedList.getFirst(), "primeiro");
		assertEquals(linkedList.getLast(), "terceiro");
		assertTrue(linkedList.list().contains("segundo"));
		assertEquals(linkedList.getIndex(1).getValue(), "segundo");
	}
	
	@Test
	public void removerPrimeiro() {
		DublyLinkedList<String> linkedList = new DublyLinkedList<String>();
		linkedList.addFirst("zero");
		linkedList.addLast("primeiro");
		linkedList.addLast("segundo");
		linkedList.removeFirst();
		assertEquals(linkedList.getFirst(), "primeiro");
		assertEquals(linkedList.getLast(), "segundo");
		assertFalse(linkedList.list().contains("zero"));
		assertEquals(linkedList.getIndex(0).getValue(), "primeiro");
	}
	
	@Test
	public void removerUltimoPorIndice() {
		DublyLinkedList<String> linkedList = new DublyLinkedList<String>();
		linkedList.addFirst("zero");
		linkedList.addLast("primeiro");
		linkedList.addLast("segundo");
		linkedList.remove(2);
		assertEquals(linkedList.getFirst(), "zero");
		assertEquals(linkedList.getLast(), "primeiro");
		assertFalse(linkedList.list().contains("segundo"));
		assertEquals(linkedList.getIndex(1).getValue(), "primeiro");
	}
	
	@Test
	public void removerTerceiroNaPosicaoQuatro() {
		DublyLinkedList<String> linkedList = new DublyLinkedList<String>();
		linkedList.addFirst("zero");
		linkedList.addLast("primeiro");
		linkedList.addLast("segundo");
		linkedList.addLast("terceiro");
		linkedList.addLast("quarto");
		linkedList.remove(3);
		assertEquals(linkedList.getFirst(), "zero");
		assertEquals(linkedList.getLast(), "quarto");
		assertFalse(linkedList.list().contains("terceiro"));
		assertEquals(linkedList.getIndex(3).getValue(), "quarto");
	}
	
	@Test
	public void removerPrimeiroPorIndice() {
		DublyLinkedList<String> linkedList = new DublyLinkedList<String>();
		linkedList.addFirst("zero");
		linkedList.addLast("primeiro");
		linkedList.addLast("segundo");
		linkedList.addLast("terceiro");
		linkedList.addLast("quarto");
		linkedList.remove(0);
		assertEquals(linkedList.getFirst(), "primeiro");
		assertEquals(linkedList.getLast(), "quarto");
		assertFalse(linkedList.list().contains("zero"));
		assertEquals(linkedList.getIndex(0).getValue(), "primeiro");
	}
}

package model.data_structures;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Stack<Item> implements Iterable<Item>, IStack {
	private Node<Item> first;     
	private int n; 

	private static class Node<Item> {
		private Item item;
		private Node<Item> next;
	}

	public Stack() {
		first = null;
		n = 0;
	}

	public boolean isEmpty() {
		return first == null;
	}


	public int size() {
		return n;
	}


	public void push(Item item) {
		Node<Item> oldfirst = first;
		first = new Node<Item>();
		first.item = item;
		first.next = oldfirst;
		n++;
	}


	public Item pop() {
		if (isEmpty()) throw new NoSuchElementException("Stack underflow");
		Item item = first.item;        
		first = first.next;            
		n--;
		return item;                 
	}



	public Item peek() {
		if (isEmpty()) throw new NoSuchElementException("Stack underflow");
		return first.item;
	}



	public Iterator<Item> iterator() {
		return new LinkedIterator(first);
	}


	private class LinkedIterator implements Iterator<Item> {
		private Node<Item> current;

		public LinkedIterator(Node<Item> first) {
			current = first;
		}

		public boolean hasNext() {
			return current != null;
		}

		public void remove() {
			throw new UnsupportedOperationException();
		}

		public Item next() {
			if (!hasNext()) throw new NoSuchElementException();
			Item item = current.item;
			current = current.next; 
			return item;
		}
	}

}

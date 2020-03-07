package model.data_structures;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class ArregloDinamico <I> implements Iterable<I>{
	
	private I[] a;         
	private int n;            

	public ArregloDinamico() {
		a = (I[]) new Object[2];
		n = 0;
	}

	public boolean isEmpty() {
		return n == 0;
	}

	public int size() {
		return n;
	}

	private void resize(int capacity) {
		assert capacity >= n;
		I[] copy = (I[]) new Object[capacity];
		for (int i = 0; i < n; i++)
			copy[i] = a[i];
		a = copy;
	}

	 public void add(I item) {
		 if (n == a.length) resize(2*a.length);    
		 a[n++] = item;                            
	 }


	 public Iterator<I> iterator() {
		 return new ArrayIterator();
	 }

	 private class ArrayIterator implements Iterator<I> {
		 private int i = 0;
		 public boolean hasNext()  { return i < n;                               }
		 public void remove()      { throw new UnsupportedOperationException();  }

		 public I next() {
			 if (!hasNext()) throw new NoSuchElementException();
			 return a[i++];
		 }
	 }

}

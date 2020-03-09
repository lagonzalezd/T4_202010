package model.data_structures;

import java.util.Comparator;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class MaxColaCP<T extends Comparable <T>> implements IMAX<T>
{
	private T[] pq;
	private int numElementos;
	private Comparator<T> comparator;

	
	public MaxColaCP(int maxN)
	{
		pq = (T[]) new Comparable[maxN+1];
		numElementos = 0;
	}

	public MaxColaCP()
	{
		this(1);
	}

	public MaxColaCP(int initC, Comparator<T> comparator)
	{
		this.comparator = comparator;
		pq = (T[]) new Object[initC + 1];
		numElementos = 0;
	}
	public MaxColaCP(Comparator<T> comparator)
	{
		this(1, comparator);
	}

	public MaxColaCP(T[] keys)
	{
		numElementos = keys.length;
		pq = (T[]) new Object[keys.length + 1];
		for (int i = 0; i < numElementos; i++)
			pq[i+1] = keys[i];

		for (int k = numElementos /2; k >= 1; k--)
			sink(k);

		assert isMaxHeap();
	}

	public boolean esVacia() {
		return numElementos == 0;
	}

	public int darNumElementos()
	{
		return numElementos;
	}

	@Override
	public void agregar(T pElemento) {
		
	}

	@Override
	public T sacarMax() {
		return null;
	}

	@Override
	public T darMax() {
		return null;
	}

	public T max()
	{
		return pq[1];
	}

	private void resize(int capacity)
	{
		assert capacity > numElementos;

		T[] temp = (T[]) new Object[capacity];

		for (int i = 1; i <= numElementos; i++)
		{
			temp[i] = pq[i];
		}

		pq = temp;
	}
	public void insert(T x)
	{
		if (numElementos == pq.length - 1) resize(2 * pq.length);

		pq[++numElementos] = x;
		swim(numElementos);
		assert isMaxHeap();
	}
	public T delMax()
	{
		if (esVacia()) throw new NoSuchElementException("La cola de prioridad esta vacia");
		T max = pq[1];
		exch(1, numElementos--);
		sink(1);
		pq[numElementos +1] = null;
		if ((numElementos > 0) && (numElementos == (pq.length - 1) / 4)) resize(pq.length / 2);
		assert isMaxHeap();
		return max;
	}

	private void swim(int k) 
	{
		while (k > 1 && less(k/2, k)) 
		{
			exch(k, k/2);
			k = k/2;
		}
	}

	private void sink(int k) 
	{
		while (2*k <= numElementos)
		{
			int j = 2*k;
			if (j < numElementos && less(j, j+1)) j++;
			if (!less(k, j)) break;
			exch(k, j);
			k = j;
		}
	}

	@SuppressWarnings("unchecked")
	private boolean less(int i, int j) {
		if (comparator == null) 
		{
			return ((Comparable<T>) pq[i]).compareTo(pq[j]) < 0;
		}
		else 
		{
			return comparator.compare(pq[i], pq[j]) < 0;
		}
	}

	private void exch(int i, int j) {
		T swap = pq[i];
		pq[i] = pq[j];
		pq[j] = swap;
	}

	private boolean isMaxHeap() {
		for (int i = 1; i <= numElementos; i++) {
			if (pq[i] == null) return false;
		}
		for (int i = numElementos +1; i < pq.length; i++) {
			if (pq[i] != null) return false;
		}
		if (pq[0] != null) return false;
		return isMaxHeapOrdered(1);
	}


	private boolean isMaxHeapOrdered(int k) 
	{
		if (k > numElementos) return true;
		int left = 2*k;
		int right = 2*k + 1;
		if (left  <= numElementos && less(k, left))  return false;
		if (right <= numElementos && less(k, right)) return false;
		return isMaxHeapOrdered(left) && isMaxHeapOrdered(right);
	}

	public Iterator<T> iterator() {
		return new HeapIterator();
	}

	private class HeapIterator implements Iterator<T>
	{
		private MaxColaCP<T> copy;

		public HeapIterator() {
			if (comparator == null) copy = new MaxColaCP<T>(darNumElementos());
			else                    copy = new MaxColaCP<T>(darNumElementos(), comparator);
			for (int i = 1; i <= numElementos; i++)
				copy.insert(pq[i]);
		}

		public boolean hasNext()  { return !copy.esVacia();                     }
		public void remove()      { throw new UnsupportedOperationException();  }

		public T next() {
			if (!hasNext()) throw new NoSuchElementException();
			return copy.delMax();
		}
	}


}
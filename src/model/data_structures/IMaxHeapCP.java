package model.data_structures;

public interface IMaxHeapCP<K> {


	public boolean isEmpty();

	public int size();

	public K max();

	public void insert(K x);
	
	public K delMax();
	
}
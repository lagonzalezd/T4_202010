package model.data_structures;


public interface IQueue<T> {

    public void enQueue(T pElemento);

    public T deQueue();

    public boolean isEmpty();

    public int size();
}
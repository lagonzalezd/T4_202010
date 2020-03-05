package model.data_structures;

import model.logic.Comparendo;

public class Queue<T> implements IQueue<T> {

    //Atributos
    private Node<T> head;
    
    private Node<T> tail;
    
    private int size;

    //Constructor
    public Queue() {
    	size = 0;
        head = null;
        tail = null;
    }

    /**
     * Se agrega un elemento al final de la cola.
     *
     * @param pElemento
     */
    public void enQueue(T pElemento) {
    	if(tail == null)
		{
    		tail = new Node<>(pElemento,null);
			head = tail;
		}
		else
		{
			Node<T> nodo = new Node<>(pElemento, null);
			tail.cambiarSiguiente(nodo);
			tail = nodo;
		}
    	size++;
    }

    /**
     * Se regresa el primer elemento y se elimina de la cola.
     *
     * @return Primer elemento.
     */
    public T deQueue() {

		if(isEmpty()){
			return null;
		}
		else{
			T toReturn = head.darElemento();
			head = head.darSiguiente();
			size--;
			return toReturn;
		}
    }

    /**
     * Se comprueba que exista al menos un elemento en la cola.
     *
     * @return True si está vacia, false si hay al menos un elemento.
     */
    public boolean isEmpty() {
        return size == 0;
    }


	public T getFirst()
	{
		if(isEmpty())
			return null;
		return head.darElemento();
	}

	public T getLast()
	{
		if(isEmpty())
			return null;
		return tail.darElemento();
	}

    /**
     * Se da el tamaño de la cola.
     *
     * @return tamano
     */
    public int size() {
        return size;
    }
   

    
    public Comparable<Comparendo>[] copiarComparendos() {

        Node actual = head;
        int i = 0;
        Comparable[] array = new Comparable[size];

        while (actual.darSiguiente() != null) 
        {

            array[i] = (Comparable) actual.darElemento();
            actual = actual.darSiguiente();
            
            i++;
        }

        return array;
    }
}
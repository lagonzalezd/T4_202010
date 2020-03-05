package model.data_structures;


public class Node<T> {

    //Attributes
	
    private Node<T> siguiente;
    
    private T elemento;

    //Constructor
	public Node(T pElemento, Node<T> pSiguiente)
	{
		elemento = pElemento;
		siguiente = pSiguiente;
	}
	

    //Methods

    /**
     * Metodo que retorna el siguiente nodo.
     * @return Siguiente nodo.
     */
    public Node<T> darSiguiente() {
        return siguiente;
    }

    /**
     * Da el elemento que contiene el nodo.
     * @return Elemento que contiene el nodo.
     */
    public T darElemento() {
        return elemento;
    }

    /**
     * Cambia el siguiente atado a este nodo.
     * @param pNodo
     */
    public void cambiarSiguiente(Node<T> pNodo) {
        siguiente = pNodo;
    }

}
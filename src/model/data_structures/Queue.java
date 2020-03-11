package model.data_structures;

public class Queue<T extends Comparable<T>> {

    private int longitud;
    private Node<T> primero;
    private Node<T> ultimo;

    public Queue() {
        longitud = 0;
        primero = null;
        ultimo = null;
    }

    public boolean estaVacia() {
        return longitud == 0;
    }

    public int darLongitud() {
        return longitud;
    }

    public void enQueue(T pElemento) {

        Node nuevo = new Node(pElemento);
        if (estaVacia()) {
            primero = nuevo;
            ultimo = nuevo;

        } else {
            ultimo.cambiarSiguiente(nuevo);
            ultimo = nuevo;

        }
        longitud++;

    }

    public T deQueue() {

        if (estaVacia()) {
            return null;

        } else {
            T elemento = primero.darElemento();
            primero = primero.darSiguiente();
            longitud--;

            return elemento;
        }

    }

    public T peek() {

        if (estaVacia()) {
            return null;

        } else {
            return primero.darElemento();

        }
    }

    public Node darPrimero()
    {
        return primero;
    }

    public Node darUltimo()
    {
        return ultimo;
    }


}
package model.data_structures;
public class Node<T extends Comparable<T>> {

    //Atributos
    private T elemento;
    private Node siguiente;

    //Constructor
    public Node(T pElemento) {
        elemento = pElemento;
        siguiente = null;
    }

    //Metodos
    public Node darSiguiente() {
        return siguiente;
    }

    public T darElemento() {
        return elemento;
    }

    public void cambiarElemento(T pElemento) {
        elemento = pElemento;
    }

    public void cambiarSiguiente(Node<T> pNodo) {
        siguiente = pNodo;
    }

}
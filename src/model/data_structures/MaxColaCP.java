package model.data_structures;

public class MaxColaCP<T extends Comparable<T>> {

    private int numElementos;
    private Node<T> primero;
    private Node<T> ultimo;


    // Primero = máximo.
    public MaxColaCP() {
        numElementos = 0;
        primero = null;
        ultimo = null;
    }

    public int darNumElementos() {
        return numElementos;
    }

    public void agregar(T pElemento) {
        Node nuevo = new Node(pElemento);

        if (esVacia()) {
            primero = nuevo;
            ultimo = nuevo;
        } else {
            ultimo.cambiarSiguiente(nuevo);
            ultimo = nuevo;
        }
        numElementos++;

    }

    public T sacarMax() {

        if (esVacia()) {
            return null;

        } else {
            T elemento = primero.darElemento();
            primero = primero.darSiguiente();
            numElementos--;

            return elemento;
        }

    }

    public T darMax() {

        if (esVacia()) {
            return null;

        } else {
            return primero.darElemento();

        }
    }


    public boolean esVacia() {
        return primero == null;
    }

}
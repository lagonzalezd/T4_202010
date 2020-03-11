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

    public boolean esVacia() {
        return numElementos == 0;
    }

    public int darNumElementos() {
        return numElementos;
    }

    public void enQueue(T pElemento) {

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

    public void agregar(T pElemento)
    {
        Node node = new Node(pElemento);
        if(esVacia())
        {
            primero = node;
            ultimo = node;
        }
        else
        {
            Node actual = primero;

            while(actual!=null)
            {

            }
        }
    }


}
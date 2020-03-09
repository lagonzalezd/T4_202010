package model.data_structures;

public class MaxHeapCP<T extends Comparable<T>> {

    private int numElementos;
    private Node primero;
    private Node ultimo;


    public int darNumElementos() {
        return numElementos;
    }

    public void agregar(Comparable pElemento) {

    }

    public Comparable sacarMax() {
        return null;
    }

    public Comparable darMax() {
        return null;
    }

    public boolean esVacia() {
        return primero == null;
    }

}

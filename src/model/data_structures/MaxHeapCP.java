package model.data_structures;

import model.logic.Comparendo;

public class MaxHeapCP<T extends Comparable<T>> {

    private T[] MaxHeap;
    private int numElementos;


    public MaxHeapCP(int pTamano) {
        MaxHeap = (T[]) new Object[pTamano + 1];
        numElementos = 0;

    }

    public T darMax() {

        if (esVacia()) {
            return null;
        } else {

            return MaxHeap[1];
        }
    }


    public int darNumElementos() {
        return numElementos;
    }

    public void agregar(T pElemento) {

    }

    public T sacarMax() {
        return null;
    }


    public boolean esVacia() {
        return numElementos == 0;
    }


}

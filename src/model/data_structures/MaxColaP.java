package model.data_structures;

public class MaxColaP<T extends Comparable<T>> implements IMaxColaP{

    private int numElementos;

    public MaxColaP() {
        numElementos = 0;

    }




    @Override
    public int darNumElementos() {
        return numElementos;
    }

    @Override
    public void agregar(Object pElemento) {

    }

    @Override
    public Object sacarMax() {
        return null;
    }

    @Override
    public Object darMax() {
        return null;
    }

    @Override
    public boolean esVacia() {
        return false;
    }
}

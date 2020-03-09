package model.data_structures;

public interface IMAX <T extends Comparable<T>> {

    int darNumElementos();

    void agregar(T pElemento);

    T sacarMax();

    T darMax();

    boolean esVacia();

}

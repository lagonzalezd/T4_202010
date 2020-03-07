package model.data_structures;

public interface IMaxColaP<T> {


    int darNumElementos();

    void agregar(T pElemento);

    T sacarMax();

    T darMax();

    boolean esVacia();

}

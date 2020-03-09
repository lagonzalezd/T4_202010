package controller;

import java.io.FileNotFoundException;
import java.util.Scanner;

import model.data_structures.Queue;
import model.logic.Comparendo;
import model.logic.Modelo;
import view.View;

public class Controller {

    /* Instancia del Modelo*/
    private Modelo modelo;

    /* Instancia de la Vista*/
    private View view;


    public Controller() {
        view = new View();
        modelo = new Modelo();
    }

    public void run() {
        Scanner lector = new Scanner(System.in);
        boolean fin = false;

        Queue<Comparendo> datos;

        while (!fin) {
            view.printMenu();

            int option = lector.nextInt();

            switch (option) {
                case 1:


                    view.printMessage("Ingrese la cantidad de datos a cargar en la cola de prioridad");

                    modelo = new Modelo();

                    int optionC = lector.nextInt();

                    modelo.cargarDatos();

                    long start = System.currentTimeMillis();
                    datos = modelo.cargarDatos();
                    long end = System.currentTimeMillis();

                    view.printMessage("Tiempo de carga (seg): " + (end-start)/1000.0 + "\n");

                    view.printMessage("Numero de datos cargados: " + datos.darLongitud());

                    break;

                case 2:


                    break;

                case 3:

                case 4:

                    break;

                case 5:

                    lector.close();
                    fin = true;
                    break;

                default:
                    view.printMessage("--------- Opcion Invalida!! ------------------");
                    break;


            }
        }

    }
}
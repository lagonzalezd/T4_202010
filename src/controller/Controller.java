package controller;

import java.util.ArrayList;
import java.util.Scanner;

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

        ArrayList<Comparendo> datos;

        while (!fin) {
            view.printMenu();

            int option = lector.nextInt();

            switch (option) {
                case 1:


                    datos = modelo.cargarDatos();


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
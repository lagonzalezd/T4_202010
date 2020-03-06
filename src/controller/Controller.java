package controller;

import java.io.FileNotFoundException;
import java.util.Scanner;

import model.data_structures.MaxPQ;
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

        MaxPQ<Comparendo> datos = new MaxPQ<Comparendo>();
        
        while (!fin) {
            view.printMenu();

            int option = lector.nextInt();

            switch (option) {
                case 1:

                    modelo = new Modelo();
                    modelo.cargarDatos();

                    datos = modelo.darDatosPQ();
                    view.printMessage("Numero de datos cargados: " + datos.size());
                    
                    for(Comparendo c: datos)
                    {
                    	view.printMessage(c.getObjectId() +"");
                    }
                    break;

                case 2:
                	
                	
                	
                    break;

                case 3:

                    break;

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

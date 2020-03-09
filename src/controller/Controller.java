package controller;

import java.util.Scanner;

import model.data_structures.MaxColaCP;
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

        MaxColaCP<Comparendo> datos = new MaxColaCP<Comparendo>();
        
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
                    datos = modelo.cargarEnColaDePrioridad(optionC);
                    long end = System.currentTimeMillis();

                    view.printMessage("Tiempo de carga (seg): " + (end-start)/1000.0 + "\n");

                    view.printMessage("Numero de datos cargados: " + datos.size());
                    
                    break;

                case 2:
                        	
                	view.printMessage("Ingrese el numero de comparendos que desea buscar");
                	
                	int N = lector.nextInt();
                	
                	view.printMessage("Ingrese una lista con el tipo de vehiculo que desea buscar separado por una coma (',') sin poner espacios \n");
                	
                	String lista = lector.next();
                	String[] listaS = lista.split(",");
                	
                	
                    long inicio = System.currentTimeMillis();
                    MaxColaCP<Comparendo> all = modelo.nComparendosMasNorteCola(N, listaS);
                    long end2 = System.currentTimeMillis();
                    
                    view.printMessage("Tiempo del requerimiento (seg): " + (end2-inicio)/1000.0 + "\n");
                	
                	for (Comparendo c: all)
                	{
                		view.printMessage("Object ID: " + c.getObjectId() + ", Clase del vehiculo: " + c.getClase_vehi() + ", latitud: " + c.getLatitud() +", longitud: " + c.getLongitud() + "\n");
                	}                	
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

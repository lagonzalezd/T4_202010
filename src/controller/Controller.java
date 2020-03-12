package controller;

import java.util.Scanner;
import java.util.Stack;

import model.data_structures.MaxColaCP;
import model.data_structures.MaxHeapCP;
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

		MaxHeapCP<Comparendo> datos = new MaxHeapCP<Comparendo>();

		Stack<Comparendo> todosLosDatos = new Stack<Comparendo>();
		
		while (!fin) {
			view.printMenu();

			int option = lector.nextInt();

			switch (option) {
			case 1:

				long i = System.currentTimeMillis();
				modelo.cargarDatos();
				long f = System.currentTimeMillis();
				todosLosDatos = modelo.darDatos();
				
				view.printDatosCargadosSolo(todosLosDatos.size() + "");
				view.tiempoDeCarga((f-i)/1000.0 + "");
				
				
				break;
			case 2:
				
				view.printCargar01();

				int optionC = lector.nextInt();

				long starth = System.currentTimeMillis();
				datos = modelo.cargarEnHeapColaDePrioridad(optionC);
				long endh = System.currentTimeMillis();
				
				long startc = System.currentTimeMillis();
				datos = modelo.cargarEnHeapColaDePrioridad(optionC); //TODO: Cambiar por cola
				long endc = System.currentTimeMillis();

				view.printCargar02((endh-starth)/1000.0 + "", "heap");
				
				view.printCargar02((endc-startc)/1000.0 + "", "cola");
				
				view.printDatosCargados(datos.size() + "", "heap");
				
				view.printDatosCargados(datos.size() + "", "cola");

				break;	

			case 3:
				view.printReq1part1();

				int N2 = lector.nextInt();

				view.printReq1part2();

				String lista2 = lector.next();
				String[] listaS2 = lista2.split(",");

				long inicio2 = System.currentTimeMillis();
				MaxColaCP<Comparendo> all2 = modelo.nComparendosMasNorteConCola(N2, listaS2);
				long end22 = System.currentTimeMillis();

				view.printMessage("Tiempo del requerimiento 1 (seg): " + (end22-inicio2)/1000.0 + "\n");

				for (Comparendo c: all2)
				{
					view.printMessage("Object ID: " + c.getObjectId() + ", Clase del vehiculo: " + c.getClase_vehi() + ", latitud: " + c.getLatitud() +", longitud: " + c.getLongitud() + "\n");
				}                	
				break;
				

			case 4:
				
				view.printReq1part1();

				int N = lector.nextInt();

				view.printReq1part2();

				String lista = lector.next();
				String[] listaS = lista.split(",");


				long inicio = System.currentTimeMillis();
				MaxHeapCP<Comparendo> all = modelo.nComparendosMasNorteConHeap(N, listaS);
				long end2 = System.currentTimeMillis();

				view.printMessage("Tiempo del requerimiento 1 (seg): " + (end2-inicio)/1000.0 + "\n");

				for (Comparendo c: all)
				{
					view.printMessage("Object ID: " + c.getObjectId() + ", Clase del vehiculo: " + c.getClase_vehi() + ", latitud: " + c.getLatitud() +", longitud: " + c.getLongitud() + "\n");
				}                	
				break;


			case 5:
				
				fin = true;
				break;
				
			default:
				view.printMessage("--------- Opcion Invalida!! ------------------");
				break;
			}
		}

	}
}

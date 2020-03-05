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
        Queue datos = null;

        while (!fin) {
            view.printMenu();

            int option = lector.nextInt();

            switch (option) {
                case 1:

                    modelo = new Modelo();

                    try {
                        modelo.cargarDatos();

                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                    datos = modelo.darDatosC();

                    Comparendo primeroCargado = (Comparendo) datos.getFirst();
                    Comparendo ultimoCargado = (Comparendo) datos.getLast();

                    view.printMessage("Fueron cargados " + datos.size() + " comparendos.");

                    view.printMessage("Primer comparendo cargado: ObjectId=" + primeroCargado.getObjectId() + ", fecha=" + primeroCargado.getFecha_hora() +
                            ", clase de vehiculo=" + primeroCargado.getClase_vehi() + ", tipo de servicio=" + primeroCargado.getTipo_servi()
                            + ", infraccion=" + primeroCargado.getInfraccion() + ", descripcion de infraccion=" + primeroCargado.getDes_infrac() + ", localidad=" + primeroCargado.getLocalidad()
                            + ", coordenadas= " + "Longitud= " + primeroCargado.getLongitud() + ", Latitud= " + primeroCargado.getLatitud() + "]");

                    view.printMessage("Ultimo comparendo cargado: ObjectId=" + ultimoCargado.getObjectId() + ", fecha=" + ultimoCargado.getFecha_hora() +
                            ", clase de vehiculo=" + ultimoCargado.getClase_vehi() + ", tipo de servicio=" + ultimoCargado.getTipo_servi()
                            + ", infraccion=" + ultimoCargado.getInfraccion() + ", descripcion de infraccion=" + ultimoCargado.getDes_infrac() + ", localidad=" + ultimoCargado.getLocalidad()
                            + ", coordenadas= " + "Longitud= " + ultimoCargado.getLongitud() + ", Latitud= " + ultimoCargado.getLatitud() + "]");

                    break;

                case 2:

                    Comparable<Comparendo>[] data = datos.copiarComparendos();

                    view.printMessage("Numero de comparendos en el arreglo: " + data.length);
                    modelo.ShellSort(data);

                    view.printMessage("Primeros diez comparendos: ");

                    int i = 0;
                    while (i < 10) {
                        Comparendo actual = (Comparendo) data[i];
                        view.printMessage("Comparendo: " + actual.toString() + "\n");
                        i++;
                    }
                    view.printMessage("Ultimos diez comparendos: \n");
                    i = 10;
                    while (i > 0) {
                        Comparendo c = (Comparendo) data[(data.length - 1) - i];
                        view.printMessage("Comparendo: " + c.toString() + "\n");
                        i--;
                    }

                    break;

                case 3:

                    Comparable<Comparendo>[] data2 = datos.copiarComparendos();
                    view.printMessage("Numero de comparendos = " + data2.length + "\n");


                    modelo.mergeSort(data2, 0, (data2.length) / 2, data2.length - 1);


                    view.printMessage("Primeros diez comparendos: \n");
                    int k = 0;
                    while (k < 10) {
                        Comparendo actual = (Comparendo) data2[k];
                        view.printMessage("Comparendo: " + actual.toString() + "\n");
                        k++;
                    }
                    view.printMessage("Ultimos diez comparendos: \n");
                    k = 10;
                    while (k > 0) {
                        Comparendo c = (Comparendo) data2[(data2.length - 1) - k];
                        view.printMessage("Comparendo: " + c.toString() + "\n");
                        k--;
                    }

                    break;

                case 4:

				Comparable<Comparendo>[] data3= datos.copiarComparendos();

				modelo.quickSort(data3, 0, data3.length-1);

				view.printMessage("Primeros diez comparendos: \n");
				i=0;
				while(i<10)
				{
					Comparendo c=(Comparendo) data3[i];
					view.printMessage("Comparendo: "+c.toString() +"\n");
					i++;
				}
				view.printMessage("Ultimos diez comparendos: \n");
				i=10;
				while(i>0)
				{
					Comparendo c=(Comparendo) data3[(data3.length-1)-i];
					view.printMessage("Comparendo: "+c.toString() +"\n");
					i--;
				}

                    break;

                case 5:

				lector.close();
				fin = true;
                    break;

                default:
                    view.printMessage("Opcion Invalida");
                    break;


            }
        }

    }
}

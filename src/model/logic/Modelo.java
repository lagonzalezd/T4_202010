package model.logic;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;

import com.google.gson.JsonParser;
import com.google.gson.stream.JsonReader;

import model.data_structures.Queue;

/**
 * Definicion del modelo del mundo
 */
public class Modelo {

	private Queue<Comparendo> datosC;

	public static String PATH = "./data/comparendos_dei_2018_small.geojson";

	public void cargarDatos() {

		datosC = new Queue<Comparendo>();

		JsonReader reader;
		try {
			reader = new JsonReader(new FileReader(PATH));
			JsonElement elem = JsonParser.parseReader(reader);
			JsonArray e2 = elem.getAsJsonObject().get("features").getAsJsonArray();


			SimpleDateFormat parser=new SimpleDateFormat("yyyy/MM/dd");

			for(JsonElement e: e2) {
				int OBJECTID = e.getAsJsonObject().get("properties").getAsJsonObject().get("OBJECTID").getAsInt();

				String s = e.getAsJsonObject().get("properties").getAsJsonObject().get("FECHA_HORA").getAsString();	
				Date FECHA_HORA = parser.parse(s); 

				String MEDIO_DETE = e.getAsJsonObject().get("properties").getAsJsonObject().get("MEDIO_DETE").getAsString();
				String CLASE_VEHI = e.getAsJsonObject().get("properties").getAsJsonObject().get("CLASE_VEHI").getAsString();
				String TIPO_SERVI = e.getAsJsonObject().get("properties").getAsJsonObject().get("TIPO_SERVI").getAsString();
				String INFRACCION = e.getAsJsonObject().get("properties").getAsJsonObject().get("INFRACCION").getAsString();
				String DES_INFRAC = e.getAsJsonObject().get("properties").getAsJsonObject().get("DES_INFRAC").getAsString();	
				String LOCALIDAD = e.getAsJsonObject().get("properties").getAsJsonObject().get("LOCALIDAD").getAsString();

				double longitud = e.getAsJsonObject().get("geometry").getAsJsonObject().get("coordinates").getAsJsonArray()
						.get(0).getAsDouble();

				double latitud = e.getAsJsonObject().get("geometry").getAsJsonObject().get("coordinates").getAsJsonArray()
						.get(1).getAsDouble();

				Comparendo c = new Comparendo(OBJECTID, FECHA_HORA, DES_INFRAC, MEDIO_DETE, CLASE_VEHI, TIPO_SERVI, INFRACCION, LOCALIDAD, longitud, latitud);
				datosC.enQueue(c);
			}

		}
		catch (FileNotFoundException | ParseException e) 
		{
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}


	
	public Queue<Comparendo> darDatosC()
	{
		return datosC;
	}
	
    public void ShellSort(Comparable datos[]) {

        Long inicio = System.currentTimeMillis();

        int tamano = datos.length;

        for (int gap = tamano / 2; gap > 0; gap /= 2) {

            for (int i = gap; i < tamano; i++) {

                Comparable temp = datos[i];

                for (int j = i; (j >= gap) && (datos[j - gap].compareTo(temp) > 0); j -= gap) {
                    datos[j] = datos[j - gap];

                    datos[j] = temp;
                }

            }

        }

        Long fin = System.currentTimeMillis();

        double seconds = ((inicio - fin) / 1000);

        System.out.println(seconds + " segundos duró ShellSort.");


    }


    public void mergeSort(Comparable datos[], int lo, int mid, int hi) {

        Long inicio = System.currentTimeMillis();

        int i = lo;
        int j = mid + 1;

        Comparable[] array = new Comparable[datos.length];

        for (int k = lo; k <= hi; k++) {

            array[k] = datos[k];
        }
        for (int k = lo; k <= hi; k++) {
            if (i > mid) {
                datos[k] = array[j++];
            } else if (j > hi) {
                datos[k] = array[i++];

            } else if ((array[j].compareTo(array[i])) < 0) {
                datos[k] = array[j++];
            } else {
                datos[k] = array[i++];
            }
        }

        Long fin = System.currentTimeMillis();

        double seconds = ((inicio - fin) / 1000);

        System.out.println(seconds + " segundos duró Mergesort.");


    }

    public int partition(Comparable datos[], int lo, int hi) {

        int x = datos.length;
        Comparable pivote = datos[x];
        int i = (lo - 1);

        for (int j = lo; j < hi; j++) {
            if (datos[j].compareTo(pivote) <= 0) {
                i++;

                Comparable temp = datos[i];
                datos[i] = datos[j];
                datos[j] = temp;

            }
        }
        Comparable temp = datos[i + 1];
        datos[i + 1] = datos[hi];
        datos[hi] = temp;

        return i + 1;

    }

    public void quickSort(Comparable datos[], int lo, int hi) {

        Long inicio = System.currentTimeMillis();

        if (lo < hi) {
            int pivote = partition(datos, lo, hi);

            quickSort(datos, lo, pivote - 1);
            quickSort(datos, pivote + 1, hi);

        }

        Long fin = System.currentTimeMillis();
        double seconds = ((fin - inicio) / 1000);
        System.out.println(seconds + " segundos, duró QuickSort.");

    }


}
package model.logic;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.Stack;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;

import com.google.gson.JsonParser;
import com.google.gson.stream.JsonReader;

import model.data_structures.MaxColaCP;
import model.data_structures.MaxHeapCP;


public class Modelo {

	private Stack<Comparendo> datos;

	private MaxHeapCP<Comparendo> datosCP;
	
	private MaxColaCP<Comparendo> datosCCP;

	public static String PATH = "./data/Comparendos_DEI_2018_Bogotá_D.C_small.geojson";
	
	/*
	 * Datos Grandes:
	 * public static String PATH = "./data/Comparendos_DEI_2018_Bogotá_D.C.geojson";
	 */
	
	

	public void cargarDatos() {

		datos = new Stack<Comparendo>();

		JsonReader reader;
		try {
			reader = new JsonReader(new FileReader(PATH));
			JsonElement elem = JsonParser.parseReader(reader);
			JsonArray e2 = elem.getAsJsonObject().get("features").getAsJsonArray();

			SimpleDateFormat parser=new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSXXX");

			for(JsonElement e: e2) {
				int OBJECTID = e.getAsJsonObject().get("properties").getAsJsonObject().get("OBJECTID").getAsInt();

				String s = e.getAsJsonObject().get("properties").getAsJsonObject().get("FECHA_HORA").getAsString();	
				Date FECHA_HORA = parser.parse(s); 

				String MEDIO_DETE = e.getAsJsonObject().get("properties").getAsJsonObject().get("MEDIO_DETECCION").getAsString();
				String CLASE_VEHI = e.getAsJsonObject().get("properties").getAsJsonObject().get("CLASE_VEHICULO").getAsString();
				String TIPO_SERVI = e.getAsJsonObject().get("properties").getAsJsonObject().get("TIPO_SERVICIO").getAsString();
				String INFRACCION = e.getAsJsonObject().get("properties").getAsJsonObject().get("INFRACCION").getAsString();
				String DES_INFRAC = e.getAsJsonObject().get("properties").getAsJsonObject().get("DES_INFRACCION").getAsString();	
				String LOCALIDAD = e.getAsJsonObject().get("properties").getAsJsonObject().get("LOCALIDAD").getAsString();
				String MUNICIPIO = e.getAsJsonObject().get("properties").getAsJsonObject().get("MUNICIPIO").getAsString();

				double longitud = e.getAsJsonObject().get("geometry").getAsJsonObject().get("coordinates").getAsJsonArray()
						.get(0).getAsDouble();

				double latitud = e.getAsJsonObject().get("geometry").getAsJsonObject().get("coordinates").getAsJsonArray()
						.get(1).getAsDouble();

				Comparendo c = new Comparendo(OBJECTID, FECHA_HORA, DES_INFRAC, MEDIO_DETE, CLASE_VEHI, TIPO_SERVI, INFRACCION, LOCALIDAD, MUNICIPIO, longitud, latitud);
				datos.push(c);
			}

		}
		catch (FileNotFoundException | ParseException e) 
		{
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}

	public MaxHeapCP<Comparendo> cargarEnHeapColaDePrioridad( int numDatos )
	{
		datosCP = new MaxHeapCP<Comparendo>();

		Iterator<Comparendo> it = datos.iterator();

		int i = 0;
		while(i < numDatos && it.hasNext())
		{
			datosCP.insert(it.next());
			i++;
		}

		return datosCP;
	}
	
	public MaxColaCP<Comparendo> cargarEnColaColaDePrioridad( int numDatos )
	{
		datosCCP = new MaxColaCP<Comparendo>();

		Iterator<Comparendo> it = datos.iterator();

		int i = 0;
		while(i < numDatos && it.hasNext())
		{
			datosCCP.enqueue(it.next());
			i++;
		}

		return datosCCP;
	}



	public Stack<Comparendo> darDatos()
	{
		return datos;
	}
	
	
	/*
	 * Requerimiento 1. -Metodo que devuelve los n comparendos que estan mas al norte en una cola de prioridad implementada con cola.
	 */
	public MaxColaCP<Comparendo> nComparendosMasNorteConCola(int N, String[] lista)
	{

		MaxColaCP<Comparendo> aRetornar = new MaxColaCP<Comparendo>();
		
		int i = 0;
		while(i<N)
		{
			Comparendo mayor = darMaxCola();
			Comparendo actual = datosCCP.dequeue();
			if(actual == mayor)
			{
				for(String l: lista)
				{
					if(l.equalsIgnoreCase(actual.getClase_vehi()))
					{
						aRetornar.enqueue(actual);
					}
				}
			}
			i++;
		}
		
		return aRetornar;

	}



	/*
	 * Requerimiento 2. -Metodo que devuelve los n comparendos que estan mas al norte implementado por heap.
	 */
	public MaxHeapCP<Comparendo> nComparendosMasNorteConHeap(int N, String[] lista)
	{

		MaxHeapCP<Comparendo> aRetornar = new MaxHeapCP<Comparendo>();

		Iterator<Comparendo> data = datosCP.iterator();

		boolean termino = false;

		for(int i = 0; i< datosCP.size() && !termino; i++){

			Comparendo actual = data.next();

			boolean es = false;
			
			for(String v: lista)
			{
				if(v.equalsIgnoreCase(actual.getClase_vehi()))
				{
					es = true;
				}
			}

			if(es) aRetornar.insert(actual);
			
			if(aRetornar.size() == N) termino = true;

		}

		return aRetornar;

	}
	
	public Comparendo darMaxCola(){
		
		Comparendo mayor = null;
		Comparendo actual = null;
		Comparendo comp = null;
		
		Iterator<Comparendo> it = datosCCP.iterator();
		
		while(it.hasNext())
		{
			actual = it.next();
			comp = it.next();
			if(actual.compareTo(comp) > 0)
			{
				mayor = actual;
			}
			else
			{
				mayor = comp;
			}
		}
		
		return mayor;
	}

	










}
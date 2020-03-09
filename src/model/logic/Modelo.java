package model.logic;

import java.io.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;

import com.google.gson.JsonParser;
import com.google.gson.stream.JsonReader;

import model.data_structures.ArregloDinamico;
import model.data_structures.MaxColaCP;


public class Modelo {

<<<<<<< HEAD
    private MaxPQ<Comparendo> datosPQ;

    public static String PATH = "./data/Comparendos_DEI_2018_Bogotá_D.C.geojson";

    public void cargarDatos() {

        datosPQ = new MaxPQ<Comparendo>();

        JsonReader reader;
        try {
            reader = new JsonReader(new FileReader(PATH));
            JsonElement elem = JsonParser.parseReader(reader);
            JsonArray e2 = elem.getAsJsonObject().get("features").getAsJsonArray();

            DateFormat parse1 = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSXXX");
            SimpleDateFormat parser = new SimpleDateFormat("yyyy/MM/dd");

            for (JsonElement e : e2) {
                int OBJECTID = e.getAsJsonObject().get("properties").getAsJsonObject().get("OBJECTID").getAsInt();

                String s = e.getAsJsonObject().get("properties").getAsJsonObject().get("FECHA_HORA").getAsString();
                Date fecha = parse1.parse(s);
                String FECHA_HORA = parser.format(fecha);


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
                datosPQ.insert(c);
            }

        } catch (FileNotFoundException | ParseException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
=======
    private ArregloDinamico<Comparendo> datos;

    private MaxColaCP<Comparendo> datosCP;

    public static String PATH = "./data/Comparendos_DEI_2018_Bogotá_D.C.geojson";

    public void cargarDatos() {

        datos = new ArregloDinamico<Comparendo>();

        JsonReader reader;
        try {
            reader = new JsonReader(new FileReader(PATH));
            JsonElement elem = JsonParser.parseReader(reader);
            JsonArray e2 = elem.getAsJsonObject().get("features").getAsJsonArray();

			SimpleDateFormat parser = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSXXX");

            for (JsonElement e : e2) {
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
                datos.add(c);
                ;
            }

        } catch (FileNotFoundException | ParseException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }

    public MaxColaCP<Comparendo> cargarEnColaDePrioridad(int numDatos) {
        datosCP = new MaxColaCP<Comparendo>();

        Iterator<Comparendo> it = datos.iterator();

        int i = 0;
        while (i < numDatos && it.hasNext()) {
            datosCP.insert(it.next());
            i++;
        }

        return datosCP;

    }

    public MaxColaCP<Comparendo> copiarDatos() {
        MaxColaCP<Comparendo> copia = new MaxColaCP<Comparendo>();

        copia = datosCP;

        return copia;
    }


    //Requerimiento 1.
    public MaxColaCP<Comparendo> nComparendosMasNorteCola(int N, String[] lista) {

        MaxColaCP<Comparendo> data = copiarDatos();

        MaxColaCP<Comparendo> aRetornar = new MaxColaCP<Comparendo>();

        boolean termino = false;

        for (int i = 0; i < data.size() && !termino; i++) {

            Comparendo actual = data.delMax();

            boolean es = false;
            for (String v : lista) {
                if (v.equalsIgnoreCase(actual.getClase_vehi())) {
                    es = true;
                }
            }

            if (es) aRetornar.insert(actual);

            if (aRetornar.size() == N) termino = true;

        }

        return aRetornar;
>>>>>>> master

    }

<<<<<<< HEAD
    public MaxPQ<Comparendo> darDatosPQ() {
        return datosPQ;
    }
=======
>>>>>>> master

}
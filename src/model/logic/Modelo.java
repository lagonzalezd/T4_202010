package model.logic;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;

import com.google.gson.JsonParser;
import com.google.gson.stream.JsonReader;
import model.data_structures.MaxColaCP;


public class Modelo {

    private ArrayList<Comparendo> datos;
    private MaxColaCP<Comparendo> colaCP;


    public static String PATH = "./data/Comparendos_DEI_2018_Bogotá_D.C.geojson";

    public ArrayList cargarDatos() {

        datos = new ArrayList<>();

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

            }

        } catch (FileNotFoundException | ParseException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        return datos;
    }


    public void copiarAmaxCola(int N) {

        for (int i = (int) Math.random(); i < N; i = (int) (i + Math.random())) {
            colaCP.agregar(datos.get(i));
        }

    }

    public MaxColaCP<Comparendo> nComparendosMasNorteCola(int N, String[] lista) {


        MaxColaCP<Comparendo> aRetornar = new MaxColaCP<>();

        boolean termino = false;

        for (int i = 0; i < colaCP.darNumElementos() && !termino; i++) {

            Comparendo actual = colaCP.sacarMax();

            boolean es = false;
            for (String v : lista) {
                if (v.equalsIgnoreCase(actual.getClase_vehi())) {
                    es = true;
                }
            }

            if (es) aRetornar.agregar(actual);

            if (aRetornar.darNumElementos() == N) termino = true;

        }

        return aRetornar;

    }

}
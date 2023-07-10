package com.example.evfrecuentepractica.Modelos;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class Contenedor {
    private String nombres;
    private String portada;
    private String id;
    //private String abreviacion;
    public Contenedor(JSONObject a) throws JSONException {
        nombres = a.getString("name").toString() ;
        portada = a.getString("portada").toString() ;
        id = a.getString("journal_id").toString() ;
        //abreviacion = a.getString("abbreviation").toString() ;
    }
    public static ArrayList<Contenedor> JsonObjectsBuild(JSONArray datos) throws JSONException {
        ArrayList<Contenedor> contenido = new ArrayList<>();
        for (int i = 0; i < datos.length() && i<20; i++) {
            contenido.add(new Contenedor(datos.getJSONObject(i)));
        }
        return contenido;
    }
    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getPortada() {
        return portada;
    }

    public void setPortada(String portada) {
        this.portada = portada;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    //public String getAbreviacion() {
    //    return abreviacion;
    //}

    //public void setAbreviacion(String abreviacion) {
    //    this.abreviacion = abreviacion;
    //}


}


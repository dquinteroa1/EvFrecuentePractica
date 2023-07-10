package com.example.evfrecuentepractica.Modelos;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class Revista {
    private String nombres;
    private String portada;
    private String doi;
    private String publicacion;
    private String volumen;
    private String numero;
    public Revista (JSONObject a) throws JSONException {
        nombres = a.getString("title").toString() ;
        portada = a.getString("cover").toString() ;
        publicacion = a.getString("date_published").toString() ;
        doi = a.getString("doi").toString() ;
        volumen = a.getString("volume").toString() ;
        numero = a.getString("number").toString() ;

    }
    public static ArrayList<Revista> JsonObjectsBuild(JSONArray datos) throws JSONException {
        ArrayList<Revista> rev = new ArrayList<>();
        for (int i = 0; i < datos.length() && i < 20; i++) {
            rev.add(new Revista(datos.getJSONObject(i)));
        }
        return rev;
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

    public String getDoi() {
        return doi;
    }

    public void setDoi(String doi) {
        this.doi = doi;
    }

    public String getPublicacion() {
        return publicacion;
    }

    public void setPublicacion(String publicacion) {
        this.publicacion = publicacion;
    }

    public String getVolumen() {
        return volumen;
    }

    public void setVolumen(String volumen) {
        this.volumen = volumen;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }
}


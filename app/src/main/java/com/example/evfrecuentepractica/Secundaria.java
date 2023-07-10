package com.example.evfrecuentepractica;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import com.example.evfrecuentepractica.Adaptadores.AdaptadorContenedor;
import com.example.evfrecuentepractica.Adaptadores.AdaptadorRevista;
import com.example.evfrecuentepractica.Modelos.Contenedor;
import com.example.evfrecuentepractica.Modelos.Revista;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import WebService.WebService;

import WebService.Asynchtask;

public class Secundaria extends AppCompatActivity implements Asynchtask {

    ListView lstOpciones;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_secundaria);

        Bundle b  = this.getIntent().getExtras();

        lstOpciones = (ListView)findViewById(R.id.ListRevista);
        View header = getLayoutInflater().inflate(R.layout.lyheadercontenedor, null);
        lstOpciones.addHeaderView(header);

        Map<String, String> datos = new HashMap<String, String>();
        WebService ws= new WebService("https://revistas.uteq.edu.ec/ws/issues.php?j_id="+b.getString("id"),
                datos, Secundaria.this, Secundaria.this);
        ws.execute("GET");

    }

    @Override
    public void processFinish(String result) throws JSONException {

        JSONArray jsonArray = new JSONArray(result);
        ArrayList<Revista> lstRev = Revista.JsonObjectsBuild(jsonArray);
        AdaptadorRevista adaptadorRev = new AdaptadorRevista(this, lstRev);
        lstOpciones.setAdapter(adaptadorRev);

    }
}
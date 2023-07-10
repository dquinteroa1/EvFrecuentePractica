package com.example.evfrecuentepractica;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.evfrecuentepractica.Adaptadores.AdaptadorContenedor;
import com.example.evfrecuentepractica.Modelos.Contenedor;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import WebService.Asynchtask;
import WebService.WebService;

public class MainActivity extends AppCompatActivity implements Asynchtask {

    ListView lstOpciones;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lstOpciones = (ListView)findViewById(R.id.lstListaUsuario);
        View header = getLayoutInflater().inflate(R.layout.lyheadercontenedor, null);
        lstOpciones.addHeaderView(header);

        Map<String, String> datos = new HashMap<String, String>();
        WebService ws= new WebService("https://revistas.uteq.edu.ec/ws/journals.php",
                datos, MainActivity.this, MainActivity.this);
        ws.execute("GET");
    }

    @Override
    public void processFinish(String result) throws JSONException {


        JSONArray jsonArray = new JSONArray(result);
        ArrayList<Contenedor> lstContenido = Contenedor.JsonObjectsBuild(jsonArray);
        AdaptadorContenedor adaptadorContenido = new AdaptadorContenedor(this, lstContenido);
        lstOpciones.setAdapter(adaptadorContenido);

        lstOpciones.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> a, View v, int position, long id) {
                Intent intent = new Intent(MainActivity.this, Secundaria.class);
                Bundle b = new Bundle();
                b.putString("id", ((Contenedor)a.getItemAtPosition(position)).getId());
                intent.putExtras(b);
                startActivity(intent);
            }
        });


    }


}
package com.example.evfrecuentepractica.Adaptadores;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.evfrecuentepractica.Modelos.Contenedor;
import com.example.evfrecuentepractica.Modelos.Revista;
import com.example.evfrecuentepractica.R;

import java.util.ArrayList;

public  class AdaptadorRevista extends ArrayAdapter<Revista> {
    public AdaptadorRevista(Context context, ArrayList<Revista> datos) {
        super(context, R.layout.lyitemrevista, datos);
    }
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(getContext());
        View item = inflater.inflate(R.layout.lyitemrevista, null);

        TextView lblNombre = (TextView)item.findViewById(R.id.lblNombre);
        lblNombre.setText("Vol. "+getItem(position).getVolumen()+" Núm: "+getItem(position).getNumero()+" "+getItem(position).getNombres());

        TextView lbldoi = (TextView)item.findViewById(R.id.lbdoi);
        lbldoi.setText("Doi: "+getItem(position).getDoi());

        TextView lblpublicacion = (TextView)item.findViewById(R.id.lblpublicacion);
        lblpublicacion.setText("Publicado: "+getItem(position).getPublicacion());

        ImageView imageView = (ImageView)item.findViewById(R.id.imgUsr);
        Glide.with(this.getContext())
                .load(getItem(position).getPortada())
                .into(imageView);


        return(item);


    }
}
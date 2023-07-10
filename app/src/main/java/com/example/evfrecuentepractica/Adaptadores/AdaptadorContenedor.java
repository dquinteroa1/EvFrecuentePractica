package com.example.evfrecuentepractica.Adaptadores;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.evfrecuentepractica.R;

import java.util.ArrayList;

import com.example.evfrecuentepractica.Modelos.Contenedor;

public  class AdaptadorContenedor extends ArrayAdapter<Contenedor> {
    public AdaptadorContenedor(Context context, ArrayList<Contenedor> datos) {
        super(context, R.layout.lyitemcontenedor, datos);
    }
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(getContext());
        View item = inflater.inflate(R.layout.lyitemcontenedor, null);

        TextView lblNombre = (TextView)item.findViewById(R.id.lblNombre);
        lblNombre.setText(getItem(position).getNombres());
        //TextView lblabreviacion = (TextView)item.findViewById(R.id.lblEmail);
        //lblabreviacion.setText(getItem(position).getAbreviacion());
        ImageView imageView = (ImageView)item.findViewById(R.id.imgUsr);
        Glide.with(this.getContext())
                .load(getItem(position).getPortada())
                .into(imageView);


        return(item);


    }
}

package com.example.volleycondao;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class Adaptador extends BaseAdapter {

    private Context context;
    private ArrayList<Persona> listaPersonas;

    // CONSTRUCTOR
    public Adaptador(Context context, ArrayList<Persona> listaPersonas) {
        this.context = context;
        this.listaPersonas = listaPersonas;
    }

    public void setListaPersonas(ArrayList<Persona> listaPersonas) {
        this.listaPersonas = listaPersonas;
    }

    @Override
    public int getCount() {
        return listaPersonas.size(); // número de elementos que contiene la lista
    }

    @Override
    public Object getItem(int position) {
        return listaPersonas.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;  // No necesitamos un código para esta aplicación
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater layoutInflater=LayoutInflater.from(context);
        convertView = layoutInflater.inflate(R.layout.item_persona, null);

        TextView nombre=(TextView)convertView.findViewById(R.id.tvNombre);
        TextView edad=(TextView)convertView.findViewById(R.id.tvEdad);


        nombre.setText(listaPersonas.get(position).getNombre() + " " + listaPersonas.get(position).getApellidos());
        edad.setText(String.valueOf(listaPersonas.get(position).getEdad()));


        return convertView;
    }
}

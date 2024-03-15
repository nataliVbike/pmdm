package com.example.volleycondao;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.android.volley.VolleyError;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private Context context;
    private ArrayList<Persona> listaPersonas;

    private ListView listViewPersonas;
    private Adaptador adaptador;

    private MyObjectDAO mObjectDAO;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        context = this;
        listaPersonas = new ArrayList<>();
        listViewPersonas = findViewById(R.id.listViewPersonas);
        adaptador = new Adaptador(context, listaPersonas); // Creamos el Adaptador para el ListView

    ///Se crea una instancia de MyObjectDAO
        mObjectDAO = new MyObjectDAO(this);
        // Llamada asíncrona para obtener datos de objetos
        mObjectDAO.getObject(new MyObjectDAO.MyObjectListener() {
            @Override
            public void onSuccess(JSONArray jsonLista) {
                // Manejar la respuesta exitosa,
                Log.d("MainActivity", "Response: " + jsonLista.toString());
                // Actualizar la interfaz de usuario con los datos obtenidos

                try {
                    //JSONArray jsonLista = new JSONArray(jsonArray);

                    Log.d("TAMAÑO", String.valueOf(jsonLista.length())); //Compruebo que accedo a los objetos de personas, viendo la cantidad de ellos

                    for (int i = 0; i < jsonLista.length(); i++){

                        String nombre = jsonLista.getJSONObject(i).getString("nombre");
                        String apellidos = jsonLista.getJSONObject(i).getString("apellidos");
                        int edad = Integer.parseInt(jsonLista.getJSONObject(i).getString("edad"));

                        Persona p = new Persona(nombre, apellidos, edad);
                        listaPersonas.add(p);

                    }


                    listViewPersonas.setAdapter(adaptador); // Asigamos el adaptador al ListView

                } catch (JSONException e) {
                    throw new RuntimeException(e);
                }
            }

            @Override
            public void onError(VolleyError error) {
                // Manejar el error
                Log.e("MainActivity", "Error: " + error.toString());
                Toast.makeText(MainActivity.this, "Error al obtener datos", Toast.LENGTH_SHORT).show();
            }
        });



        //listaPersonas = DAO_Personas.getPersonas(context);



    }
}
package com.example.volleycondao;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;

public class MyObjectDAO {

    private static final String SERVER_URL = "https://alvarogonzalezsotillo.github.io/apuntes-clase/personas.json";

    private final Context mContext;
    private final RequestQueue mRequestQueue;

    public MyObjectDAO(Context context) {
        mContext = context.getApplicationContext();
        mRequestQueue = Volley.newRequestQueue(mContext);
    }

    public interface MyObjectListener {
        void onSuccess(JSONArray response);
        void onError(VolleyError error);
    }

    /**
     * realiza una solicitud GET a la URL del servidor utilizando Volley.
     * Se proporciona un MyObjectListener para manejar la respuesta exitosa y los errores.
     * @param listener
     */
    public void getObject(final MyObjectListener listener) {
        JsonArrayRequest request = new JsonArrayRequest(Request.Method.GET, SERVER_URL, null,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        listener.onSuccess(response);
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        listener.onError(error);
                    }
                });

        mRequestQueue.add(request);
    }
}

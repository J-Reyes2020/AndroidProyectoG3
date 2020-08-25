package com.example.proyectofinal;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.proyectofinal.modelo.Cliente;
import com.example.proyectofinal.modelo.Conexion;
import com.example.proyectofinal.modelo.Productos;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

public class ProductosActivity extends AppCompatActivity implements Response.Listener<JSONObject>, Response.ErrorListener{

    Conexion ip = new Conexion();
    RequestQueue request;
    JsonObjectRequest jsonObjectRequest;

    String direccionUrle=null;

    ArrayList<Productos> listaDatos = new ArrayList<>();

    RecyclerView recyclerProducto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_productos);

        request = Volley.newRequestQueue(getApplicationContext());

        recyclerProducto = (RecyclerView)findViewById(R.id.rv_listar_productos);
        recyclerProducto.setLayoutManager(new LinearLayoutManager(this));

    }

    public void onclickCancelarCompra(View view) {
        Intent intent = new Intent(view.getContext(), MainActivity22.class);
        startActivity(intent);
    }

    @Override
    public void onErrorResponse(VolleyError error) {
        System.out.println("error: " + error.toString());

    }

    @Override
    public void onResponse(JSONObject response) {

    }

    public void datos(){
        String url = ip.getIp()+"/listaProductos.php";
        jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url, null, this, this);
        request.add(jsonObjectRequest);
    }

    public void cargarDatos(JSONObject response){
        Productos productos;
        JSONArray json = response.optJSONArray("cliente");
        JSONObject jsonObject = null;
    }
}
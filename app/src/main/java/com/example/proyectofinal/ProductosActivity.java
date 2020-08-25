package com.example.proyectofinal;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

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
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class ProductosActivity extends AppCompatActivity implements Response.Listener<JSONObject>, Response.ErrorListener{

    Conexion ip = new Conexion();
    RequestQueue request;
    JsonObjectRequest jsonObjectRequest;

    String direccionUrle=null;

    ArrayList<Productos> listaProductos = new ArrayList<>();

    RecyclerView recyclerLista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_productos);

        request = Volley.newRequestQueue(getApplicationContext());

        recyclerLista = (RecyclerView)findViewById(R.id.rv_listar_productos);
        recyclerLista.setLayoutManager(new LinearLayoutManager(this));

        datos();

    }

    public void onclickCancelarCompra(View view) {
        Intent intent = new Intent(view.getContext(), MainActivity22.class);
        startActivity(intent);
    }

    @Override
    public void onErrorResponse(VolleyError error) {
        Toast.makeText(this.getApplicationContext(), "NO hay ningun dato", Toast.LENGTH_SHORT).show();
        System.out.println("error: " + error.toString());

    }

    @Override
    public void onResponse(JSONObject response) {
        cargarDatos(response);
    }

    public void datos(){
        String url = ip.getIp()+"/listaProductos.php";
        jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url, null, this, this);
        request.add(jsonObjectRequest);
    }

    public void cargarDatos(JSONObject response) {
        Productos productos;
        JSONArray json = response.optJSONArray("productos");
        JSONObject jsonObject = null;
        try {
            System.out.println("Los registros son: " + json.length());
                for (int i=0;i<json.length();i++) {
                    jsonObject = json.getJSONObject(i);

                    productos = new Productos();
                    productos.setProductoId(jsonObject.optInt("0"));
                    productos.setNombreProducto(jsonObject.optString("1"));
                    productos.setPrecioProducto(jsonObject.optInt("2"));
                    productos.setCantidadProducto(jsonObject.optInt("3"));
                    productos.setTipoProducto(jsonObject.optInt("4"));
                    listaProductos.add(productos);
                    System.out.println(productos.toString());
                }
                AdaptadorProductoRecycler adap = new AdaptadorProductoRecycler(listaProductos);
                recyclerLista.setAdapter(adap);
            }catch (JSONException e){
            e.printStackTrace();
        }
    }
}
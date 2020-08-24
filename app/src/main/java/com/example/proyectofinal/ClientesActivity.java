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

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class ClientesActivity extends AppCompatActivity implements Response.Listener<JSONObject>,Response.ErrorListener{

    Conexion ip = new Conexion();
    RequestQueue request;
    JsonObjectRequest jsonObjectRequest;

    String direccionUrle=null;

    ArrayList<Cliente> listaDatos = new ArrayList<>();

    RecyclerView recyclerLista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clientes);

        request = Volley.newRequestQueue(getApplicationContext());

        recyclerLista = (RecyclerView)findViewById(R.id.rv_cliente_recycler);
        recyclerLista.setLayoutManager(new LinearLayoutManager(this));

        datos();
    }

    @Override
    public void onErrorResponse(VolleyError error) {
        Toast.makeText(this.getApplicationContext(), "No existen registros", Toast.LENGTH_SHORT).show();
        System.out.println("error: " + error.toString());

    }

    @Override
    public void onResponse(JSONObject response) {
        cargarDatos(response);

    }

    public void datos(){
        String url= ip.getIp()+"/listaCliente.php";

        System.out.println("URL: " + url);
        jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url, null, this, this);
        request.add(jsonObjectRequest);
    }


    public void cargarDatos(JSONObject response){
        Cliente cliente;
        JSONArray json = response.optJSONArray("cliente");
        JSONObject jsonObject = null;
        try {
            System.out.println("la cantidad de registro " + json.length());
                for (int i=0;i<json.length();i++){
                jsonObject = json.getJSONObject(i);

                cliente = new Cliente();
                cliente.setClienteId(jsonObject.optInt("cliente_id"));
                cliente.setNombre(jsonObject.optString("nombre"));
                cliente.setApellido(jsonObject.optString("apellido"));
                cliente.setTelefono(jsonObject.optInt("telefono"));
                cliente.setDireccion(jsonObject.optString("direccion"));
                cliente.setCorreoElec(jsonObject.optString("correo_electronico"));
                listaDatos.add(cliente);
                System.out.println(cliente.toString());
            }
            AdaptadorClienteRecycler adaptador = new AdaptadorClienteRecycler(listaDatos);
            recyclerLista.setAdapter(adaptador);
        }catch (JSONException e){
            e.printStackTrace();
        }
    }

    public void onclickModificar(View view) {
        Intent intent = new Intent(view.getContext(), ClientesCrudActivity.class);
        startActivity(intent);
    }

    public void onclikSalirCliente(View view) {
        Intent intent= new Intent(view.getContext(), MainActivity22.class);
        startActivity(intent);
    }


}
package com.example.proyectofinal;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.DownloadManager;
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
import com.example.proyectofinal.modelo.Conexion;
import com.example.proyectofinal.modelo.Factura;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class FacturaActivity extends AppCompatActivity implements Response.Listener<JSONObject>,Response.ErrorListener {

    Conexion ip = new Conexion();
    RequestQueue request;
    JsonObjectRequest JsonObjectRequest;

    String dirrecionURL= null;

    ArrayList<Factura> listaFactura = new ArrayList<>();

    RecyclerView recyclerLista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_factura);

        request = Volley.newRequestQueue(getApplicationContext());

        recyclerLista = (RecyclerView)findViewById(R.id.rv_factura_recycler);
        recyclerLista.setLayoutManager(new LinearLayoutManager(this));

        cargarDatos();
    }


    @Override
    public void onErrorResponse(VolleyError error) {
        Toast.makeText(this.getApplicationContext(),"No Existen Registros "+error, Toast.LENGTH_LONG).show();
        System.out.println("Error "+error);
    }

    @Override
    public void onResponse(JSONObject response) {
        cargarFacturas(response);
    }

    public void cargarDatos(){
        String url= ip.getIp()+"/factura.php";

        System.out.println("URL "+url);
        JsonObjectRequest = new JsonObjectRequest(Request.Method.GET,url,null,this,this);
        request.add(JsonObjectRequest);
    }

    public void cargarFacturas(JSONObject response){
        Factura factura;

        JSONArray json = response.optJSONArray("factura");
        JSONObject jsonObject= null;
        int contarx=0;
            try {
                System.out.println("cantidad de registro: " + json.length());
                for(int i=0;i<json.length();i++) {
                    jsonObject = json.getJSONObject(i);
                    factura = new Factura();

                    factura.setCorrelativoFactura(jsonObject.optString("0"));
                    factura.setNoFactura(jsonObject.getInt("1"));
                    factura.setSerie(jsonObject.getInt("2"));
                    factura.setFecha(jsonObject.getString("3"));
                    factura.setNit(jsonObject.getInt("4"));
                    factura.setNombre(jsonObject.getString("5"));
                    factura.setDireccion(jsonObject.getString("6"));
                    factura.setSubtotal(jsonObject.getDouble("7"));
                    factura.setDescuento(jsonObject.getDouble("8"));
                    factura.setClienteId(jsonObject.getString("9"));
                    listaFactura.add(factura);
                    contarx++;
                    System.out.println("Datos Generados "+factura.toString());
                }
                AdaptdorFacturaRecycler adaptdor= new AdaptdorFacturaRecycler(listaFactura);
                recyclerLista.setAdapter(adaptdor);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }


    public void onclikSalirFactura(View view) {
        Intent intent = new Intent(view.getContext(), MainActivity3.class);
        startActivity(intent);
    }
}
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
import com.example.proyectofinal.modelo.Conexion;
import com.example.proyectofinal.modelo.Factura;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class VerFactura extends AppCompatActivity implements Response.Listener<JSONObject>,Response.ErrorListener{

    Conexion ip = new Conexion();
    RequestQueue request;
    JsonObjectRequest jsonObjectRequest;

    String direccionUrle=null;

    ArrayList<Factura> listaDatosFactura= new ArrayList<>();

    RecyclerView recyclerListaFactura;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_factura);

        request= Volley.newRequestQueue(getApplicationContext());

        recyclerListaFactura = (RecyclerView) findViewById(R.id.rv_factura_recicler_viewr);
        recyclerListaFactura.setLayoutManager(new LinearLayoutManager(this));

        datosFactura();
    }

    @Override
    public void onErrorResponse(VolleyError error) {
        Toast.makeText(this.getApplicationContext(),"No hay registros", Toast.LENGTH_SHORT).show();
        System.out.println("error "+error.toString());
    }

    @Override
    public void onResponse(JSONObject response) {
        cargarDatos(response);
    }

    public void datosFactura(){
        String url=ip.getIp()+"/factura.php";

        System.out.println("URL: "+url);
        jsonObjectRequest = new JsonObjectRequest(Request.Method.GET,url,null,this,this);
        request.add(jsonObjectRequest);
    }

    public void cargarDatos(JSONObject response){
        Factura factura;
        JSONArray json = response.optJSONArray("factura");
        JSONObject jsonObject = null;
        try {
                System.out.println("la cantidad de registros " + json.length());
                for (int i=0;i<json.length();i++){
                jsonObject = json.getJSONObject(i);

                factura = new Factura();
                factura.setCorrelativoFactura(jsonObject.getString("correlativo_detalle"));
                factura.setNoFactura(jsonObject.getInt("no_factura"));
                factura.setSerie(jsonObject.getInt("serie"));
                factura.setFecha(jsonObject.getString("fecha"));
                factura.setNit(jsonObject.getInt("nit"));
                factura.setNombre(jsonObject.getString("nombre"));
                factura.setDireccion(jsonObject.getString("direccion"));
                factura.setSubtotal(jsonObject.getDouble("subtotal"));
                factura.setDescuento(jsonObject.getDouble("descuento"));
                factura.setClienteId(jsonObject.getString("cliente_id"));
                listaDatosFactura.add(factura);
                System.out.println(factura.toString());
            }
                AdaptadorFacturaRecycler adaptador = new AdaptadorFacturaRecycler(listaDatosFactura);
                recyclerListaFactura.setAdapter(adaptador);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }


    public void onClickRegresarDesdeFactura(View view) {
        Intent intent= new Intent(this.getApplicationContext(), MainActivity3.class);
        startActivity(intent);
    }
}


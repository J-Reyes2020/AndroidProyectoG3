package com.example.proyectofinal;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.proyectofinal.modelo.Conexion;
import com.example.proyectofinal.modelo.Ofertas;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;


public class OfertasActivity extends AppCompatActivity implements Response.Listener<JSONObject>, Response.ErrorListener {

    RequestQueue request;
    JsonObjectRequest jsonObjectRequest;
    String direccionWeb=null;

    Conexion ip = new Conexion();

    ArrayList<Ofertas> listaOferta = new ArrayList<>();

    RecyclerView recyclerOfertas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ofertas);

        request = Volley.newRequestQueue(getApplicationContext());

        recyclerOfertas = (RecyclerView)findViewById(R.id.rv_ofertas_recycler);
        recyclerOfertas.setLayoutManager(new LinearLayoutManager(this));

        cargarDatos();

    }

    @Override
    public void onErrorResponse(VolleyError error) {
        Toast.makeText(this.getApplicationContext(),"Error", Toast.LENGTH_SHORT).show();
        System.out.println("Error al conectar:" + error.toString());

    }

    @Override
    public void onResponse(JSONObject response) {
        //llamar al metodo que cargara la información
        cargarOfertas(response);
    }

    public void cargarDatos(){
        String url= ip.getIp()+"/listaOfertas.php";

        System.out.println("MI URL: " + url);
        jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url, null, this, this);
        request.add(jsonObjectRequest);
    }
    public void cargarOfertas (JSONObject response){
        Ofertas ofertas;

        JSONArray json = response.optJSONArray("ofertas");
        JSONObject jsonObject = null;
        int contarx=0;
        try {
            System.out.println("cantidad de registro: " + json.length());
            for (int i=0;i<json.length();i++) {
                //recorriendo cada uno de los elemento del array
                jsonObject = json.getJSONObject(i);
                ofertas = new Ofertas();

                //System.out.println("columna 0: " + jsonObject.optInt("0"));

                ofertas.setOfertaId(jsonObject.optInt("0"));
                ofertas.setNombreOferta(jsonObject.optString("1"));
                ofertas.setFechaInicioOferta(jsonObject.optString("2"));
                ofertas.setFechaFinalOferta(jsonObject.optString("3"));
                listaOferta.add(ofertas);
                contarx++;
                //System.out.println("contar: " + contarx);
                System.out.println("Datos Generados: " + ofertas.toString());
            }
            AdaptadorOfertaRecycler adap =new AdaptadorOfertaRecycler(listaOferta);
            recyclerOfertas.setAdapter(adap);
        }catch (JSONException e){
            e.printStackTrace();
            e.printStackTrace();
        }

    }
    public void onClickRegresarDesdeOfertas(View v) {
        Intent intent = new Intent(v.getContext(), MainActivity22.class);
        startActivity(intent);
    }
}
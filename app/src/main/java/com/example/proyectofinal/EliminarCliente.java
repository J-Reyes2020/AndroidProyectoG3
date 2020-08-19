package com.example.proyectofinal;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.example.proyectofinal.modelo.Conexion;

import org.json.JSONObject;

public class EliminarCliente extends AppCompatActivity implements Response.Listener<JSONObject>, Response.ErrorListener{

    EditText etClienteId;
    Conexion ip = new Conexion();
    String url;
    RequestQueue request;
    JsonObjectRequest jsonObjectRequest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eliminar_cliente);
        enlazarControl();
    }

    @Override
    public void onErrorResponse(VolleyError error) {
        Toast.makeText(this,"Acción no valida:  " + error, Toast.LENGTH_SHORT).show();
        System.out.println("no es posible eliminar: " + error);
    }

    @Override
    public void onResponse(JSONObject response) {
        Toast.makeText(this, "Registro eliminado", Toast.LENGTH_SHORT).show();

    }

    public void enlazarControl(){
        etClienteId = (EditText) findViewById(R.id.et_id_client);
    }

    public void onClickEliminarCliente(View view) {
        url=ip.getIp()+"eliminarCliente.php?txt_id"+etClienteId.getText().toString();
        Toast.makeText(this, url,Toast.LENGTH_SHORT).show();
        System.out.println("Eliminar: " + url);
        url = url.replace(" ", "%20");

        jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url, null, this, this);
        request.add(jsonObjectRequest);
    }
}
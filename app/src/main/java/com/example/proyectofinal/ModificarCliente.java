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

public class ModificarCliente extends AppCompatActivity implements Response.Listener<JSONObject>, Response.ErrorListener{

    EditText etClienteId;
    EditText etNombreCliente;
    EditText etApellidoCliente;
    EditText etTelefonoCliente;
    EditText etDireccionCliente;
    EditText etCorreoEle;

    Conexion ip = new Conexion();

    RequestQueue request;
    JsonObjectRequest jsonObjectRequest;

    String url;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modificar_cliente);
        enlazarControl();
    }

    private void enlazarControl(){
        etClienteId = (EditText) findViewById(R.id.et_id_cliente_modificar);
        etNombreCliente = (EditText) findViewById(R.id.et_nombre_cliente_modificar);
        etApellidoCliente = (EditText) findViewById(R.id.et_apellido_cliente_modficar);
        etTelefonoCliente = (EditText) findViewById(R.id.et_telefono_cliente_modificar);
        etDireccionCliente = (EditText) findViewById(R.id.et_direccion_cliente_modificar);
        etCorreoEle = (EditText) findViewById(R.id.et_correp_cliente_modificar);
    }

    @Override
    public void onErrorResponse(VolleyError error) {
        Toast.makeText(this, "No se pudo Modificar: ", Toast.LENGTH_SHORT).show();
        System.out.println("Error click: " + error.toString());
    }

    @Override
    public void onResponse(JSONObject response) {
        Toast.makeText(this, "Datos Actualizados Correctamente", Toast.LENGTH_SHORT).show();
    }

    private void actualizarDatos(){
        String url = ip.getIp()+"/modificarCliente.php?txt_cliente_id_modificar="+etClienteId.getText().toString()
                +"&txt_nombre_modificar="+etNombreCliente.getText().toString()
                +"&txt_apellido_modificar="+etApellidoCliente.getText().toString()
                +"&txt_telefono_modificar="+etTelefonoCliente.getText().toString()
                +"&txt_direcciom_modificar="+etDireccionCliente.getText().toString()
                +"&txt_correo_modificar="+etCorreoEle.getText().toString();

        url=url.replace(" ", "%20");
        jsonObjectRequest= new JsonObjectRequest(Request.Method.GET, url, null, this, this);
        request.add(jsonObjectRequest);
    }
    public void onClickMoficarClienteS(View view) {
        actualizarDatos();
        Toast.makeText(this, "Actualizado", Toast.LENGTH_SHORT).show();
        System.out.println("error: " + url);
    }
}
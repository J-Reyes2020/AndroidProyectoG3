package com.example.proyectofinal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.proyectofinal.modelo.Cliente;
import com.example.proyectofinal.modelo.Conexion;
import com.example.proyectofinal.modelo.Empleado;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class InsertarCliente extends AppCompatActivity implements Response.Listener<JSONObject>, Response.ErrorListener {


    EditText idCliente;
    EditText etNombre;
    EditText etApellido;
    EditText etTelefono;
    EditText etDireccion;
    EditText etCorreo;

    Conexion ip = new Conexion();

    RequestQueue request;
    JsonObjectRequest jsonObjectRequest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insertar_cliente);

        enlazarControles();

        request = Volley.newRequestQueue(getApplicationContext());
    }

    @Override
    public void onErrorResponse(VolleyError error) {
        Toast.makeText(this.getApplicationContext(), "Error al almacenar:" + error.toString(), Toast.LENGTH_LONG).show();
        System.out.println("Error al almacenar:" + error.toString());
    }

    @Override
    public void onResponse(JSONObject response) {
        Cliente cliente = new Cliente();

        cliente=cargarClientes(response);
        System.out.println(cliente.toString());
        if (cliente.getClienteId()==0){
            Toast.makeText(this.getApplicationContext(), "Error, Datos ya almacenados", Toast.LENGTH_SHORT).show();
            idCliente.setText("");
            etNombre.setText("");
            etApellido.setText("");
            etTelefono.setText("");
            etDireccion.setText("");
            etCorreo.setText("");
        }else {
            Toast.makeText(this.getApplicationContext(), "Datos almacemnados con éxito:", Toast.LENGTH_LONG).show();
            idCliente.setText("");
            etNombre.setText("");
            etApellido.setText("");
            etTelefono.setText("");
            etDireccion.setText("");
            etCorreo.setText("");
        }
    }

    public void enlazarControles(){
        idCliente = (EditText) findViewById(R.id.et_id_cliente_insertar);
        etNombre = (EditText) findViewById(R.id.et_nombre_cliente_insertar);
        etApellido = (EditText) findViewById(R.id.et_apellido_cliente_insertar);
        etTelefono = (EditText)findViewById(R.id.et_telefono_cliente_insertar);
        etDireccion = (EditText) findViewById(R.id.et_direccion_cliente_insertar);
        etCorreo = (EditText) findViewById(R.id.et_correp_cliente_insertar);
    }

    public void onClickInsertarClienteRegresar(View view) {
        Intent intent = new Intent(getApplicationContext(),ClientesCrudActivity.class);
        startActivity(intent);
    }

    public void onClikInsertarCliente(View view) {
        String url = ip.getIp()+"/insertarCliente.php?txt_cliente_id="+idCliente.getText().toString()
                +"&txt_nombre="+etNombre.getText().toString()
                +"&txt_apellido="+etApellido.getText().toString()
                +"&txt_telefono="+etTelefono.getText().toString()
                +"&txt_direccion="+etDireccion.getText().toString()
                +"&txt_correo="+etCorreo.getText().toString();

        url=url.replace(" ","20%");

        System.out.println("error" + url);

        jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url, null, this, this);
        request.add(jsonObjectRequest);
    }

    public Cliente cargarClientes(JSONObject response) {
        Cliente cliente = new Cliente();
        JSONArray json = response.optJSONArray("cliente_id");
        JSONObject jsonObject;
        try {
            jsonObject = json.getJSONObject(0);
            cliente.setClienteId(jsonObject.optInt("cliente_id"));
            cliente.setNombre(jsonObject.optString("nombre"));
            cliente.setApellido(jsonObject.optString("apellido"));
            cliente.setTelefono(jsonObject.optInt("telefono"));
            cliente.setDireccion(jsonObject.optString("direccion"));
            cliente.setCorreoElec(jsonObject.optString("correo_electronico"));
        } catch (JSONException e) {
            System.out.println(e);
            Toast.makeText(this.getApplicationContext(), "Datos Erroneos " + e, Toast.LENGTH_LONG).show();
        }
    return cliente;
    }


}
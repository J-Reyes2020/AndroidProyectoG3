package com.example.proyectofinal;

import androidx.appcompat.app.AppCompatActivity;

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

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class EliminarCliente extends AppCompatActivity implements Response.Listener<JSONObject>, Response.ErrorListener{
    EditText idCliente;
    Button btnActualizar;
    Conexion ip = new Conexion();
    String url;
    RequestQueue request;
    JsonObjectRequest jsonObjectRequest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eliminar_cliente);
        enlazarControl();

        request = Volley.newRequestQueue(getApplicationContext());
    }

    @Override
    public void onErrorResponse(VolleyError error) {
        Toast.makeText(this,"Acción no valida:  " + error, Toast.LENGTH_LONG).show();
        System.out.println("no es posible eliminar: " );
    }

    @Override
    public void onResponse(JSONObject response) {

        Cliente cliente = new Cliente();

        cliente=eliminarCliente(response);
        System.out.println(cliente.toString());
        if (cliente.getClienteId()==0){
            Toast.makeText(this.getApplicationContext(), "Datos eliminado con éxito:", Toast.LENGTH_SHORT).show();
            idCliente.setText("");
        }
    }


    public void enlazarControl(){
        idCliente = (EditText) findViewById(R.id.et_id_client);
        btnActualizar = (Button) findViewById(R.id.btn_eliminar_cliente_eliminar);
    }

    public void onClickEliminarCliente(View view) {
        url=ip.getIp()+"/eliminarCliente.php?txt_id_eliminar="+idCliente.getText().toString();
        /*Toast.makeText(this, url+"dATOS",Toast.LENGTH_LONG).show();
        System.out.println("Eliminar: " + url);*/
        url = url.replace(" ", "%20");

        jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url, null, this, this);
        request.add(jsonObjectRequest);
    }

    public Cliente eliminarCliente(JSONObject response) {
        Cliente cliente = new Cliente();
        JSONArray json = response.optJSONArray("nombre");
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
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
import com.example.proyectofinal.modelo.Cliente;
import com.example.proyectofinal.modelo.Conexion;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class EliminarCliente extends AppCompatActivity implements Response.Listener<JSONObject>, Response.ErrorListener{

    EditText idCliente;

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
        Cliente cliente = new Cliente();

        cliente=eliminarCliente(response);
        System.out.println(cliente.toString());
        if (cliente.getClienteId()==0){
            Toast.makeText(this.getApplicationContext(), "Error, NO se encuentra la informacion o" +
                    "ya fue eliminada", Toast.LENGTH_SHORT).show();
            idCliente.setText("");
        }else {
            Toast.makeText(this.getApplicationContext(), "Datos eliminado con éxito:", Toast.LENGTH_LONG).show();
            idCliente.setText("");
        }
    }


    public void enlazarControl(){
        idCliente = (EditText) findViewById(R.id.et_id_client);
    }

    public void onClickEliminarCliente(View view) {
        url=ip.getIp()+"/eliminarCliente.php?txt_id="+idCliente.getText().toString();
        Toast.makeText(this, url,Toast.LENGTH_SHORT).show();
        System.out.println("Eliminar: " + url);
        url = url.replace(" ", "%20");

        jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url, null, this, this);
        request.add(jsonObjectRequest);
    }

    public Cliente eliminarCliente(JSONObject response) {
        Cliente cliente = new Cliente();
        JSONArray json = response.optJSONArray("cliente_id");
        JSONObject jsonObject;
        try {
            jsonObject = json.getJSONObject(0);
            cliente.setClienteId(jsonObject.optInt("cliente_id"));

        } catch (JSONException e) {
            System.out.println(e);
            Toast.makeText(this.getApplicationContext(), "Datos Erroneos " + e, Toast.LENGTH_LONG).show();
        }
        return cliente;
    }
}
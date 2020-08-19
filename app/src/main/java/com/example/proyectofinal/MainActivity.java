package com.example.proyectofinal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.proyectofinal.modelo.Conexion;
import com.example.proyectofinal.modelo.Empleado;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity implements Response.Listener<JSONObject>, Response.ErrorListener {

    EditText etEmpleadoId;
    EditText etContra;
    String mensaje="";
    String puestoId;
    Conexion ip = new Conexion();
    String url;
    RequestQueue request;
    JsonObjectRequest jsonObjectRequest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etEmpleadoId = (EditText) findViewById(R.id.et_Usuario);
        etContra = (EditText) findViewById(R.id.et_contra_main);

        request = Volley.newRequestQueue(getApplicationContext());
    }

    public void onClickValidar(View view) {
       String url = ip.getIp()+"/inicioSesion.php?empleado_id="+etEmpleadoId.getText().toString()+"&contrasenia="+etContra.getText().toString();
        System.out.println("URL:" + url);
        jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url, null, this,this);
        request.add(jsonObjectRequest);
    }
    @Override
    public void onErrorResponse(VolleyError error) {
        mensaje="Datos no localizados";
        Toast.makeText(getApplicationContext(), mensaje, Toast.LENGTH_SHORT).show();
        System.out.println("Error de Conexión:" + error.toString());
        System.out.println("URL" + url);
    }

    @Override
    public void onResponse(JSONObject response) {
        cargaEmpleados(response);
    }

    public void cargaEmpleados(JSONObject response){
        Empleado empleado = new Empleado();
        JSONArray json = response.optJSONArray("empleados");
        JSONObject jsonObject;
        try {
            jsonObject = json.getJSONObject(0);
            empleado.setEmpleadoId(jsonObject.optInt("empleado_id "));
            empleado.setNombreEmpleadp(jsonObject.optString("nombre"));
            empleado.setApellidoEm(jsonObject.optString("apellido"));
            empleado.setTelefonoEm(jsonObject.optInt("telefono"));
            empleado.setDireccionEm(jsonObject.optString("direccion"));
            empleado.setCorreoElec(jsonObject.optString("correo"));
            empleado.setPuestoId(jsonObject.optInt("puesto_id"));
            empleado.setContraseniaEmp(jsonObject.getString("contrasenia"));
        }catch (JSONException e){
            e.printStackTrace();
        }
        System.out.println(empleado.toString());
        if (empleado.getPuestoId()==1){
            Toast.makeText(this.getApplicationContext(), "Bienvenido", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(getApplicationContext(),MainActivity22.class);
            startActivity(intent);
        }
        if (empleado.getPuestoId()==2){
            Toast.makeText(this.getApplicationContext(), "Bienvenido ", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(getApplicationContext(),MainActivity3.class);
            startActivity(intent);
        }
    }
}
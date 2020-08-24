package com.example.proyectofinal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ClientesCrudActivity extends AppCompatActivity {
    Button btnInsertar;
    Button btnEliminar;
    Button btnActualizar;
    Button btnBuscar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clientes_crud);

    }

    public void onClickAgregarClienteCrud(View view) {
        Intent intent = new Intent(view.getContext(), InsertarCliente.class);
        startActivity(intent);
    }

    public void onclickEliminarClienteCrud(View view) {
        Intent intent = new Intent(view.getContext(), EliminarCliente.class);
        startActivity(intent);
    }

    public void onClickActualizarClienteCrud(View view) {
        Intent intent = new Intent(view.getContext(), ModificarCliente.class);
        startActivity(intent);
    }


}
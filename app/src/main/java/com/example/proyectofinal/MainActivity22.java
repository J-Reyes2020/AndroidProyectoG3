package com.example.proyectofinal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

public class MainActivity22 extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main22);

    }

    public void onlickCliente(View view) {
        Intent intentCliente = new Intent(view.getContext(), ClientesActivity.class);
        startActivity(intentCliente);
    }

    public void onclickOfertas(View view) {
        Intent intentOfertas = new Intent(view.getContext(), OfertasActivity.class);
        startActivity(intentOfertas);
    }

    public void onclicKRegresar(View view) {
        Intent intentRegrear = new Intent(view.getContext(), MainActivity.class);
        startActivity(intentRegrear);
    }

    public void onclickProducto(View view) {
        Intent intentProducto= new Intent(view.getContext(), ProductosActivity.class);
        startActivity(intentProducto);
    }
}
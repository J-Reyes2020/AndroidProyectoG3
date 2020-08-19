package com.example.proyectofinal;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.proyectofinal.modelo.Productos;

import java.util.ArrayList;

public class AdaptadorProductoRecycler extends RecyclerView.Adapter<AdaptadorProductoRecycler.ViewHolderDatos> {

    ArrayList<Productos> listaProductos;

    public AdaptadorProductoRecycler(ArrayList<Productos> listaProductos) {
        this.listaProductos = listaProductos;
    }

    @NonNull
    @Override
    public AdaptadorProductoRecycler.ViewHolderDatos onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_lista_producto_recycler,null,false);
        return new AdaptadorProductoRecycler.ViewHolderDatos(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdaptadorProductoRecycler.ViewHolderDatos holder, int position) {
        holder.tvCodigo.setText(String.valueOf(listaProductos.get(position).getProductoId()));
        holder.tvNombrePro.setText(listaProductos.get(position).getNombreProducto());
        holder.tvPrecio.setText(String.valueOf(listaProductos.get(position).getPrecioProducto()));
        holder.tvCantidad.setText(String.valueOf(listaProductos.get(position).getCantidadProducto()));
        holder.tvTipo.setText(listaProductos.get(position).getTipoProducto());
    }

    @Override
    public int getItemCount() {
        return listaProductos.size();
    }

    public class ViewHolderDatos extends RecyclerView.ViewHolder{

        TextView tvCodigo;
        TextView tvNombrePro;
        TextView tvPrecio;
        TextView tvCantidad;
        TextView tvTipo;
        Button btnAgregar;
        public ViewHolderDatos(@NonNull View itemView) {
            super(itemView);
            tvCodigo = (TextView) itemView.findViewById(R.id.tv_producto_id_item);
            tvNombrePro = (TextView) itemView.findViewById(R.id.tv_nombre_prodcuto_item);
            tvPrecio = (TextView) itemView.findViewById(R.id.tv_precio_procuto_item);
            tvCantidad = (TextView) itemView.findViewById(R.id.tv_cantidad_producto_item);
            tvTipo = (TextView) itemView.findViewById(R.id.tv_tipo_producto_item);
            btnAgregar = (Button) itemView.findViewById(R.id.btn_agregar_al_carrito);
        }
    }
}

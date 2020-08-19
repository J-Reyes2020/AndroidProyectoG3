package com.example.proyectofinal;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.proyectofinal.modelo.Cliente;

import java.util.ArrayList;

public class AdaptadorClienteRecycler extends RecyclerView.Adapter<AdaptadorClienteRecycler.ViewHolderDatos> {
    ArrayList<Cliente> listaDatos;

    public AdaptadorClienteRecycler(ArrayList<Cliente> listaDatos) {
        this.listaDatos = listaDatos;
    }

    @NonNull
    @Override
    public AdaptadorClienteRecycler.ViewHolderDatos onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_lista_cliente_recycler,null,false);
        return new ViewHolderDatos(view);

    }

    @Override
    public void onBindViewHolder(@NonNull AdaptadorClienteRecycler.ViewHolderDatos holder, int position) {
        holder.tvCodigoCliente.setText(String.valueOf(listaDatos.get(position).getClienteId()));
        holder.tvNombre.setText(listaDatos.get(position).getNombre());
        holder.tvApellido.setText(listaDatos.get(position).getApellido());
        holder.tvTelefono.setText(String.valueOf(listaDatos.get(position).getTelefono()));
        holder.tvDireccion.setText(listaDatos.get(position).getDireccion());
        holder.tvCorreo.setText(listaDatos.get(position).getCorreoElec());

    }

    @Override
    public int getItemCount() {
        return listaDatos.size();
    }

    public class ViewHolderDatos extends RecyclerView.ViewHolder {
        TextView tvCodigoCliente;
        TextView tvNombre;
        TextView tvApellido;
        TextView tvTelefono;
        TextView tvDireccion;
        TextView tvCorreo;

        public ViewHolderDatos(@NonNull View itemView) {
            super(itemView);
            tvCodigoCliente = (TextView) itemView.findViewById(R.id.tv_item_cliente_id);
            tvNombre = (TextView) itemView.findViewById(R.id.tv_item_nombre_cliente);
            tvApellido = (TextView) itemView.findViewById(R.id.tv_item_apellido_cliente);
            tvTelefono = (TextView) itemView.findViewById(R.id.tv_item_telefono_cliente);
            tvDireccion = (TextView) itemView.findViewById(R.id.tv_item_direccion_cliente);
            tvCorreo = (TextView) itemView.findViewById(R.id.tv_item_correo_cliente);
        }
    }
}

package com.example.proyectofinal;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.proyectofinal.modelo.Ofertas;

import java.util.ArrayList;

public class AdaptadorOfertaRecycler extends RecyclerView.Adapter<AdaptadorOfertaRecycler.ViewHolderDatos>{

    ArrayList<Ofertas> listaOfertas;

    public AdaptadorOfertaRecycler(ArrayList<Ofertas> listaOfertas) {
        this.listaOfertas = listaOfertas;
    }

    @NonNull
    @Override
    public AdaptadorOfertaRecycler.ViewHolderDatos onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_lista_oferta_recycler,null,false);
        return new ViewHolderDatos(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdaptadorOfertaRecycler.ViewHolderDatos holder, int position) {
        holder.tvCodigoOferta.setText(String.valueOf(listaOfertas.get(position).getOfertaId()));
        holder.tvNombreOferta.setText(listaOfertas.get(position).getNombreOferta());
        holder.tvFechaInicio.setText(listaOfertas.get(position).getFechaInicioOferta());
        holder.tvFechaFinal.setText(listaOfertas.get(position).getFechaFinalOferta());

    }

    @Override
    public int getItemCount() {
        //tamaño
        return listaOfertas.size();
    }

    public class ViewHolderDatos extends RecyclerView.ViewHolder{

        TextView tvCodigoOferta;
        TextView tvNombreOferta;
        TextView tvFechaInicio;
        TextView tvFechaFinal;
        public ViewHolderDatos(@NonNull View itemView) {
            super(itemView);
            tvCodigoOferta=(TextView) itemView.findViewById(R.id.tv_codigo_ofertas_item);
            tvNombreOferta=(TextView) itemView.findViewById(R.id.tv_nombre_item_oferta);
            tvFechaInicio=(TextView) itemView.findViewById(R.id.tv_item_fecha_inicio_oferta);
            tvFechaFinal=(TextView) itemView.findViewById(R.id.tv_fecha_final_oferta_item);


        }
    }
}

package com.example.proyectofinal;

import android.content.Context;
import android.text.InputType;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.proyectofinal.modelo.Factura;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class AdaptadorFacturaRecycler extends RecyclerView.Adapter<AdaptadorFacturaRecycler.ViewHolderDatos> {
    ArrayList<Factura> listaDatosFactura;

    public AdaptadorFacturaRecycler(ArrayList<Factura> listaDatosFactura) {
        this.listaDatosFactura=listaDatosFactura;
    }

    @NonNull
    @Override
    public AdaptadorFacturaRecycler.ViewHolderDatos onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_lista_factura_recycler,null, false);
        return new ViewHolderDatos(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdaptadorFacturaRecycler.ViewHolderDatos holder, int position) {
        holder.tvCorrelativoDetalle.setText(listaDatosFactura.get(position).getCorrelativoFactura());
        holder.tvNoFactura.setText(String.valueOf(listaDatosFactura.get(position).getNoFactura()));
        holder.tvSerie.setText(String.valueOf(listaDatosFactura.get(position).getSerie()));
        holder.tvFecha.setText(listaDatosFactura.get(position).getFecha());
        holder.tvNit.setText(String.valueOf(listaDatosFactura.get(position).getNit()));
        holder.tvNombre.setText(listaDatosFactura.get(position).getNombre());
        holder.tvDireccion.setText(listaDatosFactura.get(position).getDireccion());
        holder.tvSubTotal.setText(String.valueOf(listaDatosFactura.get(position).getSubtotal()));
        holder.tvDescuento.setText(String.valueOf(listaDatosFactura.get(position).getDescuento()));
        holder.tvClienteId.setText(listaDatosFactura.get(position).getClienteId());
    }

    @Override
    public int getItemCount() {
        return listaDatosFactura.size();
    }

    public class ViewHolderDatos extends RecyclerView.ViewHolder {
        TextView tvCorrelativoDetalle;
        TextView tvNoFactura;
        TextView tvSerie;
        TextView tvFecha;
        TextView tvNit;
        TextView tvNombre;
        TextView tvDireccion;
        TextView tvSubTotal;
        TextView tvDescuento;
        TextView tvClienteId;
        public ViewHolderDatos(@NonNull View itemView) {
            super(itemView);
            tvCorrelativoDetalle= itemView.findViewById(R.id.tv_factura_correlativo_factura);
            tvNoFactura= itemView.findViewById(R.id.tv_factura_no_factura);
            tvSerie= itemView.findViewById(R.id.tv_factura_serie);
            tvFecha= itemView.findViewById(R.id.tv_factura_nit);
            tvNit= itemView.findViewById(R.id.tv_factura_nombre);
            tvNombre= itemView.findViewById(R.id.tv_factura_nombre);
            tvDireccion= itemView.findViewById(R.id.tv_factura_direccion);
            tvSubTotal = itemView.findViewById(R.id.tv_factura_Subtotal);
            tvDescuento= itemView.findViewById(R.id.tv_factura_descuento);
            tvClienteId= itemView.findViewById(R.id.tv_factura_cliente_id);
            tvCorrelativoDetalle.setInputType(InputType.TYPE_CLASS_TEXT|InputType.TYPE_TEXT_FLAG_NO_SUGGESTIONS);
            tvNoFactura.setInputType(InputType.TYPE_CLASS_TEXT|InputType.TYPE_TEXT_FLAG_NO_SUGGESTIONS);
            tvSerie.setInputType(InputType.TYPE_CLASS_TEXT|InputType.TYPE_TEXT_FLAG_NO_SUGGESTIONS);
            tvFecha.setInputType(InputType.TYPE_CLASS_TEXT|InputType.TYPE_TEXT_FLAG_NO_SUGGESTIONS);
            tvNit.setInputType(InputType.TYPE_CLASS_TEXT|InputType.TYPE_TEXT_FLAG_NO_SUGGESTIONS);
            tvNombre.setInputType(InputType.TYPE_CLASS_TEXT|InputType.TYPE_TEXT_FLAG_NO_SUGGESTIONS);
            tvDireccion.setInputType(InputType.TYPE_CLASS_TEXT|InputType.TYPE_TEXT_FLAG_NO_SUGGESTIONS);
            tvSubTotal.setInputType(InputType.TYPE_CLASS_TEXT|InputType.TYPE_TEXT_FLAG_NO_SUGGESTIONS);
            tvDescuento.setInputType(InputType.TYPE_CLASS_TEXT|InputType.TYPE_TEXT_FLAG_NO_SUGGESTIONS);
            tvClienteId.setInputType(InputType.TYPE_CLASS_TEXT|InputType.TYPE_TEXT_FLAG_NO_SUGGESTIONS);
        }
    }
}

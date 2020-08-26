package com.example.proyectofinal;

import android.text.InputType;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.proyectofinal.modelo.Factura;

import java.util.ArrayList;

public class AdaptdorFacturaRecycler extends RecyclerView.Adapter<AdaptdorFacturaRecycler.ViewHolderDatos>{
    ArrayList<Factura> listaFactura;

    public AdaptdorFacturaRecycler(ArrayList<Factura> listaFactura){
        this.listaFactura=listaFactura;
    }

    @NonNull
    @Override
    public AdaptdorFacturaRecycler.ViewHolderDatos onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_lista_factura_recycler, null, false);
        return new ViewHolderDatos(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdaptdorFacturaRecycler.ViewHolderDatos holder, int position) {
    holder.tvCorrelativoDetalle.setText(listaFactura.get(position).getCorrelativoFactura());
    holder.tvNoFactura.setText(String.valueOf(listaFactura.get(position).getNoFactura()));
    holder.tvSerie.setText(String.valueOf(listaFactura.get(position).getSerie()));
    holder.tvFecha.setText(listaFactura.get(position).getFecha());
    holder.tvNit.setText(String.valueOf(listaFactura.get(position).getNit()));
    holder.tvNombre.setText(listaFactura.get(position).getNombre());
    holder.tvDireccion.setText(listaFactura.get(position).getDireccion());
    holder.tvSubTotal.setText(String.valueOf(listaFactura.get(position).getSubtotal()));
    holder.tvDescuento.setText(String.valueOf(listaFactura.get(position).getDescuento()));
    holder.tvClienteId.setText(listaFactura.get(position).getClienteId());

    }

    @Override
    public int getItemCount() {
        return listaFactura.size();
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
            tvCorrelativoDetalle= (TextView) itemView.findViewById(R.id.tv_factura_correlativo_factura);
            tvNoFactura=(TextView)itemView.findViewById(R.id.tv_factura_no_factura);
            tvSerie=(TextView)itemView.findViewById(R.id.tv_factura_serie);
            tvFecha=(TextView)itemView.findViewById(R.id.tv_factura_fecha);
            tvNit=(TextView)itemView.findViewById(R.id.tv_factura_nit);
            tvNombre=(TextView)itemView.findViewById(R.id.tv_factura_nombre);
            tvDireccion=(TextView)itemView.findViewById(R.id.tv_factura_direccion);
            tvSubTotal=(TextView)itemView.findViewById(R.id.tv_factura_Subtotal);
            tvDescuento=(TextView)itemView.findViewById(R.id.tv_factura_descuento);
            tvClienteId=(TextView)itemView.findViewById(R.id.tv_factura_cliente_id);
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

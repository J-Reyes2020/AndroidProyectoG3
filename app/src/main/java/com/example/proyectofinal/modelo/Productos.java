package com.example.proyectofinal.modelo;

public class Productos {

    private int productoId;
    private String nombreProducto;
    private int precioProducto;
    private int cantidadProducto;
    private String tipoProducto;

    public Productos() {
    }

    public Productos(int productoId, String nombreProducto, int precioProducto, int cantidadProducto, String tipoProducto) {
        this.productoId = productoId;
        this.nombreProducto = nombreProducto;
        this.precioProducto = precioProducto;
        this.cantidadProducto = cantidadProducto;
        this.tipoProducto = tipoProducto;
    }

    @Override
    public String toString() {
        return "Productos{" +
                "productoId=" + productoId +
                ", nombreProducto='" + nombreProducto + '\'' +
                ", precioProducto=" + precioProducto +
                ", cantidadProducto=" + cantidadProducto +
                ", tipoProducto='" + tipoProducto + '\'' +
                '}';
    }

    public int getProductoId() {
        return productoId;
    }

    public void setProductoId(int productoId) {
        this.productoId = productoId;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public int getPrecioProducto() {
        return precioProducto;
    }

    public void setPrecioProducto(int precioProducto) {
        this.precioProducto = precioProducto;
    }

    public int getCantidadProducto() {
        return cantidadProducto;
    }

    public void setCantidadProducto(int cantidadProducto) {
        this.cantidadProducto = cantidadProducto;
    }

    public String getTipoProducto() {
        return tipoProducto;
    }

    public void setTipoProducto(String tipoProducto) {
        this.tipoProducto = tipoProducto;
    }
}

package com.example.proyectofinal.modelo;

public class Factura {
    private String correlativoFactura;
    private int noFactura;
    private int serie;
    private String fecha;
    private int nit;
    private String nombre;
    private String direccion;
    private double subtotal;
    private double descuento;
    private String clienteId;

    public Factura() {
    }

    public Factura(String correlativoFactura, int noFactura, int serie, String fecha, int nit, String nombre, String direccion, double subtotal, double descuento, String clienteId) {
        this.correlativoFactura = correlativoFactura;
        this.noFactura = noFactura;
        this.serie = serie;
        this.fecha = fecha;
        this.nit = nit;
        this.nombre = nombre;
        this.direccion = direccion;
        this.subtotal = subtotal;
        this.descuento = descuento;
        this.clienteId = clienteId;
    }

    @Override
    public String toString() {
        return "VerFactura{" +
                "correlativoFactura='" + correlativoFactura + '\'' +
                ", noFactura=" + noFactura +
                ", serie=" + serie +
                ", fecha='" + fecha + '\'' +
                ", nit=" + nit +
                ", nombre='" + nombre + '\'' +
                ", direccion='" + direccion + '\'' +
                ", subtotal=" + subtotal +
                ", descuento=" + descuento +
                ", clienteId='" + clienteId + '\'' +
                '}';
    }

    public String getCorrelativoFactura() {
        return correlativoFactura;
    }

    public void setCorrelativoFactura(String correlativoFactura) {
        this.correlativoFactura = correlativoFactura;
    }

    public int getNoFactura() {
        return noFactura;
    }

    public void setNoFactura(int noFactura) {
        this.noFactura = noFactura;
    }

    public int getSerie() {
        return serie;
    }

    public void setSerie(int serie) {
        this.serie = serie;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public int getNit() {
        return nit;
    }

    public void setNit(int nit) {
        this.nit = nit;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }

    public double getDescuento() {
        return descuento;
    }

    public void setDescuento(double descuento) {
        this.descuento = descuento;
    }

    public String getClienteId() {
        return clienteId;
    }

    public void setClienteId(String clienteId) {
        this.clienteId = clienteId;
    }
}

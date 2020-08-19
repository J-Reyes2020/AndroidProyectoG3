package com.example.proyectofinal.modelo;

public class Ofertas {

    private int ofertaId;
    private String nombreOferta;
    private int fechaInicioOferta;
    private int fechaFinalOferta;

    public Ofertas() {
    }

    public Ofertas(int ofertaId, String nombreOferta, int fechaInicioOferta, int fechaFinalOferta) {
        this.ofertaId = ofertaId;
        this.nombreOferta = nombreOferta;
        this.fechaInicioOferta = fechaInicioOferta;
        this.fechaFinalOferta = fechaFinalOferta;
    }

    @Override
    public String toString() {
        return "Ofertas{" +
                "ofertaId=" + ofertaId +
                ", nombreOferta='" + nombreOferta + '\'' +
                ", fechaInicioOferta=" + fechaInicioOferta +
                ", fechaFinalOferta=" + fechaFinalOferta +
                '}';
    }

    public int getOfertaId() {
        return ofertaId;
    }

    public void setOfertaId(int ofertaId) {
        this.ofertaId = ofertaId;
    }

    public String getNombreOferta() {
        return nombreOferta;
    }

    public void setNombreOferta(String nombreOferta) {
        this.nombreOferta = nombreOferta;
    }

    public int getFechaInicioOferta() {
        return fechaInicioOferta;
    }

    public void setFechaInicioOferta(int fechaInicioOferta) {
        this.fechaInicioOferta = fechaInicioOferta;
    }

    public int getFechaFinalOferta() {
        return fechaFinalOferta;
    }

    public void setFechaFinalOferta(int fechaFinalOferta) {
        this.fechaFinalOferta = fechaFinalOferta;
    }
}

package com.example.proyectofinal.modelo;

public class Empleado {
    private int empleadoId;
    private String nombreEmpleadp;
    private String apellidoEm;
    private int telefonoEm;
    private String direccionEm;
    private String correoElec;
    private int puestoId;
    private String contraseniaEmp;

    public Empleado() {

    }

    public Empleado(int empleadoId, String nombreEmpleadp, String apellidoEm, int telefonoEm, String direccionEm, String correoElec, int puestoId, String contraseniaEmp) {
        this.empleadoId = empleadoId;
        this.nombreEmpleadp = nombreEmpleadp;
        this.apellidoEm = apellidoEm;
        this.telefonoEm = telefonoEm;
        this.direccionEm = direccionEm;
        this.correoElec = correoElec;
        this.puestoId = puestoId;
        this.contraseniaEmp = contraseniaEmp;
    }

    @Override
    public String toString() {
        return "Empleado{" +
                "empleadoId='" + empleadoId + '\'' +
                ", nombreEmpleadp='" + nombreEmpleadp + '\'' +
                ", apellidoEm='" + apellidoEm + '\'' +
                ", telefonoEm=" + telefonoEm +
                ", direccionEm='" + direccionEm + '\'' +
                ", correoElec='" + correoElec + '\'' +
                ", puestoId=" + puestoId +
                ", contraseniaEmp='" + contraseniaEmp + '\'' +
                '}';
    }

    public int getEmpleadoId() {
        return empleadoId;
    }

    public void setEmpleadoId(int empleadoId) {
        this.empleadoId = empleadoId;
    }

    public String getNombreEmpleadp() {
        return nombreEmpleadp;
    }

    public void setNombreEmpleadp(String nombreEmpleadp) {
        this.nombreEmpleadp = nombreEmpleadp;
    }

    public String getApellidoEm() {
        return apellidoEm;
    }

    public void setApellidoEm(String apellidoEm) {
        this.apellidoEm = apellidoEm;
    }

    public int getTelefonoEm() {
        return telefonoEm;
    }

    public void setTelefonoEm(int telefonoEm) {
        this.telefonoEm = telefonoEm;
    }

    public String getDireccionEm() {
        return direccionEm;
    }

    public void setDireccionEm(String direccionEm) {
        this.direccionEm = direccionEm;
    }

    public String getCorreoElec() {
        return correoElec;
    }

    public void setCorreoElec(String correoElec) {
        this.correoElec = correoElec;
    }

    public int getPuestoId() {
        return puestoId;
    }

    public void setPuestoId(int puestoId) {
        this.puestoId = puestoId;
    }

    public String getContraseniaEmp() {
        return contraseniaEmp;
    }

    public void setContraseniaEmp(String contraseniaEmp) {
        this.contraseniaEmp = contraseniaEmp;
    }
}


package Clases;

import java.sql.Date;

public abstract class Reserva {
    private int idReserva;
    private int cantidadAlumnos;
    private int idActividad;
    private String nombreActividad;
    private int dniDocente;
    private String nombreDocente;
    private String apellidoDocente;
    private String emailDocente;
    private Date fechaCreacion;
    
    public Reserva(){
        
    }
    
    public Reserva(int idReserva, int cantidadAlumnos, int idActividad, String nombreActividad, int dniDocente, String nombreDocente, String apellidoDocente, String emailDocente, Date fechaCreacion) {
        this.idReserva = idReserva;
        this.cantidadAlumnos = cantidadAlumnos;
        this.idActividad = idActividad;
        this.nombreActividad = nombreActividad;
        this.dniDocente = dniDocente;
        this.nombreDocente = nombreDocente;
        this.apellidoDocente = apellidoDocente;
        this.emailDocente = emailDocente;
        this.fechaCreacion = fechaCreacion;
    }

    public int getIdReserva() {
        return idReserva;
    }

    public void setIdReserva(int idReserva) {
        this.idReserva = idReserva;
    }

    public int getCantidadAlumnos() {
        return cantidadAlumnos;
    }

    public void setCantidadAlumnos(int cantidadAlumnos) {
        this.cantidadAlumnos = cantidadAlumnos;
    }

    public int getIdActividad() {
        return idActividad;
    }

    public void setIdActividad(int idActividad) {
        this.idActividad = idActividad;
    }

    public String getNombreActividad() {
        return nombreActividad;
    }

    public void setNombreActividad(String nombreActividad) {
        this.nombreActividad = nombreActividad;
    }

    public int getDniDocente() {
        return dniDocente;
    }

    public void setDniDocente(int dniDocente) {
        this.dniDocente = dniDocente;
    }

    public String getNombreDocente() {
        return nombreDocente;
    }

    public void setNombreDocente(String nombreDocente) {
        this.nombreDocente = nombreDocente;
    }

    public String getApellidoDocente() {
        return apellidoDocente;
    }

    public void setApellidoDocente(String apellidoDocente) {
        this.apellidoDocente = apellidoDocente;
    }

    public String getEmailDocente() {
        return emailDocente;
    }

    public void setEmailDocente(String emailDocente) {
        this.emailDocente = emailDocente;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }
    
    
    
}


package Clases;

import java.sql.Date;

public class Periodo {
    private Date fechaInicio;
    private Date fechaFin;
    private String identificador;
    private String nombre;
    private int anoLectivo;

    public Periodo(Date fechaInicio, Date fechaFin, String identificador, String nombre, int anoLectivo) {
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.identificador = identificador;
        this.nombre = nombre;
        this.anoLectivo = anoLectivo;
    }

    public Periodo() {
    }
    

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    public String getIdentificador() {
        return identificador;
    }

    public void setIdentificador(String identificador) {
        this.identificador = identificador;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getAnoLectivo() {
        return anoLectivo;
    }

    public void setAnoLectivo(int anoLectivo) {
        this.anoLectivo = anoLectivo;
    }
    
    
}

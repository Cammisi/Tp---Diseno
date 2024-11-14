
package Clases;

import java.sql.Date;
import java.sql.Time;

public class Dia {
    private String nombreDia;
    private Time horaInicio;
    private int duracion;
    private Date fecha;

    public Dia(){
        
    }
    
    public Dia(String nombreDia, Time horaInicio, int duracion, Date fecha) {
        this.nombreDia = nombreDia;
        this.horaInicio = horaInicio;
        this.duracion = duracion;
        this.fecha = fecha;
    }
    
    public String getNombreDia() {
        return nombreDia;
    }

    public void setNombreDia(String nombreDia) {
        this.nombreDia = nombreDia;
    }

    public Time getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(Time horaInicio) {
        this.horaInicio = horaInicio;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
    
    
}

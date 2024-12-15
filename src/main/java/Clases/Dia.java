
package Clases;

import java.sql.Date;
import java.sql.Time;

public class Dia {
    private String nombreDia;
    private Time horaInicio;
    private int duracion;
    private Date fecha;
    private int cantidadAlumnos;
    private int idActividad;
    private String nombreActividad;
    private Aula aula;

    public Dia(){
        
    }
    
    public Dia(String nombreDia, Time horaInicio, int duracion, Date fecha) {
        this.nombreDia = nombreDia;
        this.horaInicio = horaInicio;
        this.duracion = duracion;
        this.fecha = fecha;
    }

    public Aula getAula() {
        return aula;
    }

    public void setAula(Aula aula) {
        this.aula = aula;
    }
    
    
    public String getNombreDia() {
        return nombreDia;
    }

    public void setNombreDia(String nombreDia) {
       
        this.nombreDia = nombreDia;
        
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
        
        switch(fecha.getDay()){
            case 0:
                this.setNombreDia("Domingo");
                break;
            case 1:
                this.setNombreDia("Lunes");
                break;
            case 2:
                this.setNombreDia("Martes");
                break;
            case 3:
                this.setNombreDia("Miercoles");
                break;
            case 4:
                this.setNombreDia("Jueves");
                break;
            case 5:
                this.setNombreDia("Viernes");
                break;
            case 6:
                this.setNombreDia("Sabado");
                break;    
        }
    }
    
    
}

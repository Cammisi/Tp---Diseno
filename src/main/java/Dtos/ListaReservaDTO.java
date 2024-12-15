
package Dtos;

import java.sql.Time;
import java.util.Date;

public class ListaReservaDTO {
    private int numeroAula;
    private int dniDocente;
    private String nombreActividad;
    private Time horaInicio;
    private Time horaFin;
    private int duracion;
    private Date dia;

    public ListaReservaDTO(int numeroAula, int dniDocente, String nombreActividad, Time horaInicio, Time horaFin){
        this.numeroAula = numeroAula;
        this.dniDocente = dniDocente;
        this.nombreActividad = nombreActividad;
        this.horaInicio = horaInicio;
        this.horaFin = horaFin;
    }
    
    public ListaReservaDTO(int numero,Time horaInicio,int duracion,Date dia){
        this.numeroAula = numero;
        this.horaInicio = horaInicio;
        this.duracion = duracion;
        this.dia = dia;
    }

    public int getNumeroAula() {
        return numeroAula;
    }

    public void setNumeroAula(int numeroAula) {
        this.numeroAula = numeroAula;
    }

    public int getDniDocente() {
        return dniDocente;
    }

    public void setDniDocente(int dniDocente) {
        this.dniDocente = dniDocente;
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

    public Time getHoraFin() {
        return horaFin;
    }

    public void setHoraFin(Time horaFin) {
        this.horaFin = horaFin;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    public Date getDia() {
        return dia;
    }

    public void setDia(Date dia) {
        this.dia = dia;
    }
    
    
}

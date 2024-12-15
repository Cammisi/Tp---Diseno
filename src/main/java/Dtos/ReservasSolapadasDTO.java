
package Dtos;

import Clases.Aula;
import java.sql.Time;


public class ReservasSolapadasDTO {
    private Aula aula;
    private String nombreDocente;
    private String catedra;
    private String email;
    private Time horaInicio;
    private Time horaFin;

    public ReservasSolapadasDTO(Aula aula, String nombreDocente, String catedra, String email, Time horaInicio, Time horaFin) {
        this.aula = aula;
        this.nombreDocente = nombreDocente;
        this.catedra = catedra;
        this.email = email;
        this.horaInicio = horaInicio;
        this.horaFin = horaFin;
    }

    public ReservasSolapadasDTO() {
    }

    public Aula getAula() {
        return aula;
    }

    public void setAula(Aula aula) {
        this.aula = aula;
    }

    public String getNombreDocente() {
        return nombreDocente;
    }

    public void setNombreDocente(String nombreDocente) {
        this.nombreDocente = nombreDocente;
    }

    public String getCatedra() {
        return catedra;
    }

    public void setCatedra(String catedra) {
        this.catedra = catedra;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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
    
    
    
    
}

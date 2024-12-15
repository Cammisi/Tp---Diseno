
package Dtos;

import Clases.Aula;
import java.sql.Time;
import java.util.Date;


public class ReservaDTO {
    private Date dia;
    private Time horaInicio;
    private int duracion;
    private int CantidadAlumnos;
    private String catedra;
    private String docente;
    private String tipoAula;
    private String email;
    private Aula aula;
    private String bedel;

    public ReservaDTO(Date dia, Time horaInicio, int duracion, int CantidadAlumnos, String catedra, String docente, String tipoAula, String email, Aula aula) {
        this.dia = dia;
        this.horaInicio = horaInicio;
        this.duracion = duracion;
        this.CantidadAlumnos = CantidadAlumnos;
        this.catedra = catedra;
        this.docente = docente;
        this.tipoAula = tipoAula;
        this.email = email;
        this.aula = aula;  
    }

    public ReservaDTO() {
    }

    public String getBedel() {
        return bedel;
    }

    public void setBedel(String bedel) {
        this.bedel = bedel;
    }
    
    

    public Date getDia() {
        return dia;
    }

    public void setDia(Date dia) {
        this.dia = dia;
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

    public int getCantidadAlumnos() {
        return CantidadAlumnos;
    }

    public void setCantidadAlumnos(int CantidadAlumnos) {
        this.CantidadAlumnos = CantidadAlumnos;
    }

    public String getCatedra() {
        return catedra;
    }

    public void setCatedra(String catedra) {
        this.catedra = catedra;
    }

    public String getDocente() {
        return docente;
    }

    public void setDocente(String docente) {
        this.docente = docente;
    }

    public String getTipoAula() {
        return tipoAula;
    }

    public void setTipoAula(String tipoAula) {
        this.tipoAula = tipoAula;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Aula getAula() {
        return aula;
    }

    public void setAula(Aula aula) {
        this.aula = aula;
    }
    
    
    
    
}

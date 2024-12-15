
package Clases;

import java.util.Date;
import java.util.ArrayList;

public abstract class Reserva {
    private int idReserva;
    private Bedel bedel;
    private int dniDocente;
    private ArrayList<Dia> dias;
    private String nombreDocente;
    private String apellidoDocente;
    private String emailDocente;
    private Date fechaCreacion;
    
    public Reserva(){
        
    }
    
    public Reserva(int idReserva, int dniDocente, String nombreDocente, String apellidoDocente, String emailDocente, Date fechaCreacion) {
        this.idReserva = idReserva;
        this.dniDocente = dniDocente;
        this.nombreDocente = nombreDocente;
        this.apellidoDocente = apellidoDocente;
        this.emailDocente = emailDocente;
        this.fechaCreacion = fechaCreacion;
        
    }
    
    public void inicializarDias(){
        this.dias = new ArrayList<>();
    }
    
    public int getIdReserva() {
        return idReserva;
    }


    public Bedel getBedel() {
        return bedel;
    }

    public void setBedel(Bedel bedel) {
        this.bedel = bedel;
    }

    public ArrayList<Dia> getDias() {
        return dias;
    }

    public void setDias(ArrayList<Dia> dias) {
        this.dias = dias;
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

    public void setDiaEspecifico(Dia dia){
        dias.add(dia);
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

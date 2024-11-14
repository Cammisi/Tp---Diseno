
package Clases;

import java.sql.Date;

public class Periodica extends Reserva{
    private Periodo unPeriodo;

    public Periodica(Periodo unPeriodo, int idReserva, int cantidadAlumnos, int idActividad, String nombreActividad, int dniDocente, String nombreDocente, String apellidoDocente, String emailDocente, Date fechaCreacion) {
        super(idReserva, cantidadAlumnos, idActividad, nombreActividad, dniDocente, nombreDocente, apellidoDocente, emailDocente, fechaCreacion);
        this.unPeriodo = unPeriodo;
    }

    public Periodo getUnPeriodo() {
        return unPeriodo;
    }

    public void setUnPeriodo(Periodo unPeriodo) {
        this.unPeriodo = unPeriodo;
    }
    
    
}

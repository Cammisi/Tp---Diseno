
package Dtos;

public class BedelDTO {
    private String nombre;
    private String apellido;
    private String turno;
    private String nombreUsuario;

    // Constructor
    public BedelDTO(String nombre, String apellido, String turno, String nombreUsuario) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.turno = turno;
        this.nombreUsuario = nombreUsuario;
    }

    // Getters y Setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getTurno() {
        return turno;
    }

    public void setTurno(String turno) {
        this.turno = turno;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }
}

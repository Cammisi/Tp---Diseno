
package Clases;


public class Bedel extends Usuario{
    private String turno;
    private boolean eliminado;

    public Bedel(String turno, boolean eliminado, String nombre, String apellido, String nombreUsuario, String contrasenia) {
        super(nombre, apellido, nombreUsuario, contrasenia);
        this.turno = turno;
        this.eliminado = eliminado;
    }
    
    public Bedel(String nombre, String apellido, String nombreUsuario, String turno){
        super(nombre,apellido,nombreUsuario);
        this.turno = turno;
    }
    
    public String getTurno() {
        return turno;
    }

    public void setTurno(String turno) {
        this.turno = turno;
    }

    public boolean isEliminado() {
        return eliminado;
    }

    public void setEliminado(boolean eliminado) {
        this.eliminado = eliminado;
    }
}

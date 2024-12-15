
package Dtos;

public class AulaDTO {
   
    private int capacidad;
    private int numero; 
    private int piso;
    private String disponible;
    private String tipo;

    public AulaDTO(int capacidad, int numero, int piso, String disponible, String tipo) {
        this.capacidad = capacidad;
        this.numero = numero;
        this.piso = piso;
        this.disponible = disponible;
        this.tipo = tipo;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public int getPiso() {
        return piso;
    }

    public void setPiso(int piso) {
        this.piso = piso;
    }

    public String getDisponible() {
        return disponible;
    }

    public void setDisponible(String disponible) {
        this.disponible = disponible;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    
    
}


package Clases;

public abstract class Aula {
    private int capacidad;
    private int numero; 
    private int piso;
    private boolean disponible;

    public Aula(){
        
    }
    
    public Aula(int capacidad, int numero, int piso, boolean disponible) {
        this.capacidad = capacidad;
        this.numero = numero;
        this.piso = piso;
        this.disponible = disponible;
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

    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }
    
    
    
}

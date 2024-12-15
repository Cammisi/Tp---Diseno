
package Clases;

public class AulaSinRecursos extends Aula{
    private String tipoDePizarron;
    private boolean aireAcondicionado;
    private boolean ventiladores;
    

    public AulaSinRecursos(){
        
    }
    
    public AulaSinRecursos(String tipoDePizarron, boolean aireAcondicionado, boolean ventiladores, int capacidad, int numero, int piso, boolean disponible) {
        super(capacidad, numero, piso, disponible);
        this.tipoDePizarron = tipoDePizarron;
        this.aireAcondicionado = aireAcondicionado;
        this.ventiladores = ventiladores;
    }

    
    
    
    public String getTipoDePizarron() {
        return tipoDePizarron;
    }
    
    public void setTipoDePizarron(String tipoDePizarron) {
        this.tipoDePizarron = tipoDePizarron;
    }

    public boolean isAireAcondicionado() {
        return aireAcondicionado;
    }

    public void setAireAcondicionado(boolean aireAcondicionado) {
        this.aireAcondicionado = aireAcondicionado;
    }

    public boolean isVentiladores() {
        return ventiladores;
    }

    public void setVentiladores(boolean ventiladores) {
        this.ventiladores = ventiladores;
    }
    
    
}


package Clases;

public class AulaMultimedios extends Aula{
    private boolean televisor;
    private boolean canon;
    private boolean computadora;
    private String tipoDePizarron;
    private boolean aireAcondicionado;
    private boolean ventiladores;

    public AulaMultimedios(boolean televisor, boolean canon, boolean computadora, String tipoDePizarron, boolean aireAcondicionado, boolean ventiladores, int capacidad, int numero, int piso, boolean disponible) {
        super(capacidad, numero, piso, disponible);
        this.televisor = televisor;
        this.canon = canon;
        this.computadora = computadora;
        this.tipoDePizarron = tipoDePizarron;
        this.aireAcondicionado = aireAcondicionado;
        this.ventiladores = ventiladores;
    }

    public boolean isTelevisor() {
        return televisor;
    }

    public void setTelevisor(boolean televisor) {
        this.televisor = televisor;
    }

    public boolean isCanon() {
        return canon;
    }

    public void setCanon(boolean canon) {
        this.canon = canon;
    }

    public boolean isComputadora() {
        return computadora;
    }

    public void setComputadora(boolean computadora) {
        this.computadora = computadora;
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

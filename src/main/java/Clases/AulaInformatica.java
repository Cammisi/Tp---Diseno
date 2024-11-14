
package Clases;

public class AulaInformatica extends Aula{
    private int cantidadDePcs;
    private String tipoDePizarron;
    private boolean canon;
    private boolean aireAcondicionado;

    public AulaInformatica(int cantidadDePcs, String tipoDePizarron, boolean canon, boolean aireAcondicionado, int capacidad, int numero, int piso, boolean disponible) {
        super(capacidad, numero, piso, disponible);
        this.cantidadDePcs = cantidadDePcs;
        this.tipoDePizarron = tipoDePizarron;
        this.canon = canon;
        this.aireAcondicionado = aireAcondicionado;
    }

    public int getCantidadDePcs() {
        return cantidadDePcs;
    }

    public void setCantidadDePcs(int cantidadDePcs) {
        this.cantidadDePcs = cantidadDePcs;
    }

    public String getTipoDePizarron() {
        return tipoDePizarron;
    }

    public void setTipoDePizarron(String tipoDePizarron) {
        this.tipoDePizarron = tipoDePizarron;
    }

    public boolean isCanon() {
        return canon;
    }

    public void setCanon(boolean canon) {
        this.canon = canon;
    }

    public boolean isAireAcondicionado() {
        return aireAcondicionado;
    }

    public void setAireAcondicionado(boolean aireAcondicionado) {
        this.aireAcondicionado = aireAcondicionado;
    }
    
    
}

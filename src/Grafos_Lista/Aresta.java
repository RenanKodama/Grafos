
package Grafos_Lista;

public class Aresta {
    private Vertice_BL destinoBL;
    private Vertice_BP destinoBP;
    private Vertice_AGM destinoAGM;
    private Double peso;

    
    public Vertice_AGM getDestinoAGM() {
        return destinoAGM;
    }

    public void setDestinoAGM(Vertice_AGM destinoAGM) {
        this.destinoAGM = destinoAGM;
    }
    
    public Vertice_BL getDestinoBL() {
        return destinoBL;
    }

    public void setDestinoBL(Vertice_BL destinoBL) {
        this.destinoBL = destinoBL;
    }

    public Vertice_BP getDestinoBP() {
        return destinoBP;
    }

    public void setDestinoBP(Vertice_BP destinoBP) {
        this.destinoBP = destinoBP;
    }

    public Double getPeso() {
        return peso;
    }

    public void setPeso(Double peso) {
        this.peso = peso;
    }

    
    
}
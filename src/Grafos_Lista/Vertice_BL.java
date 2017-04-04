
package Grafos_Lista;

import java.awt.Color;

public class Vertice_BL extends Vertice{
    private Color cor;
    private Double distancia;
    private Vertice predecessor;
    
    public String getNameColor(Color color){
        if(color.equals(Color.WHITE)){
            return "Branco";
        }
        if(color.equals(Color.GRAY)){
            return "Cinza";
        }
        
        if(color.equals(Color.BLACK)){
            return "Preto";
        }        
        return "none";
    }
    
    public Color getCor() {
        return cor;
    }

    public void setCor(Color cor) {
        this.cor = cor;
    }

    public Double getDistancia() {
        return distancia;
    }

    public void setDistancia(Double distancia) {
        this.distancia = distancia;
    }

    public Vertice getPredecessor() {
        return predecessor;
    }

    public void setPredecessor(Vertice predecessor) {
        this.predecessor = predecessor;
    }
}

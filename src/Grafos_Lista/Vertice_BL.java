package Grafos_Lista;

import java.awt.Color;

public class Vertice_BL {
    private String id;
    private Color cor;
    private Double distancia;
    private Vertice_BL predecessor;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNameColor(Color color) {
        if (color.equals(Color.WHITE)) {
            return "Branco";
        }
        if (color.equals(Color.GRAY)) {
            return "Cinza";
        }

        if (color.equals(Color.BLACK)) {
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

    public Vertice_BL getPredecessor() {
        return predecessor;
    }

    public void setPredecessor(Vertice_BL predecessor) {
        this.predecessor = predecessor;
    }
}

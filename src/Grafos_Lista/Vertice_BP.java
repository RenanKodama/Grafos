package Grafos_Lista;

import java.awt.Color;

public class Vertice_BP {

    private String id;
    private Color cor;
    private int tempo_inicial;
    private int tempo_final;
    private Vertice_BP predecessor;

    public String getId() {
        return id;
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

    public void setId(String id) {
        this.id = id;
    }

    public Color getCor() {
        return cor;
    }

    public void setCor(Color cor) {
        this.cor = cor;
    }

    public Vertice_BP getPredecessor() {
        return predecessor;
    }

    public void setPredecessor(Vertice_BP predecessor) {
        this.predecessor = predecessor;
    }

    public int getTempo_inicial() {
        return tempo_inicial;
    }

    public void setTempo_inicial(int tempo_inicial) {
        this.tempo_inicial = tempo_inicial;
    }

    public int getTempo_final() {
        return tempo_final;
    }

    public void setTempo_final(int tempo_final) {
        this.tempo_final = tempo_final;
    }

}

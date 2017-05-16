package Grafos_Lista;


public class Vertice_AGM {

    private String id;
    private Vertice_AGM predecessor;
    private double chave;

    
    public double getChave() {
        return chave;
    }

    public void setChave(double chave) {
        this.chave = chave;
    }
    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Vertice_AGM getPredecessor() {
        return predecessor;
    }

    public void setPredecessor(Vertice_AGM predecessor) {
        this.predecessor = predecessor;
    }
    
    
    
}

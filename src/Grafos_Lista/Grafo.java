
package Grafos_Lista;

import java.util.ArrayList;
import java.util.HashMap;

public class Grafo {

    private HashMap<String, ArrayList<Aresta>> map = new HashMap<>();
    private ArrayList<Vertice_BP> Queue;
    private int tempo;

    public void incrementaTempo(){
        this.tempo++;
    }
    
    public int getTempo() {
        return tempo;
    }

    public void setTempo(int tempo) {
        this.tempo = tempo;
    }
    
    public void initQueue(){
        this.Queue = new ArrayList<>();
    }
    
    public ArrayList<Vertice_BP> getQueue() {
        return Queue;
    }

    public void setQueue(ArrayList<Vertice_BP> Queue) {
        this.Queue = Queue;
    }
    
    
    public HashMap<String, ArrayList<Aresta>> getMap() {
        return map;
    }

    public void setMap(HashMap<String, ArrayList<Aresta>> map) {
        this.map = map;
    }

}

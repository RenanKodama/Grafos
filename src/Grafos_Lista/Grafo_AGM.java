package Grafos_Lista;

import java.util.ArrayList;
import java.util.HashMap;

public class Grafo_AGM {

    private HashMap<String, ArrayList<Aresta>> map_AGM = new HashMap<>();

    public HashMap<String, ArrayList<Aresta>> getMap() {
        return this.map_AGM;
    }

    public void setMap(HashMap<String, ArrayList<Aresta>> map_AGM) {
        this.map_AGM = map_AGM;
    }
}

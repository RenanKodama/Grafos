
package Grafos_Lista;

import java.util.ArrayList;
import java.util.HashMap;

public class Grafo {
    private HashMap<String, ArrayList<Aresta>> map = new HashMap<>();
    
    public HashMap<String, ArrayList<Aresta>> getMap() {
        return map;
    }

    public void setMap(HashMap<String, ArrayList<Aresta>> map) {
        this.map = map;
    }

}

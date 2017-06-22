
package AGM;

import java.util.ArrayList;
import java.util.HashMap;


public class ListAdjAGM implements GrafoAGM<VerticeAGM, ArestaAGM<VerticeAGM, VerticeAGM>> {

    HashMap<VerticeAGM, ArrayList<VerticeAGM>> map = new HashMap<>();

    @Override
    public ArrayList<VerticeAGM> getVerticesAdjacentes(VerticeAGM u) {
        if (u != null && this.map.containsKey(u)) {
            return this.map.get(u);
        } else {
            return null;
        }
    }

    @Override
    public ArrayList<VerticeAGM> getVertices() {//funcionando
        ArrayList<VerticeAGM> keys = new ArrayList<>();
        ArrayList<VerticeAGM> listVertices = new ArrayList<>();
        try {
            keys.addAll(map.keySet());

            for (int i = 0; i < keys.size(); i++) {
                listVertices.addAll(map.get(keys.get(i)));
            }

            listVertices.addAll(keys);

            return listVertices;
        } finally {
            keys = null;
            listVertices = null;
        }
    }

    @Override
    public ArrayList<ArestaAGM<VerticeAGM, VerticeAGM>> getArestas() {
        ArrayList<ArestaAGM<VerticeAGM, VerticeAGM>> list = new ArrayList<>();
        ArrayList<VerticeAGM> keys = new ArrayList<>();

        try {
            keys.addAll(this.map.keySet());
            ArrayList<VerticeAGM> vertices = null;
            for (int i = 0; i < keys.size(); i++) {
                vertices = this.map.get(keys.get(i));
                for (int j = 0; j < vertices.size(); j++) {
                    ArestaAGM a = new ArestaAGM(new VerticeAGM(keys.get(i).getId()), new VerticeAGM(vertices.get(j).getId()));
                    if (a != null) {
                        list.add(a);
                    }
                }
            }
            return list;
        } finally {
            list = null;
            keys = null;
        }
    }

    @Override
    public VerticeAGM getVertice(String id) { //funcionando
        ArrayList<VerticeAGM> keys = new ArrayList<>();
        ArrayList<VerticeAGM> listVertices;
        try {
            keys.addAll(map.keySet());

            for (int i = 0; i < keys.size(); i++) {
                if (keys.get(i).getId().equals(id)) {
                    return keys.get(i);
                }
            }

            listVertices = new ArrayList<>();

            for (int i = 0; i < keys.size(); i++) {
                listVertices.addAll(map.get(keys.get(i)));
                for (int j = 0; j < listVertices.size(); j++) {
                    if (listVertices.get(j).getId().equals(id)) {
                        return listVertices.get(j);
                    }
                }
                listVertices.clear();
            }
            return null;
        } finally {
            keys = null;
            listVertices = null;
        }
    }
    
     //Adciona um vertice no grafo, sem ligação com outro vertice
     // Cria uma chave para o vertice que leva a um arraylist de vertice adjacentes
     
    @Override
    public void adicionaVertice(VerticeAGM verticeNoGrafo, VerticeAGM verticeAdicionado) {//funcionando
        if (verticeNoGrafo != null && verticeAdicionado != null && this.map.containsKey(verticeNoGrafo)) {
            this.map.get(verticeNoGrafo).add(verticeAdicionado);
        }
    }

    @Override
    public void adicionaVertice(VerticeAGM verticeAdicionado) {//funcionando
        if (!map.containsKey(verticeAdicionado)) {
            this.map.put(verticeAdicionado, new ArrayList<>());
        } else {
            System.out.println("Vertice ja existente");
        }
    }

    @Override
    public void adicionaAresta(ArestaAGM<VerticeAGM, VerticeAGM> arestaAdicionada) {
        if (map.containsKey(arestaAdicionada.getVertice1())) {
            if (map.get(arestaAdicionada.getVertice1()).contains(arestaAdicionada.getVertice2()))
            {
                System.out.println("O grafo já contem o vertice especificado");
            } else {
                map.get(arestaAdicionada.getVertice1()).add(arestaAdicionada.getVertice2());
            }
        } else {
            ArrayList<VerticeAGM> list = new ArrayList<>();
            list.add(arestaAdicionada.getVertice2());
            map.put(arestaAdicionada.getVertice1(), list);
            list = null;
        }
    }

}

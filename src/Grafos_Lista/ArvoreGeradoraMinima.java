package Grafos_Lista;

import java.util.ArrayList;
import java.util.HashMap;
import static jdk.nashorn.internal.objects.Global.Infinity;

public class ArvoreGeradoraMinima {

    HashMap<String, ArrayList<Aresta>> conjuntoA;

    public void iniciaConuntoA() {
        this.conjuntoA = new HashMap<>();
    }

    public Aresta extrairMinimo() {
        Aresta arMin = new Aresta();

        arMin.getDestinoAGM().setChave(Double.NEGATIVE_INFINITY);

        for (String str : this.conjuntoA.keySet()) {
            for (Aresta ar : this.conjuntoA.get(str)) {
                if (arMin.getPeso() <= ar.getPeso()) {
                    arMin = ar;
                }
            }
        }
        return arMin;
    }

    public boolean conjuntoAContaisV(Aresta ar) {
        for (String str : this.conjuntoA.keySet()) {
            for (Aresta ar1 : this.conjuntoA.get(str)) {
                if (ar1.getDestinoAGM().getId().equals(ar.getDestinoAGM().getId())) {
                    return true;
                }
            }
        }
        return false;
    }

    public void algoritmoDePrim(HashMap<String, ArrayList<Aresta>> map, Aresta arestaInicial) {
        iniciaConuntoA();
        for (String str : map.keySet()) {
            for (Aresta ar : map.get(str)) {
                ar.getDestinoAGM().setChave(Infinity);
                ar.getDestinoAGM().setPredecessor(null);

                if (arestaInicial.getDestinoAGM().getId().equals(ar.getDestinoAGM().getId())) {
                    ar.getDestinoAGM().setChave(0.0);
                }
            }
        }
        this.conjuntoA = map;

        while (!conjuntoA.isEmpty()) {
            Aresta u = extrairMinimo();

            for (Aresta ar : map.get(u.getDestinoAGM().getId())) {
                if (ar.getPeso() != -1) {
                    if (conjuntoAContaisV(ar) && ar.getDestinoAGM().getId().equals(ar.getDestinoAGM().getId()) && ar.getPeso() < ar.getDestinoAGM().getChave()) {
                        ar.getDestinoAGM().setPredecessor(u.getDestinoAGM());
                        ar.getDestinoAGM().setChave(ar.getPeso());
                    }
                }
            }
        }
    }

//    public boolean isArvoreGeradoraMinima(HashMap<String, ArrayList<Aresta>> map) {
//        return this.conjuntoA.size() == map.values().size();
//    }
}

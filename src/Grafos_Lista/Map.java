package Grafos_Lista;

import java.awt.Color;
import java.util.ArrayList;

public class Map {

    public void insereMap(Grafo grafo, ArrayList<Transicoes> transicoes) {
        //Adiciona os vertices key no map
        for (int i = 0; i < transicoes.size(); i++) {
            ArrayList<Aresta> aresta = new ArrayList<>();
            grafo.getMap().put(transicoes.get(i).getOrigem(), aresta);
        }
        for (int i = 0; i < transicoes.size(); i++) {
            ArrayList<Aresta> aresta = new ArrayList<>();
            grafo.getMap().put(transicoes.get(i).getDestino(), aresta);
        }
        
        //Adiciona o caminho que leva cada vertice
        for (int i = 0; i < transicoes.size(); i++) {
            Aresta aresta = new Aresta();
            Vertice_BP vertice = new Vertice_BP();

            vertice.setId(transicoes.get(i).getDestino());
            vertice.setCor(Color.PINK);
            aresta.setPeso(transicoes.get(i).getPeso());
            aresta.setDestino(vertice);

            grafo.getMap().get(transicoes.get(i).getOrigem()).add(aresta);
        }
        verMap(grafo);
    }

    public void removeMapVertice(Grafo grafo, String id, Double peso) {
        Vertice_BP vertice = new Vertice_BP();
        Aresta aresta = new Aresta();

        vertice.setId(id);
        aresta.setDestino(vertice);
        aresta.setPeso(peso);

        //Remove o vetice das keys
        grafo.getMap().remove(id);
        //Remove o vertice do alcance dos vertices keys
        for (ArrayList<Aresta> ar : grafo.getMap().values()) {
            for (int i = 0; i < ar.size(); i++) {
                if (ar.get(i).getDestino().getId().equals(aresta.getDestino().getId())) {
                    ar.remove(i);
                }
            }
        }
        System.out.println("Remoçao do vertice " + vertice.getId());
        verMap(grafo);
    }

    public void verMap(Grafo grafo) {
        //Print_results
        System.out.println("Keys: " + grafo.getMap().keySet());

        System.out.println("Content[" + grafo.getMap().values().size() + "]: ");
        for(String str : grafo.getMap().keySet()){
            System.out.print("\t"+str+"-->\t");
            for (Aresta ar : grafo.getMap().get(str)) {
                System.out.print(ar.getDestino().getId()+"<"+ar.getDestino().getNameColor(ar.getDestino().getCor())+">"+" ");
            }
            System.out.println("");
        }
        System.out.println("EndContent\n");
        
    }
    
}

package Grafos_Lista;

import java.awt.Color;
import java.util.ArrayList;

public class BuscaProfundidade {

    public void buscaProfundidade_Init(Grafo grafo) {
        
        for (ArrayList<Aresta> ar : grafo.getMap().values()) {
            for (int i = 0; i < ar.size(); i++) {
                ar.get(i).getDestino().setCor(Color.WHITE);
                ar.get(i).getDestino().setPredecessor(null);
            }
        }
        grafo.setTempo(0);
        
        //Se branco chamar a funçao buscaProfundidade
        for (ArrayList<Aresta> ar : grafo.getMap().values()) {
            for (int i = 0; i < ar.size(); i++) {
                  if(ar.get(i).getDestino().getCor().equals(Color.WHITE));
                    //Chamada da funçao
            }
        }    
    }
    
    public void buscaProfundidade(Grafo grafo,Aresta aresta){
        grafo.incrementaTempo();
        
        aresta.getDestino().setTempo_inicial(grafo.getTempo());
        aresta.getDestino().setCor(Color.GRAY);
        
        //for(grafo){
            
        //}
    }
}

package Grafos_Lista;

import java.awt.Color;
import java.util.ArrayList;
import static jdk.nashorn.internal.objects.Global.Infinity;

public class BuscaLargura {
    public void buscaLargura_init(Grafo grafo,Vertice_BL vertice){       
        //Setando todos os vertices menos o inicial como:
        //brancos, distancia nula e sem predecessor
        for (String str : grafo.getMap().keySet()) {
            for (Aresta ar : grafo.getMap().get(str)) {
                if(!ar.getDestino().getId().equals(vertice.getId())){
                    ar.getDestino().setCor(Color.WHITE);
                    ar.getDestino().setDistancia(Infinity);
                    ar.getDestino().setPredecessor(null);
                }
            }
        }
        //Setando o vertice inicial como:
        //cinza, distancia 0 e sem predecessor
        Vertice_BP verticeInicial = new Vertice_BP();
        
        for (String str : grafo.getMap().keySet()) {
            for (Aresta ar : grafo.getMap().get(str)) {
                if(ar.getDestino().getId().equals(vertice.getId())){
                    ar.getDestino().setCor(Color.GRAY);
                    ar.getDestino().setDistancia(0.0);
                    ar.getDestino().setPredecessor(null);
                    verticeInicial = ar.getDestino();
                }
            }
        }
        
        //Inicializar a Fila e Adicionar o elemento
        grafo.initQueue();
        grafo.getQueue().add(verticeInicial);
        
        System.out.println("\tInicializaçao_BL");
        Map map = new Map();
        map.verMap(grafo);
        
        //Debug para a queue
        /*System.out.println("FilaContent: ");
        System.out.println("\t"+grafo.getQueue().get(0).getId()+"["+grafo.getQueue().get(0).getNameColor(grafo.getQueue().get(0).getCor())+"]");
        System.out.println("EndFilaContent");*/
    }
    
    public void buscaLargura(Grafo grafo) {
        Map map = new Map();
        
        while (!grafo.getQueue().isEmpty()) {
            Vertice_BP vertice;

            vertice = grafo.getQueue().remove(0);

            for (Aresta ar : grafo.getMap().get(vertice.getId())) {
                //Pintar somente os valores referente a key
                if (ar.getDestino().getCor().equals(Color.WHITE)) {
                    ar.getDestino().setCor(Color.GRAY);
                    ar.getDestino().setDistancia(vertice.getDistancia() + 1);
                    ar.getDestino().setPredecessor(vertice);
                    grafo.getQueue().add(ar.getDestino());
                    
                    //Pintar os demais valores do map tambem
                    for (ArrayList<Aresta> ar1 : grafo.getMap().values()) {
                        for (Aresta ar2 : ar1) {
                            if(ar2.getDestino().getId().equals(ar.getDestino().getId())){
                                ar2.setDestino(ar.getDestino());
                            }
                        
                        }
                    }
                }
            }

            vertice.setCor(Color.BLACK);
           
            for (ArrayList<Aresta> ar : grafo.getMap().values()) {
                for (Aresta ar1 : ar) {
                    if(vertice.getId().equals(ar1.getDestino().getId())){
                        ar1.setDestino(vertice);
                    }
                }
            }
            
            //Debug step by step do busca em largura
            /*map.verMap(grafo);*/
        }
        
        System.out.println("\tTermino_BL");
        map.verMap(grafo);
    }
}

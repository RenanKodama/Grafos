
package Grafos_Lista;

import java.util.ArrayList;


public class Principal {

    public static void main(String[] args) {
        Grafo grafo = new Grafo();
        Map map = new Map();
        ArrayList<Transicoes> transicoes = new ArrayList<>();
        
        Transicoes aux0 = new Transicoes();
        Transicoes aux1 = new Transicoes();
        Transicoes aux2 = new Transicoes();
        Transicoes aux3 = new Transicoes();
        Transicoes aux4 = new Transicoes();
         
        aux0.setOrigem("A");
        aux0.setDestino("B");
        aux0.setPeso(1.00);
        
        aux1.setOrigem("B");
        aux1.setDestino("C");
        aux1.setPeso(1.00);

        aux2.setOrigem("C");
        aux2.setDestino("B");
        aux2.setPeso(1.00);
        
        aux3.setOrigem("C");
        aux3.setDestino("D");
        aux3.setPeso(1.00);
        
        aux4.setOrigem("D");
        aux4.setDestino("A");
        aux4.setPeso(1.00);
        
        transicoes.add(aux0);
        transicoes.add(aux1);
        transicoes.add(aux2);
        transicoes.add(aux3);
        transicoes.add(aux4);
        
        System.out.println("Transiçoes");
        for(int i=0;i<transicoes.size();i++){
            System.out.print(transicoes.get(i).getOrigem()+" ");
            System.out.print(transicoes.get(i).getPeso()+" ");
            System.out.println(transicoes.get(i).getDestino());
        }
        System.out.println("");
        
        map.insereMap(grafo, transicoes);
        //map.removeMapVertice(grafo,"C",1.00);
        
        BuscaLargura bL = new BuscaLargura();
        
        Vertice_BL verticeInitial = new Vertice_BL();
        verticeInitial.setId("A");
        
        bL.buscaLargura_init(grafo, verticeInitial);
        bL.buscaLargura(grafo);
    }
    
}

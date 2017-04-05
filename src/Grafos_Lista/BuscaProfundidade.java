package Grafos_Lista;

import java.awt.Color;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class BuscaProfundidade {

    private int tempo;
    
    public void buscaInacessiveis(Grafo grafo){

    }

    public void buscaProfundidade_Init(Grafo grafo) {
        for (ArrayList<Aresta> ar : grafo.getMap().values()) {
            for (int i = 0; i < ar.size(); i++) {
                Vertice_BP verticeBP = new Vertice_BP();

                verticeBP.setId("null");
                ar.get(i).getDestinoBP().setCor(Color.WHITE);
                ar.get(i).getDestinoBP().setPredecessor(verticeBP);
            }
        }

        setTempo(0);
        //Se branco chamar a funçao buscaProfundidade
        for (ArrayList<Aresta> ar : grafo.getMap().values()) {
            for (int i = 0; i < ar.size(); i++) {
                if (ar.get(i).getDestinoBP().getCor().equals(Color.WHITE)) {
                    buscaProfundidade(grafo, ar.get(i));
                }

            }
        }
    }

    public void buscaProfundidade(Grafo grafo, Aresta aresta) {
        incrementaTempo();
        aresta.getDestinoBP().setTempo_inicial(getTempo());
        aresta.getDestinoBP().setCor(Color.GRAY);
        
        for(ArrayList<Aresta> ar1 : grafo.getMap().values()){
            for(Aresta ar2 : ar1){
                if(ar2.getDestinoBP().getId().equals(aresta.getDestinoBP().getId())){
                    ar2.setDestinoBP(aresta.getDestinoBP());
                }
            }
        }
        
        for (Aresta ar : grafo.getMap().get(aresta.getDestinoBP().getId())) {
            if (ar.getDestinoBP().getCor().equals(Color.WHITE)) {
                ar.getDestinoBP().setPredecessor(aresta.getDestinoBP());
                buscaProfundidade(grafo, ar);

            }
        }

        aresta.getDestinoBP().setCor(Color.BLACK);
        incrementaTempo();
        aresta.getDestinoBP().setTempo_final(getTempo());

        verBuscaP(grafo);
    }

    public void removeBLVertice(Grafo grafo, String id, Double peso) {
        Vertice_BP vertice = new Vertice_BP();
        Aresta aresta = new Aresta();

        vertice.setId(id);
        aresta.setDestinoBP(vertice);
        aresta.setPeso(peso);

        //Remove o vetice das keys
        grafo.getMap().remove(id);
        //Remove o vertice do alcance dos vertices keys
        for (ArrayList<Aresta> ar : grafo.getMap().values()) {
            for (int i = 0; i < ar.size(); i++) {
                if (ar.get(i).getDestinoBP().getId().equals(aresta.getDestinoBP().getId())) {
                    ar.remove(i);
                }
            }
        }
        System.out.println("Remoçao do vertice " + vertice.getId());
        verBuscaP(grafo);
    }

    private void incrementaTempo() {
        this.tempo++;
    }

    public int getTempo() {
        return tempo;
    }

    public void setTempo(int tempo) {
        this.tempo = tempo;
    }

    public void verBuscaP(Grafo grafo) {
        //Print_results
        System.out.println("Keys: " + grafo.getMap().keySet());

        System.out.println("Content[" + grafo.getMap().values().size() + "]: ");
        for (String str : grafo.getMap().keySet()) {
            System.out.print("\t" + str + "-->\t");
            for (Aresta ar : grafo.getMap().get(str)) {
                System.out.print(ar.getDestinoBP().getId() + "<"
                        + ar.getDestinoBP().getNameColor(ar.getDestinoBP().getCor()) + ">" + " ");
                //"("
                //+ ar.getDestinoBP().getPredecessor().getId() + ")");
            }
            System.out.println("");
        }
        System.out.println("EndContent\n");

    }
    
    public void verInacessiveis(Grafo grafo, ArrayList<Transicoes> transicoes) {
        Set<String> set = new HashSet<>();
        
        System.out.println("Inacessiveis");
        for(Transicoes ar1 : transicoes){
            set.add(ar1.getOrigem());
        }
        
        //VARRER VALUES DE MAP E IR COMPARANDO COM O SET
        
        System.out.println(set.toString());
        System.out.println();
        
    }
    
    public void insereBP(Grafo grafo, ArrayList<Transicoes> transicoes) {
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
            aresta.setDestinoBP(vertice);

            grafo.getMap().get(transicoes.get(i).getOrigem()).add(aresta);
        }
        //verBuscaP(grafo);
        verInacessiveis(grafo, transicoes);
    }

}

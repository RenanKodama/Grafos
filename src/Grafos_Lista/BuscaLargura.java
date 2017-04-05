package Grafos_Lista;

import java.awt.Color;
import java.util.ArrayList;
import static jdk.nashorn.internal.objects.Global.Infinity;

public class BuscaLargura {

    private ArrayList<Vertice_BL> Queue;

    public void insereBL(Grafo grafo, ArrayList<Transicoes> transicoes) {
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
            Vertice_BL vertice = new Vertice_BL();

            vertice.setId(transicoes.get(i).getDestino());
            vertice.setCor(Color.PINK);
            aresta.setPeso(transicoes.get(i).getPeso());
            aresta.setDestinoBL(vertice);

            grafo.getMap().get(transicoes.get(i).getOrigem()).add(aresta);
        }
        verBuscaL(grafo);
    }

    public void removeBLVertice(Grafo grafo, String id, Double peso) {
        Vertice_BL vertice = new Vertice_BL();
        Aresta aresta = new Aresta();

        vertice.setId(id);
        aresta.setDestinoBL(vertice);
        aresta.setPeso(peso);

        //Remove o vetice das keys
        grafo.getMap().remove(id);
        //Remove o vertice do alcance dos vertices keys
        for (ArrayList<Aresta> ar : grafo.getMap().values()) {
            for (int i = 0; i < ar.size(); i++) {
                if (ar.get(i).getDestinoBL().getId().equals(aresta.getDestinoBL().getId())) {
                    ar.remove(i);
                }
            }
        }
        System.out.println("Remoçao do vertice " + vertice.getId());
        verBuscaL(grafo);
    }

    public void buscaLargura_init(Grafo grafo, Vertice_BL vertice) {
        //Setando todos os vertices menos o inicial como:
        //brancos, distancia nula e sem predecessor
        for (String str : grafo.getMap().keySet()) {
            for (Aresta ar : grafo.getMap().get(str)) {
                if (!ar.getDestinoBL().getId().equals(vertice.getId())) {
                    ar.getDestinoBL().setCor(Color.WHITE);
                    ar.getDestinoBL().setDistancia(Infinity);
                    ar.getDestinoBL().setPredecessor(null);
                }
            }
        }
        //Setando o vertice inicial como:
        //cinza, distancia 0 e sem predecessor
        Vertice_BL verticeInicial = new Vertice_BL();

        for (String str : grafo.getMap().keySet()) {
            for (Aresta ar : grafo.getMap().get(str)) {
                if (ar.getDestinoBL().getId().equals(vertice.getId())) {
                    ar.getDestinoBL().setCor(Color.GRAY);
                    ar.getDestinoBL().setDistancia(0.0);
                    ar.getDestinoBL().setPredecessor(null);
                    verticeInicial = ar.getDestinoBL();
                }
            }
        }

        //Inicializar a Fila e Adicionar o elemento
        initQueue();
        getQueue().add(verticeInicial);

        System.out.println("\tInicializaçao_BL");

        verBuscaL(grafo);

        //Debug para a queue
        System.out.println("FilaContent: ");
        System.out.println("\t"+getQueue().get(0).getId()+"["+getQueue().get(0).getNameColor(getQueue().get(0).getCor())+"]");
        System.out.println("EndFilaContent\n");
    }

    public void buscaLargura(Grafo grafo) {
        verBuscaL(grafo);

        while (!getQueue().isEmpty()) {
            Vertice_BL vertice;

            vertice = getQueue().remove(0);

            for (Aresta ar : grafo.getMap().get(vertice.getId())) {
                //Pintar somente os valores referente a key
                if (ar.getDestinoBL().getCor().equals(Color.WHITE)) {
                    ar.getDestinoBL().setCor(Color.GRAY);
                    ar.getDestinoBL().setDistancia(vertice.getDistancia() + 1);
                    ar.getDestinoBL().setPredecessor(vertice);
                    getQueue().add(ar.getDestinoBL());

                    //Pintar os demais valores do map tambem
                    for (ArrayList<Aresta> ar1 : grafo.getMap().values()) {
                        for (Aresta ar2 : ar1) {
                            if (ar2.getDestinoBL().getId().equals(ar.getDestinoBL().getId())) {
                                ar2.setDestinoBL(ar.getDestinoBL());
                            }

                        }
                    }
                }
            }

            vertice.setCor(Color.BLACK);

            for (ArrayList<Aresta> ar : grafo.getMap().values()) {
                for (Aresta ar1 : ar) {
                    if (vertice.getId().equals(ar1.getDestinoBL().getId())) {
                        ar1.setDestinoBL(vertice);
                    }
                }
            }

            //Debug step by step do busca em largura
            verBuscaL(grafo);
        }

        System.out.println("\tTermino_BL");
        verBuscaL(grafo);
    }
    
    public void initQueue() {
        this.Queue = new ArrayList<>();
    }

    public ArrayList<Vertice_BL> getQueue() {
        return Queue;
    }

    public void setQueue(ArrayList<Vertice_BL> Queue) {
        this.Queue = Queue;
    }

    public void verBuscaL(Grafo grafo) {
        System.out.println("Keys: " + grafo.getMap().keySet());

        System.out.println("Content[" + grafo.getMap().values().size() + "]: ");
        for (String str : grafo.getMap().keySet()) {
            System.out.print("\t" + str + "-->\t");
            for (Aresta ar : grafo.getMap().get(str)) {
                System.out.print(ar.getDestinoBL().getId() + "<" + ar.getDestinoBL().getNameColor(ar.getDestinoBL().getCor()) + ">" + " ");
            }
            System.out.println("");
        }
        System.out.println("EndContent\n");
    }
}

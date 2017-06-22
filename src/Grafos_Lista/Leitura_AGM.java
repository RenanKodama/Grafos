package Grafos_Lista;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Leitura_AGM {

    public void arrumarMatriz(int peso, Double[][] matriz) {

        for (int i = 0; i < peso; i++) {
            for (int j = 0; j < peso; j++) {
                if (i == j) {
                    matriz[i][j] = 0.0;
                }
            }
        }
    }

    public void leituraArquivo(String local) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File(local));
        int qtdLinha;
        String aux[];
        Double matriz[][];
        Double pesoMax;

        aux = scanner.nextLine().split(" ");
        qtdLinha = Integer.parseInt(aux[0]);
        pesoMax = Double.parseDouble(aux[1]);

        System.out.println("Dimensoes: " + qtdLinha + " " + pesoMax);

        while (scanner.hasNext()) {
            matriz = new Double[qtdLinha][qtdLinha];

            for (int i = 0; i < qtdLinha; i++) {
                if (scanner.hasNext()) {

                    aux = scanner.nextLine().split(" ");

                    for (int j = 0; j < aux.length; j++) {
                        if (!aux[j].equals("")) {
                            if ((qtdLinha - 1 - i) == j) {
                                matriz[qtdLinha - 1 - i][j] = 0.0;
                                matriz[j][qtdLinha - 1 - i] = 0.0;

                            } else {
                                matriz[qtdLinha - 1 - i][j] = Double.parseDouble(aux[j]);
                                matriz[j][qtdLinha - 1 - i] = Double.parseDouble(aux[j]);
                            }
                        }

                    }
                    //System.out.println(Arrays.toString(aux));
                }

            }
            arrumarMatriz(qtdLinha, matriz);
            verMatrizEspelhada(qtdLinha, matriz);
            tranformarToList(matriz, qtdLinha, pesoMax);
            //System.out.println("iniciou outro grafo");
        }

    }

    public HashMap<String, ArrayList<Aresta>> tranformarToList(Double[][] matriz, int linha, Double pesomax) {
        HashMap<String, ArrayList<Aresta>> map = new HashMap<>();
        Grafo grafo_agm = new Grafo();

        //adicionando Keys no map
        for (int i = 0; i < linha; i++) {
            for (int j = 0; j < linha; j++) {
                ArrayList<Aresta> ar = new ArrayList<>();
                map.put(Integer.toString(i), ar);
            }
        }

        //adicionando adjacentes
        for (int i = 0; i < linha; i++) {
            for (int j = 0; j < linha; j++) {
                Aresta aresta = new Aresta();
                Vertice_AGM vr = new Vertice_AGM();

                aresta.setPeso(matriz[i][j]);
                vr.setId(Integer.toString(j));
                aresta.setDestinoAGM(vr);

                map.get(Integer.toString(i)).add(aresta);
            }
        }
        
        //criando inalcaçaveis
//        for (String str : map.keySet()) {
//            for (Aresta ar : map.get(str)) {
//                if(ar.getPeso().equals(pesomax)){
//                    ar.setPeso(-1.00);
//                }
//            }
//        }

        grafo_agm.setMap(map);

        //ver HashMap
        int numeroLabels = 0;
        verMap(grafo_agm);
        
        
        
        
        return (map);
    }

    public void verMatrizEspelhada(int linhaMat, Double[][] matriz) {
        System.out.println("Grafo Matriz Espelhada");
        for (int i = 0; i < linhaMat; i++) {
            for (int j = 0; j < linhaMat; j++) {
                System.out.print(matriz[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public void verMap(Grafo grafo_agm) {
        System.out.println("Keys: " + grafo_agm.getMap().keySet());

        System.out.println("Content[" + grafo_agm.getMap().values().size() + "]: ");
        for (String str : grafo_agm.getMap().keySet()) {
            System.out.print("\t" + str + "-->\t");
            for (Aresta ar : grafo_agm.getMap().get(str)) {
                System.out.print(" "
                        + ar.getDestinoAGM().getId() + "<"
                        + ar.getPeso() + ">");
            }
            System.out.println("");
        }
        System.out.println("EndContent\n");

    }
}

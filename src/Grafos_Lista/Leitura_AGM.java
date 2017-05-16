package Grafos_Lista;

import java.awt.Color;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class Leitura_AGM {

    public void leituraArquivo(String local) {
        try {
            String[] aux;
            String linha;
            Double[][] matriz;
            int auxI;
            int auxJ;
            int linhaMat, colunaMat;

            FileReader arq = new FileReader(local);
            BufferedReader lerArq = new BufferedReader(arq);

            aux = lerArq.readLine().split(" ");             //linha01 dimensao
            linhaMat = Integer.parseInt(aux[0]);
            colunaMat = Integer.parseInt(aux[1]);

            System.out.println("Dimensao: " + linhaMat + " " + colunaMat + "\n");

            linha = lerArq.readLine();

            auxI = linhaMat;
            auxJ = 1;
            matriz = new Double[linhaMat][colunaMat];

            while (linha != null) {
                for (int i = 0; i < linhaMat; i++) {
                    if (linha != null) {
                        for (String s : linha.split(" ")) {
                            if (!s.isEmpty()) {
                                if (auxI - 1 == auxJ) {
                                    matriz[auxI - 1][auxJ] = 0.0;     //atribuindo zero para DiagonalPrincipal

                                } else {
                                    double aux0;
                                    if(Double.parseDouble(s) == linhaMat){
                                        aux0 = -1.0;
                                    }
                                    else{
                                        aux0 = Double.parseDouble(s);
                                    }
                                    matriz[auxI - 1][auxJ] = aux0;     //transformando em double
                                    matriz[auxJ][auxI - 1] = aux0;     //transformando em double
                                }
                                auxJ++;
                            }
                        }
                        auxJ = 1;
                        auxI--;
                    }

                    //System.out.println(linha);        //linha referente ao arquivo
                    linha = lerArq.readLine();
                }
                auxI = linhaMat;
                auxJ = 1;
             
                HashMap<String, ArrayList<Aresta>> map;
                
                verMatrixEspelhada(linhaMat, colunaMat, matriz);        //ver resultado dos grafos em forma de matriz completa
                map = tranformarToList(matriz, linhaMat, colunaMat);          //relizar a tranformaçao da matriz para lista(hashMap)
                
            }

            arq.close();

        } catch (IOException e) {
            System.err.printf("Erro na abertura do arquivo: %s.\n", e.getMessage());
        }
    }

    public HashMap<String, ArrayList<Aresta>> tranformarToList(Double[][] matriz, int linha, int coluna) {
        HashMap<String, ArrayList<Aresta>> map = new HashMap<>();
        Grafo_AGM grafo_agm = new Grafo_AGM();

        //adicionando Keys no map
        for (int i = 0; i < linha; i++) {
            for (int j = 0; j < coluna; j++) {
                ArrayList<Aresta> ar = new ArrayList<>();
                map.put(Integer.toString(i), ar);
            }
        }

        //adicionando adjacentes
        for (int i = 0; i < linha; i++) {
            for (int j = 0; j < coluna; j++) {
                Aresta aresta = new Aresta();
                Vertice_AGM vr = new Vertice_AGM();

                aresta.setPeso(matriz[i][j]);
                vr.setId(Integer.toString(j));
                aresta.setDestinoAGM(vr);

                map.get(Integer.toString(i)).add(aresta);
            }
        }
        grafo_agm.setMap(map);

        //ver HashMap
        
        verMap(grafo_agm);
        return(map);
    }

    public void verMatrixEspelhada(int linhaMat, int colunaMat, Double[][] matriz) {
        System.out.println("Grafo Matriz Espelhada");
        for (int i = 1; i < linhaMat; i++) {
            for (int j = 1; j < colunaMat; j++) {
                System.out.print(matriz[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public void verMap(Grafo_AGM grafo_agm) {
        System.out.println("Keys: " + grafo_agm.getMap().keySet());

        System.out.println("Content[" + grafo_agm.getMap().values().size() + "]: ");
        for (String str : grafo_agm.getMap().keySet()) {
            System.out.print("\t" + str + "-->\t");
            for (Aresta ar : grafo_agm.getMap().get(str)) {
                System.out.print(" "+
                        ar.getDestinoAGM().getId() + "<"
                        + ar.getPeso() + ">");
            }
            System.out.println("");
        }
        System.out.println("EndContent\n");

    }
}

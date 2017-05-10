package Grafos_Lista;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Leitura {

    public void leituraArquivo(String local) {
        try {
            String[] aux;
            String linha;
            int[][] matriz;
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
            matriz = new int[linhaMat][colunaMat];

            while (linha != null) {
                for (int i = 0; i < linhaMat; i++) {
                    if (linha != null) {
                        for (String s : linha.split(" ")) {
                            if (!s.isEmpty()) {
                                matriz[auxI - 1][auxJ] = Integer.parseInt(s);         //transformando em integer
                                matriz[auxJ][auxI - 1] = Integer.parseInt(s);
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

                verMatrixEspelhada(linhaMat, colunaMat, matriz);

                //A FUNÇAO SERIA MAIS OU MENOS AQUI PARA CALCULAR CADA GRAFO
            }

            arq.close();

        } catch (IOException e) {
            System.err.printf("Erro na abertura do arquivo: %s.\n", e.getMessage());
        }
    }

    public void verMatrixEspelhada(int linhaMat, int colunaMat, int[][] matriz) {
        System.out.println("Grafo Matriz Espelhada");
        for (int i = 1; i < linhaMat; i++) {
            for (int j = 1; j < colunaMat; j++) {
                System.out.print(matriz[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}

package AGM;

import java.io.FileNotFoundException;
import java.util.List;

public class PrincipalAGM {

    public static void main(String[] args) throws FileNotFoundException {

        int numeroRotulos = 0, qtdVert, qtdRotulos;
        ArquivoAGM arquivo = new ArquivoAGM();
        List<String> txt;
        txt = arquivo.TxtToString();    
        List<int[][]> listMatriz;
        String rotuloaux = txt.get(0);
        long tempo1 = System.currentTimeMillis();

        
        qtdVert = Integer.parseInt(String.valueOf(rotuloaux.split(" ")[0]));
        qtdRotulos = Integer.parseInt(String.valueOf(rotuloaux.split(" ")[1]));
        MatrizAGM manipulatematrix = new MatrizAGM();
        listMatriz = manipulatematrix.ConverterMat(txt, qtdVert);

        for (int p = 0; p < listMatriz.size(); p++) {
            int[][] matriz;
            matriz = listMatriz.get(p); 
            int[][] matrizInvr = manipulatematrix.invertMatrix(matriz, qtdVert); 
            ListAdjAGM grafo = new ListAdjAGM();

            for (int i = 0; i < qtdVert; i++) {
                VerticeAGM v = new VerticeAGM(String.valueOf(i));
                grafo.adicionaVertice(v);
            }

            for (int i = 0; i < qtdVert; i++) {
                for (int j = 0; j < qtdVert; j++) {
                    if (matrizInvr[i][j] != -1 & matrizInvr[i][j] != qtdRotulos) {
                        VerticeAGM v = grafo.getVertice(String.valueOf(i));
                        VerticeAGM vAdj = grafo.getVertice(String.valueOf(j));
                        grafo.adicionaVertice(v, vAdj);
                        grafo.adicionaVertice(vAdj, v);
                    }
                }
            }

            int contaRotuloDaInstancia = 0;

            System.out.println("Matriz: " + p);
            MvcaAGM mvca = new MvcaAGM();
            contaRotuloDaInstancia = mvca.mcva(grafo, qtdVert, matrizInvr, qtdRotulos);
            System.out.println(" ");

            numeroRotulos += contaRotuloDaInstancia;
        }

        long time2 = System.currentTimeMillis();
        float numberLabels = numeroRotulos / 10f;
        float tempo = ((time2 - tempo1) / 999);
        
        System.out.println("Tempo: " + tempo + "s ");
        System.out.println("Numero de Rótulos totais: " + numberLabels);
    }

}
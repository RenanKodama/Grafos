package Grafos_Lista;

import java.util.ArrayList;
import java.util.Scanner;

public class TiposBuscas {

    public void iniciaBuscas() {
        String tipoBusca;
        Scanner entrada = new Scanner(System.in);

        System.out.println("Tipo da Busca: " + "\n\t"
                + "Algo. Busca em Largura -> BL" + "\n\t"
                + "Algo. Busca em Profundidade -> BP" + "\n"
        );
        System.out.print("Digite[BL|BP]: ");
        tipoBusca = entrada.nextLine();
        System.out.println();

        switch (tipoBusca) {
            case "BL":
                iniciaBuscaLargura();
                break;
            case "BP":
                iniciaBuscaProfundidade();
                break;
            default:
                System.out.println("Erro Tipo de Busca");
                break;
        }
    }

    private void iniciaBuscaLargura() {
        ArrayList<Transicoes> transicoes = new ArrayList<>();
        Transicoes nulo = new Transicoes();
        Grafo grafo = new Grafo();
        BuscaLargura bL = new BuscaLargura();
        Vertice_BL verticeInitialBL = new Vertice_BL();

        /* Input01 
                A->B
                B->C
                C->B
                C->D
                D->A
         */
        
        Transicoes aux0 = new Transicoes("A", "B", 1.00);
        Transicoes aux1 = new Transicoes("B", "C", 1.00);
        Transicoes aux2 = new Transicoes("C", "B", 1.00);
        Transicoes aux3 = new Transicoes("C", "D", 1.00);
        Transicoes aux4 = new Transicoes("D", "A", 1.00);

        transicoes.add(aux0);
        transicoes.add(aux1);
        transicoes.add(aux2);
        transicoes.add(aux3);
        transicoes.add(aux4);

        nulo.verTransicoes(transicoes);
        MatrizAdj matAdj = new MatrizAdj();
        matAdj.iniciaMatrizAdj(transicoes);
        matAdj.iniciaMatrixAdjT();
        
        verticeInitialBL.setId("A");

        bL.insereBL(grafo, transicoes);
        //bL.removeBLVertice(grafo,"C",1.00);
        bL.buscaLargura_init(grafo, verticeInitialBL);
        bL.buscaLargura(grafo);
    }

    private void iniciaBuscaProfundidade() {
        Grafo grafo = new Grafo();
        BuscaProfundidade bP = new BuscaProfundidade();
        Aresta arestaInicial = new Aresta();
        Vertice_BP verticeInitialBP = new Vertice_BP();

        /* Input02
                A->B
                A->D
                B->E
                E->D
                D->B
                F->E
                F->G
                G->G
         */
        ArrayList<Transicoes> transicoes = new ArrayList<>();
        Transicoes nulo = new Transicoes();
        Transicoes aux0 = new Transicoes("A", "B", 1.00);
        Transicoes aux1 = new Transicoes("A", "D", 1.00);
        Transicoes aux2 = new Transicoes("B", "E", 1.00);
        Transicoes aux3 = new Transicoes("E", "D", 1.00);
        Transicoes aux4 = new Transicoes("D", "B", 1.00);
        Transicoes aux5 = new Transicoes("F", "E", 1.00);
        Transicoes aux6 = new Transicoes("F", "G", 1.00);
        Transicoes aux7 = new Transicoes("G", "G", 1.00);

        transicoes.add(aux0);
        transicoes.add(aux1);
        transicoes.add(aux2);
        transicoes.add(aux3);
        transicoes.add(aux4);
        transicoes.add(aux5);
        transicoes.add(aux6);
        transicoes.add(aux7);

        nulo.verTransicoes(transicoes);
        MatrizAdj matAdj = new MatrizAdj();
        matAdj.iniciaMatrizAdj(transicoes);
        matAdj.iniciaMatrixAdjT();
        
        verticeInitialBP.setId("A");
        arestaInicial.setDestinoBP(verticeInitialBP);

        bP.insereBP(grafo, transicoes);
        bP.buscaProfundidade_Init(grafo);
        bP.buscaProfundidade(grafo, arestaInicial);
        bP.verBuscaP(grafo);
        bP.verTopologia();
    }

}

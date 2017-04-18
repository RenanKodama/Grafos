package Grafos_Lista;

import java.util.ArrayList;
import java.util.Collections;

public class MatrizAdj {
    
    private double[][] matrizAdj;
    private ArrayList<String> vertices;
    private double[][] matrizAdjT;

    
    public void calculaMatrizAdjT(){
        for(int i=0;i<vertices.size();i++){
            for(int j=0;j<vertices.size();j++){
                matrizAdjT[i][j] = matrizAdj[j][i];
            }
        }
        verMatrizAdjT();
    }
    
    public void iniciaMatrixAdjT() {
        this.matrizAdjT = new double[this.vertices.size()][this.vertices.size()];
        calculaMatrizAdjT();
    }

    public void iniciaMatrizAdj(ArrayList<Transicoes> transicoes) {
        this.vertices = new ArrayList();

        //Adiciona os vertices nao repetidos
        for (int i = 0; i < transicoes.size(); i++) {
            if (!this.vertices.contains(transicoes.get(i).getOrigem())) {
                this.vertices.add(transicoes.get(i).getOrigem());
            }
        }
        for (int i = 0; i < transicoes.size(); i++) {
            if (!this.vertices.contains(transicoes.get(i).getOrigem())) {
                this.vertices.add(transicoes.get(i).getDestino());
            }
        }
        
        Collections.sort(this.vertices);

        this.matrizAdj = new double[this.vertices.size()][this.vertices.size()];
        insereMatrizAdj(transicoes);
        //System.out.println("VerticesADJ: "+vertices.toString());
    }

    private void insereMatrizAdj(ArrayList<Transicoes> transicoes) {
        for (Transicoes tran : transicoes) {
            this.matrizAdj[vertices.indexOf(tran.getOrigem())][vertices.indexOf(tran.getDestino())] = tran.getPeso();
        }
        verMatrizAdj();
    }

    public ArrayList<String> getVertices() {
        return vertices;
    }

    public void setVertices(ArrayList<String> vertices) {
        this.vertices = vertices;
    }

    public double[][] getMatrizAdjT() {
        return matrizAdjT;
    }

    public void setMatrizAdjT(double[][] matrizAdjT) {
        this.matrizAdjT = matrizAdjT;
    }

    public double[][] getMatrizAdj() {
        return matrizAdj;
    }

    public void setMatrizAdj(double[][] matrizAdj) {
        this.matrizAdj = matrizAdj;
    }
    
    public void verMatrizAdjT() {
        System.out.println("\nVertices: "+this.vertices.toString() + "\n");
        System.out.println("MatrizAdjacenciaTContent: ");
        for (int i = 0; i < this.vertices.size(); i++) {
            System.out.print("\t");
            for (int j = 0; j < this.vertices.size(); j++) {
                System.out.print(this.matrizAdjT[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("MatrizAdjacenciaTEndContent");
    }
    
    public void verMatrizAdj() {
        System.out.println("\nVertices: "+this.vertices.toString() + "\n");
        System.out.println("MatrizAdjacenciaContent: ");
        for (int i = 0; i < this.vertices.size(); i++) {
            System.out.print("\t");
            for (int j = 0; j < this.vertices.size(); j++) {
                System.out.print(this.matrizAdj[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("MatrizAdjacenciaEndContent");
    }

}

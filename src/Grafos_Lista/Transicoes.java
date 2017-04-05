package Grafos_Lista;

import java.util.ArrayList;

public class Transicoes {

    private String origem;
    private String destino;
    private Double peso;
 

    Transicoes(String origem, String destino, Double peso) {
        this.destino = destino;
        this.origem = origem;
        this.peso = peso;
    }
    
    Transicoes(){
        this.destino = "";
        this.origem = "";
        this.peso = 0.0;
    }

    public String getOrigem() {
        return origem;
    }

    public void setOrigem(String origem) {
        this.origem = origem;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public Double getPeso() {
        return peso;
    }

    public void setPeso(Double peso) {
        this.peso = peso;
    }

    public void verTransicoes(ArrayList<Transicoes> transicoes) {
        System.out.println("Transiçoes");
        for (int i = 0; i < transicoes.size(); i++) {
            System.out.print(transicoes.get(i).getOrigem() + " ");
            System.out.print(transicoes.get(i).getPeso() + " ");
            System.out.println(transicoes.get(i).getDestino());
        }
        System.out.println("");
    }

}

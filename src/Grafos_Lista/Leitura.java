
package Grafos_Lista;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Leitura {
    public void pularLinhas(int num,BufferedReader lerArq) throws IOException{
        for (int i = 0; i < (num-1); i++) {
            lerArq.readLine();
        }
    }
    
    public void leituraArquivo(String local){
        try {
            int linhaMat,colunaMat;
            String[] aux;
            FileReader arq = new FileReader(local);
            BufferedReader lerArq = new BufferedReader(arq);
            
            aux = lerArq.readLine().split(" ");             //linha01 dimensao
            linhaMat = Integer.parseInt(aux[0])-1;
            colunaMat = Integer.parseInt(aux[1])-1;
            
            System.out.println("Dimensao: "+linhaMat+" "+colunaMat);
            
            int cont=0;
            
            String linha = lerArq.readLine();
            while (linha != null) {
                System.out.println(linha);
                
                if(cont == linhaMat){
                    System.out.println("Outro Grafo");
                    cont=0;
                }
                cont++;
                
                linha = lerArq.readLine();
            }
            arq.close();

            

//            pularLinhas(5,lerArq);
//            pularLinhas(1,lerArq);              //linha13 to end transiçoes
//            ArrayList<Transicoes> listEstados = new ArrayList();
//            
//            

            
        } catch (IOException e) {
            System.err.printf("Erro na abertura do arquivo: %s.\n",e.getMessage());
        }
    }
    
//    public void verTransicoes(AutomatoLeitura automato){
//        System.out.println("AlfabetoEntrada: "+Arrays.toString(automato.getAlfabetoEntrada()));
//        System.out.println("AlfabetoPilha: "+Arrays.toString(automato.getAlfabetoPilha()));
//        System.out.println("SimboloEpsolon: "+Arrays.toString(automato.getSimboloEpsilon()));
//        System.out.println("SimboloInicialPilha: "+Arrays.toString(automato.getSimboloInicialPilha()));
//        System.out.println("ConjuntoEstados: "+Arrays.toString(automato.getConjuntoEstados()));
//        System.out.println("EstadoInicial: "+Arrays.toString(automato.getEstadoInicial()));
//        System.out.println("EstadosAceitaçao: "+Arrays.toString(automato.getEstadosAceitacao()));
//        
//        System.out.println("Transiçoes: ");
//        
//        for(Transicoes tr : automato.getTransicoes()){
//            System.out.println("\t"+tr.getEstadoAtual()+" "
//                    +tr.getSimboloAtualPalavra()+" "
//                    +tr.getSomboloTopoPilha()+" "
//                    +tr.getNovoEstado()+" "
//                    +tr.getSimboloEmpilhar()
//            );
//        }
//        iniciaAutomato(automato);
//    }
    
//    public void iniciaAutomato(AutomatoLeitura automato){
//        Automato auto = new Automato();
//        auto.gerarAutomato(automato);
//    }
   
}

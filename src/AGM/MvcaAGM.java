
package AGM;

import java.util.ArrayList;
import java.util.List;
import static jdk.nashorn.internal.objects.Global.Infinity;


public class MvcaAGM {
    public MvcaAGM(){
        
    }
    
    public int mcva(ListAdjAGM grafo, int nVertice, int[][] matrizAdj, int nRotulo){
        List<Integer> listRotuloNVisitados = new ArrayList<>();
        List<Integer> listRotuloUtilizados = new ArrayList<>();
        ConectadosAGM componentesConexas = new ConectadosAGM();
        int contador = nVertice;
        double aux = Infinity;
        int contadorAux;
        int rotulo = -1;
        
        
        for(int i = 0; i < nRotulo; i++){
            listRotuloNVisitados.add(i);
        }
        
        while(aux > 1){ 
            
            for(int k = 0; k < listRotuloNVisitados.size(); k++){
                
                ListAdjAGM subgrafoaux2 = new ListAdjAGM();
                
                //adicionar todos os vertices no subgrafo 
                for(int i = 0; i < nVertice; i++){
                    VerticeAGM v = new VerticeAGM(String.valueOf(i));
                    subgrafoaux2.adicionaVertice(v);
                }
                
                
                if(!listRotuloUtilizados.isEmpty()){
                    for(int i = 0; i < listRotuloUtilizados.size(); i++){
                        for(int l = 0; l < nVertice; l++){
                            for(int p = 0; p < nVertice; p++){
                                if(matrizAdj[l][p] == listRotuloUtilizados.get(i)){
                                        VerticeAGM v = subgrafoaux2.getVertice(String.valueOf(l));
                                        VerticeAGM v2 = subgrafoaux2.getVertice(String.valueOf(p));
                                        subgrafoaux2.adicionaVertice(v, v2);
                                        subgrafoaux2.adicionaVertice(v2, v);
                                }
                            }
                        }
                    }
                }
                
               
                for(int i = 0; i < nVertice; i++){
                    for(int j = 0; j < nVertice; j++){
                        if(matrizAdj[i][j] == listRotuloNVisitados.get(k)){
                            VerticeAGM v = subgrafoaux2.getVertice(String.valueOf(i));
                            VerticeAGM v2 = subgrafoaux2.getVertice(String.valueOf(j));
                            subgrafoaux2.adicionaVertice(v, v2);
                            subgrafoaux2.adicionaVertice(v2, v);
                        }
                    }
                }
                
                contadorAux = componentesConexas.ContarComponentes(subgrafoaux2, nVertice);
                
                //DEBUG{
                    //System.out.println("Label: " + k);
                    //System.out.println("Count: " + countaux);
                    //System.out.println(" ");
                //}
                
                if(contadorAux < contador){
                    rotulo = k;
                    contador = contadorAux; 
                }
            }
            aux = contador; 
            contador = 10000;
            listRotuloUtilizados.add(rotulo);
        }
        
        String teste = "";
        for(int i = 0; i < listRotuloUtilizados.size(); i++){
            teste += listRotuloUtilizados.get(i) + " ";
        }
        System.out.println("Rotulos utilizados: " + teste);  
        return listRotuloUtilizados.size();
    }
}

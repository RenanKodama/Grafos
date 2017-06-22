
package AGM;

import java.util.ArrayList;
import java.util.List;


public class ConectadosAGM {
    public ConectadosAGM(){
    
    }
    

    public int ContarComponentes(ListAdjAGM grafo, int nVertice){
        int numCompoConex = 0;
        List<String> listVertNVisitados = new ArrayList<>();
        

        for(int i = 0; i < nVertice; i++){
            listVertNVisitados.add(String.valueOf(i));
        }
        

        while(!listVertNVisitados.isEmpty()){
            
            numCompoConex++;
            VerticeAGM v = grafo.getVertice(listVertNVisitados.get(0));
            List<VerticeAGM> listVertAdj = new ArrayList<>();
            
            for(int i = 0; i < grafo.getVerticesAdjacentes(v).size(); i++){
                listVertAdj.add(grafo.getVerticesAdjacentes(v).get(i));
            }
            
            listVertNVisitados.remove(v.getId());


            while(!listVertAdj.isEmpty()){
                List<VerticeAGM> listaVerticeAdj2 = new ArrayList<>();

                VerticeAGM v2 = grafo.getVertice(listVertAdj.get(0).getId());
                
                for(int i = 0; i < grafo.getVerticesAdjacentes(v2).size(); i++){
                   listaVerticeAdj2.add(grafo.getVerticesAdjacentes(v2).get(i));
                }

                for(int i = 0; i < listaVerticeAdj2.size(); i++){
                    if(listVertNVisitados.contains(listaVerticeAdj2.get(i).getId()) && !listVertAdj.contains(listaVerticeAdj2.get(i))){
                       listVertAdj.add(listaVerticeAdj2.get(i));
                    }
                }
               
                listVertNVisitados.remove(v2.getId()); 
                listVertAdj.remove(v2);
            }
           
        }
        //System.out.println("Num_compo: " + count);
        return numCompoConex;
    }
}

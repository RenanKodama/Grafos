
package AGM;

import java.util.ArrayList;
import java.util.List;


public class MatrizAGM {
    public MatrizAGM(){
        
    }

    public List ConverterMat(List<String> txt, int nVertice){
        List<int[][]> listMatriz = new ArrayList<>();

        String linha;
        
        int aux = 1;
        while(aux < txt.size()){
           
            int[][] auxMatriz = new int[nVertice-1][nVertice-1];
            for(int i = 0; i < (nVertice - 1); i++){
                linha = txt.get(aux);
                String[] split = linha.split(" ");
                for(int j = 0; j < split.length; j++){
                    auxMatriz[i][j] = Integer.parseInt(split[j]);
                }
                aux++;
            }
            listMatriz.add(auxMatriz);
            aux++;
        }
        return listMatriz;
    }
    
    
    public int[][] invertMatrix(int[][] matriz, int nVertice){
        int[][] invertedMatrix = new int[nVertice][nVertice];
        for(int i = 0; i < nVertice; i++){
            for(int j = 0; j <= i; j++){
                invertedMatrix[i][j] = -1;
            }
        }
        
        int lin = 0;
        int colun = 0;
        int auxcolun = 1;
        int auxverticeatual = nVertice - 2;

        
        for(int i = 0; i < nVertice - 1; i++){
            colun = auxcolun;
            for(int j = auxverticeatual; j >= 0; j--){
                invertedMatrix[lin][colun] = matriz[i][j];
                colun++;
            }
            lin++;
            auxcolun++;
            auxverticeatual--;
        }
        
      
        return invertedMatrix;
    }
}

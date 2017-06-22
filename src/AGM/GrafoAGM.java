
package AGM;

import java.util.ArrayList;


public interface GrafoAGM<V extends VerticeAGM, A extends ArestaAGM<V,V>> {
    
    public ArrayList<V> getVerticesAdjacentes(V u);
    public ArrayList<V> getVertices();
    public ArrayList<A> getArestas();
    public V getVertice(String id);
    

    public void adicionaVertice(V verticeNoGrafo, V verticeAdicionado);
	

    public void adicionaVertice(V verticeAdicionado);

    
    public void adicionaAresta(A arestaAdicionada);	
}

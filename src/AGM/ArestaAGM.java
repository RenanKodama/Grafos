
package AGM;


public class ArestaAGM<U extends VerticeAGM,V extends VerticeAGM> {
    private VerticeAGM vertice1 = null;
    private VerticeAGM vertice2 = null;
    
    public ArestaAGM(V v1,V v2){
        this.vertice1 = v1;
        this.vertice2 = v2;
    }
    
    public VerticeAGM getVertice1(){
        return this.vertice1;
    }
    
    public void setVertice1(VerticeAGM v1){
        this.vertice1 = v1;
    }
    
    public VerticeAGM getVertice2(){
        return this.vertice2;
    }
    
    public void setVertice2(VerticeAGM v2){
        this.vertice2 = v2;
    }
}

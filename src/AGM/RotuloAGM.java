
package AGM;


public class RotuloAGM extends ArestaAGM<VerticeAGM,VerticeAGM> {
    public String peso;
    
    public RotuloAGM(VerticeAGM v1,VerticeAGM v2,String peso){
        super(v1,v2);
        this.peso = peso;
    }
    
    public String getPeso(){
        return this.peso;
    }
    
    public void setPeso(String peso){
        this.peso = peso;
    }
}

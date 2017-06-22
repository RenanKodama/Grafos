
package AGM;


public class VerticeAGM {
     private String id;
    
    public VerticeAGM(){
        this.id = String.valueOf(getClass().hashCode());
    }
    
    public VerticeAGM(String id){
        this.id = id;
    }
    
    public String getId(){
        return this.id;
    }
    
    public void setId(String id){
        this.id = id;
    }
}


public class TNode {
     private String value;
     private TNode left;
     private TNode right;
     
     public TNode(){
    	    value="";
    	    left=null;
    	    right=null;
     }
     
     public TNode(String value){
    	    this.value=value;
    	    left=null;
    	    right=null;
     }
     
     void setValue(String value){
    	    this.value=value;
     }
     
     String getValue(){
    	    return value;
     }
     
     void set_left(TNode Temp){
    	    left=Temp;
     }
     
     
     TNode get_left(){
    	     return left;
     }
     
     void set_right(TNode Temp){
 	    right=Temp;
  }
  
  
  TNode get_right(){
 	     return right;
  }
  
     
     
     
     
     
     
     
     
     
     
     
}



public class Node {
     private Node next;
     private String data;
     
     public Node(String data){
    	   this.data=data;
    	   this.next=null;
     }
    
    public  Node(){
    	 
     }
     
     
     public Node getNext(){
    	       return next;
     }
     
     public void setNext(Node next){
          this.next=next;    	    
     }
     
     
     public void setData(String data){
    	    this.data=data;
     }
     
     
     public String getData(){
    	   return data;
     }
     
     public void displayNode(){
    	     System.out.println(data);
     }
     
     
}

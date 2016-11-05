
public class Tree {
      private  TNode root;
      
      public Tree(){
    	      root=null;
      }
      
      public TNode get_root(){
    	      return root;
      }
      
      public void Insert(String x){
    	    TNode temp=new TNode(x);
    	    if(root==null)
    	    	   root=temp;
    	    else{
    	       TNode P,T;
    	       P=T=root;
    	       while(T!=null){
    	    	   P=T;
    	    	   if(x.compareTo(T.getValue())<0)
    	    		   T=T.get_left();
    	    	   else
    	    		   T=T.get_right();
    	    	  
    	       }
    	    	if(x.compareTo(P.getValue())<0)
    	    		  P.set_left(temp);
    	    	else
    	    		  P.set_right(temp);
    	    }
    	  
      }
      
      
      TNode Search(String x){
    	    TNode T;
    	    T=root;
    	    while(T!=null && T.getValue().compareTo(x)!=0){
    	    	if(x.compareTo(T.getValue())<0)
    	    		   T=T.get_left();
    	    	else
    	    		T=T.get_right();
    	    }
    	    
    	    return T;
      }
      
        void printTNode(TNode T){
    	     System.out.println(T.getValue());
      }
      
        void printInOrder(TNode T){
    	    if(T!=null){
    	    	   printInOrder(T.get_left());
    	    	   if(T!=root)
    	    	        printTNode(T);
    	    	   printInOrder(T.get_right());
    	    }
      }
        
        void arrayToTree(String[]Arr){
        	   for(int i=0;i<Arr.length;i++){
        		      this.Insert(Arr[i]);
        	   }
        }
      
      
      public static void main(String [] args){
    	     Tree MyT=new Tree();
    	     
    	     MyT.Insert("cef");
    	     MyT.Insert("abc");
    	    
    	     System.out.println("official gene name:"+MyT.get_root().getValue());
    	     MyT.printInOrder(MyT.get_root());
    	     
      
      }
      
      
      
      
      
      
}

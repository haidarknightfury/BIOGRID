
public class LinkedList {
	private Node head;
	
	public LinkedList(){
		     head=null;
	}
	
	public boolean isEmpty(){
		   return head==null;
	}
	
	Node get_head(){
		  return head;
	}
	
	public void insertFirst(String data){
		    Node newNode=new Node(data);
		    newNode.setNext(head);
		    head=newNode;
	}
	
	public void insertLast(String data){
		    Node newNode=new Node(data);
		    if (head==null){
		    	    head=newNode;
		    	    return;
		    }
		    Node current=head;
		    Node previous=current;
		    while(current!=null){
		    	   previous=current;
		    	   current=current.getNext();
		    }
		    
		    previous.setNext(newNode);
		           
	}
	
	public void insertOrdered(String data){
		   Node newNode=new Node(data);
		   if(head==null)
			     head=newNode;
		  
		   else{
			   Node current=head.getNext();
			   Node previous=head;
			   while(current!=null&&current.getData().compareTo(data)<=0){
				    if(current.getData().equals(data)){
				    	return;
				    }
				    	
				     previous=current;
				     current=current.getNext();
			   }
			   
			   newNode.setNext(current);
			   previous.setNext(newNode);
			  
		   }
		   
	}
	
	public Node find(String data){
		   Node current=head;
		   while(current.getData().compareTo(data)!=0){
			     if(current.getNext()==null)
			    	   return null;
			     else
			    	  current=current.getNext();
		   }
		   return current;
	}
	
	public void display(){
		   Node current=head;
		   while(current!=null){
			        current.displayNode();
			        current=current.getNext();
		   }
	}
	
	
	public LinkedList ArrayToList(String [] Arr){
		      LinkedList temp=new LinkedList();
		      for(int i=0;i<Arr.length;i++){
		    	       temp.insertOrdered(Arr[i]);
		    	         
		      }
		      return temp;
		
	}
	
	
	

	
	public static void main(String[]args){
		       LinkedList L=new LinkedList();
		       L.insertOrdered("haidar");
		       L.insertOrdered("Aboo");
		       L.insertOrdered("Dargaye");
		       L.insertOrdered("Bakr");
		       L.insertOrdered("Dargaye");
		       L.insertOrdered("Aboo");
		       L.insertOrdered("Dargaye");
		       L.display();
	}

	

}

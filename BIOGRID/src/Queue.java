
public class Queue <T> {
	   private int rear;
	   private int front;
	   private int size;
	   private T Arr[];
	   
	   public Queue(int s){
		      size=s;
		      Arr=(T[])new Object[size];
		      front=size-1;
		      rear=size-1;
	   }
	   
	   public boolean IsEmpty(){
		       return front==rear;
	   }
	   
	   public boolean IsFull(){
		      return front==(rear+1)%size;
		      
	   }
	   
	   
	   public void enqueue(T item){
		      rear=(rear+1)%size;
		      Arr[rear]=item;
		      
	   }
	   
	   public T dequeue(){
		   T temp=Arr[(front+1)%size];
		   front=(front+1)%size;
		   return temp;
	   }
	   
	   public T peekFront(){
		       return Arr[(front+1)%size];
	   }
	   
	   
//	   public void displayQueue(){
//		       int start=(front+1)%size;
//		       while(start!=(rear+1)%size){
//		    	        System.out.println(Arr[start]);
//		    	        start=(start+1)%size;
//		       }
//		       
//	   }
//	   
//	   
//	   public void displayQueue(){
//		   Queue Temp=new Queue(Arr.length);
//		   Temp.Arr=this.Arr;
//		   int count=0;
//		   while(!Temp.IsEmpty() && count!=Temp.Arr.length-1){
//			    System.out.println(Temp.dequeue());
//			    count++;
//		   }
//	   }
	   
	   
	   public void displayQueue(){
		   for(int i=0;i<Arr.length;i++){
			   System.out.println(Arr[i]);
		   }
	   }
	   
	   public void destroyQueue(){
		      front=size-1;
		      rear=size-1;
		   
	   }
	   
	   
	   
	   
	   
	   
	   
}

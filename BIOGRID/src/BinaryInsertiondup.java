
public class BinaryInsertiondup {
	static int Arr[]=new int[10];
	static int size=0;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		binInsert(9);
		binInsert(2);
		binInsert(5);
		binInsert(2);
		
		
		print();
		
		

	}
	
	public static void binInsert(int key){
		   int lo=0;
		   int hi=size;
		   while(lo<hi){
			       int mid=(lo+(hi-lo)/2);
			       if(key<Arr[mid])
			    	     hi=mid;
			       else
			    	   lo=mid+1;
		   }
		   System.out.println(lo);
		   
		   
		   
		   for(int j=size;j>lo;j--){
			    Arr[j]=Arr[j-1];
		   }
		   
		   Arr[lo]=key;
		   size++;
		  
	}
	
	
	public static void print(){
		  for(int i=0;i<size;i++){
			  System.out.println(Arr[i]);
		  }
	}

}



public class QuickSort {
    static String[] Arr;
    static String[] Temp;
    static int size;
    static int ArrContent=0;
    
	public static void main(String[] args) {
		
		size=FindNextPrime(5);
		Arr=new String[size];
		Temp=new String[size];
		
		
		hashInsert("zeg");
		hashInsert("abu");
		hashInsert("sne");
		hashInsert("zeg");
		hashInsert("csu");
		hashInsert("abu");
		hashInsert("abu");
		hashInsert("buk");
		
		
		display(Arr);
		//ArrayCompaction();
		Test();
		display(Arr);
//		Arr[0]="zeg";
//		Arr[1]="abu";
//		Arr[2]="sne";
//		Arr[3]="csu";
//		Arr[4]="buk";
//		
		
	     int length=Arr.length-1;
		 quicksort(Arr,0,ArrContent-1);//change value of 5 to length
		 display(Arr);
		

	}
	
	
	public static void swap(String Arr[],int i,int j){
	      String temp=Arr[i];
	      Arr[i]=Arr[j];
	      Arr[j]=temp;
}

	
	  public static int partition(String Arr[],int l,int r){
		   int i=l;
		   int j=r;
		  
		   while(i<j){
			    
			     while( Arr[i].compareTo(Arr[r])<0){
			    	    i=i+1;
			     }

			     while((i<j) && (Arr[j].compareTo(Arr[r])>=0)){
		    	     j=j-1;
		          }
			     
			     if(i<j){
			    	swap(Arr,i,j);
			     }
			     else{
			    	swap(Arr,i,r);
			     }
		   }
		 
		return i;   
	   }
	  
	   public static void quicksort(String Arr[],int l,int r){
	         
		      if(r-l>0){
		    	       int x=partition(Arr,l,r);
     		    	  
		    	       quicksort(Arr,l,x-1);
		    	       quicksort(Arr,x+1,r);
		    	       
		      }
	   }
	   
	   public static void display(String[] Arr){
		   for(int i=0;i<Arr.length;i++){
			     System.out.printf(Arr[i]+" ");
		   }
		   System.out.println();
	}
	   
	   

		public static int hash(String Gene){
			int h=0;
			for(int i=1;i<Gene.length();i++){
				    h=(31*h+Gene.charAt(i))%size;
			}
			return h;
		}
		
		
		
		public static int FindNextPrime(int num){
			   boolean prime=false;
			   num++;
			   while(!prime){
				     prime=true;
				     for(int i=2;i<num;i++){
				    	    if(num%i==0){
				    	    	   prime=false;
				    	    	   break;
				    	    }
		
				     }
				     if(prime==true)
				    	   return num;
				     else
				    	 num++;
				     
			   }
			   
			   return num;
	 	   
		}
		
		public static void hashInsert(String Gene){
			    boolean insert=true;
			    int x=hash(Gene);
			    while(Arr[x]!=null){
			    	   if(Arr[x].equals(Gene)){
			    		     
			    		      insert=false;
			    		      break;
			    	   }
			    	   else{
			    		      x=(x+1)%size;
			    	   }
			    }
			    if(insert){
			         Arr[x]=Gene;
			         ArrContent++;
			         System.out.println(x);
			    }
			    
			    
		}
		
		public static void Test(){
			int j=0;
			for(int i=0;i<Arr.length;i++){
				    if(Arr[i]!=null)
				    	    Temp[j++]=Arr[i];
		      }
			Arr=Temp;
			System.out.println(j);
		}
		
		

		
		public static void ArrayCompaction(){
			  Queue<Integer> empty=new Queue<Integer>(1000);
			  for(int i=0;i<size;i++){
				      if(Arr[i]==null){
				    	    // System.out.println(i);
				    	     empty.enqueue(i);    
				      }
				      else{
				    	   if(!empty.IsEmpty()){
				    		      int x=empty.dequeue();
				    		      Arr[x]=Arr[i];
				    		      empty.enqueue(i);
				    		      Arr[i]=null;
				    	   }
				    	
				      }
			  }
		}
		

}

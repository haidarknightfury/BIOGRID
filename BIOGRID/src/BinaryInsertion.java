
public class BinaryInsertion {
    static String Arr[]=new String[6];
    static boolean insert=true;
    static int size=0;
    
	public static void main(String[] args) {

		BinInsert("zuh");
		BinInsert("bil");
		BinInsert("abu");
		BinInsert("tma");
		BinInsert("abu");
		BinInsert("oye");
		BinInsert("bil");
		BinInsert("abu");
		

		
		print();
	}
	
	static void print(){
		System.out.println("print array");
		for(int i=0;i<size;i++){
			System.out.println(Arr[i]);
		}
	}
	
	
	
	
	
	
	static int BinarySearch (int low, int high, String key)
	{
	    int mid;

	    if (low == high)
	        return low;

	    mid = low + ((high - low) / 2);

	    if (key.compareTo(Arr[mid])>0)
	        return BinarySearch ( mid + 1, high, key);
	    else if (key.compareTo(Arr[mid])<0)
	        return BinarySearch ( low, mid, key);
	    
	    
	    return mid;
	}
	
	

	static void BinInsert(String item){
		
		      int ins=BinarySearch(0,size,item);
			

		      System.out.println(ins+" , "+Arr[ins]);
		     	  
		      if(Arr[ins]!=null&&Arr[ins].compareTo(item)==0)
		    	  return;
		    			  
		      for(int i=size-1;i>=ins;i--){
		    	     Arr[i+1]=Arr[i];
		      }
		      Arr[ins]=item;
		      size++;
		}
	
	
	

}

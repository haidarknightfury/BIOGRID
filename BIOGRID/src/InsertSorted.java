
public class InsertSorted {
	static String Arr[]=new String[50];
	static int size=0;
	public static void main(String[] args) {
		
		InsertSorted("zbe");
		InsertSorted("abc");
		InsertSorted("bbc");
		InsertSorted("abc");
		InsertSorted("abc");
		InsertSorted("abc");
		InsertSorted("abc");
		InsertSorted("zbe");
		
		   System.out.println(size);
		   
		   for(int c=0;c<size;c++){
				System.out.println(Arr[c]);
			}
 

	}
	
	public static void InsertSorted(String item){
		   boolean dup=false;
		   int k;
		   int i;
		   for(i=0;i<size&&(item.compareTo(Arr[i])>=0);i++){
			      if (item.equals(Arr[i])){
			    	     dup=true;
			    	     return;
			      }
		   }
		   for(k=size;k>i;k--){
			      Arr[k]=Arr[k-1];
		   }
		   
		   
		   
		      Arr[i]=item;
	          size++;
		   
		   
		
		   
	}
	
	
	

}

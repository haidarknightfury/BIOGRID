
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.io.*;
public class BIOGRIDALL {
	static LinkedList GeneArray [];
	static Tree Aliases[];//not yet developped.Use array of aliases to input aliases.
	//one array of linked list for interactors and one for aliases.
    static int upTo=0;
    static int size;
    static int ArrContent=0;    
    
	public static void main(String[] args) {
		
		long start=System.currentTimeMillis();
		
		Scanner in=new Scanner(System.in);
		
	    
	    String geneA;
	    String geneB;
	    
	    String Alias_GeneA[];
	    String Alias_GeneB[];
	    
	    size=FindNextPrime(58000);
		System.out.println(size);
		
		GeneArray =new LinkedList[size];
		Aliases=new Tree[size];
		  try{
		      Scanner file=new Scanner(new File("C:\\Users\\haidar\\"
		      		+ "Desktop\\ASSIGNMENT ALGO\\BIOGRID-ALL-3.4.130.mitab.txt"));
		      System.out.println(file.nextLine());
		      System.out.println("WAIT WHILE OPTIMISING PERFORMANCE..");
		         while(file.hasNext()){
		    	     String line=file.nextLine();
		    	     String tokens[]=line.split("\t");
		    	     geneA=ObtainGenes(tokens[2]);
		    	     geneB=ObtainGenes(tokens[3]);
		    	     Alias_GeneA=ObtainAliases(tokens[4]);
		    	     Alias_GeneA=ParseAliases(Alias_GeneA);
		    	    
		    	     Alias_GeneB=ObtainAliases(tokens[5]);
		    	     Alias_GeneB=ParseAliases(Alias_GeneB);
		    	     
		    	     
      		    	 hashInsert(geneA,geneB,Alias_GeneA);
      		    	 hashInsert(geneB,geneA,Alias_GeneB);
		        }
		      
		       System.out.println("INSERTION OVER");
		       
		       long end=System.currentTimeMillis();
		       System.out.println("your program took "+(end-start)+" ms");
		       
		       int choice;
		       
		       do{
		    	   System.out.println("BIOGRID REPOSITORY OF GENES");
		    	   System.out.println("1.OBTAIN INTERACTIONS");
		    	   System.out.println("2.GET FILE OF SORTED DISTINCT GENE NAMES");
		    	   System.out.println("3.EXIT");
		    	   System.out.println("4. SEARCH INTERACTION BY ALIAS");
		    	   System.out.println("YOUR CHOICE: ");
		    	   choice=in.nextInt();
		    	   
			       switch(choice){
			       
			          case 1:    start=System.currentTimeMillis();
			        	         System.out.println("ENTER GENE NAME");
				                 String search_name=in.next();
				                 Search(search_name);
				                 end=System.currentTimeMillis();
				                 System.out.println("YOUR QUERY WAS EXECUTED IN "+(end-start)+" ms");
				                 break;
			          case 2:     
			        	       String TempArr[]=new String[size];
			                   for(int i=0;i<size;i++){
			                	         if(GeneArray[i]!=null){
			        	                       TempArr[i]=GeneArray[i].get_head().getData();
			                	         }
			                   }
			        
			                  ArrayCompaction(TempArr);
			                  file.close();
			   
			                  System.out.println("Sorting array");
			                  start=System.currentTimeMillis();
		           			  quicksort(TempArr,0,ArrContent-1);
	                          printGenes(TempArr);
			                  System.out.println("sorted");
			                  end=System.currentTimeMillis();
				              System.out.println("YOUR QUERY WAS EXECUTED IN "+(end-start)+" ms");
			        	         break;
			        	         
			          case 3:  System.out.println("SEARCHING BY ALIASES");
	                           System.out.println("ENTER ALIAS");
	                           String Alias=in.next();
	               
	                           for(int i=0;i<size;i++){
	                	       if(Aliases[i]!=null){
	                	    	    if (Aliases[i].Search(Alias)!=null){
	                	    	              Search(Aliases[i].get_root().getValue());
	                	    	              break;
	                	    	     }
	                	    	    
	                	       }
	                        }
	        	      
			          case 4: 
			        	       System.out.println("PROGRAM EXITED");
			        	       return;
			        	       
			    
			        	       
			          default: System.out.println("WRONG CHOICE \n ENTER AGAIN"); 
			          
			       }
		    	   
		    	   
		       }while(choice!=4);
		    	   
	
		        
	   }
	   catch(FileNotFoundException fnfe){
		   System.out.println("COULD NOT OPEN FILE");
	   }
	}
	
	public static String [] ObtainAliases(String G){
		   String genes[];
		   Pattern p=Pattern.compile("entrez gene/locuslink");
		   Matcher m=p.matcher(G);
		   int count=0;
		   while(m.find()){
			   count+=1;
		   }
		   genes=new String[count];
		   String tokens[]=G.split("entrez gene/locuslink:");
		   return tokens;
		  
	}	
	
	
	
	public static String[] ParseAliases(String src[]){
		 for(int i=0;i<src.length;i++){
    	     if(src[i].indexOf("(")!=-1)
    	         src[i]=(src[i].substring(0,src[i].indexOf("(gene")));
    	     
    	    	 
     }
		 return src;
		
	}
	
	public static boolean isAvailable(String Gene){
		 for(int i=0;i<upTo;i++){
			    if(GeneArray[i].equals(Gene)){
			    	   return true;
			    }
		 }
		return false;
	}
	
	
	public static void printGenes(String Array[]){
		 try {
			PrintStream output=new PrintStream(new File("Output.txt"));
			 for(int i=0;i<ArrContent;i++){
			     System.out.println(Array[i]);
			     output.println(Array[i]);
			     
		  }
		  System.out.println(ArrContent);
		 
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		 
	}
	

	
	public static String ObtainGenes(String G){
		 String gene;
		 int start=G.indexOf("entrez gene/locuslink");
	     while(G.charAt(start)!=':'){
	    	     start++;
	     }
	     int end=G.indexOf("|", start);
	     if(end>0){
	    	 gene=(G.substring(start+1,end));
	     }
	     else{
	    	    gene=(G.substring(start+1));
	     }
	     
	     return gene;		
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
	         
		      if(r>l){
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
		
	
		
		
		

		public static void hashInsert(String Gene,String GeneB,String[]Al){
		    int x=hash(Gene);
		    while(GeneArray[x]!=null){
		    	   if(GeneArray[x].get_head().getData().equals(Gene)){
		    		  GeneArray[x].insertOrdered(GeneB);
	    		      break;
	    	        }
		    	     else{
		    		      x=(x+1)%size;
		    	      }
	         }	    
		    if(GeneArray[x]==null){
		    	 GeneArray[x]=new LinkedList();
		         GeneArray[x].insertOrdered(Gene);
		         GeneArray[x].insertOrdered(GeneB);
		         
		         Aliases[x]=new Tree();
		         Aliases[x].Insert(Gene);
		         Aliases[x].arrayToTree(Al);
		         
		         ArrContent++;
		        
		    }
	    }
		

		public static void ArrayCompaction(String Array[]){
			  Queue<Integer> empty=new Queue<Integer>(60000);
			  for(int i=0;i<size;i++){
				      if(Array[i]==null){
				    	     empty.enqueue(i);    
				      }
				      else{
				    	   if(!empty. IsEmpty()){
				    		      int x=empty.dequeue();
				    		      Array[x]=Array[i];
				    		      empty.enqueue(i);
				    		      Array[i]=null;
				    	   }
				      }
			  }
		}
		
		public static void Search(String Gene){
			 int x=hash(Gene);
			    while(GeneArray[x]!=null){
			    	   if(GeneArray[x].get_head().getData().equals(Gene)){
			    		  GeneArray[x].display();
		    		      break;
		    	        }
			    	     else{
			    		      x=(x+1)%size;
			    	      }
		         }	    
			    if(GeneArray[x]==null){
			         System.out.println("Gene Not Found");
			    }
			    
		}
		
		
		
		static int BinarySearch (int low, int high, String key)
		{
		    int mid;

		    if (low == high)
		        return low;

		    mid = low + ((high - low) / 2);

		    if (key.compareTo(GeneArray[mid].get_head().getData())>0)
		        return BinarySearch ( mid + 1, high, key);
		    else if (key.compareTo(GeneArray[mid].get_head().getData())<0)
		        return BinarySearch ( low, mid, key);
		    
		    return mid;
		}
		
		
		
		
		
	
	   
}

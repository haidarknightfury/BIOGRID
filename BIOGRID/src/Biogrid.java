import java.io.*;
import java.util.*;

public class Biogrid {

	
	public static void main(String[] args) {
		   try{
			      int count=0;
			      Scanner file=new Scanner(new File("C:\\Users\\haidar\\Desktop\\ASSIGNMENT ALGO\\BIOGRID-ALL-3.4.130.mitab.txt"));
			      System.out.println(file.nextLine());
			      //for(int i=0;i<10;i++){
			      while(file.hasNext()){
			    	     String line=file.nextLine();
			    	     //System.out.println(line);
			    	     count++;
			      }
			      System.out.println(count);
			      
			      file.close();
			      
	}
		   catch(FileNotFoundException fnfe){
			   System.out.println("COULD NOT OPEN FILE");
		   }

	}

	
}

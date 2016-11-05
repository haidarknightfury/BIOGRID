import java.util.*;
import java.io.*;
public class FileDefinition {
	   public String path;
	   public int NumLines;
	   public  Scanner file;
	   public FileDefinition(String path){
		     this.path=path;
		     int count=0;
		     try{
		    	  file=new Scanner(new File(path));
				  file.nextLine();//first line is heading 
				  while(file.hasNextLine()){
					     count++;
					     file.nextLine();
				  }
				  NumLines=count;
				  file.close();
				  
				  file=new Scanner(new File(path));
		    	 
		     }
		     catch(FileNotFoundException fnfe){
				   System.out.println("COULD NOT OPEN FILE");
			   }
		     
	   }

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public int getNumLines() {
		return NumLines;
	}
	
	public void close(){
		file.close();
	}

	
	   
	   
	   

}

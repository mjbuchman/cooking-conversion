import java.io.*;
import java.util.*;

public class Converter {
	
   private String measurement1, measurement2;
   private int numberField;

   /**
    * Constructor for instantiating a job
    * @param measurement1: The label chosen from the first drop down box
    * @param measurement2: The label chosen from the second drop down box
    * @param numberField: The number typed into the text box
    */
   public Converter(String m1, String m2, int nF) {
       measurement1 = m1;
       measurement2 = m2;
       numberField = nF;
   }
	
   public double getConversionRate(){	   
       try {
    	   File file = new File("conversions.txt");
    	   Scanner sc = new Scanner(file);
       
    	   while(sc.hasNextLine()){
    		  if(sc.next().equals(this.measurement1)) {
    			  if(sc.next().equals(this.measurement2)){
    				  return sc.nextDouble();
    			  }
    		  }
    	   }
           sc.close();         
       }
       catch(Exception ex) {
           ex.printStackTrace();               
       }
	   
	   return 0.0;  // Used for error checking
   }
   
   public void print() {
		System.out.println("Converting " + this.numberField + " " + this.measurement1 + " to " + this.measurement2 + "...");
	}
}

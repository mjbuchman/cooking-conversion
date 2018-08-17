import java.io.*;
import java.util.*;

public class Converter {
	
   private String measurement1, measurement2;
   private double numberField;

   /**
    * Constructor for instantiating a job
    * @param measurement1: The label chosen from the first drop down box
    * @param measurement2: The label chosen from the second drop down box
    * @param numberField: The number typed into the text box
    */
   public Converter(String m1, String m2, double nF) {
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
    				  double result = sc.nextDouble();
    				  sc.close();
    				  return result;
    			  }
    		  }
    	   }
           sc.close();         
       }
       catch(Exception ex) {
           ex.printStackTrace();               
       }
	   
	   return -1.0;  // Used for error checking
   }
   
   public String getResult(double rate) {   
	   double calc = ((double) Math.round(this.numberField*rate*1000))/1000;
	   String result = toString(calc);
	   if(calc%1 == .0) {
		   return result.substring(0, result.length()-2);
	   }else {
		   return result;
	   }
   }
 
   
   public String toString(double rate) {
		return "" + rate;
   }
}

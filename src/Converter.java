import java.io.*;
import java.util.*;

public class Converter {

    private String measurement1, measurement2;  //Chosen string from drop down boxes
    private double numberField;  // Number input by user

    /**
    * Constructor for instantiating a converter
    * @param measurement1: The label chosen from the first drop down box
    * @param measurement2: The label chosen from the second drop down box
    * @param numberField: The number typed into the text box
    */
    public Converter(String m1, String m2, double nF) {
        measurement1 = m1;
        measurement2 = m2;
        numberField = nF;
    }

    /**
    * Returns the conversion rate between the two specified measurements
    * from a file named conversions.txt
    * 
    * Uses measurements from the created Converter object
    * 
    * @return The double found after parsing the file
    */
    public double getConversionRate(){	   
        try {
            File file = new File("conversions.txt");
            Scanner sc = new Scanner(file);

            /* Parse file for matching measurement labels */
            while (sc.hasNextLine()) {
                if (sc.next().equals(this.measurement1)) {  // If first label matches
                    if (sc.next().equals(this.measurement2)) {  // If second label matches
                        double result = sc.nextDouble();  // Grab conversion rate on this line
                        sc.close();
                        return result;
                    }
                }
            }
            sc.close();         
        } catch (Exception ex) {
            ex.printStackTrace();               
        }

        return -1.0;  // Used for error checking
    }

    /**
    * Calculates the resulting conversion using the found conversion rate
    * and number provided by user
    * 
    * Also removes '.0' from end of results if necessary and rounds to 3 DP
    * 
    * @return The double calculated in String form
    */
    public String getResult(double rate) {   
        double calc = ((double) Math.round(this.numberField*rate*1000))/1000;  //Do conversion and round to 3 DP
        String result = toString(calc);
        if (calc%1 == .0) {
            return result.substring(0, result.length()-2);  // If result ends in .0 remove the .0
        } else {
            return result;
        }
    }

    /**
    * toString method for a double
    *
    * @param rate: Passed in double to be converted to type String
    * @return The resulting String
    */
    public String toString(double rate) {
        return "" + rate;
    }
}

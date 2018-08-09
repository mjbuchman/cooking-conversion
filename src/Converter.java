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
	
   public void print() {
		System.out.println("Converting " + this.numberField + " " + this.measurement1 + " to " + this.measurement2 + "...");
	}
}

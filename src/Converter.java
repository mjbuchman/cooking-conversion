public class Converter {
	
   private String measurement1, measurement2;
   private int numberField1, numberField2;

   /**
    * Constructor for instantiating a job
    * @param measurement1: The label chosen from the first drop down box
    * @param measurement2: The label chosen from the second drop down box
    * @param numberField1: The number typed into the first text box
    * @param numberField2: The number typed into the second text box
    */
   public Converter(String m1, String m2, int nF1, int nF2) {
       measurement1 = m1;
       measurement2 = m2;
       numberField1 = nF1;
       numberField2 = nF2;
   }
	
   public void print() {
		System.out.println("Converting " + this.numberField1 + " " + this.measurement1 + " to " + this.numberField2 + " " + this.measurement2 + "...");
	}
}

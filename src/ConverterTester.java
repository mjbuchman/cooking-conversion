public class ConverterTester {
	public static void main(String[] args) {
		Converter test = new Converter("Tablespoon(s)", "Cup(s)", 8);
		System.out.println("Conversion Rate: " + test.getConversionRate());
		System.out.println("Result: " + test.getResult(test.getConversionRate()));
	}
}

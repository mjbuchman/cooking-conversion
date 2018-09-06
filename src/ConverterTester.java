import java.util.*;

public class ConverterTester {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("Enter first measurement in singular form (i.e. Tablespoon): ");
		String a = input.nextLine();
		
		System.out.print("Enter second measurement in singular form (i.e. Tablespoon): ");
		String b = input.nextLine();
		
		System.out.print("Enter number of " + a + "s to convert to " + b + "s: ");
		int c = input.nextInt();
		
		input.close();
		
		Converter test = new Converter(a + "(s)", b + "(s)", c);
		System.out.println("Conversion Rate: " + test.getConversionRate());
		System.out.println("Result: " + test.getResult(test.getConversionRate()));
	}
}

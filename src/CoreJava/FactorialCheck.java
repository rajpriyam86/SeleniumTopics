package CoreJava;

public class FactorialCheck {
	public static void main(String[] args) {
		int input = 20;

		int i = input;
		long j = 1;
		if (input < 0) {
			System.out.println("Please provide a non negetive number");
		} else {
			while (i > 0) {
				j = i * j;
				i -= 1;

			}
			System.out.println(j);
		}

	}

}

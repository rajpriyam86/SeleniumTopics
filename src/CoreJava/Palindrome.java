package CoreJava;

public class Palindrome {

	public static void main(String[] args) {
		int input = -121;
		if (input < 0) {
			System.out.println(input + " : This is not a plindrome");
		}else {

		int i = input;
		int j = 0;

		while (i > 0) {
			
			j = j * 10 + (i % 10);

			i = i / 10;

		}
		if (j == input) {
			System.out.println(input + " : This is a plindrome");
			
		} else {
			System.out.println(input + " : This is not a plindrome");
		}
		}
	}

}

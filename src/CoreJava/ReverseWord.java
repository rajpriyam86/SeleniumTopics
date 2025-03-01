package CoreJava;

public class ReverseWord {

	public static void main(String[] args) {
		String input = "Test Automation";
		StringBuilder str = new StringBuilder();

		String[] words = input.split(" ");
		for (String word : words) {
			StringBuilder reverseWord = new StringBuilder(word);
			str.append(reverseWord.reverse()).append(" ").toString();

		}

		System.out.println(str.toString().toLowerCase());
	}
}

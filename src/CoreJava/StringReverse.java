package CoreJava;

public class StringReverse {
	
	public static void main (String[] args) {
		
		String input = "Test Automation";
		String input2 = "Priyam";
		StringBuilder sb = new StringBuilder();
		String[] words = input.split(" ");
		for( String word: words) {
			StringBuilder reverseWord = new StringBuilder(word);
			sb.append(reverseWord.reverse().toString().toLowerCase()).append(" ");
			
		}
		System.out.println(sb);
		
		StringBuilder sb2 = new StringBuilder(input2);
		System.out.println(sb2.reverse().toString());
		
		
	}

}

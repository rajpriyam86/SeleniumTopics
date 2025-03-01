import java.util.ArrayList;
import java.util.List;

public class CoreJavaBasics2 {

	public static void main(String[] args) {
		int[] arr = { 1, 2, 3, 4, 5, 6, 42, 565, 2135, 21498, 10234, 2574, 21, 54, 86 };
		int[] mul = new int[arr.length];
		int[] nomul = new int[arr.length];
		int x = 0;
		int y = 0;
		// For LOop starts here

		// for loop to exit if the condition satisfy
		for (int j = 0; j < arr.length; j++) {
			// to check if the number is multiple by 2 and will store it in a variable mul
			if (arr[j] % 2 == 0) {
				System.out.println(arr[j]);
				break;
			} else

			{
				System.out.println(arr[j]);
			}
		}

		System.out.println("group For Loop Starts here..... ");
		// for loop to check the condition and group and print it
		for (int i = 0; i < arr.length; i++) {
			// to check if the number is multiple by 2 and will store it in a variable mul
			if (arr[i] % 2 == 0) {
				mul[x] = arr[i];
				x++;
			} else
			// to check if the number is not multiple by 2 and will store it in a variable
			// nomul
			{
				nomul[y] = arr[i];
				y++;
			}
		}
		// Printing the result in a group
		System.out.print("These are multiple by 2: ");
		for (int i = 0; i < x; i++) {
			System.out.print(mul[i] + ", ");

		}
		System.out.println();
		System.out.print("These are not multiple by 2: ");
		for (int i = 0; i < y; i++) {
			System.out.print(nomul[i] + ", ");

		}
		System.out.println();
		// ArrayList Starts Here
		System.out.println("ArrayList Starts Here.....");
		List<String> name = new ArrayList<String>();
		name.add("Java");
		name.add("Selenium");
		name.add("Learning");
		for (int i = 0; i < name.size(); i++) {
			System.out.println(name.get(i));
		}
		// Enhanced For loop for arraylist statrs gere
		System.out.println("Enhanced For loop...");
		for (String val : name) {
			System.out.println(val);

		}
		//calling methods from MethodsDemo class - To call we need to create an object first
		System.out.println("Calling diff method here....");
		MethodsDemo  d1 = new MethodsDemo();
		d1.getdata();
		d1.getvalue();

	}

}

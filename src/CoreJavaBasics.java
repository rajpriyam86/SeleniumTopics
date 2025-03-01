
public class CoreJavaBasics {

	public static void main(String[] args) {
		
		//Basic variable declaration 		
		int num = 5;
		String Name = "This is the code";
		char word = 's';
		double decimal = 512.505;
		boolean bool = true;
		
		System.out.println(decimal+" "+"You have successfully printed the variable");
		
		//Arrays starts here
		int[] arr = new int[5];
		arr[0] = 5;
		arr[1] = 7;
		arr[2] = 6;
		arr[3] = 7;
		arr[4] = 8;
		System.out.println(arr[2]);
		
		int[] arr2 = {1,2,3,4,5,6}; 
		System.out.println(arr[3]);
		
		String[] name =  {"Java", "Basic", "Learn"};
		
		//For loop starts here	
		//Printing arr
		for (int i = 0 ; i< arr.length; i ++)
		{
			System.out.println(arr[i]);
		}
		//Printing arr2
		for (int i = 0 ; i< arr2.length; i ++)
		{
			System.out.println(arr2[i]);
		}
		//printing name
		for (int i = 0 ; i< name.length; i ++)
		{
			System.out.println(name[i]);
		}
		
		//enhanced for loop
		
		for(int print : arr) 
		{
			System.out.println(print);
		
		}
		

	}

}


public class MethodsDemo {
	
	//you can avoid this main method if you intension is to create only Method
	public static void main(String[] args) {
		MethodsDemo call = new MethodsDemo();
		call.getdata();
		getvalue();
		
	}
	
	//if we are not using static then we need to create an object so that we can call out that
	public String getdata()
	{
		System.out.println("This is a method created in another class");
		return ("Null");
		
	}
	
	//if we are using static then we no need to create an object we can call out the the method alone
	public static String getvalue()
	{
		System.out.println("this is another method to call");
		return ("Null");
	}
	
}

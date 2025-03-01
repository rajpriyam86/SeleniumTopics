import java.util.Scanner;

public class Fib {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int a=0; 
		int b=a+1;
		int c =0;
		Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your name: "); 
        int value = scanner.nextInt(); 
		System.out.println(a);
		for (int i=1; i<value;i++)
		{
			c =a+b;
			System.out.println(c);
			a=b;
			b=c;
			
		}
		int x= 0;
		int y = 0;
		Scanner scanner2 = new Scanner(System.in);
        System.out.println("Enter your line: "); 
         x = scanner2.nextInt(); 
        
        for(int i = 1; i<x;i++)
        {
        	for(int j=0; j<x-i;j++)
        	{
        		System.out.print(" ");
        	}
        	for(int k=1;k<=i;k++)
        	{
        		System.out.print("*"+" ");
        	}
        	System.out.println();
        }

	}

}

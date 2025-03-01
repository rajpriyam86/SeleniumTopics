package CoreJava;

public class FibbonacciSeries {
	public static void main(String[] args) {
	int k = 0;
	int j = 1;
	int p = 0;
	System.out.print(k+", ");
	System.out.print(j+", ");
	for (int i =0; i<10;i++) {
		
		p=j+k;
		System.out.print(p+", ");
		k=j;
		j=p;
		
		
		
	}
	}

}

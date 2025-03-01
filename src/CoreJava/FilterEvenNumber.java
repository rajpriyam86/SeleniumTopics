package CoreJava;

import java.util.ArrayList;
import java.util.List;

public class FilterEvenNumber {
	
	public static void main(String[] args) {
		int[] input = {1,2,3,4,5,6,7,8,9,7};
		List<Integer> even = new ArrayList<>() ;
		List<Integer> odd = new ArrayList<>() ;
		for (int i=0;i<input.length;i++){
			if(input[i]%2==0) {
				even.add(input[i]);
			}else {
				odd.add(input[i]);
			}
		}
			
			System.out.println("Even Numbers: "+even);
			System.out.println("Odd Numbers: "+odd);
			
		}
	

}

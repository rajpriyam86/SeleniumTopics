package CoreJava;

import java.util.ArrayList;

public class ArrayListExample {

public static void main (String[] args) {
    
    ArrayList<String> arr = new ArrayList<>();
    
    arr.add("apple");
    arr.add("banana");
    arr.add("cherry");
    arr.add("mango");
    arr.add("apple");
    System.out.println(arr);
    arr.remove(0);
    System.out.println(arr);
    
    if(arr.contains("orange"))
    {
        System.out.println("orange is  found");
    }
    else
    {
        System.out.println("orange is not found");
    }
    System.out.println(arr.size());
    for(int i=0;i<arr.size();i++)
    {
        System.out.println("index "+i+" contains "+arr.get(i));
        
    }
}
}
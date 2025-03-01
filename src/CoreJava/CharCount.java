package CoreJava;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

public class CharCount {public static void main(String[] args) {
	String input = "sgduwgblsb$#$%^&*12345$%^";
	Map<Character,Integer> map = new LinkedHashMap<>();
	for(Character ch: input.toCharArray()) {
		map.put(ch, map.getOrDefault(ch, 0)+1);
	}
	
	for(Map.Entry<Character,Integer>entry:map.entrySet()) {
		System.out.println(entry.getKey()+"----->"+entry.getValue());
	}
}

}

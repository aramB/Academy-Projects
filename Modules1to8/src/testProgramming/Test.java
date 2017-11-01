package testProgramming;

import java.util.HashMap;
import java.util.Map;

public class Test {
	public static void main(String[] args) {
		Map<String, Integer> hashMap = new HashMap<String,Integer>();
		hashMap.put("A", 0);
		hashMap.put("B", 1);
		hashMap.put("C", 2);
		hashMap.put("D", 3);
		hashMap.put("A", 4);
		hashMap.put("C", 5);

		for (Map.Entry<String, Integer> kvp: hashMap.entrySet()){
		    String key = kvp.getKey();
		    Integer value = kvp.getValue();
		    System.out.printf("(%s, %d) ",key, value);
		}
	}

	public static int plus(int förstaTalet, int andraTalet) {
		int summa = förstaTalet + andraTalet;
		return summa;
	}
}

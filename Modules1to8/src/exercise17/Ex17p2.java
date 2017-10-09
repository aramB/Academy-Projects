package exercise17;

import java.util.HashMap;
import java.util.Map;

public class Ex17p2
{
	public static void main(String[] args) {
		Print print = new Print();
		String s = "Hello World!";
		print.printOutput(s);
	}
}

class CharCounter
{
	public Map<Character, Integer> calc(String str) {
	 		Map<Character, Integer> characterMap = new HashMap<>();
			for (int i = 0; i < str.length(); i++) {
				if (characterMap.containsKey(str.charAt(i))) {
					int value = characterMap.get(str.charAt(i));
					characterMap.put(str.charAt(i), ++value);
				}
				else {
					characterMap.put(str.charAt(i), 1);
				}
			}
			return characterMap;
		}
}

class Print
{
	public void printOutput(String str) {
		CharCounter charCounter = new CharCounter();
		System.out.println("Counting the characters in the string '" + str + "'");
		System.out.println();
		Map<Character, Integer> characterMap = charCounter.calc(str);
		for (Map.Entry<Character, Integer> keyValue: characterMap.entrySet()) {
			char key = keyValue.getKey();
			int value = keyValue.getValue();
			System.out.printf("%2c ", key);
			for (int i = 0; i < value; i++) {
				System.out.print('*');
			}
			System.out.println();
		}
		maxValuePrint(characterMap);

	}

	public void maxValuePrint(Map<Character, Integer> dic) {
		int max = Integer.MIN_VALUE;
		char maxKey = ' ';
		for (Map.Entry<Character, Integer> elem : dic.entrySet()){
			int value = elem.getValue();
			if (value > max) {
				max = value;
				maxKey = elem.getKey();
			}
		}
		System.out.println();
		System.out.println("The most common character is \"" + maxKey + "\" that appered " + max + " times.");
	}
}
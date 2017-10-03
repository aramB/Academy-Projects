package Exercise10;

import java.util.Scanner;

public class InsertString {
	public String insertString(String inputStr, String stringToInsert, int atPosition) {
		String finalStr;
		String firstHalf;
		String secondHalf;

		if (atPosition==0) {
			finalStr = stringToInsert + inputStr;
		}
		else {
			firstHalf = inputStr.substring(0,atPosition);
			secondHalf = inputStr.substring(atPosition);
			finalStr = firstHalf + stringToInsert + secondHalf;
		}
		return finalStr;
	}
}

class Main4 {
	public static void main(String[] args) {
		InsertString insertObject = new InsertString();

		Scanner sc = new Scanner(System.in);
		System.out.println("input: ");

		String in = sc.nextLine();
		System.out.println("String to insert: ");
		String toInsert = sc.nextLine();

		System.out.println("At pos: ");
		int position = sc.nextInt();

		System.out.println(insertObject.insertString(in, toInsert, position));
	}
}

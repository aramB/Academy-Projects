package Exercise8;

import java.util.Scanner;

public class challeng {
	public static void main(String[] args) {
		asciiValue();
		lowerToUpperCase();
	}

	private static void lowerToUpperCase() {
		char[] lowerCase = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o',
							'p','q','r','s','t','u','v','w','x','y','z'};
		char[] upperCase = {'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O',
							'P','Q','R','S','T','U','V','W','X','Y','Z'};
		Scanner sc = new Scanner(System.in);
		System.out.print("Input: ");
		String s = sc.nextLine();
		char[] lower = new char[s.length()];
		String upper = "";
		for (int i = 0; i < s.length(); i++) {
			lower[i] = s.charAt(i);
		}
		for (int i = 0; i < s.length(); i++) {
			boolean checker = false;
			for (int j=0; j<lowerCase.length; j++) {
				if (lower[i] == lowerCase[j]) {
					upper += upperCase[j];
					checker = true;
					break;
				}
			}
			if (!checker) {
				upper += lower[i];
			}
		}
		System.out.println("Output: " + upper);
	}


	private static void asciiValue() {
		Scanner sc = new Scanner(System.in);
		System.out.print("Input: ");
		String str = sc.nextLine();
		StringBuilder sb = new StringBuilder();

		System.out.println("The characters are: ");
		for (int i = 0; i < str.length(); i++) {
			sb.append(str.charAt(i) + " - " + (int)str.charAt(i) + "\n");
		}
		System.out.println(sb.toString());
	}
}

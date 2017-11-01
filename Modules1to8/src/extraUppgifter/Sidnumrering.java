package extraUppgifter;

import java.util.Scanner;

public class Sidnumrering
{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = "";
		String output = "";
		System.out.print("Mata in sidnummer: ");
		while (sc.hasNextInt()) {
			int digit = sc.nextInt();
			if (digit == 0) {
				s += digit;
				break;
			}
			else {
				s += digit;
			}
		}
		for (int i = 1; i < s.length(); i++) {
			if (s.charAt(i) == s.charAt(i-1)-1) {

			}
		}

		System.out.println(s);
	}
}

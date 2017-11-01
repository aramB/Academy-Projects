package testProgramming;

import java.util.Scanner;

public class Sidnumrering
{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = "";
		String output = "";
		System.out.print("Mata in sidnummer: ");
		while (sc.hasNextInt()) {
			if (sc.nextInt() == 0) {
				s += sc.nextInt();
				break;
			}
			else {
				s += sc.nextInt();
			}
		}
		for (int i = 0; i < s.length(); i++) {

		}

		System.out.println(s);
	}
}

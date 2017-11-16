package extraUppgifter;

import java.util.Scanner;

public class Sidnumrering
{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Mata in sidnummer: ");
		int first = sc.nextInt();
		int current = first;
		String s = first + "-";
		while (sc.hasNextInt()) {
			int next = sc.nextInt();
			if (current+1 == next){
				current = next;
			}

			else if (next == 0){
				s += current;
				break;
			}
			else {
				s += current + ", ";
				current = next;
			}
			//current = next;
		}
		System.out.println(s);
	}
}

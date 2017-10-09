package exercise16;

import java.util.ArrayList;

public class Ex16p3
{
	public static void main(String[] args) {
		ArrayList<ArrayList<String>> names = new ArrayList<>();

		ArrayList<String> namesStartingWithA = new ArrayList<>();
		namesStartingWithA.add("Anders");
		namesStartingWithA.add("Andreas");
		namesStartingWithA.add("Anna");

		ArrayList<String> namesStartingWithB = new ArrayList<>();
		namesStartingWithB.add("Berit");
		namesStartingWithB.add("Bertil");
		namesStartingWithB.add("Bo");

		ArrayList<String> namesStartingWithC = new ArrayList<>();
		namesStartingWithC.add("Cecilia");
		namesStartingWithC.add("Carter");
		namesStartingWithC.add("Carl");

		names.add(namesStartingWithA);
		names.add(namesStartingWithB);
		names.add(namesStartingWithC);
		printAllNames(names);
	}

	private static void printAllNames(final ArrayList<ArrayList<String>> names) {
		for (ArrayList<String> list : names){
			for (String elem : list) {
				System.out.println(elem);
			}
		}
	}
}

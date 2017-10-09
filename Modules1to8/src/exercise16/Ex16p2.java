package exercise16;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Ex16p2
{
	public static void main(String[] args) {
		List<Integer> listA = Arrays.asList(1, 2, 3, 4, 5, 6);
		List<Integer> listB = Arrays.asList(4, 5, 6, 7, 8, 9);
		HelperClass help = new HelperClass();

		System.out.println(help.union(listA, listB));
		System.out.println(help.intersect(listA, listB));
		System.out.println(help.except(listA, listB));

	}

}

class HelperClass
{
	//Returns a new list that contains the elements from both lists, excluding duplicates.
	public List<Integer> union(List<Integer> listA, List<Integer> listB) {
		List<Integer> res = new ArrayList<>();
		for (int elem : listA) {
			res.add(elem);
		}
		for (int elem : listB) {
			if (!res.contains(elem)) {
				res.add(elem);
			}
		}
		return res;
	}

	//Returns the intersection of the two lists that only contains those element that exists in both lists.
	public List<Integer> intersect(List<Integer> listA, List<Integer> listB) {
		List<Integer> res = new ArrayList<>();
		for (int elem : listA) {
			if (listB.contains(elem)) {
				res.add(elem);
			}
		}
		return res;
	}

	public List<Integer> except(List<Integer> listA, List<Integer> listB) {
		List<Integer> res = new ArrayList<>();
		for (int elem : listA) {
			if (!listB.contains(elem)) {
				res.add(elem);
			}
		}
		return res;
	}
}

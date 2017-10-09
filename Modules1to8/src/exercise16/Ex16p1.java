package exercise16;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Ex16p1
{
	public static void main(String[] args) {

		IntegerHelper integerHelper = new IntegerHelper();

		List<Integer> nums = new ArrayList<>();
		for (int i = 1; i <= 10; i++) {
			nums.add(i);
		}

		//List<Integer> nums1 = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10); //immutable!
		//nums1.add(15); ====================================================================>>>>>> OMÖJLIGT! GÅR EJ ATT ÄNDRAS!

		//integerHelper.maxValue(nums);
		//System.out.print(nums);

		List<Integer> res = integerHelper.evenNumbers(nums);
		System.out.println(res);
	}
}

class IntegerHelper
{
	public List<Integer> evenNumbers(List<Integer> arrayList) {
		List<Integer> res = new ArrayList<>();
		for (int elem : arrayList) {
			if (elem%2 == 0) {
				res.add(elem);
			}
		}
		return res;
	}

	public int maxValue(List<Integer> arrayList) {
		int max = Integer.MIN_VALUE;
		for (int elem : arrayList) {
			if (elem > max) {
				max = elem;
			}
		}
		return max;
	}
}
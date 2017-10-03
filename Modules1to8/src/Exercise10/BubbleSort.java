package Exercise10;

import java.util.Arrays;

class Main2 {
	public static void main(String[] args) {
		int[] nums = {9,7,5,3,2,7,8,1,5,9 };
		BubbleSort bubbleSort = new BubbleSort();
		int[] result = bubbleSort.sortArray(nums);
		System.out.println(Arrays.toString(nums));
		System.out.println(Arrays.toString(result));
	}
}

public class BubbleSort {

	public int[] sortArray(int[] array) {
		int[] result = array.clone();
		for (int i = 0; i < result.length; i++) {
			for (int index = 1; index < result.length-i; index++) {
				int temp = 0;
				if (result[index-1]>result[index]) {
					temp = result[index-1];
					result[index-1] = result[index];
					result[index] = temp;
				}

			}
		}
		return result;
	}
}

package Exercise10;

import java.util.Arrays;

class Main2 {
	public static void main(String[] args) {
		int[] nums = {9,7,5,3,2,7,8,1,5,9 };
		BubbleSort bubbleSort = new BubbleSort();
		int[] result = bubbleSort.sortArray(nums);
		System.out.println(Arrays.toString(result));
	}
}

public class BubbleSort {

	public int[] sortArray(int[] array) {
		for (int i = 0; i < array.length; i++) {
			for (int index = 1; index < array.length; index++) {
				int temp = 0;
				if (array[index-1]>array[index]) {
					temp = array[index-1];
					array[index-1] = array[index];
					array[index] = temp;
				}

			}
		}
		return array;
	}
}

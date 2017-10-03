package Exercise10;

public class ArrayHelper {
	public int maxNumber(int[] array){
		int max = Integer.MIN_VALUE;
		for (int i=0; i<array.length; i++) {
			if (array[i]>max) {
				max = array[i];
			}
		}
		return max;
	}

	public int minNumber(int[] array) {
		int minValue = Integer.MAX_VALUE;
		for (int i=0; i<array.length; i++) {
			if (array[i] < minValue) {
				minValue = array[i];
			}
		}
		return minValue;
	}

	public int sumArray(int[] array) {
		int sum = 0;
		for (int elem : array) {
			sum += elem;
		}
		return sum;
	}
}

class Main {
	public static void main(String[] args) {
		int[] f = {1,2,3,4,5,6,7,8,9,10};
		ArrayHelper arrayHelper = new ArrayHelper();
		System.out.println(arrayHelper.maxNumber(f));
		System.out.println(arrayHelper.minNumber(f));
		System.out.println(arrayHelper.sumArray(f));
	}
}

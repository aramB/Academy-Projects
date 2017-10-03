package Exercise10;

import java.time.LocalDate;
import java.util.Random;

public class LottoGenerator {

	public int[] generatNumbers() {
		int[] array = new int[7];
		for (int i = 0; i < array.length; i++) {
			array[i] = generateUniqueNumber(array);
		}
		return array;
	}

	public int generateUniqueNumber(int[] array) {
		Random random = new Random();
		int randomNum;
		do {
			randomNum = random.nextInt(35) + 1;

		}while (duplicateExist(array, randomNum));
		return randomNum;
	}

	public boolean duplicateExist(int[] array, int num) {
		boolean checker = false;
		for (int elem : array) {
			if (num == elem) {
				checker = true;
			}
			else {
				checker = false;
			}
		}
		return checker;
	}
}

class Main1 {
	public static void main(String[] args) {
		LottoGenerator lotto = new LottoGenerator();
		int[] randArray = lotto.generatNumbers();
		for (int elem : randArray) {
			System.out.print(elem + " ");
		}
	}
}

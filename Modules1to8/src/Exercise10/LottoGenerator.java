package Exercise10;

import java.time.LocalDate;
import java.util.Random;

public class LottoGenerator {

	public int[] generatNumbers() {
		int[] array = getInts();
		return array;
	}

	private int[] getInts() {
		Random rand = new Random();
		int randomNum = 0;
		int[] array = new int[7];
		for (int elem : array) {
			elem = rand.nextInt(37) + 1;
		}
		return array;
	}
}

class Main1 {
	public static void main(String[] args) {
		LottoGenerator lotto = new LottoGenerator();
		System.out.println(lotto.generatNumbers());
	}
}

package extraUppgifter;

public class pyramid
{
	public static void main(String[] args) {
		int n = 3;

		for (int row = 1, i = 1; row <= n; row++) {
			for (int col = 1; col <= row; col++, i++) {
				System.out.print(i + " ");
			}
			System.out.println();
		}
	}
}

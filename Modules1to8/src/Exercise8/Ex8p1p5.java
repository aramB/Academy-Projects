package Exercise8;

public class Ex8p1p5 {
    public static void main(String[] args) {
	String input ="1,2,4,9,8,7,6,4,1";

	String[] utanKomma = input.split(",");
	int[] array = new int[utanKomma.length];

	for (int i = 0; i < array.length; i++) {
	    array[i] = Integer.parseInt(utanKomma[i]);
	}
	for (int elem: array){
	    System.out.print(elem+" ");
	}
    }
}

package Exercise8;

public class Ex8p2 {
    public static void main(String[] args) {
	for (int i=0; i<16; i++){
	    System.out.printf("%4s",i);
	}
	System.out.println();
	for (int posRow = 0; posRow < 8; posRow++) {
	    System.out.print(posRow);
	    for (int posCol = 0; posCol < 16; posCol++) {
		if (posRow==0) {
		    System.out.printf("%4c", (char)posCol);
		}
		else if (posRow>=1) {
		    System.out.printf("%4c", (char)(posCol+(posRow*16)));
		}
	    }
	    System.out.println();
	}
    }
    public static int convertIntToHex(int n) {
      return Integer.valueOf(String.valueOf(n), 16);
    }
}

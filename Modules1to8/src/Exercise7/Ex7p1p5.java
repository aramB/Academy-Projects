package Exercise7;

public class Ex7p1p5 {
    public static void main(String[] args) {
        String res = "";
        for (int i=0; i<10; i++) {
            res += i;
            System.out.print(res);
            for (int j = i; j < 9; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}

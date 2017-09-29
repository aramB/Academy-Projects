package Exercise5;

public class Ex5pkt8 {
    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            if (!((i < 5 || i > 10) && (i < 42 || i > 42))) {
                System.out.println(i);
            }
        }
    }
}


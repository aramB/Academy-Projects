package Exercise7;

import java.util.Random;

public class Ex7p1p6 {
    public static void main(String[] args) {
        int heads = 0, tails = 0;
        Random rand = new Random();
        int i = 0;
        for (; i < 100 ; i++) {
            int checker = rand.nextInt(2);
            if (checker == 0) {
                heads++;
            } else {
                tails++;
            }
        }
        System.out.println("Flipped " + i + " coins");
        System.out.println("Total heads " + heads);
        System.out.println("Total tails " + tails);
    }
}

package Exercise3;

import java.util.Scanner;

public class Ex3pkt1 {
    public static void main(String[] args) {
        Scanner in = new Scanner("12 3213 3223");
        //System.out.println("Please enter 3 numbers, one per row: ");
        String s="";
        for (int i = 0; i < 3; i++) {
            s += in.nextInt() + "\n";
        }
        System.out.println("Output: \n" + s + " ");
    }



}

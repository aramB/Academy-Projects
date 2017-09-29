package Exercise7;

public class Ex7p3 {
    public static void main(String[] args) {
        System.out.println(binaryStringToInteger("10000000")); //128
        System.out.println(binaryStringToInteger("00000001")); //1
        System.out.println(binaryStringToInteger("00001111")); //15
        System.out.println(binaryStringToInteger("11110000")); //240
        System.out.println(binaryStringToInteger("01111111")); //127
        System.out.println(binaryStringToInteger("11111111")); //255
    }

    public static int binaryStringToInteger(String input) {
        int[] bitar = new int[input.length()];
        double dec = 0;
        int power = bitar.length-1;
        for (int i = 0; i < bitar.length; i++) {
            bitar[i]=Character.getNumericValue(input.charAt(i));
            dec += bitar[i]*Math.pow(2,power);
            power--;
        }
        return (int) dec;
    }
}

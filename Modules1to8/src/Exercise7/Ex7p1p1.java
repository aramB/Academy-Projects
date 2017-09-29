package Exercise7;

public class Ex7p1p1 {
    public static void main(String[] args) {
        int[] input = {1, 4, 5, 7, 20000, -511, 100, -200, 400};
        int sum=0;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i=0; i<input.length; i++){
            sum += input[i];
            if (input[i]<min) {
                min = input[i];
            }
            if (input[i]>max) {
                max = input[i];
            }
        }
        System.out.println("Sum= " + sum);
        System.out.println("Maximum= " + max);
        System.out.println("Minimum= " + min);
    }
}

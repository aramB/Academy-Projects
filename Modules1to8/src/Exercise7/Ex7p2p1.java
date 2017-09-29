package Exercise7;

public class Ex7p2p1 {
    public static void main(String[] args) {
        int[] input = {1, 4, 5, 7, 20000, -511, 100, -201, 400};
        int n=0;
        for (int elem : input) {
            if (elem%2==0){
                n++;
            }
        }
        int[] result = new int[n];
        int counter = 0;
        for (int elem : input) {
            if (elem%2==0){
                result[counter] = elem;
                counter++;
            }

        }
        for (int item : result) {
            System.out.println(item);
        }
    }
}

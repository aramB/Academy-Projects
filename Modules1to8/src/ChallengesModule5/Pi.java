package ChallengesModule5;

public class Pi {
    public static void main(String[] args) {
        int alternate = -1;
        double sum = 0;
        double fyra=4.0;
        double term = 4711.0;
        double i=1;
        while (Math.abs(term) >1E-9) {
            //for (double i=1.0; i<=1000; i+=2){
            term = fyra / i;
            sum += term;
            fyra = alternate * fyra;
            i+=2;
        }
        System.out.println(sum);
    }
}

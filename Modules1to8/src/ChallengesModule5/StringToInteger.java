package ChallengesModule5;

public class StringToInteger {
    public static void main(String[] args) {
        String digit = "a4568";
        double multiple = 1*Math.pow(10,(digit.length()-1));
        int sum = 0;
        for (int i = 0; i < digit.length(); i++, multiple/=10) {
            int numericValue =(int)digit.charAt(i) - 48;
            sum += numericValue*multiple; //1*Math.pow(10,(digit.length()-1))
        }
        System.out.println(sum);
    }
}

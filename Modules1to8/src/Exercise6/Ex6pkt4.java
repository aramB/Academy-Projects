package Exercise6;

import java.util.Scanner;

public class Ex6pkt4 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Please enter the first num: ");
        int firstNum = in.nextInt();
        System.out.print("Please enter the second num: ");
        int secondNum = in.nextInt();
        System.out.print("Please enter operator + - * /: ");
        String operator = in.next();
        int result=0;
        switch (operator) {
            case "+":{
                result = firstNum + secondNum;
                break;
            }
            case "-":{
                result = firstNum - secondNum;
                break;
            }
            case "*":{
                result = firstNum * secondNum;
                break;
            }
            case "/":{
                result = firstNum / secondNum;
                break;
            }
            default:
                System.out.println("Invalid operator");
        }
        System.out.println("Result: "+result);
    }
}

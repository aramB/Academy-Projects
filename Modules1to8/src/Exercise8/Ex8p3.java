package Exercise8;

import java.util.Scanner;

public class Ex8p3 {
    public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	System.out.print("Input: ");
	String in = sc.nextLine();
	/*
	if (in.length() >= 2) {
	    if (Character.isDigit(in.charAt(0)) && Character.isDigit(in.charAt(1))) {
		System.out.println("OK");
	    }
	    else {
		System.out.println("Output: Input error");
	    }
	}
	*/
	/*
	if (in.contains("borg")) {
	    System.out.println("OK");
	} else {
	    System.out.println("Output: Input error");
	}
	*/
	/*
	if (in.charAt(in.length()-1) == ':') {
	    System.out.println("OK");
	} else {
	    System.out.println("Output: Input error");
	}
	*/
	/*
	boolean uppercaseChecker = true;
	for (int i=0; i<in.length(); i++){
	    if (!Character.isUpperCase(in.charAt(i))){
	        uppercaseChecker = false;
	    }
	}
	if (uppercaseChecker) {
	    System.out.println("OK");
	} else {
	    System.out.println("Output: Input error");
	}
	*/
	if (in.indexOf('(')>=0 && in.indexOf(')')>=0 && in.indexOf(')')>in.indexOf('(')){
	    System.out.println("Ok");
	}
	else {
	    System.out.println("Output: Not oK!");
	}
    }
}

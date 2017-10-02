package Exercise8;

import java.util.Scanner;

public class Ex8p7 {
	public static void main(String[] args) {
		double foodTax = 1.0/10;
		double otherTax = 25.0/100.0;
		double priceIncTax;
		double priceExTax;
		double tax = 0;
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the product name: ");
		String productName = sc.nextLine();
		System.out.print("Price per unit: ");
		int price = sc.nextInt();
		System.out.print("Quantity bought: ");
		int quantity = sc.nextInt();
		System.out.print("Food item? (y/n): ");
		String foodQuestion = sc.next();

		System.out.println("\n--- RECIPT ---");
		System.out.println("Product: " + productName + "\n");

		priceExTax = quantity*price;

		if (foodQuestion.equals("n")) {
			tax = priceExTax*otherTax;
			priceIncTax = priceExTax + tax;
		}
		else {
			tax = priceExTax*foodTax;
			priceIncTax = priceExTax + tax;
		}
		System.out.println("Total amount to pay, excluding tax: " + (int)priceExTax);
		System.out.println("Total amount to pay, including tax: " + (int)priceIncTax);
		System.out.println("Of which, tax is: " + (int)tax);
		System.out.println("-----------");

	}
}

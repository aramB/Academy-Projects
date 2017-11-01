package exercise21;

import java.util.ArrayList;
import java.util.List;

public class Ex21p1
{
	public static void main(String[] args) {

		Processor cpu1 = new Processor(1, "Intel Core I7", 3000);
		Processor cpu2 = new Processor(2, "AMD threadripper", 3500);
		Keyboard kbd = new Keyboard(3, "Microsoft Natural keyboard");
		Monitor monitor = new Monitor(4, "Samsung T191T");

		List<Product> productList = new ArrayList<>();

		productList.add(cpu1);
		productList.add(cpu2);
		productList.add(kbd);
		productList.add(monitor);

		printProducts(productList);

	}
	private static void printProducts(List<Product> lista) {
		for (Product elem : lista) {
			elem.describe();
		}
	}
}


interface Product
{
	//public boolean isForSale;
	void describe();
}

class Processor implements Product
{
	private int id;
	private String productName;
	private int frequency;
	private int numberOfCores;

	public Processor(final int id, final String productName, final int frequency) {
		this.id = id;
		this.productName = productName;
		this.frequency = frequency;
	}

	@Override public void describe() {
		System.out.printf("Name: %s (ID:%d)" + "\n" + " frequency: %d" + "\n" + " numberOfCores: %d" + "\n", productName, id, frequency,
						  numberOfCores);
	}
}

class Keyboard implements Product
{
	private int id;
	private String productName;
	private boolean gotNumericKeypad;
	private String color;
	private boolean isWireless;

	public Keyboard(final int id, final String productName)
	{
		this.id = id;
		this.productName = productName;
	}

	@Override public void describe() {
		System.out.printf("Name: %s (ID:%d)" + "\n" + " gotNumericKeypad: %b" + "\n" + " color: %s" + "\n" + " isWireless: %b" + "\n",
						  productName, id, gotNumericKeypad, color, isWireless);
	}
}

class Monitor implements Product
{
	private int id;
	private String productName;
	private int size;
	private float weight;

	public Monitor(final int id, final String productName) {
		this.id = id;
		this.productName = productName;
	}

	@Override public void describe() {
		System.out.printf("Name: %s (ID:%d)" + "\n" + " size: %d" + "\n" + " wight: %f", productName, id, size, weight);
	}
}

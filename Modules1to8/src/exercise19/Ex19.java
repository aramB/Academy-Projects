package exercise19;

import java.util.ArrayList;
import java.util.List;

public class Ex19
{
	public static void main(String[] args) {
		Processor cpu1 = new Processor();
		Processor cpu2 = new Processor();
		Keyboard kbd = new Keyboard();
		Monitor monitor = new Monitor();
		List<Product> productList = new ArrayList<>();

		productList.add(cpu1);
		productList.add(cpu2);
		productList.add(kbd);
		productList.add(monitor);

		cpu1.productName = "Intel Core I7";
		cpu1.frequency = 3000;

		cpu2.productName = "Amd threadripper";
		cpu2.frequency = 3500;

		kbd.productName = "Microsoft Natural keyboard";

		monitor.productName = "Samsung T191T";

		printProducts(productList);
	}

	private static void printProducts(List<Product> lista) {
		for (Product elem : lista) {
			if (elem instanceof Processor) {
				System.out.print(elem.productName + "\nFreq: ");
				System.out.println(((Processor) elem).frequency);
			}
			else {
				System.out.println(elem.productName);
			}
		}
	}
}

class Product
{
	public int id;
	public String productName;
	public boolean isForSale;

}

class Processor extends Product
{
	public int frequency;
	public int numberOfCores;
}

class Keyboard extends Product
{
	public boolean gotNumericKeypad;
	public String color;
	public boolean isWireless;
}

class Monitor extends Product
{
	public int size;
	public float weight;
}

package exercise20;


import java.util.ArrayList;
import java.util.List;

public class Ex20p1
{
	public static void main(String[] args) {
		Processor cp1 = new Processor();

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
		cpu1.id = 1;
		cpu1.frequency = 3000;
		cpu2.productName = "Amd threadripper";
		cpu2.id = 2;
		cpu2.frequency = 3500;
		kbd.productName = "Microsoft Natural keyboard";
		kbd.id = 3;
		monitor.productName = "Samsung T191T";
		monitor.id = 4;

		printProducts(productList);

	}

	private static void printProducts(List<Product> lista) {
		for (Product elem : lista) {
			elem.describe();
		}
	}
}

abstract class Product
{
	public int id;
	public String productName;
	public boolean isForSale;

	public abstract void describe();

}

class Processor extends Product
{
	public int frequency;
	public int numberOfCores;

	@Override public void describe() {
		System.out.printf("Name: %s (ID:%d)" + "\n" + " frequency: %d" + "\n" + " numberOfCores: %d" + "\n", productName, id, frequency,
						  numberOfCores);
	}
}

class Keyboard extends Product
{
	public boolean gotNumericKeypad;
	public String color;
	public boolean isWireless;

	@Override public void describe() {
		System.out.printf("Name: %s (ID:%d)" + "\n" + " gotNumericKeypad: %b" + "\n" + " color: %s" + "\n" + " isWireless: %b" + "\n",
						  productName, id, gotNumericKeypad, color, isWireless);
	}
}

class Monitor extends Product
{
	public int size;
	public float weight;

	@Override public void describe() {
		System.out.printf("Name: %s (ID:%d)" + "\n" + " size: %d" + "\n" + " wight: %f", productName, id, size, weight);
	}
}
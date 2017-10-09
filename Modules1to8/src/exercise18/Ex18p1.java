package exercise18;

public class Ex18p1
{
	public static void main(String[] args) {

		Processor cpu = new Processor();
		Monitor monitor = new Monitor();
		LCDMonitor lcdMonitor = new LCDMonitor();
		Product product = new Product();

		cpu.setId(1040);
		cpu.productName="Intel Core i7";
		cpu.isForSale=true;
		cpu.frequency=3000;
		cpu.numberOfCores=8;
	}
}
class Processor extends Product
{
	public int frequency;
	public int numberOfCores;
}

class Monitor extends Product
{
	int size;
	float weight;
}

class LCDMonitor extends Monitor
{
	boolean touchEnabled;
	boolean vesaMount;
	boolean hasSpeaker;

	public void print() {
		System.out.printf("ProductID {0}\r\n", getId());
		System.out.printf("Size {0}\r\n", size);
		System.out.printf("TouchEnabled {0}\r\n", touchEnabled);
	}
}

class Product
{
	private int id;
	public String productName;
	public boolean isForSale;

	public int getId() {
		return id;
	}

	public void setId(final int id) {
		this.id = id;
	}
}

class CRTMonitor
{
	int refreshRate;
	boolean environmentFriendly;
}

class Keyboard extends Product
{
	public boolean gotNumericKeypad;
	public String color;
	public boolean isWireless;
}

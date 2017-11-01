package exercise22;

public class Ex22p1
{
	public static void main(String[] args) {
		// write your code here
		Volvo volvo = new Volvo();
		Tesla tesla = new Tesla();

		method1(volvo);
		method2(tesla);
		method3(tesla);

		Car car1 = new Volvo();
		Car car2 = new Tesla();
		Car car3 = volvo;
		Car car4 = tesla;

		Tesla tesla1 = new Tesla();
		Car tesla2 = tesla1;
		Tesla tesla3 = (Tesla) tesla2;
	}

	private static void method1(Volvo car) {
		car.start();
		car.stop();
	}

	private static void method2(Tesla car) {
		car.start();
		car.stop();
	}

	private static void method3(Car car) {
		car.start();
		car.stop();
	}
}

interface Car
{
	void start();
	void stop();
}

class Volvo implements Car
{
	@Override public void start() { }
	@Override public void stop() { }
}

class Tesla implements Car
{
	@Override public void start() { }
	@Override public void stop() { }

	public void ChargeBattery() {
		System.out.println("Charging battery");
	}
}

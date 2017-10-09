package exercise15.ex15p1;

public class Main {
	public static void main(String[] args) {
		Tire[] tire = new Tire[4];
		Door[] door = new Door[4];
		for (int i = 0; i < tire.length; i++) {
			tire[i] = new Tire(100);
			door[i] = new Door(150);
		}

		Car car = new Car(1000, tire, door);
		System.out.println("Total car weight " + car.getWeight());
	}
}

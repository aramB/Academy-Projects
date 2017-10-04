package exercise13;

public class Car {
	public String model;
	public int age;

	public Car(String model, int age) {
		this.model = model;
		this.age = age;
	}
}

class Main {
	public static void main(String[] args) {
		// write your code here
		Car car = new Car("Volvo", 20);
		System.out.println(car.model);
		System.out.println(car.age);
	}
}

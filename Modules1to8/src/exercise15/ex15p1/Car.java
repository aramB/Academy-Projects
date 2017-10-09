package exercise15.ex15p1;

public class Car {
	private Tire[] wheels;
	private Door[] doors;
	private float weight;

	//Tire tireWeightEach = new Tire(100);
	//Door doorWeightEach = new Door(150);

	public Car (float weight, Tire[] wheels, Door[] doors) {
		this.weight = weight;
		this.wheels = wheels;
		this.doors = doors;
	}

	//Implement logic here to get the total weight of
	// the car + all the doors and wheels
	public float getWeight() {
		float totalWeight;
		float wheelWeight = 0, doorsWeight = 0;
		for(Tire elem : wheels) {
			wheelWeight += elem.getWeight();
		}
		for (Door elem : doors) {
			doorsWeight += elem.getWeight();
		}
		totalWeight = wheelWeight + doorsWeight + weight;
		return totalWeight;
	}
}

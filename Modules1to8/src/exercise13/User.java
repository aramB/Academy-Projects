package exercise13;

public class User {
	public String name;
	public String city;
	public String country;
	public int age;

	public User() {
		this.name = null;
		this.city = null;
		this.country = null;
		this.age = 0;
	}

	public User(String name, String city, String country, int age) {
		this.name = name;
		this.city = city;
		this.country = country;
		this.age = age;
	}

	public User(String name, String city) {
		this.name = name;
		this.city = city;
	}
}

class Main1 {
	public static void main(String[] args) {
		User u1 = new User("kalle", "Linköping", "Sweden", 12);
		User u3 = new User("Adam", "Helsingborg", "Sweden", 45);
		User u4 = new User();
		System.out.println(u3.name);
		System.out.println(u3.city);
		System.out.println(u3.country);
		System.out.println(u3.age);
	}
}

package exercise12;

public class User {
	public String name;
	public String city;
	public String country;
	public int age;
}

class SearchUsers {
	public int getMaxAgedUser(int[] array){

	}
}

class Main1 {
	public static void main(String[] args) {
		User[] users = new User[3];

		User u1 = new User();
		u1.name = "Kalle";
		u1.city = "Stockholm";
		u1.country = "Sweden";
		u1.age = 25;
		users[0] = u1;

		User u2 = new User();
		u2.name = "Joel";
		u2.city = "Malmö";
		u2.country = "Sweden";
		u2.age = 55;
		users[1] = u2;

		User u3 = new User();
		u3.name = "Adam";
		u3.city = "Helsingborg";
		u3.country = "Sweden";
		u3.age = 45;
		users[2] = u3;

		SearchUsers susers = new SearchUsers();
		int maxage = susers.getMaxAgedUser(users);
		System.out.println("max age= " + maxage);
	}
}
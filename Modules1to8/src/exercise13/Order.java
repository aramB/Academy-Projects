package exercise13;

public class Order {
	public int id;
	private String product;

	public Address home;
	public Address delivery; //referenser till ett adress-objekt
	public Address invoice;

	public Order(int id, String product, Address home, Address delivery, Address invoice) {
		this.id = id;
		this.product = product;
		this.home = home;
		this.delivery = delivery;
		this.invoice = invoice;
	}
}

class Address {
	public String city, country, name, addressline1, addressline2;
	public int zipcode;

	public Address(String city, String country) {
		this.city=city;
		this.country=country;
	}
}
class Main2{
	public static void main(String[] args) {
		Address home = new Address("sthlm", "sweden");
		Order order1 = new Order(12, "produkt", home, home, home);
		//System.out.println(order1.product);

	}
}
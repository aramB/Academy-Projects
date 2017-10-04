package exercise14;

public class Customer {
	private int id;
	private String name;
	private String address;
	private String zipcode;
	private String city;
	private String email;

	public Customer(final int id, final String name, final String address, final String zipcode, final String city,
					final String email)
	{
		this.setId(id);
		this.setName(name);
		this.setAddress(address);
		this.setZipcode(zipcode);
		this.city = city;
		this.email = email;
	}

	public int getId() {
		return id;
	}

	public void setId(final int id) {
		if (id < 0){
			this.id = 0;
		}
		else {
			this.id = id;
		}
	}

	public String getName() {
		return name;
	}

	public void setName(final String name) {
		if (name.length() == 0) {
			this.name = "Unknown";
		}
		else {
			this.name = name;
		}
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(final String address) {
		if (address.length()>20) {
			this.address = address.substring(0,20);
		}
		else {
			this.address = address;
		}
	}

	public String getZipcode() {
		return zipcode;
	}

	public void setZipcode(final String zipcode) {
		if (zipcode.length()==5) {
			for (int i = 0; i < zipcode.length(); i++) {
				if (Character.isDigit(i)) {
					this.zipcode = zipcode;
				} else {
					this.zipcode = "00000";
				}
			}
		}
		else {
			this.zipcode = "00000";
		}

	}

	public String getCity() {
		return city;
	}

	public void setCity(final String city) {
		this.city = city;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(final String email) {
		//TODO: kan kompletteras, orkar inte nu!
		this.email = email;
	}
}

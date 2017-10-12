package exercise20;

import org.joda.money.CurrencyUnit;
import org.joda.money.Money;

import java.util.ArrayList;
import java.util.List;

public class Ex20p3
{
	public static void main(String[] args) {

		Order order = new Order("Edument AB");

		order.addOrderLine(new OrderLine("Widget A", 10, Money.of(CurrencyUnit.EUR, 3.14)));
		order.addOrderLine(new OrderLine("Widget B", 10, Money.of(CurrencyUnit.EUR, 9.95)));
		System.out.println(order);
		System.out.println("Total: " + order.getOrderTotal());
	}
}

class Order
{
	private List<OrderLine> orderlines;
	public String customerName;

	public Order(final String customerName) {
		this.customerName = customerName;
		orderlines = new ArrayList<>();
	}

	public void addOrderLine(OrderLine orderLine) {
		orderlines.add(orderLine);
	}

	public List<OrderLine> getAllOrderLnes() {
		return orderlines;
	}

	public String toString() {
		String s= "";
		String name = customerName;
		for (OrderLine elem : getAllOrderLnes()) {
			s += " \n " + elem.toString();
		}
		return name + s;
	}

	public Money getOrderTotal() {
		Money total=Money.of(CurrencyUnit.EUR,0.00);
		for (OrderLine elem : getAllOrderLnes()) {
			total = total.plus(elem.getOrderTotal());
		}
		return total;
	}
}

class OrderLine
{
	public String productName;
	public int quantity;
	public Money price;

	public OrderLine(final String productName, final int quantity, final Money price) {
		this.productName = productName;
		this.quantity = quantity;
		this.price = price;
	}

	public String toString(){
		String s;
		s = productName + ", " + quantity + " items, price per item " + price;
		return s;
	}

	public Money getOrderTotal() {
		Money total = price.multipliedBy(quantity);
		return total;
	}
}
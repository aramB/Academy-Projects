package exercise22;

import org.joda.money.CurrencyUnit;
import org.joda.money.Money;

import java.util.ArrayList;
import java.util.List;

public class Ex22p2
{
	public static void main(String[] args) {

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
		Money total=Money.of(CurrencyUnit.EUR, 0.00);
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

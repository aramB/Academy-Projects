package se.edument;

import java.util.List;

/**
 * Created by Tore on 2017-02-16.
 */
public class Order {
    public int id;
    public String customerId;
    List<OrderLine> orderLines;

    public Order(int Id, String customerId, List<OrderLine> orderLines) {
        this.id = Id;
        this.customerId = customerId;
        this.orderLines = orderLines;
    }

    public Order(String customerId, List<OrderLine> orderLines) {
        this.id = 0;
        this.customerId = customerId;
        this.orderLines = orderLines;
    }
}


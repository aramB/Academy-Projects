package se.edument;
import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;


import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


/**
 * The unit tests against our NorthwindRepo class
 */
public class NorthwindRepoTest {

    //sut is the object that we are testing
    private static NorthwindRepo sut;

    private String connstr = "jdbc:sqlserver://localhost;databasename=Northwind;user=sqluser;password=pass";

    /**
     * The @Before causes this Setup method to always be executed before every test.
     */
    @Before
    public  void SetUp() {

        try {
            sut = new NorthwindRepo(connstr);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Given an object instance of NorthwindRepo
     * When we call rep.countProductsInCategory(2)
     * Then we get back an integer greater than 0
     */
    @Test
    public void countProductByCategory() {
        int numberOfProducts = sut.countProductByCategory(2);
        Assert.assertTrue(numberOfProducts > 0);

    }

    /**
     *
     * Given an object instance of NorthwindRepo
     * When we call rep.getProduct(2)
     * Then we get a product with the correct Id and name back
     */
    @Test
    public void getProductById() {
        Product prod = sut.getProduct(2);
        Assert.assertEquals(prod.id, 2);
        Assert.assertEquals(prod.name, "Chang");
    }

    /**
     *
     * Given an object instance of NorthwindRepo
     * When we call rep.getProduct(99999999)  for a non-existing product
     * Then we get null back
     */
    @Test
    public void getNonExistingProductByIdReturnsNull() {
        Product prod = sut.getProduct(99999999);
        Assert.assertNull(prod);
    }


    /**
     * Given an object instance of NorthwindRepo
     * When we call rep.getProduct(“Chang”)
     * Then we get back a product with the correct product name back
     */
    @Test
    public void getProductByName() {
        Product prod = sut.getProduct("Chang");
        Assert.assertEquals(prod.id, 2);
        Assert.assertEquals(prod.name, "Chang");
    }


    /**
     * Given an object instance of NorthwindRepo
     * When we call rep.getProduct(“XXXXXX”) for a non-existing product
     * Then we get null back
     */
    @Test
    public void getNonExistingProductByNameReturnsNull() {
        Product prod = sut.getProduct("XXXXXX");
        Assert.assertNull(prod);
    }



    /**
     *
     * Given an object instance of NorthwindRepo
     * When we call rep.allProducts()
     * Then we get back an integer of more than 0 entries
     */
    @Test
    public void allProducts() {
        ArrayList<Product> allProducts = sut.allProducts();
        Assert.assertTrue( allProducts.size() > 0);
    }

    /**
     *
     * Given an object instance of NorthwindRepo
     * When we call rep.getCustomer(“ALFKI”)
     * Then We get back a Customer object with the id of “ALFKI”
     */
    @Test
    public void getCustomerExistingCustomer() {
        Customer customer = sut.getCustomer("ALFKI");
        Assert.assertEquals(customer.id, "ALFKI");
    }


    /**
     *
     * Given an object instance of NorthwindRepo
     * When we call rep.getCustomer(“XXXXXX”) for a non-existing customer
     * Then we get null back
     */
    @Test
    public void getNonExistingCustomerShouldReturnNull() {
        Customer customer = sut.getCustomer("XXXXXX");
        Assert.assertNull(customer);
    }



    /**
     * Given an object instance of NorthwindRepo
     * When we call rep.getCustomersByCompany(“Around the Horn”)
     * Then we get one customer back with the correct company name and id
     */
    @Test
    public void getCustomerByCompanyName(){
        ArrayList<Customer> customerByCompany = sut.getCustomerByCompanyName("Around the Horn");
        Assert.assertTrue(customerByCompany.size() == 1);
        Assert.assertEquals(customerByCompany.get(0).companyName, "Around the Horn");
        Assert.assertEquals(customerByCompany.get(0).id, "AROUT");
    }

    /**
     * Given an object instance of NorthwindRepo
     * When we call rep.getOrder(10248)
     * Then we get an order with correct customerID back
     *      we get an order with 3 order lines
     *      we get an order with correct id set
     */
    @Test
    public void getExistingOrderShouldReturnCorrectOrder() {
        Order order = sut.getOrder(10248);
        Assert.assertEquals(order.id, 10248);
        Assert.assertEquals(order.customerId, "VINET");
        Assert.assertEquals(order.orderLines.size(), 3);
    }

    /**
     * Given an object instance of NorthwindRepo
     * When we call rep.getOrder(999999)
     * Then we get null back
     */
    @Test
    public void getNonExistingOrderShouldReturnNull() {
        Order order = sut.getOrder(999999);
        Assert.assertNull(order);
    }

    /**
     * ### THIS IS THE MOST ADVANCED TEST! TRY TO MAKE IT! BUT DO THE OTHERS FIRST ###
     *
     * Given an object instance of NorthwindRepo
     *       a new Order Object
     * When we call rep.CreateNewOrder(order))
     * Then we get the new orderID back that is >0
     */
    @Test
    public void CanCreateNewOrders() throws SQLException {

        List<OrderLine> orderlines = new ArrayList<>();
        orderlines.add(new OrderLine(1,10));
        orderlines.add(new OrderLine(2,20));
        orderlines.add(new OrderLine(3,30));

        Order order = new Order("ALFKI", orderlines);

        int orderId = sut.CreateNewOrder(order);
        Assert.assertTrue(orderId>0);
    }
}
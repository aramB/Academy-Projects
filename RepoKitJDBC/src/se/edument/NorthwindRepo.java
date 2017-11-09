package se.edument;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * NorthwindRepo repository class
 */
public class NorthwindRepo {
    private Connection dbconn;

    private Boolean inTransaction = false;


    /**
     * Constructor thast creates the connection object to be used by the methods
     *
     * @param connstr
     * @throws RuntimeException
     */
    public NorthwindRepo(String connstr) throws RuntimeException {
        try {
            dbconn = DriverManager.getConnection(connstr);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e.getMessage());
        }
    }

    /**
     * returns a list of all the products
     *
     * @return
     */
    public ArrayList<Product> allProducts() {
        ArrayList<Product> productList = new ArrayList<>();
        try {
            Statement stm = dbconn.createStatement();
            ResultSet res = stm.executeQuery("Select ProductID, ProductName from dbo.products");
            while (res.next()){
                Product productObject = new Product(res.getInt(1),res.getString(2));
                productList.add(productObject);
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            if (dbconn!=null){
                try {
                    dbconn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return productList;
    }

    /**
     * returns a product by ID or null if not found
     *
     * @param productId
     * @return
     */
    public Product getProduct(int productId) {
        try{
            PreparedStatement pstm = dbconn.prepareStatement("select productid, productname " +
                    "from dbo.products " +
                    "where productID = ?");
            pstm.setInt(1, productId);
            ResultSet res = pstm.executeQuery();
            if (res.next()){
                return new Product(res.getInt(1),res.getString(2));
            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        finally {
            if (dbconn != null){
                try {
                    dbconn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        /*ArrayList<Product> products = allProducts();
        for (Product elem : products) {
            if (elem.id == productId){
                return elem;
            }
        }*/
        return null;
    }


    /**
     * returns a product by name or null if not found
     *
     * @param productName
     * @return
     */
    public Product getProduct(String productName) {
        try{
            PreparedStatement pstm = dbconn.prepareStatement("select productid, productname " +
                    "from dbo.products " +
                    "where productname = ?");
            pstm.setString(1, productName);
            ResultSet res = pstm.executeQuery();
            if (res.next()){
                return new Product(res.getInt(1),res.getString(2));
            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        finally {
            if (dbconn != null){
                try {
                    dbconn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;

    }

    /**
     * Counts the number of products in the provided categoryId
     *
     * @param categoryId
     * @return
     */
    public int countProductByCategory(int categoryId) {
        try{
            PreparedStatement pstm = dbconn.prepareStatement("SELECT COUNT(*) FROM dbo.products " +
                    "WHERE categoryID = ?");
            pstm.setInt(1, categoryId);
            ResultSet resultSet = pstm.executeQuery();
            if (resultSet.next()){
                int numOfProdByCatID = resultSet.getInt(1);
                return numOfProdByCatID;
            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        finally {
            if (dbconn!=null){
                try {
                    dbconn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return 0;
    }

//====================================================================================
//====================================================================================
    /**
     * returns a customer by ID (these are strings in Northwind)
     *
     * @param customerId
     * @return
     */
    public Customer getCustomer(String customerId) {
        try {
            PreparedStatement pstm = dbconn.prepareStatement("SELECT customerid, companyname FROM Customers " +
                    "WHERE customerid = ?");

            pstm.setString(1, customerId);
            ResultSet res = pstm.executeQuery();
            if (res.next()) {
                Customer customer = new Customer(res.getString(1), res.getString(2));
                return customer;
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            if (dbconn!=null){
                try {
                    dbconn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }

    /**
     * returns a list of customer objects associated with the company name provided
     * <p>
     * We return a list because we might have custonmers with the same company name
     *
     * @param companyName
     * @return
     */
    public ArrayList<Customer> getCustomerByCompanyName(String companyName) {
        ArrayList<Customer> customers = new ArrayList<>();

        try {
            PreparedStatement pstm = dbconn.prepareStatement("SELECT CustomerID, CompanyName " +
                    "FROM Customers " +
                    "WHERE companyName = ?");

            pstm.setString(1, companyName);
            ResultSet res = pstm.executeQuery();
            while (res.next()){
                Customer customerObject = new Customer(res.getString(1), res.getString(2));
                customers.add(customerObject);
            }
            return customers;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            if(dbconn!=null){
                try {
                    dbconn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }


    /**
     * returns an order identified by the identifier passed in
     *
     * @param orderId
     * @return
     */
    public Order getOrder(int orderId) {
        List<OrderLine> orderLines = new ArrayList<>();
        try {
            PreparedStatement pstm = dbconn.prepareStatement(
                    "SELECT Orders.CustomerID," +
                    "[Order Details].ProductID, " +
                    "[Order Details].Quantity " +
                    "FROM [Order Details] " +
                    "INNER JOIN Orders " +
                    "ON [Order Details].OrderID = Orders.OrderID " +
                    "WHERE Orders.OrderID = ?");
            pstm.setInt(1, orderId);
            ResultSet res = pstm.executeQuery();

            while (res.next()) {
                System.out.println(res.getInt(2) + " "+ res.getInt(3));
                OrderLine orderLine = new OrderLine(res.getInt(2), res.getInt(3));
                orderLines.add(orderLine);
            }
            if (orderLines.size() > 0) {
                //we found data
                return new Order(orderId, res.getString(1), orderLines);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            if (dbconn!=null){
                try {
                    dbconn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }


    /**
     * Insert a new order to the database
     * <p>
     * We only need to set the fields we have in the Order and OrderLine object
     * <p>
     * Do google for Statement.RETURN_GENERATED_KEYS fow how to get the inserted ID back.
     * <p>
     * To insert the order lines look at the executeBatch method.
     * see http://stackoverflow.com/questions/12012592/jdbc-insert-multiple-rows
     *
     * @param order
     * @return
     */
    public int CreateNewOrder(Order order) throws SQLException {

        return 0;
    }


    /**
     * Private helper method that builds a Customer out of provided resultsets
     * That you can use but not required
     *
     * @param res
     * @return
     * @throws SQLException
     */
    private Customer newCustomer(ResultSet res) throws SQLException {
        // todo, pull data from result set
        return new Customer(res.getString(1), res.getString(2));
    }


    /**
     * Private method that is used to map a resultset to an object
     * That you can use but not required
     * @param res
     * @return
     * @throws SQLException
     */
    private Product newProduct(ResultSet res) throws SQLException {

        Product prod = new Product(res.getInt(1), res.getString(2));
        return prod;
    }
}
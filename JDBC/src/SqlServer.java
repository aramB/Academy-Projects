import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.*;

public class SqlServer {
    public static void main(String[] args) {
        String connStr = "jdbc:sqlserver://localhost;databasename=Northwind;user=sqluser;password=pass";

        Connection dbConn = null;

        try{
            dbConn = DriverManager.getConnection(connStr);
            Statement stmt = dbConn.createStatement();
            //ResultSet rs = stmt.executeQuery("Select COUNT(*) as NumberOfCustomers from dbo.Customers");
            ResultSet rs = stmt.executeQuery("select EmployeeID,\n" +
                    "\t   LastName,\n" +
                    "\t   FirstName,\n" +
                    "\t   Title,\n" +
                    "\t   Country\n" +
                    "from dbo.Employees\n" +
                    "where EmployeeID=9;\n");
            /*while (rs.next()) {
                //int test = rs.getInt(1);
                int count = rs.getInt("NumberOfCustomers");
                System.out.println(count);
            }*/

            while(rs.next()){
                String employeeID = rs.getString("EmployeeID");
                String lastName = rs.getString("LastName");
                String firstName = rs.getString("FirstName");
                String title = rs.getString("Title");
                String country = rs.getString("Country");
                System.out.print("ID: " + employeeID +
                        "\nLastName: " + lastName +
                        "\nFistName: " + firstName +
                        "\nTitle: " + title +
                        "\nCountry: " + country);
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            if (dbConn != null){
                try {
                    dbConn.close();
                }
                catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        System.out.println("Done!");
    }
}

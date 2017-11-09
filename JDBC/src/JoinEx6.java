import java.sql.*;

public class JoinEx6 {
    public static void main(String[] args) {
        String connStr = "jdbc:sqlserver://localhost;databasename=Northwind;user=sqluser;password=pass";

        Connection dbConn = null;

        try {
            dbConn = DriverManager.getConnection(connStr);
            Statement stmt = dbConn.createStatement();
            ResultSet rs = stmt.executeQuery(
                    "SELECT  Employees.EmployeeID, " +
                            "Employees.LastName, " +
                            "Employees.FirstName, " +
                            "Territories.TerritoryID, " +
                            "Territories.TerritoryDescription\n" +
                            "FROM  Employees INNER JOIN\n" +
                            "EmployeeTerritories ON " +
                            "Employees.EmployeeID = EmployeeTerritories.EmployeeID " +
                            "INNER JOIN\n" +
                            "Territories ON " +
                            "EmployeeTerritories.TerritoryID = Territories.TerritoryID\n" +
                            "WHERE (Employees.EmployeeID = 9)"
            );

            String id, lastName, firstName, territoryID, terDesc;
            while (rs.next()){
                id = rs.getString("EmployeeID");
                lastName = rs.getString("LastName");
                firstName = rs.getString("FirstName");
                territoryID = rs.getString(4);
                terDesc = rs.getString(5);
                System.out.println(rs.getRow()+ ": " +
                        id+ ", " +
                        lastName+ ", " +
                        firstName+ ", " +
                        territoryID+ ", " +
                        terDesc
                );
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
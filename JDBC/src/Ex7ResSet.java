import java.sql.*;

public class Ex7ResSet {
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

            ResultSetMetaData rsmd = rs.getMetaData();

            /*String id, lastName, firstName, territoryID, terDesc;
            while (rs.next()){
                id = rs.getString(1);
                lastName = rs.getString(2);
                firstName = rs.getString(3);
                territoryID = rs.getString(4);
                terDesc = rs.getString(5);
                System.out.println(rs.getRow()+ ": " +
                        id+ ", " +
                        lastName+ ", " +
                        firstName+ ", " +
                        territoryID+ ", " +
                        terDesc
                );
            }*/
            System.out.println("Columns: "+rsmd.getColumnCount());
            for (int i = 1; i <= rsmd.getColumnCount() ; i++) {
                System.out.println("Column "+rsmd.getColumnName(i)+"("+rsmd.getColumnTypeName(i)+")");
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

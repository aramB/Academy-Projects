import java.sql.*;

public class Ex8PreparedStatments {
    public static void main(String[] args) {
        getProductName(230857230);
        //System.out.println(getProductName(1));
    }

    public static String getProductName(int productID){
        String connStr = "jdbc:sqlserver://localhost;databasename=Northwind;user=sqluser;password=pass";

        Connection dbConn = null;

        String stm = "select ProductName from dbo.Products where ProductID = ?";
        try{
            dbConn = DriverManager.getConnection(connStr);
            PreparedStatement pstm = dbConn.prepareStatement(stm);
            pstm.setInt(1, productID);
            ResultSet res = pstm.executeQuery();
            if (!res.next()){
                System.out.println("\"\"");
            }
            else {
                System.out.println(res.getString(1));
            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        finally {
            if (dbConn!=null){
                try {
                    dbConn.close();
                }
                catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return "";
    }
}

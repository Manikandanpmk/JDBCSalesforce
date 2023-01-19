import java.sql.*;
public class Salesforce {
    static Connection connection = null;
    static DatabaseMetaData metadata = null;

    public static void main(String args[]) throws SQLException {
        //Registering the Driver
        Connection connection = null;
        connection = DriverManager.getConnection("jdbc:salesforce:User=support@nsoftware.com;Password=!nBanana1111;Security Token=DCvIH8H8P0yCQE41X6tA7SS48;");
        Statement stat = connection.createStatement();
        boolean ret = stat.execute("SELECT BillingState, Name FROM Account");
        if (ret) {
            ResultSet rs = stat.getResultSet();
            while (rs.next()) {
                for (int i = 1; i <= rs.getMetaData().getColumnCount(); i++) {
                    System.out.println(rs.getMetaData().getColumnLabel(i) + "=" + rs.getString(i));
                }
            }
        }
    }
}
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLNonTransientConnectionException;
import java.sql.Statement;

import com.google.api.client.util.Data;

/**
* A sample app that connects to a Cloud SQL instance and lists all available tables 
in a database.
*/

public class Database {
public static void main(String[] args) throws SQLNonTransientConnectionException 
,IOException, SQLException {

Connection connection = Database.getConnect();
try (Statement statement = connection.createStatement()) {
//   statement.executeUpdate("INSERT INTO categories VALUES (01, \"Head Accessories\"), (02, \"Tops\"), (03, \"Pants\"), (04, \"Shoes\"), (05, \"Cultural\");");
  ResultSet resultSet = statement.executeQuery("Select * from categories");
  while (resultSet.next()) {
    System.out.println(resultSet.getString(2));
  }
}catch(Exception e){
  e.printStackTrace();
}
}

/**
     * SSH using credentials and then connect to DB
     * @return Connection
     */
    public static Connection getConnect() {

        Connection conn = null;
        try {
            // now connect to DB
            String instanceConnectionName = "vast-zodiac-379618:us-central1:wichacks";
                String databaseName = "dressUp";


                String IP_of_instance = "10.83.160.3";
                String username = "wichacks";
                String password = "imsohungry";

                String jdbcUrl = String.format(
                        "jdbc:mysql://%s/%s?cloudSqlInstance=%s"
                         + "&socketFactory=com.google.cloud.sql.mysql.SocketFactory&useSSL=false",
                IP_of_instance,
                databaseName,
                instanceConnectionName);

                Connection connection = DriverManager.getConnection(jdbcUrl, username, password);
                conn = connection;


        }
        catch (SQLException e) {
        }

        return conn;
    }

    /**
     *
     * @param username
     * @param password
     * @return if the user exists, it returns the user id.
     */
    public static int verifyLogin(String username, String password) {
        Connection conn = Database.getConnect();

        try {
            PreparedStatement st = (PreparedStatement) conn
                    .prepareStatement("Select username, password from userInfo where username=?;");

            st.setString(1, username);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                if (password == rs.getString(2)) {
                    return 1;
                    //update most recent access date
                }
                else return -1;
        }
            
        } catch (SQLException e) {

        }

        return -1;

    }

    public static int createUser(String username, String password, String country) throws IOException {
        Connection conn = Database.getConnect();

        try {
            PreparedStatement st = (PreparedStatement) conn
                    .prepareStatement("INSERT INTO userInfo VALUES (?, ?, ?);"); 
            st.setString(1, username);
            st.setString(2, password);
            st.setString(3, country);
            System.out.println(st);
            int rs = st.executeUpdate();
            if(rs == 1){
                return 1;
            }
        } catch (SQLException e) {
            }

        return -1;

    }

}
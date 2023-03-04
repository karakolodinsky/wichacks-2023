import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class User {
    private Connection conn; // not working yet
    private String username;
    private String password;
    private String country;
    /**
     * Makes a User
     * @param username: String
     * @param password: String
     */
    public User(String username, String password, String country){
        this.username = username;
        this.password = password;
        this.country = country;
    }

    public int addUser(User user) {
        try {
            int result = 0;
            String sql = "INSERT INTO userInfo (username, password, country) VALUES (?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, user.getUsername());
            ps.setString(2, user.getPassword());
            ps.setString(3, user.getCountry());

            result = ps.executeUpdate();
            return(result);
        } // end of try

        catch(SQLException sqle) {
            sqle.printStackTrace();
            return -1;
        } // end of catch
    }



    /**
     * @return String of User's ID
     */
    public String getUsername(){
        return this.username;
    }
    /**
     * @return String of User's password
     */
    public String getPassword(){
        return this.password;
    }
    /**
     * @return String of user's country
     */
    public String getCountry() {
        return this.country;
    }
}

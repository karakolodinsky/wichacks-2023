public class User {

    private String userID;
    private String password;
    private String country;
    /**
     * Makes a User
     * @param userID: String
     * @param password: String
     */
    public User(String userID, String password, String country){
        this.userID = userID;
        this.password = password;
        this.country = country;
    }

    /**
     * @return String of User's ID
     */
    public String getUserID(){
        return this.userID;
    }
    /**
     * @return String of user's country
     */
    public String getCountry() {
        return this.country;
    }
}

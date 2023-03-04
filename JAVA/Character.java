import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Character{
    private Connection conn; // not working yet
    private String name;
    private String catchPhrase;

    /**
     * Make characters
     * @param name: String
     * @param catchPhrase: String
     */
    public Character(String name, String catchPhrase){
        this.name = name;
        this.catchPhrase = catchPhrase;
    }

    public int addCharacter(Character character) {
        try {
            int result = 0;
            String sql = "INSERT INTO newCharacter (name, catchphrase) VALUES (?, ?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, character.getname());
            ps.setString(2, character.getCatchPhrase());

            result = ps.executeUpdate();
            return(result);
        } // end of try

        catch(SQLException sqle) {
            sqle.printStackTrace();
            return -1;
        } // end of catch
    }

    /**
     * get name of character
     */
    public String getname(){
        return this.name;
    }

    /**
     * @return character's catchphrase
     */
    public String getCatchPhrase(){
        return this.catchPhrase;
    }



}

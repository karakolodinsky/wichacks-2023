public class Character{

    private String name;
    private String catchPhrase;

    /**
     * Make characters
     * @param name: String
     * @param catchPhrase: String
     */
    public Character(String name,String catchPhrase){
        this.name = name;
        this.catchPhrase = catchPhrase;
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

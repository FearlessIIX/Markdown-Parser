package Utils;

public class Token {
    protected String name;
    protected String type = "NONE";

    // Constructors
    public Token(String name) {
        this.name = name;
    }

    // Getters
    public String getName() {
        return this.name;
    }
    public String getType() {
        return this.type;
    }

    // Setters
    public void changeName(String new_name) {
        this.name = new_name;
    }
    public void change_type(String new_type) {
        this.type = new_type;
    }

    @Override
    public String toString() {
        return "'" + this.name + "'";
    }
}

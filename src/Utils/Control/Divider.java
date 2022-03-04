package Utils.Control;

import Utils.Token;

public class Divider extends Token {

    // Constructors
    public Divider() {
        super("NONE");
        this.type = "divider";
    }

    @Override
    public String toString() {
        return this.type;
    }
}

package Utils.Control;

import Utils.Token;

public class Break extends Token {

    // Constructors
    public Break() {
        super("NONE");
        this.type = "break";
    }

    @Override
    public String toString() {
        return this.type;
    }
}

package Utils.Text;

import Utils.Token;

public class Text extends Token {

    protected int style;

    // Constructors
    public Text(String name) {
        super(name);
        this.type = "text";
    }
    public Text(String name, int style) {
        super(name);
        this.type = "text";
        this.style = style;
    }

    // Getters
    public int getStyle() {
        return this.style;
    }

    // Setters
    public void setStyle(int style) {
        this.style = style;
    }
}

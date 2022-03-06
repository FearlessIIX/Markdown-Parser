package Utils;

public class Text extends Token {

    protected int style;

    // Constructors
    /**
     * For text, 1: plain, 2: italics, 3: bold, 4: italics and bold
     */
    public Text(String name) {
        super(name);
        this.type = "text";
        this.style = 1;
    }
    /**
     * For text, 1: plain, 2: italics, 3: bold, 4: italics and bold
     */
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

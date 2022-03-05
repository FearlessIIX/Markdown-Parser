package HTML.Elements;

import HTML.Container;
import Utils.Text.Text;

import java.util.ArrayList;

public class P extends Container {

    protected boolean newline_after = false;

    // Constructors
    public P() {
        this.name = "p";
    }
    public P(ArrayList<Text> contents) {
        super(contents);

        this.name = "p";
    }
    public P(ArrayList<Text> contents, boolean newline_after) {
        super(contents);

        this.name = "p";
        this.newline_after = newline_after;
    }

    // Getters
    public boolean addNewlineAfter() { return this.newline_after; }

    // Setters
    public void setNewlineAfter(boolean new_after) { this.newline_after = new_after; }
}

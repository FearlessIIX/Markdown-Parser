package HTML.Elements;

import HTML.Container;
import Utils.Text.Text;

import java.util.ArrayList;

public class HeaderBase extends Container {

    protected int magnitude;

    // Constructors
    public HeaderBase(int magnitude) {
        this.name = "header_base";
        this.magnitude = magnitude;
    }
    public HeaderBase(ArrayList<Text> contents, int magnitude) {
        super(contents);

        this.name = "header_base";
        this.magnitude = magnitude;
    }

    // Getters
    public int getMagnitude() { return this.magnitude; }

    // Setters
    public void setMagnitude(int magnitude) {
        if (magnitude > 0 && magnitude < 7) this.magnitude = magnitude;
        else if (magnitude > 7) this.magnitude = 6;
        else this.magnitude = 1;
    }
}

package Utils;

import Utils.Text.Text;

import java.util.ArrayList;

public class Header extends Token {
    private final int magnitude;
    private final ArrayList<Text> contents = new ArrayList<>();

    // Constructors
    public Header(String name, int magnitude) {
        super(name);

        this.magnitude = magnitude;
    }

    // Getters
    public int getMagnitude() {
        return this.magnitude;
    }


    public void addContent(Text content) {
        this.contents.add(content);
    }

    @Override
    public String toString() {
        return this.name;
    }
}

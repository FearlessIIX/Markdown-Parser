package Utils;

import Utils.Text.*;

import java.util.ArrayList;

public class Para extends Token {

    static int PARA_COUNT = 1;

    protected final ArrayList<Text> contents = new ArrayList<>();

    // Constructors
    public Para() {
        super("paragraph" + PARA_COUNT);
        PARA_COUNT++;

        this.type = "para";
    }
    public Para(ArrayList<Text> contents)  {
        super("paragraph" + PARA_COUNT);
        PARA_COUNT++;

        this.type = "para";
        this.contents.addAll(contents);
    }

    public void addText(Text text) {
        this.contents.add(text);
    }
    public ArrayList<Text> getContents() {
        return this.contents;
    }
}

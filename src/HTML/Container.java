package HTML;

import HTML.Element;
import Utils.Text.Text;

import java.util.ArrayList;

public class Container extends Element {

    protected final ArrayList<Text> contents = new ArrayList<>();

    // Constructors
    public Container() {
        this.name = "container";
    }
    public Container(ArrayList<Text> contents) {
        this.contents.addAll(contents);
        this.name = "container";
    }

    // Getters
    public String getName() { return this.name; }
    public ArrayList<Text> getContents() { return this.contents;}

    // Setters
    public void addText(Text text) {
        Text last = this.contents.get(this.contents.size() - 1);

        if (last.getStyle() == text.getStyle()) {
            String name = last.getName() + text.getName();
            this.contents.set(this.contents.size() - 1, new Text(name, last.getStyle()));
            return;
        }

        this.contents.add(text);
    }
}

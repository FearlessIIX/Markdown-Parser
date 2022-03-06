package HTML;

import Utils.Text;

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
        if (!(this.contents.size() < 1)) {
            Text last = this.contents.get(this.contents.size() - 1);

            if (last.getStyle() == text.getStyle()) {
                String name = last.getName() + text.getName();
                this.contents.set(this.contents.size() - 1, new Text(name, last.getStyle()));
                return;
            }
        }

        this.contents.add(text);
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("[").append(this.name).append("]");

        for (Text txt : contents) {
            if (txt.getStyle() == 1) builder.append(txt.getName());
            else if (txt.getStyle() == 2) builder.append("[I]").append(txt.getName());
            else if (txt.getStyle() == 3) builder.append("[B]").append(txt.getName());
            else builder.append("[I B]").append(txt.getName());
        }

        return builder.toString();
    }
}

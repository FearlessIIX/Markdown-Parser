package HTML.Base;
import HTML.Container;

public class Whitespace extends Container {

    public Whitespace() {
        this.name = "whitespace";
    }

    @Override
    public String toString() {
        return "[" + this.name + "]";
    }
}

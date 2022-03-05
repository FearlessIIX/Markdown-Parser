package HTML.Elements;

import Utils.Text.Text;

import java.util.ArrayList;

public class Headers {
    static class H1 extends HeaderBase {

        // Constructors
        public H1() {
            super(1);

            this.name = "h1";
        }
        public H1(ArrayList<Text> contents) {
            super(contents, 1);

            this.name = "h1";
        }
    }
    static class H2 extends HeaderBase {
        // Constructors
        public H2() {
            super(2);

            this.name = "h2";
        }
        public H2(ArrayList<Text> contents) {
            super(contents, 2);

            this.name = "h2";
        }
    }
    static class H3 extends HeaderBase {
        // Constructors
        public H3() {
            super(3);

            this.name = "h3";
        }
        public H3(ArrayList<Text> contents) {
            super(contents, 3);

            this.name = "h3";
        }
    }
    static class H4 extends HeaderBase {
        // Constructors
        public H4() {
            super(4);

            this.name = "h4";
        }
        public H4(ArrayList<Text> contents) {
            super(contents, 4);

            this.name = "h4";
        }
    }
    static class H5 extends HeaderBase {
        // Constructors
        public H5() {
            super(5);

            this.name = "h5";
        }
        public H5(ArrayList<Text> contents) {
            super(contents, 5);

            this.name = "h5";
        }
    }
    static class H6 extends HeaderBase {
        // Constructors
        public H6() {
            super(6);

            this.name = "h6";
        }
        public H6(ArrayList<Text> contents) {
            super(contents, 6);

            this.name = "h6";
        }
    }
}

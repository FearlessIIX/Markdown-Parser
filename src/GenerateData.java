import HTML.*;
import HTML.Base.Whitespace;
import HTML.Elements.*;
import Utils.*;

import java.util.ArrayList;
import java.util.Stack;

public class GenerateData {
    public static ArrayList<Container> generateData(ArrayList<ArrayList<Token>> lines) {
        ArrayList<Container> data = new ArrayList<>();

        for (int i = 0; i < lines.size(); i++) {
            ArrayList<Token> line = lines.get(i);

            // the first item in every line determines what type of Element to interpret the line as
            if (line.size() > 0) {
                Token first = line.get(0);
                String name = first.getName();

                // If all characters in the name are '#' (Header)
                if (name.replace("#", "").equals("")) {
                    // Removes the first Token from the line since it only informs us of the type of Element desired
                    line.remove(first);
                    Container container = createHeader(line, first.getName().length());

                    data.add(container);
                }
                // The first token does not match any type of element (defaults to paragraph)
                else {
                    Container container = createParagraph(line);

                    data.add(container);
                }
            } else {
                data.add(new Whitespace());
            }
        }

        return data;
    }
    private static Container createHeader(ArrayList<Token> line, int type) {
        Stack<String> style = new Stack<>();

        // Creating the correct type of header based on the passed type
        Container con;
        if (type <= 1) con = new Headers.H1();
        else if (type == 2) con = new Headers.H2();
        else if (type == 3) con = new Headers.H3();
        else if (type == 4) con = new Headers.H4();
        else if (type == 5) con = new Headers.H5();
        else con = new Headers.H6();

        for (Token tk : line) {
            String name = tk.getName();

            if (name.equals("_") || name.equals("*")) {
                if (style.size() > 0 && style.peek().equals("italics")) style.pop();
                else style.add("italics");
            }
            else if (name.equals("__") || name.equals("**")) {
                if (style.size() > 0 && style.peek().equals("bold")) style.pop();
                else style.add("bold");
            }
            else {
                if (style.size() < 1) {
                    con.addText(new Text(name, 1));
                } else if (style.size() == 1) {
                    con.addText(new Text(name, (style.peek().equals("italics") ? 2 : 3)));
                } else {
                    con.addText(new Text(name, 4));
                }
            }
        }
        return con;
    }

    private static Container createParagraph(ArrayList<Token> line) {
        P para = new P();
        Stack<String> style = new Stack<>();

        for (Token tk : line) {
            String name = tk.getName();

            if (name.equals("_") || name.equals("*")) {
                if (style.size() > 0 && style.peek().equals("italics")) style.pop();
                else style.add("italics");
            }
            else if (name.equals("__") || name.equals("**")) {
                if (style.size() > 0 && style.peek().equals("bold")) style.pop();
                else style.add("bold");
            }
            else {
                if (style.size() < 1) {
                    para.addText(new Text(name, 1));
                } else if (style.size() == 1) {
                    para.addText(new Text(name, (style.peek().equals("italics") ? 2 : 3)));
                } else {
                    para.addText(new Text(name, 4));
                }
            }
        }

        return para;
    }
}

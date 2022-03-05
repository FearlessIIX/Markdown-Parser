import Utils.Token;

import java.util.ArrayList;

public class Tokenizer {
    public static ArrayList<ArrayList<Token>> tokenize(ArrayList<String> lines) {
        ArrayList<ArrayList<Token>> tok_lines = new ArrayList<>();

        StringBuilder tok_builder = new StringBuilder();

        for (String line : lines) {

            ArrayList<Token> tok_line = new ArrayList<>();

            for (int i = 0; i < line.length(); i++) {
                char ch = line.charAt(i);

                // If user is using an escape character, and there is a next token
                if (ch == '\\') {

                    if (i + 1 < line.length())
                        tok_builder.append(line.charAt(i++));
                }
                else if (isMetaChar(ch)) {
                    if (!(tok_builder.isEmpty() ||
                            tok_builder.toString().replace(" ", "").isEmpty())) {
                        tok_line.add(new Token(tok_builder.toString()));
                        tok_builder.delete(0, tok_builder.length());
                    }

                    tok_line.add(new Token(String.valueOf(ch)));
                }
                else
                    tok_builder.append(ch);
            }

            if (!(tok_builder.isEmpty() ||
                    tok_builder.toString().replace(" ", "").isEmpty())) {
                tok_line.add(new Token(tok_builder.toString()));
                tok_builder.delete(0, tok_builder.length());
            }

            tok_lines.add(tok_line);
        }

        return tok_lines;
    }

    public static boolean isMetaChar(char ch) {
        switch (ch) {
            case '#':
            case '_':
            case '*':
            case '^':
                return true;
        }
        return false;
    }
}
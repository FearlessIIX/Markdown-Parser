import Utils.Token;

import java.util.ArrayList;

public class Merge {
    public static ArrayList<ArrayList<Token>> merge(ArrayList<ArrayList<Token>> lines) {
        ArrayList<ArrayList<Token>> merge_lines = new ArrayList<>();

        for (ArrayList<Token> line : lines) {
            ArrayList<Token> tok_line = new ArrayList<>();

            for (int i = 0; i < line.size(); i++) {

                Token current = line.get(i);
                String current_name = current.getName();

                switch (current_name) {
                    case "_":
                    case "*":
                        // There is a next element in the list, and its name is the same as the current elements name
                        if (i + 1 < line.size()
                                && line.get(i + 1).getName().equals(current_name)) {
                            // Sets the search pointer up by one
                            i++;
                            tok_line.add(new Token(current_name.repeat(2)));
                        }
                        // There was only one occurrence of this Token, does NOT modify the pointer
                        else
                            tok_line.add(current);
                        break;
                    case "#":
                        int count = 0;
                        // Loops until we pass all Tokens in the list, or a checked element does not match the current element.
                         while (i + count < line.size()
                                 && line.get(i + count).getName().equals(current_name)) {
                             // Counting the number of matches (This also include the checked token itself, so at minimum 1)
                             count++;
                         }
                         // Sets the pointer up by the amount of matches (minus one to account for the current token)
                         i+= count - 1;
                         tok_line.add(new Token(current_name.repeat(count)));
                        break;
                    default:
                        tok_line.add(current);
                }
            }
            merge_lines.add(tok_line);
        }
        return merge_lines;
    }
}

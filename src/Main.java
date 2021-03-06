import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

import HTML.Container;
import Utils.Token;

public class Main {
    public static void main(String[] args) {
        // Prints a message and exits if less than one command line argument was passed
        if (args.length < 1) {
            System.out.println("This program accepts one argument, the name of the markdown file, include the ending [.md]");
            return;
        }

        // Reading the file
        ArrayList<String> contents = readFile(args[0]);

        // Tokenizing the contents of the file
        ArrayList<ArrayList<Token>> results = Tokenizer.tokenize(contents);

        // Merging all Tokens capable of merging
        results = Merge.merge(results);

        // Converting the Tokens into HTML Elements (cast down to Container)
        ArrayList<Container> data = GenerateData.generateData(results);

        GenerateHTML.generateHTML(data, args[0]);
    }
    public static ArrayList<String> readFile(String filename) {
        ArrayList<String> lines = new ArrayList<>();
        try {
            File source = new File(filename);
            Scanner scan = new Scanner(source);

            // Reading the source file line by line until there are no more lines left
            while (scan.hasNext())
                lines.add(scan.nextLine());

        } catch (FileNotFoundException ignored) {
            // Getting the current Path (which is wherever the JVM was invoked from)
            Path currentRelativePath = Paths.get("");
            String s = currentRelativePath.toAbsolutePath().toString();

            System.out.println("Failed to find file named '" + filename + "' in '" + s + "'");
            System.out.println("Exiting. . ");
            System.exit(-1);
        }
        return lines;
    }
}

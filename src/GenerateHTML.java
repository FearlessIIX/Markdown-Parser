import Utils.Text;
import HTML.Container;

import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class GenerateHTML {
    public static void generateHTML(ArrayList<Container> data, String filename) {
        File file = createResFile(filename);

        try {
            FileWriter writer = new FileWriter(file);

            // Content suffix
            writer.write("<!DOCTYPE html>\n");
            writer.write("<head><title>" + file.getName() + "</title></head>\n");
            writer.write("<html>\n");

            // Converting the main content of the md file to HTML
            convertElementsToHTML(data, writer);

            // Content prefix
            writer.write("</html>\n");
            writer.close();
        } catch (IOException ioe) {
            System.out.println("Fatal error, issues while writing to file");
        }
    }

    private static File createResFile(String filename) {
        if (!(filename.endsWith(".html"))) {
            // Converting the filename (ending in .md) into the correct name (ending in .html)
            filename = filename.substring(0, filename.length() - 3) + ".html";
        }

        File dir = new File("gen");

        // Tries to create the file, returns whether it was created
        if (!(dir.mkdir())) {
            // Returns whether the file exists or not
            if (!(dir.exists())) {
                System.out.println("There were issues creating directory 'gen'");
                System.out.println("Exiting. . ");
                System.exit(-1);
            }
        }

        File file = new File(dir.getName(), filename);

        // If the desired compiled markdown file already exists in the parent directory
        while (file.exists()) {

            Scanner scan = new Scanner(System.in);
            System.out.println("File " + filename + " already exists, would you like to override it?\n[y: yes.  n: no]");

            // User answers yes
            if (scan.nextLine().equalsIgnoreCase("y")) {
                // If we fail to delete the file (Which shouldn't happen here)
                if (!(file.delete())) {
                    System.out.println("Failed to delete file " + filename + ".\n Exiting. .");
                    System.exit(-1);
                }
                break;
            }
            // User answers no
            else {
                System.out.println("Would you like to compile the markdown to a different filename?\n[y: yes.  n: no]");

                // User answers yes
                if (scan.nextLine().equalsIgnoreCase("y")) {
                    System.out.println("Enter the new filename [ending in .html]");
                    String new_name = scan.nextLine();

                    // If the filename does NOT end with .html
                    if (!(new_name.endsWith(".html"))) {
                        System.out.println("Filename must end with .html prefix");
                        continue;
                    }
                    filename = new_name;
                    // Changes the file Obj to the new requested filename
                    file = new File(dir.getName(), filename);
                }
                // User answers no
                else {
                    System.out.println("Exiting . . ");
                    System.exit(0);
                }
            }
        }

        try {
            // If we fail to create the file (Which shouldn't happen here)
            if (!(file.createNewFile())) {
                System.out.println("Failed to make file '" + filename + "'");
                System.out.println("Exiting. .");
                System.exit(-1);
            }
        } catch (IOException ioe) {
            System.out.println("Failed to make file '" + filename + "'");
            System.out.println("Exiting. . ");
            System.exit(-1);
        }

        return file;
    }

    private static void convertElementsToHTML(ArrayList<Container> data, FileWriter writer) throws IOException {
        Container previous = null;
        for (Container c : data) {
            String name = c.getName();

            // If previous tag is a header, and current tag is not a header
            if (!(previous == null) && isHeader(previous) && !isHeader(c))
                writer.write("<br>\n");

            if (name.equals("whitespace")) {
                previous = c;
                continue;
            }

            // Starting tag for this container
            writer.write("<" + name + ">\n");

            // Writing the text contents of this container
            writeContents(c, writer);

            // Ending tag for this container
            writer.write("</" + name + ">\n");

            previous = c;
        }
    }

    private static boolean isHeader(Container c) {
        String name = c.getName();
        String headers = "h1 h2 h3 h4 h5 h6";

        for (String h : headers.split(" "))
            if (name.equals(h)) return true;
        return false;
    }

    private static void writeContents(Container c, FileWriter writer) throws IOException {
        boolean bold = false;
        boolean italic = false;

        for (Text txt : c.getContents()) {
            int new_style = txt.getStyle();

            // If style of txt is one (plain text)
            if (new_style == 1) {
                // If bold is still enabled
                if (bold) {
                    // Writing the closing tag for bold text, then setting it to false
                    writer.write("  </strong>\n");
                    bold = false;
                }
                // If italic is still enabled
                if (italic) {
                    // Writing the closing tag for italic text, then setting it to false
                    writer.write("  </em>\n");
                    italic = false;
                }

                // Writing the text to the file
                writer.write("  " + txt.getName() + "\n");
                continue;
            }
            // If style of txt is two (italic)
            if (new_style == 2) {
                // If italic is disabled
                if (!italic) {
                    // Writing the opening tag for italic text, then setting it to true
                    writer.write("  <em>\n");
                    italic = true;
                }
                // If bold is still enabled
                if (bold) {
                    // Writing the closing tag for bold text, then setting it to false
                    writer.write("  </strong>\n");
                    bold = false;
                }

                // Writing the text to the file
                writer.write("  " + txt.getName() + "\n");
                continue;
            }
            // If style of txt is three (bold)
            if (new_style == 3) {
                // If italic is still enabled
                if (italic) {
                    // Writing the closing tag for italic text, then setting it to false
                    writer.write("  </em>\n");
                    italic = false;
                }
                // If bold text is disabled
                if (!bold) {
                    // Writing the opening tag for bold text, then setting it to true
                    writer.write("  <strong>\n");
                    bold = true;
                }

                // Writing the text to the file
                writer.write("  " + txt.getName() + "\n");
                continue;
            }
            // If the style of txt is four (italic + bold)
            if (new_style == 4) {
                // If bold is disabled
                if (!bold) {
                    // Writing the opening tag for bold text, then setting it to true
                    writer.write("  <strong>\n");
                    bold = true;
                }
                // If italic text is disabled
                if (!italic) {
                    // Writing the opening tag for italic text, then setting it to true
                    writer.write("  <em>\n");
                    italic = true;
                }

                // Writing the text to the file
                writer.write("  " + txt.getName() + "\n");
            }
        }
        // Closing any tags that have been left open
        if (bold)
            writer.write("  </strong>\n");
        if (italic)
            writer.write("  </em>\n");
    }
}

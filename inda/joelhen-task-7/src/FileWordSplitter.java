import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * This class reads a text file and splits it into individual words.
 */
public class FileWordSplitter {

    private ArrayList<String> words;

    /**
     * Constructor for the FileWordSplitter class.
     *
     * @param filename The path to the text file to be processed.
     * @throws IOException If an I/O error occurs while reading the file.
     */
    public FileWordSplitter(String filename) {

        words = new ArrayList<>();

        try {
            BufferedReader file = new BufferedReader(new FileReader(filename));
            
            String line = file.readLine();

            // Reads the file line by line and splits each line into words
            while (line != null) {
                String[] wordsArray = line.split(" ");

                // Adds each word contained in the line into the words ArrayList
                for (int i = 0; i < wordsArray.length; i++) {
                    words.add(wordsArray[i]);
                }

                line = file.readLine();
            }

            file.close();
            
        } catch (IOException e) {
            System.out.println("Something went wrong: " + e.getMessage());  

            System.exit(1);  
        }
    }

    /**
     * Getter method.
     *
     * @return The ArrayList of words.
     */
    public ArrayList<String> getWords() {
        return words;
    }

    public static void main(String[] args) {
        FileWordSplitter hamlet = new FileWordSplitter("src/hamlet.txt");
        System.out.println(hamlet.getWords().get(3));
    }

}
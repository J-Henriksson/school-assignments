import java.io.IOException;
import java.util.HashMap;

public class FileTextAnalyzer {

    // Fields
    private FileWordSplitter words;
    private HashMap<String, Integer> wordOccurences = new HashMap<>();

    /**
     * Constructor for the FileTextAnalyzer class.
     *
     * @param filename The path to the text file to be analyzed.
     * @throws IOException If an I/O error occurs while reading the file.
     */
    public FileTextAnalyzer(String filename) {
        words = new FileWordSplitter(filename);

        // Counts word occurrences for each word and populates the wordOccurrences HashMap
        for(int i = 0; i < wordCount(); i++) {
            String indexedWord = words.getWords().get(i).toLowerCase();

            // If the HashMap already contains the word as a key the sum of 
            // the value is increased by 1. Otherwise a new key value pair is created for the word
            if (wordOccurences.containsKey(indexedWord)) {
                wordOccurences.merge(indexedWord, 1, Integer::sum);
            }
            else {
                wordOccurences.put(indexedWord, 1);
            }
        }
    }
    
    /**
     * Getter method.
     *
     * @return WordOccurences HashMap.
     */
    public HashMap<String, Integer> getWordOccurences() {
        return this.wordOccurences;
    }
    
    /**
     * Gets the total number of words in the text.
     *
     * @return The total word count.
     */
    public int wordCount() {

        return words.getWords().size();
    }

    /**
     * Gets the number of occurrences of a specific word.
     *
     * @param word The word to count occurrences for.
     * @return The number of occurrences of the word.
     */
    public int occurrencesOf(String word) {
        if (!getWordOccurences().containsKey(word.toLowerCase())) {
            return 0;
        }
        else {
            return getWordOccurences().get(word.toLowerCase());
        }
    }

    /**
     * Calculates the frequency of a specific word in the text.
     *
     * @param word The word to calculate the frequency of.
     * @return The frequency of the word in the text.
     */
    public double frequencyOf(String word) {
        return (((double) occurrencesOf(word) / (double) wordCount() ));
    }

    /**
     * Finds the amount of unique words in the text.
     *
     * @return The count of unique words.
     */
    public int uniqueWordCount() {
        return getWordOccurences().size();
    }

    public static void main(String[] args) {
        FileTextAnalyzer hamlet = new FileTextAnalyzer("src/hamlet.txt");
        System.out.println(hamlet.getWordOccurences());
        System.out.println(hamlet.occurrencesOf("hamlet"));
        System.out.println(hamlet.frequencyOf("Hamlet"));
        System.out.println(hamlet.uniqueWordCount());
    }
}

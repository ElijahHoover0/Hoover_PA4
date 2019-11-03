import java.io.FileNotFoundException;
import java.io.IOException;

public class Application {
    /*Create a separate class called Application that
    contains a main method which illustrates the use
    of DuplicateCounter by calling both the remove
    and write methods. Your input file must be called
    problem2.txt and your output file must be called
    unique_word_counts.txt.
     */
    public static void main(String[] args) throws IOException {
        DuplicateCounter duplicateCounter = new DuplicateCounter();
        duplicateCounter.count("problem2.txt");
        duplicateCounter.write("unique_word_counts.txt");



    }
}

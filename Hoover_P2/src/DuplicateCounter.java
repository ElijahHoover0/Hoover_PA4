import java.util.ArrayList;
import java.io.*;
import java.util.Scanner;

public class DuplicateCounter {
    /*Create an instance method called count that takes a single parameter
    called dataFile (representing the path to a text file) and uses a Map
    of Strings to count how many times each word occurs in dataFile. The
    counts should be stored in an instance variable called wordCounter.


    Create an instance method called write that takes a single parameter
    called outputFile (representing the path to a text file) and writes
    the contents of wordCounter to the file pointed to by outputFile. The
    output file should be overwritten if it already exists, and created
    if it does not exist.
     */
    private ArrayList<String> wordToCount = new ArrayList<String>();
    private ArrayList<Integer> wordCounter = new ArrayList<Integer>();
    private int numOfWords;
    public DuplicateCounter(){
        int numOfWords = 0;
    }
    //Map<Integer, String> map = new HashMap<Integer, String>();


   /* public int compareTo(DuplicateCounter other){
        int comparisonVal =3;
        return comparisonVal;
    }*/

    public void count(String dataFile) throws FileNotFoundException {
        FileInputStream fileReader = null;
        fileReader = new FileInputStream(dataFile);
        Scanner inFS = null;
        inFS = new Scanner(fileReader);

        try{
            while(inFS.hasNext()){
                wordToCount.add(inFS.next());
                wordCounter.add(1);
                numOfWords=numOfWords+1;
                for(int i=0;i<numOfWords-1;i++){
                    if((wordToCount.get(wordToCount.size()-1)).equals(wordToCount.get(i))){
                        wordToCount.remove(numOfWords-1);
                        wordCounter.remove(numOfWords-1);
                        wordCounter.set(i,wordCounter.get(i)+1);
                        numOfWords=numOfWords-1;
                    }
                }

            }
            System.out.println(wordToCount.get(1));
        }
        finally{
            inFS.close();
        }


    }
    public void write(String outputFile) throws IOException {

        try{
            File file = new File(outputFile);
            if(file.createNewFile()) {
                System.out.println("File has been created");
            }else{
                System.out.println("File already exists");
            }
            FileWriter fileWriter = new FileWriter(outputFile);


            for(int i=0;i<numOfWords;i++){
                fileWriter.write(wordToCount.get(i) + " appears " + wordCounter.get(i) + " times\n");
            }
            fileWriter.close();
        }
        finally{
            System.out.println("File closed");
        }


    }
}

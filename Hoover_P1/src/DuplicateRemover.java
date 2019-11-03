import java.util.ArrayList;
import java.io.*;
import java.util.Scanner;


public class DuplicateRemover {
    //Create an instance method called remove that takes a single parameter
    // called dataFile (representing the path to a text file) and uses a Set
    // of Strings to eliminate duplicate words from dataFile. The unique
    // words should be stored in an instance variable called uniqueWords.

    // Create an instance method called write that takes a single
    // parameter called outputFile (representing the path to a text
    // file) and writes the words contained in uniqueWords to the
    // file pointed to by outputFile. The output file should be
    // overwritten if it already exists, and created if it does not exist.

    //private String[] uniqueWords = new String[100];
    private ArrayList<String> uniqueWords = new ArrayList<String>();
    private int numOfUniqueWords;

    //Default constructor
    public DuplicateRemover(){
        numOfUniqueWords = 0;
    }
    //Instance method 1
    public void remove(String dataFile) throws IOException{
        FileInputStream fileReader = null;
        Scanner inFS = null;
        fileReader = new FileInputStream(dataFile);
        inFS = new Scanner(fileReader);
        try {
            while (inFS.hasNext()) {
                uniqueWords.add(inFS.next());
                numOfUniqueWords++;
                        for(int i=0;i<numOfUniqueWords-1;i++){
                            if((uniqueWords.get(numOfUniqueWords-1)).equals(uniqueWords.get(i))){
                                uniqueWords.remove(numOfUniqueWords-1);
                                numOfUniqueWords = numOfUniqueWords -1;
                            }
                        }
            }
            for(int i=0;i<numOfUniqueWords-1;i++){
            }
        }
        finally{
            fileReader.close();
            System.out.println("file closed");
        }

    }
    //Instance method 2
    public void write(String outputfile){
        try{
            File file = new File(outputfile);
            if(file.createNewFile()){
                System.out.println("File has been created");
            }else{
                System.out.println("File already exists");
                }
            FileWriter fileWriter = new FileWriter(outputfile);
            for(int i=0;i<numOfUniqueWords-1;i++){
                fileWriter.write(uniqueWords.get(i)+" ");
            }
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            System.out.println("File closed");
        }


    }
}

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Lab09Hashing {
    static Hashtable<String, Set<Integer>> wordLineCount; // Initialized in preProcess, using set to avoid duplicate lines

    static void preProcess(String filename){
        wordLineCount = new Hashtable<>();
        File file = new File(filename);
        try(Scanner scanner = new Scanner(file)){
            int lineNumber = 1;
            while(scanner.hasNextLine()){ // Going line by line through provided file
                String line = scanner.nextLine().toLowerCase(); // Don't want it to be case sensitive
                String[] words = line.split("\\W+");
                for(String word : words){ // Going through each word in the line
                    // If word is already in ht, add line number to list at that key
                    if(wordLineCount.containsKey(word)) wordLineCount.get(word).add(lineNumber);
                    // Else create new list with line number at that key
                    else wordLineCount.put(word, new HashSet<Integer>(Arrays.asList(lineNumber)));
                }
                lineNumber++;
            }
        }
        catch(FileNotFoundException e){
            System.out.println("Preprocess failed, fnf");
            return;
        }
    }

    static String queryHT(String word){
        if(wordLineCount.containsKey(word)) return wordLineCount.get(word).toString();
        else return "Not found.";
    }

    public static void main(String[] args) {
        preProcess("lab09text.txt");
        System.out.println("Algorithm: " + queryHT("algorithm"));
        System.out.println("Computer: " + queryHT("computer"));
        System.out.println("Algorithms: " + queryHT("algorithms"));
        System.out.println("Structure: " + queryHT("structure"));
        System.out.println("Structures: " + queryHT("structures"));

    }
}

package predictive;

/*
 * Quiz 2
 * 
 * Made by Irsyad Fikriansyah Ramadhan
 * -- 19 November 2022
 * IF184301 Object Oriented Programming (E)
 * 
 */
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.io.*;

public class PredictivePrototype {

    // turning word into it corresponds numbers in a keypad
    public static String wordToSignature(String word){  
        // StringBuffer that store the result for the string
        StringBuffer result = new StringBuffer("");

        // loop for every word
        for (int i = 0; i < word.length(); i++){
            if (i == 0 && word.charAt(i) == ' ')
                break;
            switch (Character.toLowerCase(word.charAt(i))) {
                case 'a' : case 'b' : case 'c' : 
                    result.append("2"); break;
                case 'd' : case 'e' : case 'f' :
                    result.append("3"); break;
                case 'g' : case 'h' : case 'i' :
                    result.append("4"); break;
                case 'j' : case 'k' : case 'l' :
                    result.append("5"); break;
                case 'm' : case 'n' : case 'o' :
                    result.append("6"); break;
                case 'p' : case 'q' : case 'r' : case 's' :
                    result.append("7"); break;
                case 't' : case 'u' : case 'v' :
                    result.append("8"); break;
                case 'w' : case 'x' : case 'y' : case 'z' :
                    result.append("9");  break;
                default :
                    result.append(" "); break;
            }
        }
        // return the result
        return result.toString();
    }

    /* 
     ? Why using StringBuffer instead of String ?
     * String is imutable wheareas StringBuffer is mutable
     * that means, every change is done to String, it is actually making
     * new string that is stored on another memory.
     * therefore, it will be more cost efficient for the memory if we use
     * StringBuffer
     * 
     * Source : https://www.youtube.com/watch?v=_drNcLWgUlE
     */

    // checking if a word contains a symbols or numbers
    public static boolean isValidWord(String str){
        Pattern p = Pattern.compile("[^a-z A-Z]", Pattern.CASE_INSENSITIVE);
        Matcher m = p.matcher(str);

        // return false if there is a symbol
        return !m.find();
    }

    // turning word into it corresponds numbers in a keypad
    public static Set<String> signatureToWords(String signature){
        // Set to store the words
        Set<String> mySet = new HashSet<String>();

        // Obtaining file location (saved inside src)
        File words = new File("src/predictive/words");

        // use the try-catch in case the file 'words' is not available
        // or accessible
        try (Scanner input = new Scanner(words)) {
            while(input.hasNextLine()){
                // getting every line in words file
                String line = input.nextLine();

                if (line.length() != signature.length())
                    continue;

                if (isValidWord(line) == false)
                    continue;
                
                // remove every " " (space) of wordToSignature(line)
                String temp = wordToSignature(line);

                // if the number and the signature is the same, add the word into the set
                if (signature.equals(temp)){
                    mySet.add(line.toLowerCase());
                }
            }
            input.close();

            // return the set
            return mySet;

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    /*  
     ? why not store the dictionary in your Java program ?
     * first of all, it is not a good practice because it will be a
     * burdensome if we wanted to add/remove/edit the dictionary if
     * it is stored in the code it self
     * 
     * second, it will be hard to see the code giving the number of
     * words are there inside the dictionary.
     * 
     * that is why it is stored on a saperate file and if we need it,
     * we can always access it from the code side.
     */    

}

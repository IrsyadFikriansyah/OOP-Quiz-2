package predictive;
/*
 * Quiz 2
 * 
 * Made by Moh. Adib Syambudi
 * -- 24 November 2022
 * IF184301 Object Oriented Programming (E)
 * 
 */
import java.io.*;
import java.util.*;

public class DictionaryListImpl {
    //field 
    private ArrayList<WordSig> arr = new ArrayList<WordSig>();
    //constructor 
    public DictionaryListImpl(File dictionary) {
        //error handling when there no file
        try (Scanner input = new Scanner(dictionary)) {
        while(input.hasNextLine()){ //iterate until next line of input
            String line = input.nextLine();

            if (isValidWord(line) == false)
                continue;
            
            this.arr.add(new WordSig(line, wordToSignature(line).replaceAll(" ", "")));
        }
        //sorting arraylist
        Collections.sort(arr);

        input.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }

     // function to convert char into correspond number in a keypad
     private static int w2s(char c){
        switch (Character.toLowerCase(c)) {
            case 'a' : case 'b' : case 'c' : 
                return 2;
            case 'd' : case 'e' : case 'f' :
                return 3;
            case 'g' : case 'h' : case 'i' :
                return 4;
            case 'j' : case 'k' : case 'l' :
                return 5;
            case 'm' : case 'n' : case 'o' :
                return 6;
            case 'p' : case 'q' : case 'r' : case 's' :
                return 7;
            case 't' : case 'u' : case 'v' :
                return 8;
            case 'w' : case 'x' : case 'y' : case 'z' :
                return 9;            
            default :
                return 0;
        }
    } 

    // turning word into it corresponds numbers in a keypad
    public static String wordToSignature(String word){  
        // split the string by " " (space) to anticipate more than 1 words in a string      
        String arr[] = word.split(" ", 0);

        // StringBuffer that store the result for the string
        StringBuffer result = new StringBuffer("");

        // loop for every word
        for (int i = 0; i < arr.length; i++){
            if (arr[i] == "")
                continue;
            
            // StringBuffer that store the result for a word
            StringBuffer temp = new StringBuffer("");

                // loop for every character in a word
                for (int j = 0; j < arr[i].length(); j++){
                    // variable to store the correspond number of the character
                    int code = w2s(arr[i].charAt(j));

                    // appending into StringBuffer for a word
                    if (code == 0)
                        temp.append(" ");
                    else
                        temp.append(w2s(arr[i].charAt(j)));    
                }
                
                // appending into StringBuffer for a string
                temp.append(" ");
                result.append(String.valueOf(temp));
            }

        // return the result
        // ! note: the string contain " "(space) after the signiture
        return result.toString();
    }

    // checking if a word contains a symbols
    public static boolean isValidWord(String word){
        String symbols = "1234567890`~,<.>/?;:'\"[{]}\\|-_=+!@#$%^&*()";
        char charArray[] = word.toCharArray();
        // sort the charArray so that if a word contain(s) a symbol
        // it will be in the first index
        Arrays.sort(charArray);
        if (symbols.indexOf(charArray[0]) >= 0)
            return false;
        return true;
    }


    public Set<String> signatureToWords(String signature){
        //store the set for return value
        Set<String> mySet = new HashSet<String>();
        //binary search using 2 variable which use for traversal forward and backward
        int indexfor  = Collections.binarySearch(this.arr,new WordSig(null,signature));
        int indexbac  = Collections.binarySearch(this.arr,new WordSig(null,signature));
        //backward traversal for signature word on list
        while(arr.get(indexbac).getSignature().equals(signature)){
            mySet.add(arr.get(indexbac).getWords().toLowerCase());
            indexbac--;
        }
        //forward traversal for signature word on list
        while(arr.get(indexfor).getSignature().equals(signature)){
            mySet.add(arr.get(indexfor).getWords().toLowerCase());
            indexfor++;
        }
        
        return mySet;
    }
    //Getter for arraylist
    public ArrayList<WordSig> getArr() {
        return arr;
    }
    //print all member of list
    public void PrintList(){
        for (int i = 0; i < arr.size(); i++){
            System.out.println(arr.get(i).getWords() + "\t" + arr.get(i).getSignature());
        }
    }

    
}

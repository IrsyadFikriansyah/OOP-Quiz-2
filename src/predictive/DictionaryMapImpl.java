package predictive;
/*
 * Quiz 2
 * 
 * Made by Muhammad Zikri Ramadhan
 * -- 24 November 2022
 * IF184301 Object Oriented Programming (E)
 * 
 */
import java.io.*;
import java.util.*;

//generic multi-value map
public class DictionaryMapImpl implements Dictionary{
	
    //Create map object contains Signature as key and it's words as value
	Map<String, ArrayList<String>> signmap = new HashMap<>();
	
    //this method is for checking if it is a valid word or not
	private static boolean isValidWord(String word) {
		for (int i=0; i<word.length(); i++) {
            //if it is upper case letter or lower case letter, then do nothing
			if ((word.charAt(i) >= 97 && word.charAt(i) <= 122) || (word.charAt(i) >= 65 && word.charAt(i) <= 90)){ 
			}
            //if it's not a letter, then we return false
            else return false;
		}
		return true;
	}
	
	public DictionaryMapImpl() {
		try {
            //this part is to read file words.txt which we will use
			File words = new File("src/predictive/words");
			Scanner file = new Scanner(words);
			
			//if the file has next line
			while (file.hasNextLine()) {
				String data = file.nextLine();
				//first we check the validity of a word
                //check if it is a valid word
				if(isValidWord(data)) {
					data = data.toLowerCase();
                    //check the signature of the wordds
                    //if it's signature never place on map, create new key fofr the signature
					if(!signmap.containsKey(wordToSignature(data))) signmap.put(wordToSignature(data), new ArrayList<String>());
                    //lastly, we pull it's words
					signmap.get(wordToSignature(data)).add(data);
				}
			}	
			file.close();
	    }
        catch (FileNotFoundException e) {
            //if the file not found
	    	System.out.println("An error occurred.");
	    	e.printStackTrace();
	    }
	}
	
	//this part is for converting word to signature
	public String wordToSignature(String word) {
		StringBuffer sb = new StringBuffer ("");
		//incase we have upper-case letter, we lower-cased it
		word = word.toLowerCase();
		//we paired each letter and corrseponding number 
		for (int i=0; i<word.length(); i++) {
			if (word.charAt(i) >= 97 && word.charAt(i) <= 99) sb.append("2");
            else if (word.charAt(i) >= 100 && word.charAt(i) <= 102) sb.append("3");
			else if (word.charAt(i) >= 103 && word.charAt(i) <= 105) sb.append("4");
            else if (word.charAt(i) >= 106 && word.charAt(i) <= 108) sb.append("5");
			else if (word.charAt(i) >= 109 && word.charAt(i) <= 111) sb.append("6");
			else if (word.charAt(i) >= 112 && word.charAt(i) <= 115) sb.append("7");
			else if (word.charAt(i) >= 116 && word.charAt(i) <= 118) sb.append("8");
			else if (word.charAt(i) >= 119 && word.charAt(i) <= 122) sb.append("9");
			else sb.append(" ");
		}
		return sb.toString();
	}
	
    //this part is for converting signature to word
	public Set<String> signatureToWords(String signature){
		Set<String> stringSet = new HashSet<String>();
		
        //create new array list to get words from it's signature
		ArrayList<String> arr_list = new ArrayList<String>();
		arr_list = signmap.get(signature);
        //Store Words at stringset
		for(int i = 0; i < arr_list.size(); i++){
			stringSet.add(arr_list.get(i));        
        }
		return stringSet;
	}
}
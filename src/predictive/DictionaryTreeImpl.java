package predictive;
/*
 * Quiz 2
 * 
 * Made by Muhammad Zikri Ramadhan
 * -- 24 November 2022
 * IF184301 Object Oriented Programming (E)
 * 
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

//this class is for tree implementation
public class DictionaryTreeImpl implements Dictionary{
	
	//make variabel
	Tree temp;
	Tree br2 = new Tree("2");
	Tree br3 = new Tree("3");
	Tree br4 = new Tree("4");
	Tree br5 = new Tree("5");
	Tree br6 = new Tree("6");
	Tree br7 = new Tree("7");
	Tree br8 = new Tree("8");
	Tree br9 = new Tree("9");
	Set<String> stringSet;
	
	//constructor
	public DictionaryTreeImpl() {
		//this part is for reading the words file
		try {
			File words = new File("src/predictive/words");
			Scanner file = new Scanner(words);
			
			//check if the file has next line
			while (file.hasNextLine()) {
				String data = file.nextLine();
				
				//for every valid word
				//we add the substring into our tree
				if (isValidWord(data)) {
					//incase there is upper case letter
					data = data.toLowerCase();
					
					//get the signature of the word
					String signature = wordToSignature(data);
					int len = signature.length()-1;
					
					//first character to determine the tree we will use
					if (signature.charAt(0) == '2') temp = br2;
					else if (signature.charAt(0) == '3') temp = br3;
					else if (signature.charAt(0) == '4') temp = br4;
					else if (signature.charAt(0) == '5') temp = br5;
					else if (signature.charAt(0) == '6') temp = br6;
					else if (signature.charAt(0) == '7') temp = br7;
					else if (signature.charAt(0) == '8') temp = br8;
					else if (signature.charAt(0) == '9') temp = br9;
					
					//add the substring into the tree
					for (int i=1; i<len; i++) {
						temp = temp.addWords(data.substring(0, i), signature.substring(0, i+1));
					}
				}
			}
			//close the opened file
			file.close();
	    }
		//if the file was not found
		catch (FileNotFoundException e) {
	    	System.out.println("An error occurred.");
	    	e.printStackTrace();
	    }
	}
	
	//this method is for checking whether the word is valid word or not
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
	public Set<String> signatureToWords(String signature) {
		//if the length of signature is zero but it still dont match any words
		//we return an empty set
		if (signature.length() == 0) return new HashSet<String>();
		//check the first character from the signature
		//to determine the tree we will use
		if (signature.charAt(0) == '2') return br2.getWords(signature.substring(1, signature.length()));
		else if (signature.charAt(0) == '3') return br3.getWords(signature.substring(1, signature.length()));
		else if (signature.charAt(0) == '4') return br4.getWords(signature.substring(1, signature.length()));
		else if (signature.charAt(0) == '5') return br5.getWords(signature.substring(1, signature.length()));
		else if (signature.charAt(0) == '6') return br6.getWords(signature.substring(1, signature.length()));
		else if (signature.charAt(0) == '7') return br7.getWords(signature.substring(1, signature.length()));
		else if (signature.charAt(0) == '8') return br8.getWords(signature.substring(1, signature.length()));
		else return br9.getWords(signature.substring(1, signature.length()));
	}
}
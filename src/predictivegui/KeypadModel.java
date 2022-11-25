package predictivegui;
/*
 * Quiz 2
 * 
 * Made by Irsyad Fikriansyah Ramadhan
 * -- 24 November 2022
 * IF184301 Object Oriented Programming (E)
 * 
 */
// The Model performs all the calculations needed
// and that is it. It doesn't know the View exists

import java.util.ArrayList;
import java.util.List;

import predictive.Dictionary;
import predictive.DictionaryTreeImpl;

public class KeypadModel{
    /**
	 * Class for action of each button pressed
	 */

    private StringBuffer sb = new StringBuffer("");
    private static Dictionary dic = new DictionaryTreeImpl();
	private List<String> signature = new ArrayList<String>();
	private List<String> currMatch;
    private StringBuffer currString = new StringBuffer("");
    private StringBuffer response = new StringBuffer("");
    private int index;

    public String press(char ch) {
		// if 0 pressed then create new word
		if (ch == '0') { 
			// only make a new word when the current signature is not empty
			if (sb.length() > 0) 
				newWord();
		}
		// if * pressed change current word to the next word of the signature
		else if (ch == '*') { 
			changeCurrentWord(); 
			getCurrentWord(); 
		}
		// if # pressed delete the last character from the signature
		else if (ch == '#') { 
            delChar(); 
            getCurrentWord(); 
		}
		// if 1 pressed then do nothing
		else if (ch == '1') {}
		// if 2 - 9 pressed then add them to the current signature
		else {
			addChar(ch); 
			getCurrentWord(); 
		}	

		return this.getResponse() + currMatch.get(index);
	}

    // method to add character to signature
	private void addChar(char ch) {
		sb.append(ch);
		currMatch = new ArrayList<String>(dic.signatureToWords(sb.toString()));
		index = 0;
	} 
	
    // method to take certain word from the signature
    private void getCurrentWord() {
        // if there is word from the signature  
        if(currMatch.size() > 0){
            currString.setLength(0);
            currString.append(currMatch.get(index));
        }
        // if there is no word from the signature
        else
            currString = sb;
    }

    // method to make a new signature
    private void newWord() {
        // current signature for later use
        signature.add(sb.toString());
        sb.setLength(0); // reset the sb
        
        // append the text field 
        if (!currString.isEmpty()) {
            response.append(currString + " ");			
        }
		currMatch.removeAll(currMatch);
        currString.setLength(0); // reset the currString
    }

	// method to delete character from signature
	private void delChar() {
		// if the length of current signature is 0 and there at least 1 
		// signature before the current siganture then take the last signature from 
		// signature arraylist to be the current signature
		if (sb.length() == 0 && signature.size() > 0) {
            sb.setLength(0);
			sb.append(signature.get(signature.size() - 1));
			signature.remove(signature.size() - 1);
			
			// delete the last signature from the text field string
			response.setLength(response.length() - 1);
		}
		// if the length of current signature is more than 0, then delete last character
		else if (sb.length() > 0){
			sb.setLength(sb.length() - 1);
		}
		currMatch = new ArrayList<String>(dic.signatureToWords(sb.toString()));
		index = 0;

	}
	
	// method to change the current word from the signature
	private void changeCurrentWord() {
		// increment current index 
		index++;
		if (index == currMatch.size()) // back to 0 if it's the size of list
			index = 0;
	}
	
    public String getResponse() {
        return response.toString();
    }
	
}

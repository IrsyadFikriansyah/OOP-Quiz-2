package predictive;

/*
 * Quiz 2
 * 
 * Made by Moh. Adib Syambudi
 * -- 24 November 2022
 * IF184301 Object Oriented Programming (E)
 * 
 */

import java.math.BigInteger;

public class WordSig implements Comparable<WordSig> { 
    //field
    private String words;
    private String signature;
    //constructor
    public WordSig (String words, String signature) {
        this.words = words;
        this.signature = signature;
    }
    //getter words fields
    public String getWords() {
        return words;
    }
    //getter signature field
    public String getSignature() {
        return signature;
    }
    //compare between two object Wordsig for sorting
    @Override
    public int compareTo(WordSig ws) { 
        return new BigInteger(this.signature).compareTo(new BigInteger(ws.signature));
    }
    //toString for attributet field
    @Override
    public String toString()
    {
        return "{" + this.signature + ":" + "[" + this.words + "]" + "}";
    }

    


}
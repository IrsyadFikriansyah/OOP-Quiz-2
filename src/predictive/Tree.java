package predictive;
/*
 * Quiz 2
 * 
 * Made by Muhammad Zikri Ramadhan
 * -- 24 November 2022
 * IF184301 Object Oriented Programming (E)
 * 
 */
import java.util.*;

//this class is for tree implementation
public class Tree {
	
	//make the tree
	private Set<String> words;
	private Tree br2, br3, br4, br5, br6, br7, br8, br9;
	private Tree temp;
	
	//constructor
	public Tree(String root) {
		this.words = new HashSet<String>();
		this.br2 = null;
		this.br3 = null;
		this.br4 = null;
		this.br5 = null;
		this.br6 = null;
		this.br7 = null;
		this.br8 = null;
		this.br9 = null;
	}
	
	//this part is to get words from each tree section using recursive
	public Set<String> getWords(String signature){
		if (signature.length()>0) {
			// check every number in signature for the correct path to the paired words
			if (signature.charAt(0) == '2' && br2 != null) return br2.getWords(signature.substring(1, signature.length()));
			else if (signature.charAt(0) == '3' && br3 != null) return br3.getWords(signature.substring(1, signature.length()));
			else if (signature.charAt(0) == '4' && br4 != null) return br4.getWords(signature.substring(1, signature.length()));
			else if (signature.charAt(0) == '5' && br5 != null) return br5.getWords(signature.substring(1, signature.length()));
			else if (signature.charAt(0) == '6' && br6 != null) return br6.getWords(signature.substring(1, signature.length()));
			else if (signature.charAt(0) == '7' && br7 != null) return br7.getWords(signature.substring(1, signature.length()));
			else if (signature.charAt(0) == '8' && br8 != null) return br8.getWords(signature.substring(1, signature.length()));
			else if (signature.charAt(0) == '9' && br9 != null) return br9.getWords(signature.substring(1, signature.length()));

			// if certain br that has to be paired is null then restrun empty set
			else return new HashSet<String>();
		} 
		return words;
	}
	
	//this part is to add words to the tree
	public Tree addWords (String data, String nextSig) {
		//add the words
		words.add(data);
		int len = nextSig.length()-1;
		
		//make new tree for the next signature depend on the last number
		if (nextSig.charAt(len) == '2') {
			if (br2 == null) this.br2 = new Tree(nextSig);
			temp = this.br2;
		}
		else if (nextSig.charAt(len) == '3') {
			if (br3 == null) this.br3 = new Tree(nextSig);
			temp = this.br3;
		}
		else if (nextSig.charAt(len) == '4') {
			if (br4 == null) this.br4 = new Tree(nextSig);
			temp = br4;
		}
		else if (nextSig.charAt(len) == '5') {
			if (br5 == null) this.br5 = new Tree(nextSig);
			temp = this.br5;
		}
		else if (nextSig.charAt(len) == '6') {
			if (br6 == null) this.br6 = new Tree(nextSig);
			temp = this.br6;
		}
		else if (nextSig.charAt(len) == '7') {
			if (br7 == null) this.br7 = new Tree(nextSig);
			temp = this.br7;
		}
		else if (nextSig.charAt(len) == '8') {
			if (br8 == null) this.br8 = new Tree(nextSig);
			temp = this.br8;
		}
		else if (nextSig.charAt(len) == '9') {
			if (br9 == null) this.br9 = new Tree(nextSig);
			temp = this.br9;
		}
		return temp;
	}
}
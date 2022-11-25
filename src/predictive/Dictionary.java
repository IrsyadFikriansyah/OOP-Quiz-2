package predictive;
/*
 * Quiz 2
 * 
 * Made by Moh. Adib Syambudi, Muhammad Zikri Ramadhan
 * -- 24 November 2022
 * IF184301 Object Oriented Programming (E)
 * 
 */
import java.util.Set;

//interface for type dictionary
public interface Dictionary {

	Set<String> signatureToWords(String signature);
	String wordToSignature(String word);
}
package predictive;
/*
 * Quiz 2
 * 
 * Made by Muhammad Zikri Ramadhan
 * -- 24 November 2022
 * IF184301 Object Oriented Programming (E)
 * 
 */
public class Sigs2WordsMap {

	//class for testing the wordToSignature method
    //from DictionaryMapImpl class
	static Dictionary DictMap;
	public static void main(String[] args) {
		
		DictMap = new DictionaryMapImpl();
		long start = System.nanoTime();
		for (int i=0; i<args.length; i++) {
			System.out.println(args[i] + " : " + DictMap.signatureToWords(args[i]));
		}
	    long end = System.nanoTime();
	    long exetime = end - start;
	    
	    //execution time
	    System.out.println("Execution time: " + exetime + " nanoseconds");
	}
}
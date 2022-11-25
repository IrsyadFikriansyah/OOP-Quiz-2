package predictive;
/*
 * Quiz 2
 * 
 * Made by Muhammad Zikri Ramadhan
 * -- 24 November 2022
 * IF184301 Object Oriented Programming (E)
 * 
 */
public class Sigs2WordsTree {

	//class for testing the wordToSignature method
    //from DictionaryTreeImpl class
	static Dictionary DictTree;
	public static void main(String[] args) {
		
		DictTree = new DictionaryTreeImpl();
		long start = System.nanoTime();
		for (int i=0; i<args.length; i++) {
			System.out.println(args[i] + " : " + DictTree.signatureToWords(args[i]));
		}
	    long end = System.nanoTime();
	    long exetime = end - start;
	    
	    //execution time
	    System.out.println("Execution time: " + exetime + " nanoseconds");
	}
}
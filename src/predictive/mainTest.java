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

public class mainTest {
    public static void main(String[] args) {
        //Testing the implementation of Map Dictionary
        DictionaryMapImpl MapTester = new DictionaryMapImpl();
        Set<String> tester = MapTester.signatureToWords("4663");
        System.out.println("signatureToWords(4663) -> "+tester);

        tester = MapTester.signatureToWords("43556");
        System.out.println("signatureToWords(43556) -> "+tester);
    
        tester= MapTester.signatureToWords("96753");
        System.out.println("signatureToWords(96753) -> "+tester);

        //Testing the implementation of Tree Dictionary
        DictionaryTreeImpl TreeTester = new DictionaryTreeImpl();
        Set<String> TreeSet = TreeTester.signatureToWords("4663");
        System.out.println("\nsignatureToWords(4663) -> "+TreeSet);

        TreeSet = TreeTester.signatureToWords("43556");
        System.out.println("signatureToWords(43556) -> "+TreeSet);
        
        TreeSet = TreeTester.signatureToWords("96753");
        System.out.println("signatureToWords(96753) -> "+TreeSet);
    }
}
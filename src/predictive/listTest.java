package predictive;
/*
 * Quiz 2
 * 
 * Made by Moh. Adib Syambudi
 * -- 24 November 2022
 * IF184301 Object Oriented Programming (E)
 * 
 */
import java.io.File;

public class listTest {
    public static void main(String[] args) {
        //build object DictionaryListImpl with wird file from quiz
        DictionaryListImpl listtest = new DictionaryListImpl(new File("src/predictive/words"));
        //test the method signatureToWord 
        System.out.println(listtest.signatureToWords("4663"));
        
        
        
    }

}

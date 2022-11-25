package predictive;

/*
 * Quiz 2
 * 
 * Made by Irsyad Fikriansyah Ramadhan
 * -- 19 November 2022
 * IF184301 Object Oriented Programming (E)
 * 
 */

import java.util.*;

public class Sigs2WordsProto {
    public static void main(String[] args) {
        // Scanner
        Scanner input = new Scanner(System.in);
        
        // String variable
        String strInput = input.next(), strInput2;

        // Set variable to contain sign2word
        Set<String> mySet = new HashSet<String>();
        
        if (strInput.compareTo("Sigs2WordsProto") == 0){

            // scan the numbers that will converted into words
            strInput2 = input.nextLine();

            // split the numbers(string) and put then inside an array
            String arr[] = strInput2.split(" ", 0);

            for (int i = 0; i < arr.length; i++){
                if (arr[i] == "")
                    continue;

                mySet = PredictivePrototype.signatureToWords(arr[i]);
                System.out.print(arr[i] + " : ");
                System.out.println(mySet);

                // remove all content of set preparing for the next numbers
                mySet.removeAll(mySet);
            }
        }

        // close the Scanner
        input.close();
    }    
}

/* 
 * Run:
 * Sigs2WordsProto 4663 43556 96753 69 6263 47
 * 
 * Output:
 * 4663 : [hood, ione, ioof, good, hond, inne, gond, hone, hoof, gone, goof, home, gome]
 * 43556 : [gekko, hello]
 * 96753 : [world, yorke]
 * 69 : [ow, nw, ox, mw, oy, mx, ny, oz, my, nz]
 * 6263 : [mane, name, mand, nane, nand, oboe, mame]
 * 47 : [ip, hp, iq, gp, hq, ir, gq, hr, is, gr, hs, gs]
 */



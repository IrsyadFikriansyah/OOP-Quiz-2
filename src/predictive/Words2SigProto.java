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

public class Words2SigProto {
    public static void main(String[] args) {
        // Scanner
        Scanner input = new Scanner(System.in);
        
        // String variable
        String strInput = input.next(), strInput2, output;

        // LinkedList variable to contain word2sign
        LinkedList<String> ll = new LinkedList<String>();

        if (strInput.compareTo("Word2SigProto") == 0){
            // scan the numbers that will converted into words
            strInput2 = input.nextLine();

            // split the numbers(string) and put then inside an array
            String arr[] = strInput2.split(" ", 0);

            // put the words into a set
            for (int i = 0; i < arr.length; i++){
                if (arr[i] == "")
                    continue;
                ll.add(arr[i]);
            }
            System.out.print("input : ");
            System.out.println(ll);

            // prosses the string and store them inside variable output
            output = PredictivePrototype.wordToSignature(strInput2);
            System.out.print("output : ");
            System.out.println(output);
        }   

        // close the Scanner
        input.close();
    }    
}

/* 
 * Run:
 * Word2SigProto home hello world my name is
 * 
 * Output:
 * input : [home, hello, world, my, name, is] 
 * output : 4663 43556 96753 69 6263 47
 */
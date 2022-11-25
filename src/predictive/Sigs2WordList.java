package predictive;
/*
 * Quiz 2
 * 
 * Made by Moh. Adib Syambudi
 * -- 24 November 2022
 * IF184301 Object Oriented Programming (E)
 * 
 */
import java.util.*;
import java.io.File;

public class Sigs2WordList {
    public static void main(String[] args) throws Exception {
        //build object DictionaryListImpl with file word from quiz
        DictionaryListImpl file = new DictionaryListImpl(new File("src\\words"));
        ArrayList<String> sign = new ArrayList<String>();
        sign.add("4663");
        sign.add("43556");
        sign.add("96753");
        sign.add("69");
        sign.add("6263");
        sign.add("47");
        //result of dictionary
        for(int i = 0;i < 6;i++){
            String inp = sign.get(i);
            System.out.println(inp + ":" + file.signatureToWords(inp));
        }
            
    
        //input : 4663 43556 96753 69 6263 47
        /*output : 4663:[hood, ione, ioof, good, hond, inne, gond, hone, hoof, gone, goof, home, gome]
                   43556:[gekko, hello]
                   96753:[world, yorke]
                   69:[ow, nw, ox, mw, oy, ny, mx, oz, nz, my]
                   6263:[name, mane, nane, mand, oboe, nand, mame]
                   47:[ip, iq, hp, ir, hq, gp, hr, gq, is, hs, gr, gs]*/
        } 
}

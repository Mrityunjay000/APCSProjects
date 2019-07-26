/*
 * Mrityunjay Mishra
 * Mr. Finnegan
 * APCS - 3rd
 * 21 February 2018
 */
import static java.lang.System.*;

public class CipherRunner {

    public static void main(String args[]) {
    	BottomRightColumnRow cs = new BottomRightColumnRow();
    	
    	System.out.println("friendly");
        System.out.println(cs.encode("friendly"));
        System.out.println(cs.decode(cs.encode("friendly")));
        
        System.out.println("\nchicken");
        System.out.println(cs.encode("chicken"));
        System.out.println(cs.decode(cs.encode("chicken")));

        System.out.println("\nabc");
        System.out.println(cs.encode("abc"));
        System.out.println(cs.decode(cs.encode("abc")));

        System.out.println("\ndnadoublehelix");
        System.out.println(cs.encode("dnadoublehelix"));
        System.out.println(cs.decode(cs.encode("dnadoublehelix")));

        System.out.println("\ncipherscodesandstrings");
        System.out.println(cs.encode("cipherscodesandstrings"));
        System.out.println(cs.decode(cs.encode("cipherscodesandstrings")));

        System.out.println("\nelvissoundgardenhinderseetherbeatles");
        System.out.println(cs.encode("elvissoundgardenhinderseetherbeatles"));
        System.out.println(cs.decode(cs.encode("elvissoundgardenhinderseetherbeatles")));
    }
}
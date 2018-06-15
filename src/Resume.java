import java.io.FileNotFoundException;
import java.util.*;

import static java.lang.System.out;

public class Resume {

    static String userName = "";
    static ArrayList<String> education = new ArrayList<String>();
    static ArrayList<String> work = new ArrayList<String>();
    static HashMap<String, String> skills = new HashMap<String, String>();
    static boolean[] keepAsking = {true, true, true};

    public static void main(String[] args) throws FileNotFoundException {
        Mechanics.userPrompts(1);

        //while they want to keep asking OR 10 data entries
        while (keepAsking[0]){
            Mechanics.userPrompts(2);
        }
        //while they want to keep asking OR 10 data entries
        while (keepAsking[1]){
            Mechanics.userPrompts(3);
        }
        //while they want to keep asking OR 20 data entries
        while (keepAsking[2]){
            Mechanics.userPrompts(4);
        }
        //show resume
        String results = Mechanics.generateDisplayResults();
        out.println(results);
        Mechanics.writeToFile(results);
    }
}

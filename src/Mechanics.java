import java.util.Map;
import java.util.Scanner;
import java.util.Set;

import static java.lang.System.out;

public class Mechanics {

    //this function displays to the user what they must do next to go through the program, and triggers functions based off their choices
    protected static void userPrompts(int whichStep){
        //this counter makes sure they don't enter more than the specified amounts of each set
        int counter;
        Scanner keyboard = new Scanner(System.in);
        switch (whichStep) {
            case 1:
                out.print("Please enter your full name: ");
                Resume.userName = keyboard.nextLine();
                break;
            case 2:
                //reset the counter to.. 0 really, but it's better to have it set this way
                counter = Resume.education.size();
                out.print("Please enter an educational achievment: ");
                Resume.education.add(keyboard.nextLine());
                Resume.keepAsking[0] = keepLooping(counter, whichStep);
                break;
            case 3:
                counter = Resume.work.size();
                out.print("Please enter an example of your work experience: ");
                Resume.work.add(keyboard.nextLine());
                Resume.keepAsking[1] = keepLooping(counter, whichStep);
                break;
            case 4:
                counter = Resume.skills.size();
                out.print("Please enter a skill: ");
                String currentSkill = keyboard.nextLine();
                out.print("Please enter your rating for this skill: ");
                String currentRating = keyboard.nextLine();
                Resume.skills.put(currentSkill, currentRating);
                Resume.keepAsking[2] = keepLooping(counter, whichStep);
                break;
        }
    }

    //this function is called to maintain the while loop in Resume.java to the correct amounts for each set of information
    private static boolean keepLooping(int counter, int whichStep) {
        if (whichStep <= 3) {
            if (counter > 10) {
                out.println("This list is now full.");
                return Boolean.parseBoolean(null);
            }
        } else if (whichStep == 4) {
            if (counter > 20) {
                out.println("This list is now full.");
                return Boolean.parseBoolean(null);
            }
        }
        //the program only gets this far if they have not filled up that current data set
        Scanner keyboard = new Scanner(System.in);
        out.println("Do you have another entry for this section?\n{'y' for yes, 'n' for no}");
        String output = keyboard.nextLine();
        if (output.equalsIgnoreCase("y")) {
            return true;
        } else if (output.equalsIgnoreCase("n")) {
            return false;
        } else if (!output.equalsIgnoreCase("y") & !output.equalsIgnoreCase("n")){
            out.println("Invalid entry. Please type either 'y' for yes, or 'n' for no.");
            return keepLooping(counter, whichStep);
        }
        counter++;
        return true;
    }


    //returns a string of the results of the input, formatted as a "robo-resume"
    protected static String generateDisplayResults(){
        String output = "Name: ";
        output += Resume.userName + "\n\n" + "Education: \n";
        for (String object : Resume.education){
            output += "\u2022 " + object + "\n";
        }
        output += "\nWork Experience: \n";
        for (String object : Resume.work){
            output += "\u2022 " + object + "\n";
        }
        output += "\nSkillsets:";
        Set set = Resume.skills.entrySet();
        for (Object aSet : set) {
            Map.Entry mentry = (Map.Entry) aSet;
            output += "\u2022 " + mentry.getKey() + ", " + mentry.getValue() + "\n";
        }
        return output;
    }
}

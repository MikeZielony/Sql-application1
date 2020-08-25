package View;

import java.util.List;
import java.util.Scanner;

public class View {

    private static Scanner scan = new Scanner(System.in);

    public static void printMenu(String[] options) {
        for(int i = 0; i < options.length; i++){
            System.out.println(String.format("(%d) %s",i+1,options[i]));
        }
    }

    public static int getUserChoice(int optionsLength) {
        boolean isCorrect;
        String userChoice;
        do {
            userChoice = scan.nextLine();
            isCorrect = validateUserChoice(userChoice,optionsLength);
        }while(!isCorrect);
        return Integer.parseInt(userChoice);
    }

    private static boolean validateUserChoice(String userChoice, int optionLength) {
        try {
            int parseUserChoice = Integer.parseInt(userChoice);
            return !(parseUserChoice > optionLength || parseUserChoice < 1);
        }catch(Exception e){
            System.out.print("Invalid input!");
            return false;
        }
    }
    public static void showPersonList(List<String> people) {
        for (int i  = 0; i < people.size(); i++) {
            System.out.println((i + 1) + ". " + people.get(i));
        }
    }
}


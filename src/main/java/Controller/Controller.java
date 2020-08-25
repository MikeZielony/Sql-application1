package Controller;

import SQL.DatabaseInit;
import View.View;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Scanner;

public class Controller {

    public void runApp() {
        DatabaseInit DatabaseInit = new DatabaseInit();
        String statement = getStatementsFromtxt("src/main/Resources/dbInit.sql");
        DatabaseInit.initializeDb(statement);



        System.out.println("Provide your input?:");
        String[] options = {"Return first and last names of mentors",
                "Return nicknames of all mentors working at Miskolc",
                "Return fullname and phone number of Carol",
                "Return the right Carol",
                "Return applicant with unique code",
                "Return updated phone number of Jemima Foreman",
                "Return applicants without mauriseu.net domain"};
        View.printMenu(options);

        int userChoice = View.getUserChoice(options.length);
        switch (userChoice){
            case 1:
                List<String> mentorNames = DatabaseInit.getMentorsTwoNames();
                View.showPersonList(mentorNames);
                break;
            case 2:
                List<String> mentorNickNames = DatabaseInit.getMentorsNickames();
                View.showPersonList(mentorNickNames);
                break;
            case 3:
                List<String> carolData = DatabaseInit.getCarolData();
                View.showPersonList(carolData);
                break;
            case 4:
                List<String> carolCorrectData = DatabaseInit.getCorrectCarolData();
                View.showPersonList(carolCorrectData);
                break;
            case 5:
                List<String> newApplicantData = DatabaseInit.getNewApplicant();
                View.showPersonList(newApplicantData);
                break;
            case 6:
                List<String> updateApplicantData = DatabaseInit.updatePhoneNumber();
                View.showPersonList(updateApplicantData);
                break;
            case 7:
                List<String> deleteSpecificUsers = DatabaseInit.deleteSpecificApplicants();
                View.showPersonList(deleteSpecificUsers);
                break;
            case 8:
                System.out.printf("");
                break;

        }
    }
    public String getStatementsFromtxt(String fileName) {
        File file = new File(fileName);
        String content = "";
        try {
            Scanner scan = new Scanner(file);
            while(scan.hasNext())
                content += scan.nextLine();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return content;
    }

}

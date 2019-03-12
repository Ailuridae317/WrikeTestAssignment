package Wrike.pages;

import java.util.Random;

public class Answers {
    static Random random;

    public Answers(){
        random = new Random();
    }

    public static String getInterestAnswer(){
        int interest = random.nextInt(2) + 1;
        String interestChoice = "";
        switch (interest){
            case 1: interestChoice = "very_interested";
                break;
            case 2: interestChoice = "just_looking";
                break;
            default:
                break;
        }
        return interestChoice;
    }

    public static String getMembersAnswer(){
        int members = random.nextInt(5) +1;
        String membersChoice = "";
        switch (members){
            case 1: membersChoice = "1-5";
                break;
            case 2: membersChoice = "6-15";
                break;
            case 3: membersChoice = "16-25";
                break;
            case 4: membersChoice = "26-50";
                break;
            case 5: membersChoice = "50+";
                break;
            default:
                break;
        }
        return membersChoice;
    }

    public static String getBusinessAnswer(){
        int business = random.nextInt(3) +1;
        String businessChoice = "";
        switch (business){
            case 1: businessChoice = "yes";
                break;
            case 2: businessChoice = "no";
                break;
            case 3: businessChoice = "other";
                break;
            default:
                break;
        }
        return businessChoice;
    }
}

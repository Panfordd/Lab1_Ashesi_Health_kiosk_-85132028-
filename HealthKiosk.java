//TASK 0
import java.util.Scanner;

public class HealthKiosk {
    public static void main(String[] args){
        System.out.println("Welcome to the Ashesi Health Kiosk!");

        //TASK 1
        Scanner input=new Scanner(System.in);
        char services;
        System.out.print("Enter service code(P/L/T/C): ");
        services=input.next().toUpperCase().charAt(0);
        switch(services){
            case 'P':System.out.println("Go to: Pharmacy Desk");break;
            case 'L':System.out.println("Go to: Lab Desk");break;
            case 'T':System.out.println("Go to: Triage Desk");break;
            case 'C':System.out.println("Go to: Counseling Desk");break;
            default: System.out.println("Invalid Service code.");
        }

        //Task 2
        int metric = 0;
        int finalMetric = 0;
        double weight;
        double height;
        double bodyMassIndex;
        double roundedBMI = 0;
        String category;
        double requiredDosage;
        int numberOfTablets = 0;
        double angle;
        double sinAngle = 0;
        double cosAngle;

        if(services=='T'){
            System.out.print("Enter a health metric(1/2/3): ");
            metric= input.nextInt();
            if(metric==1){
                System.out.println("Enter your weight: ");
                weight=input.nextDouble();
                System.out.println("Enter your height: ");
                height=input.nextDouble();
                bodyMassIndex=(weight/(Math.pow(height,2)));
                roundedBMI=Math.round(bodyMassIndex *10)/10.0;
                finalMetric= (int) roundedBMI;

                if(roundedBMI<18.25)
                    category="Underweight";
                else if(roundedBMI>18.25 && roundedBMI<=24.9)
                    category="Normal";
                else if(roundedBMI>=25.0 && roundedBMI<=29.9)
                    category="Overweight";
                else
                    category="Obese";
                System.out.println("BMI: "+roundedBMI);
                System.out.println("Category: "+ category);
            }
            else if(metric==2){
                System.out.println("Enter the required dosage: ");
                requiredDosage=input.nextDouble();
                numberOfTablets= (int) Math.ceil(requiredDosage/250);
                System.out.println("Tablets: "+ numberOfTablets);
                finalMetric= numberOfTablets;
            }
            else if(metric==3){
                System.out.println("Enter an angle in degrees:");
                angle=Math.toRadians(input.nextDouble());
                sinAngle=Math.round(Math.sin(angle) *1000)/1000.0;
                cosAngle=Math.round(Math.cos(angle)*1000)/1000.0;
                System.out.println("sine of Angle: "+sinAngle);
                System.out.println("cosine of Angle: "+cosAngle);
                finalMetric=(int)sinAngle;
            }
        }

        //TASK 3-ID SANITY CHECK
        int randomCharacter;
        char letter;
        String newLetter;
        int num1,num2,num3,num4;
        String numberID;
        randomCharacter=  65 + (int) (Math.random()*26);
        letter = (char) randomCharacter;
        newLetter=String.valueOf(letter);
        num1= 3 + (int) (Math.random()*7);
        num2=  3 + (int) (Math.random()*7);
        num3=  3 + (int) (Math.random()*7);
        num4= 3 + (int) (Math.random()*7);
        numberID= (newLetter + num1+num2+num3+num4);
        System.out.println("ID: "+ numberID);

        if(numberID.length()==5 && Character.isLetter(numberID.charAt(0)) && Character.isDigit(numberID.charAt(1)) && Character.isDigit(numberID.charAt(2)) && Character.isDigit(numberID.charAt(3)) && Character.isDigit(numberID.charAt(4)))
            System.out.println("ID OK");

        //TASK 4-"SECURE" DISPLAY CODE
        String firstName;
        char character1;
        char shifted;
        String idExtraction;
        System.out.println("Enter your first name: ");
        input.nextLine();
        firstName=input.nextLine().toUpperCase();
        character1=firstName.charAt(0);
        shifted= (char)('A' + (character1- 'A' + 2) % 26);
        idExtraction = numberID.substring(numberID.length()-2);
        String displayCode = shifted + idExtraction + "-" + finalMetric;
        System.out.println("Display Code: " + displayCode);

        //TASK 5
        String summary;
        if (services == 'P') {
            summary = "PHARMACY | ID=" + numberID + " | Code=" + displayCode;
        } else if (services == 'L') {
            summary = "LAB | ID=" + numberID + " | Code=" + displayCode;
        } else if (services == 'T') {
            if (metric == 1) {
                summary = "TRIAGE | ID=" + numberID + " | BMI=" + roundedBMI + " | Code=" + displayCode;
            } else if (metric == 2) {
                summary = "TRIAGE | ID=" + numberID + " | Tablets=" + numberOfTablets + " | Code=" + displayCode;
            } else if (metric == 3) {
                summary = "TRIAGE | ID=" + numberID + " | sin=" + sinAngle + " | Code=" + displayCode;
            } else {
                summary = "TRIAGE | ID=" + numberID + " | Code=" + displayCode;
            }
        } else if (services == 'C') {
            summary = "COUNSELING | ID=" + numberID + " | Code=" + displayCode;
        } else {
            summary = "UNKNOWN SERVICE | ID=" + numberID + " | Code=" + displayCode;
        }

        System.out.println("Summary: " + summary);

        input.close();
    }
}

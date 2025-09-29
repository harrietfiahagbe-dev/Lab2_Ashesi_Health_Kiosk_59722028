//Date; 29/09/2025
//Author: Harriet Yayra Boven Fiahagbe
//Description:This is a Health Kiosk Intake System for Ashesi University's Health Center. The program is a self-service kiosk where students can select a health service, calculate their preferred health metrics, generate and validate their student ID, create a secure display code, and print a summary slip.


//Importing Scanner package to allow input
import java.util.Scanner;

public class HealthKiosk {
    public static void main(String[] args) {
        //Creating Scanner object for user input
        Scanner input = new Scanner(System.in);

        //Creating Variables
        char service_code;
        String service_name = "";
        String service_desk = "";
        int option_t = 0;
        double weight;
        double height;
        double body_mass = 0;
        String body_mass_fb = "";
        double dosage;
        double degrees;
        char first_letter;
        int num_1;
        int num_2;
        int num_3;
        int num_4;
        String first_name;
        int final_body_mass = 0;



        //A welcome line for the users
        System.out.println("Welcome to the Ashesi Health Kiosk!");

        //Asking users to enter their service code
        System.out.println("Please enter your preferred service code (P,L,T,C):  ");
        service_code = input.next().charAt(0);
        //Changing all input to uppercase
        service_code = Character.toUpperCase(service_code);

        //Creating a case for options for the user
        switch (service_code) {
            case 'P':
                service_name = "PHARMACY";
                service_desk = "Pharmacy Desk";
                break;
            case 'L':
                service_name = "LAB";
                service_desk = "Lab Desk";
                break;
            case 'T':
                service_name = "TRIAGE";
                service_desk = "Triage Desk";
                break;
            case 'C':
                service_name = "COUNSELING";
                service_desk = "Counseling Desk";
                break;
            default:
                System.out.println("Invalid Service Code.");




        }
        System.out.println("Go to the: " + service_desk);
        //Verifying condition if the user picked T
        if (service_code == 'T'){
            //Asking user to input their health metric
            System.out.print("Please enter your health metric (1: BMI , 2. Dosage Round-up, 3.Simple Trig Helper): ");
            option_t = input.nextInt();

            //Using switch case to perform the user's picked health metric
            switch(option_t){
                case 1:
                    //Asking for the weight of the user
                    System.out.print("Please enter your weight in kilograms: ");
                    weight = input.nextDouble();

                    //
                    System.out.print("Please enter your height in meters: ");
                    height = input.nextDouble();

                    //Calculating the BMI
                    body_mass = weight / Math.pow(height,2);
                    body_mass = Math.round(body_mass * 10) / 10.0;
                    //System.out.println("BMI: " + body_mass);
                    final_body_mass = (int) body_mass;

                    //
                    if (body_mass < 18.5){
                       body_mass_fb = "Underweight";
                    }else if (body_mass>= 18.5 && body_mass <=24.9){
                        body_mass_fb = "Normal";
                    }else if (body_mass >= 25.0 && body_mass<=29.9){
                        body_mass_fb = "Overweight";
                    }else if(body_mass >= 30.0){
                    body_mass_fb = "Obese";
                    }
                    //
                    System.out.println("This is your BMI: " +body_mass +  " You are: " + body_mass_fb);
                    break;
                case 2:
                    //
                    System.out.print("Please enter your required dosage (mg): ");
                    dosage = input.nextDouble();

                    //Pharmacy gives only 250mg of tablets, Used for calculations
                    double num_of_tablets = dosage/250;
                    double final_tablets = Math.ceil(num_of_tablets);
                    final_tablets = (int) final_tablets;
                    //
                    System.out.println("This is how much you have to take: " + final_tablets + "mg");
                    break;
                case 3:
                    //
                    System.out.print("Please enter an angle in degrees: ");
                    degrees = input.nextDouble();
                    //
                    double angle_radians = Math.toRadians(degrees);
                    //
                    double angle_sin = Math.sin(angle_radians);
                    double angle_cos = Math.cos(angle_radians);
                    //
                    angle_sin = Math.round(angle_sin  * 1000) / 1000.0;
                    angle_cos = Math.round(angle_cos * 1000) / 1000.0;
                    System.out.println("This is your angle in sin: " + angle_sin + " radian.");
                    System.out.println("This is your angle in cos: " + angle_cos + " radian.");
                    break;
                default:
                    System.out.println("Invalid input.");
                }




            }
            //Creating ID for user
            //
            char randomLetter = (char)('A' + (int)(Math.random() * 26));
            //
            num_1 = 3 + (int)(Math.random() * 7);
            num_2 =  3 + (int)(Math.random() * 7);
            num_3 = 3 + (int)(Math.random() * 7);
            num_4 = 3 + (int)(Math.random() * 7);
            //Concating all the values, we use the "" to force string concatenation
            String your_id = "" + randomLetter + num_1 + num_2 + num_3 + num_4;

            //Checking for the conditions highlighted
            //The length of the ID
            int length_id = your_id.length();
            if ((length_id == 5) &&
                    Character.isLetter(your_id.charAt(0)) && Character.isDigit(your_id.charAt(1)) &&
                    Character.isDigit(your_id.charAt(2)) && Character.isDigit(your_id.charAt(3)) &&
                    Character.isDigit(your_id.charAt(4))) {
                    System.out.println("This is a strong ID!");
            }else if (length_id != 5){
                System.out.println("This is not the right length");
            }else if (!Character.isLetter(your_id.charAt(0))){
                System.out.println("The first value has to be a letter");
            }else{
            System.out.println("Last four values must be digits");}



            input.nextLine();
            //Creating a unique code for the user, we are going to accept input
            System.out.println("Type in your name: ");
            first_name = input.nextLine();

            //Getting the first letter of the name
            char first_character = Character.toUpperCase(first_name.charAt(0));

            //Shifting the letter by 2 positions
            char shifted_letter =  (char)('A' + (first_character - 'A' + 2) % 26);

            //Extracting characters for task 3
            char character_id_3 = your_id.charAt(3);
            char character_id_4 = your_id.charAt(4);

            String final_code = "" + shifted_letter + character_id_3 + character_id_4 + "-" + final_body_mass;
            System.out.println("Display code: " + final_code);

            //Printing the whole summary of the user's information

            if (service_code == 'T' && option_t == 1){
                String summary = "Summary: " + service_name + " | ID= " + your_id + " | BMI=" + body_mass +  " | Code= " + final_code;
                System.out.println(summary);
            }
            else{
                String summary = "Summary: " + service_name + " | ID= " + your_id + " | Code= " + final_code;
                System.out.println(summary);
            }




       input.close();




















    }
}





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
        int option_t;
        double weight;
        double height;
        double body_mass;
        String body_mass_fb;
        double dosage;
        double degrees;



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
                service_name = "Pharmacy Desk";
                break;
            case 'L':
                service_name = "Lab Desk";
                break;
            case 'T':
                service_name = "Triage Desk";
                break;
            case 'C':
                service_name = "Counseling Desk";
                break;
            default:
                System.out.println("Invalid Service Code.");




        }
        //Verifying condition if the user picked T
        if (service_code == 'T'){
            //Asking user to inpur their health metric
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

                    //
                    body_mass = weight / Math.pow(height,2);
                    body_mass = Math.round(body_mass * 10) / 10.0;
                    System.out.println("BMI: " + body_mass);

                    //
                    if (body_mass < 18.5){
                       body_mass_fb = "Underweight";
                    }else if (body_mass>= 18.5 && body_mass <=24.9){
                        body_mass_fb = "Normal";
                    }else if (body_mass >= 25.0 && body_mass<=29.9){
                        body_mass_fb = "Overweight";
                    }else if(body_mass >= 30.0);{
                    body_mass_fb = "Obese";
                    }
                    //
                    System.out.println("This is your BMI: " + "You are: " + body_mass_fb);
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
                    System.out.println("This iis your angle in sin: " + angle_sin + "radian.");
                    System.out.println("This iis your angle in cos: " + angle_cos + "radian.");
                    break;
                default:
                    System.out.println("Invalid input.");
                }






            }



        }

        //System.out.println("Go to the: " + service_name);




    }

}

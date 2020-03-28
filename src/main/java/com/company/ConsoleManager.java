package com.company;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

import static com.company.MenuPrintSelection.*;

public class ConsoleManager {

    private static Scanner in = new Scanner(System.in);

    public static void showContacts(Set<Person> people){
        int i=1;
        for (Person bookPersons : people){
            System.out.println("Number "+i+" : "+bookPersons);
            i++;
        }
        System.out.println("To use number enter:");
    }

    public static String phoneNumberImput(){
        String number;
        System.out.println("Insert Phone Number in pattern XXX XXX XXX : ");
        String prefix = "+48";
        String tmpForNumber = in.nextLine();
        String phoneNumberInput  = prefix + tmpForNumber;
        if(phoneNumberInput.endsWith("+48")){
            number = null;
            System.out.println("Wrong input, no number");
        }else{
            number = phoneNumberInput;
        }
        return number;
    }

    public static void objectPrinter(HashSet<Person> toPrint){
        System.out.println(toPrint);
        System.out.println();
    }

    public static String gettingConsoleImput(){
        String input = in.nextLine();
        return input;
    }

    public static void choosedFromBookUserPrint(String bookUserHoiceName,String bookUserHoiceSurname, String userPhoneNumberFromBook){
        System.out.println("Choosed User: "+ bookUserHoiceName+ " "+bookUserHoiceSurname +" "+ userPhoneNumberFromBook);
    }

    public static void messagePrinter(MenuPrintSelection menuOption){
        if (menuOption.equals(MAIN_MENU_SELECTION)){
            System.out.println("1. Add person");
            System.out.println("2. Find person");
            System.out.println("3. Show all contacts");
            System.out.println("4. Send Message");
            System.out.println("5. Save Added person");
            System.out.println("6. Close program");
        }else if (menuOption.equals(SEND_TEXT_MESSAGE)){
            System.out.println("1. Send Message by Just input number");
            System.out.println("2. Send Message by PhoneBook");
            System.out.println("3. Close program");
        }else if (menuOption.equals(MESSAGE_SENT)){
            System.out.println("Corect number");
            System.out.println("Pleas input message: ");
        }else if (menuOption.equals(ENTER_NAME)){
            System.out.println("Enter Name");
        }else if (menuOption.equals(ENTER_SURNAME)){
            System.out.println("Enter surname: ");
        }else if (menuOption.equals(PERSON_EXIST)){
            System.out.println("Person Exist");
        }else if (menuOption.equals(PROGRAM_EXIT_MESSAGE)){
            in.close();
            System.out.println("Exiting Program");
        }else if (menuOption.equals(ERROR_PRINT)){
            System.out.println("Error");
        }else if (menuOption.equals(MAIN_MENU_SELECTION_DEFAULT)){
            System.out.println("Enter a number from 1 to 4");
        }else if (menuOption.equals(NUMBER_CORRECT_MESSAGE)){
            System.out.println("Corect number");
        }else if (menuOption.equals(ERROR_MESSAGE_BOOK_EMPTY)){
            System.out.println("The Book is Empty");
        }
    }
}

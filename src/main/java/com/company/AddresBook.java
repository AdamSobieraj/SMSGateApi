package com.company;

import java.util.HashSet;
import static com.company.ConsoleManager.*;
import static com.company.ConsoleManager.messagePrinter;
import static com.company.MenuPrintSelection.*;
import static com.company.OpenCSVReadWrite.readWithOpenCSV;
import static com.company.OpenCSVReadWrite.wtriteWithOpenCSV;

public class AddresBook{
    private HashSet<Person> people = new HashSet<Person>();
    PhoneNumberValidator phoneNumberValidator = new PhoneNumberValidator();
    SMSSender messageSender = new SMSSender();
    boolean test;

    //Menu section
    public void menuRun(){

        while (true){
            MenuAction action = showMainMenuSelection();
            switch (action){
                case ADD_PERSON:
                    Person listNewPerson = getPerInformation();
                    if (people.contains(listNewPerson)){ messagePrinter(PERSON_EXIST); }
                    people.add(listNewPerson);
                    break;
                case FIND_PERSON:
                    break;
                case DISPLAY_ALL:
                    for (Person personFromFile: readWithOpenCSV()){
                        people.add(personFromFile);
                    }
                    objectPrinter(people);
                    break;
                case SEND_MESSAGE:
                    sendTextMessage();
                    break;
                case SAVE_BOOK_LIST:
                    wtriteWithOpenCSV(people);
                    break;
                case EXIT:
                    messagePrinter(PROGRAM_EXIT_MESSAGE);
                    System.exit(0);
                    break;
            }
        }
    }

    private void sendTextMessage(){
        TextMessageMenu action = showTextMenuSelection();
            switch (action) {
                case SEND_BY_IMPUT_NUMBER:
                    String phoneNumberInput = phoneNumberImput();
                    messageSentFunction(phoneNumberInput);
                    break;
                case SEND_BY_PHONE_BOOK:
                    sentTextOprtionFromBook();
                    break;
                case EXIT:
                    messagePrinter(PROGRAM_EXIT_MESSAGE);
                    System.exit(0);
                    break;
            }
    }

    private void messageSentFunction(String phoneNumberInput){
        if (phoneNumberValidator.numberCheck(phoneNumberInput)) {
            messagePrinter(MESSAGE_SENT);
            String newMessage = gettingConsoleImput();
            messageSender.sendMessage(phoneNumberInput, newMessage);
        } else {
            messagePrinter(ERROR_PRINT);
        }
    }

    private MenuAction showMainMenuSelection() {
        messagePrinter(MAIN_MENU_SELECTION);
        String choice;
        do {
            choice = gettingConsoleImput();
            switch (Integer.parseInt(choice)) {
                case 1: return MenuAction.ADD_PERSON;
                case 2: return MenuAction.FIND_PERSON;
                case 3: return MenuAction.DISPLAY_ALL;
                case 4: return MenuAction.SEND_MESSAGE;
                case 5: return MenuAction.SAVE_BOOK_LIST;
                case 6: return MenuAction.EXIT;
                default: messagePrinter(MAIN_MENU_SELECTION_DEFAULT);
            }
        } while (!choice.equals("6"));
        return null;
    }

    private TextMessageMenu showTextMenuSelection() {
        messagePrinter(SEND_TEXT_MESSAGE);
        String choice;
        do {
            choice = gettingConsoleImput();
            switch (Integer.parseInt(choice)) {
                case 1: return TextMessageMenu.SEND_BY_IMPUT_NUMBER;
                case 2: return TextMessageMenu.SEND_BY_PHONE_BOOK;
                case 3: return TextMessageMenu.EXIT;
                default: messagePrinter(MAIN_MENU_SELECTION_DEFAULT);
            }
        } while (!choice.equals("3"));
        return null;
    }

    private Person getPerInformation(){
        messagePrinter(ENTER_NAME);
        String perName = gettingConsoleImput();
        messagePrinter(ENTER_SURNAME);
        String surname = gettingConsoleImput();
        String phoneNumberInput  = phoneNumberImput();
        if (phoneNumberValidator.numberCheck(phoneNumberInput)) {
            messagePrinter(NUMBER_CORRECT_MESSAGE);
        } else {
            messagePrinter(ERROR_PRINT);
        }
        return new Person(phoneNumberInput, perName , surname);
    }

    private void sentTextOprtionFromBook(){

        if (people.size() != 0){
            showContacts(people);
            messagePrinter(ENTER_NAME);
            String bookUserHoiceName = gettingConsoleImput();
            messagePrinter(ENTER_SURNAME);
            String bookUserHoiceSurname = gettingConsoleImput();
            String userPhoneNumberFromBook= "";
            for (Person bookPersons : people){
                if (bookUserHoiceName.equals(bookPersons.getName())&&
                        bookUserHoiceSurname.equals(bookPersons.getSurname())){
                    userPhoneNumberFromBook = bookPersons.getPhoneNumber();
                }
            }
            choosedFromBookUserPrint(bookUserHoiceName,bookUserHoiceSurname,userPhoneNumberFromBook);
            messageSentFunction(userPhoneNumberFromBook);
        }else{
            messagePrinter(ERROR_MESSAGE_BOOK_EMPTY);
        }
    }
}

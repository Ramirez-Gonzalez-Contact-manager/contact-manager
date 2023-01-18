import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import static java.nio.file.Paths.get;


public class Main {
    static Scanner sc1 = new Scanner(System.in);


    public static void main(String[] args) throws IOException {
        boolean proceed = true;
        do{
            mainMenu();
            int userInput = sc1.nextInt();

            if (userInput == 1) {
//            shows contacts information per line.
                printContacts();

            } else if (userInput ==2) {
                addContact();
            }else if (userInput ==3) {
                searchContacts();
            }else if (userInput ==4) {
                System.out.println("add a delete feature.");
            }else if (userInput ==5) {
                exit();
                proceed = false;
            }else{
                System.out.println("You have entered an invalid choice.");
            }
        }while(proceed);

    }

    //
    public static void printContacts() throws IOException {
        System.out.println("___________________________________________");
        System.out.println("Name        |  Phone number        ");
        Path contactsList = get("data", "contacts.txt");
        List<String>Listing = Files.readAllLines(contactsList);
        for (String contact : Listing) {
            System.out.println(contact);
            System.out.println("___________________________________________");

        }
    }

    public static void addContact() throws IOException {
        System.out.println("___________________________________________");
        System.out.println("Add a New Contact");
        System.out.println("\nFirst Name:\n");
        String firstName = sc1.next();
        System.out.println("\nLast Name:\n");
        String lastName = sc1.next();
        System.out.println("\nPhone Number: \n");
        String pNumber = sc1.next();
        Files.write(
                Paths.get("data", "contacts.txt"),
                Arrays.asList(firstName + " " + lastName + " | " + pNumber),
                StandardOpenOption.APPEND
        );
        System.out.println( firstName +" " + lastName + "  has been added to contacts file.");        System.out.println("___________________________________________");
        System.out.println("___________________________________________");


    }


    public static void mainMenu(){
        System.out.println("___________________________________________");
        System.out.println(" Welcome to the Contacts Manager");
        System.out.println("\n-Main Menu-");
        System.out.println("\n1. View Contact");
        System.out.println("\n2. Add a new contact.");
        System.out.println("\n3. Search a contact by name.");
        System.out.println("\n4. Delete an existing contact.");
        System.out.println("\n5. Exit.");
        System.out.println("\nMake a selection");
        System.out.println("___________________________________________");
    }
    public static void searchContacts() throws IOException {
        System.out.println("___________________________________________");
        System.out.println("Enter Name of Contact:");
        String searchedName = sc1.next();
        Path contactsList = get("data", "contacts.txt");
        List<String> Listing = Files.readAllLines(contactsList);
        for(String name : Listing){
            if(name.contains(searchedName)){
                System.out.println(name);
                System.out.println("___________________________________________");
            }

        }
    }

    public static void exit(){
        System.out.println("___________________________________________");
        System.out.println("Thank you for using Contact Manager");
        System.out.println("___________________________________________");

    }
}



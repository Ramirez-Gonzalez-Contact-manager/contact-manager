import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;

import static java.nio.file.Paths.get;


public class Main {
    static Scanner sc1 = new Scanner(System.in);


    public static void main(String[] args) throws IOException {
        boolean proceed = true;
        do {
            mainMenu();
            int userInput = sc1.nextInt();

            if (userInput == 1) {
                printContacts();
            } else if (userInput == 2) {
                addContact();
            } else if (userInput == 3) {
                searchContacts();
            } else if (userInput == 4) {
                deleteContact();
            } else if (userInput == 5) {
                exit();
                proceed = false;
            } else {
                System.out.println("You have entered an invalid choice.");
            }
        } while (proceed);

    }

    // Displays functions within the application to the user.
    public static void mainMenu() {
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


    // Allows user to view all contacts. * Bonus formatting
    public static void printContacts() throws IOException {
        System.out.printf("|%-10s        |%-10s        |","Name","Phone Number");
        System.out.println("\n___________________________________________");
        Path contactsList = get("data", "contacts.txt");
        List<String> Listing = Files.readAllLines(contactsList);
        for (String contact : Listing) {
            System.out.println(contact);
        }
        System.out.println("___________________________________________");

    }



    // Allows user to add contacts.
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
                Arrays.asList(String.format("|%-8s %-8s | %-18s |",firstName,lastName,pNumber)),
                StandardOpenOption.APPEND
        );
        System.out.println("___________________________________________");
        System.out.println("___________________________________________");


        }


    // Allows user to search for contacts.
    public static void searchContacts() throws IOException {
        System.out.println("___________________________________________");
        System.out.println("Enter Name of Contact:");
        String searchedName = sc1.next();
        Path contactsList = get("data", "contacts.txt");
        List<String> Listing = Files.readAllLines(contactsList);
        for (String name : Listing) {
            if (name.contains(searchedName)) {
                System.out.println(name);
                System.out.println("___________________________________________");
            }

        }

    }

    //Allows user to delete contacts.
    public static void deleteContact() throws IOException {
        System.out.println("___________________________________________");
        System.out.println("Enter Name of Contact:");
        String searchedName = sc1.next();
        Path contactsList = get("data", "contacts.txt");
        List<String> Listing = Files.readAllLines(contactsList);
        ArrayList<String> Listing2 = new ArrayList<>();
        for (String name : Listing) {
            if (name.contains(searchedName)) {
                System.out.println(searchedName + " Has Been removed from contacts.txt");
            } else {
                Listing2.add(name);
            }
        }
        Files.write(Paths.get("data", "contacts.txt"), Listing2);
    }

    // Allows user to exit from the application.
    public static void exit() {
        System.out.println("___________________________________________");
        System.out.println("Thank you for using Contact Manager");
        System.out.println("___________________________________________");

    }

}
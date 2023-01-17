import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Scanner;

import static java.nio.file.Paths.get;


public class Main {
    static Scanner sc1 = new Scanner(System.in);


    public static void main(String[] args) throws IOException {
        Path contactsList = get("data", "contacts.txt");
        List<String> contacts = Files.readAllLines(contactsList);
        System.out.println(" Welcome to the Contacts Manager");
        System.out.println("\n-Main Menu-");
        System.out.println("\n1. View Contact");
        System.out.println("\n2. Add a new contact.");
        System.out.println("\n3. Search a contact by name.");
        System.out.println("\n4. Delete an existing contact.");
        System.out.println("\n5. Exit.");
        System.out.println("\nMake a selection");
        int userInput = sc1.nextInt();

        if (userInput == 1) {
//            shows contacts information per line.
            printContacts();

        }

    }

    //
    public static void printContacts() throws IOException {
        System.out.println("Name        |  Phone number        ");
        Path contactsList = get("data", "contacts.txt");
        List<String>Listing = Files.readAllLines(contactsList);
        for (String contact : Listing) {
            System.out.println(contact);
        }
    }

    public static void addContact(String[] args) {
        System.out.println("Name        |  Phone number        ");
        Path contactsList = get("data", "contacts.txt");
        List<String>Listing = Files.readAllLines(contactsList);

//        Files.write(
//                get("data", "contacts.txt"),
//                Arrays.asList(""), // list with one item
//                StandardOpenOption.APPEND
        );
    }
}



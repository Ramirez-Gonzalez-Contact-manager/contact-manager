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

public class NewMain {

    static Scanner sc1 = new Scanner(System.in);

    static ArrayList<Contact> contacts;

    public static void main(String[] args) {

    }

    public static List<Contact> createContactList() throws IOException {
        ArrayList<Contact> contacts = new ArrayList<>();
        Path contactsList = get("data", "contacts.txt");
        List<String> Listing = Files.readAllLines(contactsList);
        for (String name : Listing) {
            Contact person = new Contact(name.substring(0, name.lastIndexOf("|")), name.substring(name.lastIndexOf("|") + 1));
            contacts.add(person);
        }
        System.out.println(contacts);
        return contacts;
    }

    public static int contactListApp(){
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
        return sc1.nextInt();
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
                Arrays.asList(String.format("|%-8s %-8s | %-18s |",firstName,lastName,pNumber)),
                StandardOpenOption.APPEND
        );
        System.out.println("___________________________________________");
        System.out.println("___________________________________________");


    }
}

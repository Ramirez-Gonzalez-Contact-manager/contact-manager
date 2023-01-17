import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
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
            for (String contact : contacts) {
                System.out.println(contact);
            }

        }
//
//        }
//        System.out.println(userInput);
//
//        System.out.println(contacts);
//        System.out.println(contacts.get(2));

    }
//
    public static void printContacts(){
        System.out.println("Name        |  Phone number        ");



    }



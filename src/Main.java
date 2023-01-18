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

    static List<Contact> contacts;


    public static void main(String[] args) throws IOException {
        boolean proceed = true;
        do {
            contacts = createContactList();
            System.out.println(contacts);
            mainMenu();
            int userInput = sc1.nextInt();

            if (userInput == 1) {
//            shows contacts information per line.
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

    //
    public static void printContacts() throws IOException {
        System.out.println("Name        |  Phone number        ");
        System.out.println("___________________________________________");
        Path contactsList = get("data", "contacts.txt");
        List<String> Listing = Files.readAllLines(contactsList);
        for (String contact : Listing) {
            System.out.println(contact);
        }
        System.out.println("___________________________________________");

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
        Contact newPerson = new Contact((firstName +" "+  lastName),pNumber);
        Path contactsList = get("data", "contacts.txt");
        List<String> Listing = Files.readAllLines(contactsList);
        System.out.println(Listing);
        System.out.println(firstName);
        if (contacts.contains(firstName)){
            System.out.println( "There is already a contact named " + newPerson.getName() + " Do you want to overwrite it?(yes/no");
            String userInput = sc1.next();
            if(userInput.equals("yes")){
                Files.write(
                        Paths.get("data", "contacts.txt"),
                        Arrays.asList(firstName + " " + lastName + " | " + pNumber),
                        StandardOpenOption.APPEND
                );
            }

        }
        Files.write(
                Paths.get("data", "contacts.txt"),
                Arrays.asList(firstName + " " + lastName + " | " + pNumber),
                StandardOpenOption.APPEND
        );
        System.out.println(firstName + " " + lastName + "  has been added to contacts file.");
        System.out.println("___________________________________________");
        System.out.println("___________________________________________");


    }


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

    public static void deleteContact() throws IOException {
        System.out.println("___________________________________________");
        System.out.println("Enter Name of Contact:");
        String searchedName = sc1.next();
        Path contactsList = get("data", "contacts.txt");
        List<String> Listing = Files.readAllLines(contactsList);
        ArrayList<String> Listing2 = new ArrayList<>();
        for (String name : Listing) {
            if (name.contains(searchedName)) {
                Listing.remove(name);
                System.out.println(name + " Has Been removed from contacts.txt");
            }
            else{
                Listing2.add(name);
            }
        }
        System.out.println(Listing2);
        Files.write(Paths.get("data", "contacts.txt"),Listing2);
    }
        public static void exit() {
        System.out.println("___________________________________________");
        System.out.println("Thank you for using Contact Manager");
        System.out.println("___________________________________________");

    }
//
    public static List<Contact> createContactList() throws IOException {
        ArrayList<Contact> contacts = new ArrayList<>();
        Path contactsList = get("data", "contacts.txt");
        List<String> Listing = Files.readAllLines(contactsList);
        for (String name : Listing) {
            Contact person = new Contact(name.substring(0,name.lastIndexOf("|")),name.substring(name.lastIndexOf("|") + 1));
            contacts.add(person);
        }
        System.out.println(contacts);
        return contacts;
    }



    }




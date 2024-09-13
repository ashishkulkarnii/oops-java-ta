import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Contact implements Serializable {
    private String name;
    private String phoneNumber;
    private String email;

    public Contact(String name, String phoneNumber, String email) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {
        return "Name: " + name + ", Phone: " + phoneNumber + ", Email: " + email;
    }
}

class AddressBook implements Serializable {
    private List<Contact> contacts;

    public AddressBook() {
        contacts = new ArrayList<>();
    }

    public void addContact(Contact contact) {
        contacts.add(contact);
    }

    public void updateContact(int index, Contact contact) {
        contacts.set(index, contact);
    }

    public void deleteContact(int index) {
        contacts.remove(index);
    }

    public List<Contact> getAllContacts() {
        return contacts;
    }
}

public class AddressBookApp {
    private static final String FILE_NAME = "address_book.ser";

    public static void main(String[] args) {
        AddressBook addressBook = loadAddressBook();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to Simple Address Book App!");

        while (true) {
            System.out.println("\n1. Add a new contact");
            System.out.println("2. Update an existing contact");
            System.out.println("3. Delete a contact");
            System.out.println("4. View all contacts");
            System.out.println("5. Exit");
            System.out.print("\nEnter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline character

            switch (choice) {
                case 1:
                    addContact(addressBook, scanner);
                    break;
                case 2:
                    updateContact(addressBook, scanner);
                    break;
                case 3:
                    deleteContact(addressBook, scanner);
                    break;
                case 4:
                    viewAllContacts(addressBook);
                    break;
                case 5:
                    saveAddressBook(addressBook);
                    System.out.println("Exiting... Address book saved.");
                    return;
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        }
    }

    private static void addContact(AddressBook addressBook, Scanner scanner) {
        System.out.print("Enter name: ");
        String name = scanner.nextLine();
        System.out.print("Enter phone number: ");
        String phoneNumber = scanner.nextLine();
        System.out.print("Enter email: ");
        String email = scanner.nextLine();

        Contact contact = new Contact(name, phoneNumber, email);
        addressBook.addContact(contact);
        System.out.println("Contact added successfully!");
    }

    private static void updateContact(AddressBook addressBook, Scanner scanner) {
        List<Contact> contacts = addressBook.getAllContacts();
        if (contacts.isEmpty()) {
            System.out.println("No contacts found.");
            return;
        }

        System.out.println("Select a contact to update:");
        for (int i = 0; i < contacts.size(); i++) {
            System.out.println((i + 1) + ". " + contacts.get(i));
        }
        System.out.print("Enter index of contact to update: ");
        int index = scanner.nextInt();
        scanner.nextLine(); // Consume newline character

        if (index < 1 || index > contacts.size()) {
            System.out.println("Invalid index!");
            return;
        }

        System.out.println("Enter updated details:");
        System.out.print("Enter name: ");
        String name = scanner.nextLine();
        System.out.print("Enter phone number: ");
        String phoneNumber = scanner.nextLine();
        System.out.print("Enter email: ");
        String email = scanner.nextLine();

        Contact updatedContact = new Contact(name, phoneNumber, email);
        addressBook.updateContact(index - 1, updatedContact);
        System.out.println("Contact updated successfully!");
    }

    private static void deleteContact(AddressBook addressBook, Scanner scanner) {
        List<Contact> contacts = addressBook.getAllContacts();
        if (contacts.isEmpty()) {
            System.out.println("No contacts found.");
            return;
        }

        System.out.println("Select a contact to delete:");
        for (int i = 0; i < contacts.size(); i++) {
            System.out.println((i + 1) + ". " + contacts.get(i));
        }
        System.out.print("Enter index of contact to delete: ");
        int index = scanner.nextInt();
        scanner.nextLine(); // Consume newline character

        if (index < 1 || index > contacts.size()) {
            System.out.println("Invalid index!");
            return;
        }

        addressBook.deleteContact(index - 1);
        System.out.println("Contact deleted successfully!");
    }

    private static void viewAllContacts(AddressBook addressBook) {
        List<Contact> contacts = addressBook.getAllContacts();
        if (contacts.isEmpty()) {
            System.out.println("No contacts found.");
            return;
        }

        System.out.println("Contacts:");
        for (Contact contact : contacts) {
            System.out.println(contact);
        }
    }

    private static AddressBook loadAddressBook() {
        AddressBook addressBook = null;
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
            addressBook = (AddressBook) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            addressBook = new AddressBook();
        }
        return addressBook;
    }

    private static void saveAddressBook(AddressBook addressBook) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            oos.writeObject(addressBook);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

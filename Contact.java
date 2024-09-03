import java.util.Scanner;

interface AddressBookOperations {
    void addContact(Contact contact);
    void viewContacts();
    Contact searchContact(String name);
}

class Contact {
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

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void displayContact() {
        System.out.println("Name: " + name);
        System.out.println("Phone Number: " + phoneNumber);
        System.out.println("Email: " + email);
        System.out.println("-----------------------------");
    }
}

class AddressBook implements AddressBookOperations {
    private Contact[] contacts;
    private int contactCount;

    public AddressBook(int size) {
        contacts = new Contact[size];
        contactCount = 0;
    }

    @Override
    public void addContact(Contact contact) {
        if (contactCount < contacts.length) {
            contacts[contactCount++] = contact;
            System.out.println("Contact added successfully.");
        } else {
            System.out.println("Address Book is full, cannot add more contacts.");
        }
    }

    @Override
    public void viewContacts() {
        if (contactCount == 0) {
            System.out.println("No contacts in Address Book.");
        } else {
            System.out.println("Displaying all contacts:");
            for (int i = 0; i < contactCount; i++) {
                contacts[i].displayContact();
            }
        }
    }

    @Override
    public Contact searchContact(String name) {
        for (int i = 0; i < contactCount; i++) {
            if (contacts[i].getName().equalsIgnoreCase(name)) {
                return contacts[i];
            }
        }
        return null;
    }
}

public class AddressBookApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        AddressBook addressBook = new AddressBook(100);

        while (true) {
            System.out.println("\nAddress Book Menu:");
            System.out.println("1. Add a new contact");
            System.out.println("2. View all contacts");
            System.out.println("3. Search for a contact by name");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter Phone Number: ");
                    String phoneNumber = scanner.nextLine();
                    System.out.print("Enter Email: ");
                    String email = scanner.nextLine();
                    Contact newContact = new Contact(name, phoneNumber, email);
                    addressBook.addContact(newContact);
                    break;
                case 2:
                    addressBook.viewContacts();
                    break;
                case 3:
                    System.out.print("Enter the name to search: ");
                    String searchName = scanner.nextLine();
                    Contact foundContact = addressBook.searchContact(searchName);
                    if (foundContact != null) {
                        foundContact.displayContact();
                    } else {
                        System.out.println("Contact not found.");
                    }
                    break;
                case 4:
                    System.out.println("Exiting the program.");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice, please try again.");
            }
        }
    }
}

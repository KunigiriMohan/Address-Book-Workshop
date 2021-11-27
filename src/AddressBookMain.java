
import java.util.ArrayList;
import java.util.Scanner;

public class AddressBookMain {

    ArrayList<Contact> contacts = new ArrayList<>();

    public static void menu() {
        System.out.println("Press 1 to Add the Contacts");
        System.out.println("Press 2 to Print Contacts");
        System.out.println("Press 3 to Edit Contacts");
        System.out.println("Press 4 to exit");
    }

    public void printContacts() {
        for (int i = 0; i <= contacts.size(); i++)
        {
            System.out.println(contacts.get(i));
        }
    }

    public int contactinBook(String firstName) {
        for (int i = 0; i < contacts.size(); i++)
            if (contacts.get(i).getFirst_Name().equals(firstName))
                return i;

        return -1;
    }
    public void editContacts(String firstName) {
        Scanner inp = new Scanner(System.in);
        int place = contactinBook(firstName);
        if (place >= 0) {

            System.out.println("Enter Last name");
            String lastName = inp.next();
            System.out.println("Enter Phone Number");
            String mobileNumber = inp.next();
            System.out.println("Enter City");
            String city = inp.next();
            System.out.println("Enter State");
            String state = inp.next();
            System.out.println("Enter Pin Code");
            String pinCode = inp.next();
            contacts.set(place,new Contact(firstName, lastName, mobileNumber, city, state, pinCode));

        }
        else if (place == -1)
        {
            System.out.println("First Name Not Match");
        }
    }
    private void deleteContact(String name) {
        int place =contactinBook(name);
        contacts.remove(place);
    }

    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);
        AddressBookMain obj = new AddressBookMain();
        menu();
        int choice = inp.nextInt();
        while (choice != 4) {

            if (choice == 1) {
                System.out.println("Enter First Name:");
                String firstName = inp.next();
                System.out.println("Enter Last NAme");
                String lastName = inp.next();
                System.out.println("Enter  phone number.");
                String number = inp.next();
                System.out.println("Enter The City");
                String city = inp.next();
                System.out.println("Enter The State");
                String state = inp.next();
                System.out.println("Enter the pin code");
                String pinCode = inp.next();
                obj.contacts.add(new Contact(firstName, lastName, number, city, state, pinCode));

            }
            else if (choice == 2)
            {
                obj.printContacts();
            }
            else if (choice == 3)
            {
                String firstName = inp.next();
                obj.editContacts(firstName);
            }
            else if (choice ==4)
            {
                System.out.println("Enter First name of contact to delete");
                String name = inp.next();
                obj.deleteContact(name);
            }
            menu();
            choice = inp.nextInt();
        }
    }


}

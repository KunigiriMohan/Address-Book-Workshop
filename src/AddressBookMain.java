
import java.util.*;

public class AddressBookMain {

    List<Contact> contacts = new ArrayList<>();
    Map<String,Contact> books= new LinkedHashMap<>();
    Map<String,Contact> name = new LinkedHashMap<>();
/*
* menu() method to select option by user
* */
    public static void menu() {
        System.out.println("Press 1 to Add the Contacts");
        System.out.println("Press 2 to Print Contacts");
        System.out.println("Press 3 to Edit Contacts");
        System.out.println("Press 4 to delete Contacts");
        System.out.println("Press 5 to exit");
    }
/*
* printContacts() method to print contacts in address book
* */
    public void printContacts() {
        for (int i = 0; i <= contacts.size()-1; i++)
        {
            System.out.println(contacts.get(i));
        }
    }
/*
* contactinBook() method to check contact is present in address book or not
* */
    public int contactinBook(String firstName) {
        for (int i = 0; i < contacts.size(); i++)
            if (contacts.get(i).getFirst_Name().equals(firstName))
                return i;

        return -1;
    }
    /*
    * editContacts() method to edit contacts
    * */
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
    /*
    * deleteContact() method to delete the contacts
    * */
    private void deleteContact(String name)
    {
        int place =contactinBook(name);
        contacts.remove(place);
    }
    /*
    * add() method to add contacts to Address Book
    * */
    public void add(String book, String firstName, String lastName, String number, String city, String state, String pinCode)
    {
        Contact object = new Contact(firstName, lastName, number, city, state, pinCode);
        if (contacts.size() == 0)
        {
            contacts.add(object);
        }
        else
        {
            for (int i = 0; i <=contacts.size() + 1; i++)
            {
                if (object.equals(contacts.get(i)))             //Using Equal method to find Contact is present in Address book
                {
                    System.out.println("Contact already Present");
                }
                else {
                    contacts.add(object);
                    books.put(book, object);
                    name.put(firstName, object);
                }
            }
        }

    }

    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);
        AddressBookMain obj = new AddressBookMain();
        menu();
        int choice = inp.nextInt();
        while (choice != 5)
        {
            if (choice == 1)
            {
                System.out.println("Enter Book name : ");
                String book = inp.next();
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

                obj.add(book,firstName, lastName, number, city, state, pinCode);
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

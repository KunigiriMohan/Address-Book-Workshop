
import java.util.ArrayList;
import java.util.Scanner;

public class AddressBookMain {

    ArrayList<Contact> contacts= new ArrayList<Contact>();
    public static void menu() {
        System.out.println("Press 1 to Add the contacts");
        System.out.println("Press 2 to Print contacts");
        System.out.println("Press 3 to exit");
    }
    public void printContacts(){
        for (int i=0;i<=contacts.size();i++){
            System.out.println(contacts.get(i));
        }
    }

    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);
        AddressBookMain obj = new AddressBookMain();
        menu();
        int choice = inp.nextInt();
        while (choice != 2) {

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

            } else if (choice == 2) {
                obj.printContacts();

            }
            menu();
            choice = inp.nextInt();
            }

        }
    }

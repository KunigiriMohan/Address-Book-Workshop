import java.util.*;

class AddressBookMain {

    Map<String, Contact> contacts = new LinkedHashMap<>();
    Map<String, Contact> books = new LinkedHashMap<>();
    Map<String, Contact> name = new LinkedHashMap<>();
    Map<String, Contact> cityName = new LinkedHashMap<>();
    Map<String, Contact> stateName = new LinkedHashMap<>();


    /*
     * addContact() to add new created contacts to address book
     * */

    public void printContactDetails() {
        contacts.entrySet().stream().forEach(System.out::println);
    }

    /*
     * menu() method for showing options user has
     * */
    public static void menu() {
        System.out.println("Press 1 for Adding a new contact to your address book.");
        System.out.println("Press 2 for Editing Existing contact");
        System.out.println("Press 3 for Deleting Existing Contact");
        System.out.println("Press 4 for viewing the contacts present");
        System.out.println("Press 5 to view contact details by city");
        System.out.println("Press 6 to view contact details by State");
        System.out.println("Press 7 to view contact count by State");
        System.out.println("Press 8 to view contact count by City");
        System.out.println("Press 9 to Quit");
    }

    /*
     * haveContacts() method to return index of particular person in person array
     * */
    int contactinBook(String s) {
        for (int i = 0; i < contacts.size(); i++)
            if (contacts.containsKey(s))
                return i;

        return -1;
    }

    /*
     *editContact() to edit existing contacts
     **/
    public void editContact(String firstName) {
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
            contacts.replace(firstName, new Contact(firstName, lastName, mobileNumber, city, state, pinCode));
            books.replace(firstName, new Contact(firstName, lastName, mobileNumber, city, state, pinCode));
            name.replace(firstName, new Contact(firstName, lastName, mobileNumber, city, state, pinCode));
        } else if (place == -1) {
            System.out.println("First Name Not Match");
        }
    }

    /**
     * method for deleting contacts
     */
    public void deleteContact(String s) {
        int place = contactinBook(s);
        if (place >= 0) {
            contacts.remove(place);
            books.remove(place);
            name.remove(place);
        }
    }

    /*
     * countStatePerson() method to count person present particular state and return value
     * */
    public static long countStatePerson() {
        AddressBookMain obj = new AddressBookMain();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Name of the State.");
        String nameState = scanner.next();
        return obj.stateName.entrySet().stream().filter(name -> name.getKey().equals(nameState)).count();
    }

    /*
     * countCityPerson() method to count person present particular city and return value
     * */
    public static long countcityPerson() {
        AddressBookMain obj = new AddressBookMain();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Name of the City.");
        String nameCity = scanner.next();
        return obj.cityName.entrySet().stream().filter(name -> name.getKey().equals(nameCity)).count();
    }

    /*
     * personbyCity() method for to view person by city
     * */
    public static void personbyCity() {
        AddressBookMain obj = new AddressBookMain();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Name of the City.");
        String nameCity = scanner.next();

        if (obj.cityName.entrySet().stream().anyMatch(name -> name.getKey().equals(nameCity))) {
            obj.cityName.entrySet().stream().filter(name -> name.getKey().equals(nameCity)).forEach(System.out::println);
        } else {
            System.out.println("No Contacts found on city Name");
        }
    }

    public static void personbyState() {
        AddressBookMain obj = new AddressBookMain();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Name of the City.");
        String nameState = scanner.next();
        boolean value = false;
        if (value = obj.stateName.entrySet().stream().anyMatch(name -> name.getKey().equals(nameState))) {
            obj.stateName.entrySet().stream().filter(name -> name.getKey().equals(nameState)).forEach(System.out::println);
        } else {
            System.out.println("No Contacts found on city Name");
        }
    }

    /*
     * Mian function of class
     * */
    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);
        AddressBookMain obj = new AddressBookMain();
        menu();
        int choice = inp.nextInt();
        while (choice != 9) {
            if (choice == 1) {
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
                obj.add(book, firstName, lastName, number, city, state, pinCode);

            } else if (choice == 2) {
                System.out.println("Enter the First Name of the contact you want to edit?");
                String fName = inp.next();
                obj.editContact(fName);
            } else if (choice == 3) {
                System.out.println("What is the First name of the contact you want to delete?");
                String fName = inp.next();
                obj.deleteContact(fName);
            } else if (choice == 4) {
                obj.printContactDetails();
            } else if (choice == 5) {
                personbyCity();
            } else if (choice == 6) {
                personbyState();
            } else if (choice == 7) {
                System.out.println("No of times contacts present in State : " + countStatePerson());
            } else if (choice == 8) {
                System.out.println("No of times contacts present in City : " + countcityPerson());
            }

            menu();
            choice = inp.nextInt();
        }
    }

    private void add(String book, String firstName, String lastName, String number, String city, String state, String pinCode) {
        Contact object = new Contact(firstName, lastName, number, city, state, pinCode);
        if (contacts.size() == 0) {
            contacts.put(firstName, object);
        } else {
            for (int i = 0; i <= contacts.size() + 1; i++) {
                if (object.equals(contacts.get(i)))             //Using Equal method to find Contact is present in Address book
                {
                    System.out.println("Contact already Present");
                } else {
                    contacts.put(firstName, object);
                    books.put(book, object);
                    name.put(firstName, object);
                }
            }
        }
    }
}
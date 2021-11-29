import java.util.*;

class AddressBookMain {

    Map<String, Contact> contacts = new LinkedHashMap<>();
    Map<String, Contact> books = new LinkedHashMap<>();
    Map<String, Contact> name = new LinkedHashMap<>();
    Map<String, Contact> cityName = new LinkedHashMap<>();
    Map<String, Contact> stateName = new LinkedHashMap<>();


    /*
     * personbyCity() method for to view person by city
     * */
    public boolean personbyCity (String nameCity)
    {
        return cityName.entrySet().stream().anyMatch(name -> name.getKey().equals(nameCity));
    }
    public boolean personbyState (String nameState) {

        return stateName.entrySet().stream().anyMatch(name -> name.getKey().equals(nameState));
    }
    /*
    * add() method to add contacts to Addressbook
    * */
    public void add(String book, String firstName, String lastName, String number, String city, String state, String pinCode) {
        Contact object = new Contact(firstName, lastName, number, city, state, pinCode);
        if (contacts.size() == 0) {
            contacts.put(firstName,object);
            books.put(book, object);
            name.put(firstName, object);
            stateName.put(state,object);
            cityName.put(city,object);

        } else {
            for (int i = 0; i <= contacts.size() + 1; i++) {
                if (object.equals(contacts.get(i)))             //Using Equal method to find Contact is present in Address book
                {
                    System.out.println("Contact already Present");
                } else {
                    contacts.put(firstName,object);
                    books.put(book, object);
                    name.put(firstName, object);
                    stateName.put(state,object);
                    cityName.put(city,object);
                }
            }
        }
    }
}

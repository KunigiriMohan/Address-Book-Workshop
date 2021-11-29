import java.util.*;

class AddressBookMain {

    Map<String, Contact> contacts = new LinkedHashMap<>();
    Map<String, Contact> books = new LinkedHashMap<>();
    Map<String, Contact> name = new LinkedHashMap<>();
    Map<Contact,String> cityName = new LinkedHashMap<>();
    Map<Contact,String> stateName = new LinkedHashMap<>();


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
     * countStatePerson() method to count person present particular state and return value
     * */
    public long countStatePerson(String nameState) {

        return stateName.entrySet().stream().filter(name -> name.getValue().equals(nameState)).count();
    }

    /*
     * countCityPerson() method to count person present particular city and return value
     * */
    public long countcityPerson(String nameCity) {
        return cityName.entrySet().stream().filter(name -> name.getValue().equals(nameCity)).count();
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
            stateName.put(object,state);
            cityName.put(object,city);

        } else {
            for (int i = 0; i <= contacts.size() + 1; i++) {
                if (object.equals(contacts.get(i)))             //Using Equal method to find Contact is present in Address book
                {
                    System.out.println("Contact already Present");
                } else {
                    contacts.put(firstName,object);
                    books.put(book, object);
                    name.put(firstName, object);
                    stateName.put(object,state);
                    cityName.put(object,city);
                }
            }
        }
    }
}
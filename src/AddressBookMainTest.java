import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AddressBookMainTest {

    /*@Test
    void add() {
        AddressBookMain obj = new AddressBookMain();
        obj.add("mohan", "mohan", "raju", "8555058332", "adoni", "andhra", "518301");
        assertFalse((obj.add("mohan", "mohan", "raju", "8555058332", "adoni", "andhra", "518301")));
    }*/

    @Test
    void add1() {
        AddressBookMain obj = new AddressBookMain();
        obj.add("mohan", "mohan", "raju", "8555058332", "adoni", "andhra", "518301");
        assertEquals(true, obj.personbyState("andhra"));
    }

    @Test
    void personinCity() {
        AddressBookMain obj = new AddressBookMain();
        obj.add("mohan", "mohan", "raju", "8555058332", "adoni", "andhra", "518301");
        assertEquals(true, obj.personbyCity("adoni"));
    }
    @Test
    void countbyCity(){
        AddressBookMain obj = new AddressBookMain();
        obj.add("mohan", "mohan", "raju", "8555058332", "adoni", "andhra", "518301");
        obj.add("mohan", "raju", "yadav", "8555058332", "adoni", "andhra", "518301");
        obj.add("mohan", "pavan", "kumar", "8555058332", "adoni", "telangana", "500001");
        obj.add("mohan", "praveen", "reddy", "8555058332", "bangalore", "karnataka", "510001");
        obj.add("mohan", "ashok", "kumar", "8555058332", "hyderabad", "telangana", "500001");

        assertEquals(3,obj.countcityPerson("adoni"));
    }
    @Test

    void countbyState(){
        AddressBookMain obj = new AddressBookMain();
        obj.add("mohan", "mohan", "raju", "8555058332", "adoni", "andhra", "518301");
        obj.add("mohan", "raju", "yadav", "8555058332", "adoni", "andhra", "518301");
        obj.add("mohan", "pavan", "kumar", "8555058332", "adoni", "telangana", "500001");
        obj.add("mohan", "praveen", "reddy", "8555058332", "bangalore", "karnataka", "510001");
        obj.add("mohan", "ashok", "kumar", "8555058332", "hyderabad", "telangana", "500001");

        assertEquals(2,obj.countStatePerson("andhra"));
    }

}

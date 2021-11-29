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
        assertEquals(true,obj.personbyState("andhra"));
    }
    @Test
    void add2(){
        AddressBookMain obj = new AddressBookMain();
        obj.add("mohan", "mohan", "raju", "8555058332", "adoni", "andhra", "518301");
        assertEquals(true,obj.personbyCity("adoni"));
    }
}


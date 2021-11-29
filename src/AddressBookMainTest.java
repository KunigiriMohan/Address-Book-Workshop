import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AddressBookMainTest {

    @Test
    void add() {
        AddressBookMain obj = new AddressBookMain();
        obj.add("mohan","mohan","raju","8555058332","adoni","andhra","518301");
        assertFalse((obj.add("mohan","mohan","raju","8555058332","adoni","andhra","518301")));
    }
}

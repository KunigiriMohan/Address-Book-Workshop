public class Contact {

    private String phonenumber;
    private String first_Name;
    private String last_Name;
    private String city;
    private String state;
    private String zip;

    public Contact(String firstName, String lastName, String phoneNumber , String city, String state, String zip) {
        this.first_Name = firstName;
        this.last_Name=lastName;
        this.city=city;
        this.phonenumber = phoneNumber;
        this.state=state;
        this.zip=zip;

    }
    /*
    * getters and setters
    * */
    public String getFirst_Name() {
        return first_Name;
    }
    public String getlastName() {
        return last_Name;
    }
    public String getCity() {
        return city;
    }
    public String getState(){
        return state;
    }

    public String getNumber(int newnum) {
        return phonenumber;
    }

    public void setFirst_Name(String first_Name) {
        this.first_Name = first_Name;
    }

    public String getLast_Name() {
        return last_Name;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String toString() {
        return  " First Name : " + first_Name + " Last Name: "+last_Name+" Phone Number: " + phonenumber+" City: "+city+" State: "+state +" Zip Code : "+zip ;
    }

}








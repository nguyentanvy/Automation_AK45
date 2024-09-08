package theInternet;

public class Person {
    private String lastName;
    private  String firstName;
    private String email;
    private Float due;
    private String website;
    public Person(String lastName, String firstName, String email, Float due, String website) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.email = email;
        this.due = due;
        this.website = website;
    }

    public String getLastName(){
        return lastName;
    }
    public String getFirstName(){
        return firstName;
    }
    public Float getDue(){
        return due;
    }

}

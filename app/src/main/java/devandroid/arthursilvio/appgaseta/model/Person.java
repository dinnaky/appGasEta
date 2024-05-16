package devandroid.arthursilvio.appgaseta.model;

//Class
public class Person {

    //gets and setts
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String curse) {
        this.course = curse;
    }

    public String getTell() {
        return tell;
    }

    public void setTell(String tell) {
        this.tell = tell;
    }

    //attributes
    private String firstName;
    private String surname;
    private String course;
    private String tell;

    //constructor
    public Person() {

    }
}
package uk.axone.framework.oopsrefresher;

/**
 * @author Karthik.Gandhinathan
 */
public class Student {
    public int rollNo;
    public String name;
    public Address address;

    public Student(int rollNo, String name, Address address) {
        this.rollNo = rollNo;
        this.name = name;
        this.address = address;
    }


    public void displayStudent(){
        System.out.println(rollNo + "----" + name);
        System.out.println("Address: City: " + address.city + " " + address.county + " " + address.country);
    }

    public static void main(String[] args) {
        Student s1 = new Student(001, "Paul Smith", new Address("London", "Surrey", "United Kingdom"));
        Student s2 = new Student(002, "Murugan", new Address("Tunbridge", "Kent", "United Kingdom"));

        s1.displayStudent();
        s2.displayStudent();
    }

}

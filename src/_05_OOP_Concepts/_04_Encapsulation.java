package _05_OOP_Concepts;

// Bundles data and methods together and restricts direct access to the data from outside the class.
// Declare data as private: Hide the class data so it cannot be accessed directly from outside the class.
// Use getters and setters: Keep variables private and provide public getter and setter methods for controlled access and safe modification, often with validation.

class Programmer{
    private String name;                          // default is null

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }
}
public class _04_Encapsulation {
    public static void main(String[] args) {
        Programmer pr = new Programmer();
        System.out.println(pr.getName());
        pr.setName("Daksh Sharma");
        System.out.println(pr.getName());
    }
}

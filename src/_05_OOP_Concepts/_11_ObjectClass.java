package _05_OOP_Concepts;

//Object is the root superclass of all classes in Java.
//Every class directly or indirectly inherits from Object.
//If you don't explicitly extend a class, Java implicitly adds: extends Object.

//Why is it important?
//Because every class inherits some common methods from Object.

//Defines essential methods shared by all objects: toString(), equals(), hashCode(), getClass() etc.
//Supports thread communication (wait(), notify(), notifyAll())

// One can override these methods to get the desired result.
// EXAMPLE BELOW

public class _11_ObjectClass {
    String n;

    // Constructor
    public _11_ObjectClass(String n) {
        this.n = n;
    }

    // Override toString() for a
    // custom string representation
    @Override
    public String toString() {
        return "Person{name:'" + n + "'}";
    }


    public static void main(String[] args) {
        _11_ObjectClass p = new _11_ObjectClass("Daksh");

        // Custom string representation
        System.out.println(p.toString());

        // Default hash code value
        System.out.println(p.hashCode()); // Returns an integer hash value for the object.
                                          // Used heavily in hash-based collections like HashMap and HashSet.
    }
}

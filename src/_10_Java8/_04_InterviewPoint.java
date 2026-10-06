package _10_Java8;

public interface _04_InterviewPoint {
    // main method can be written inside interface too from java8
    public static void main(String[] args) {
        System.out.println("Hello from interface");
    }
}


/*  Note:
    One .java file can have at most one public top-level type.
    A top-level type can be: class, interface, enum, record

    Also, the filename must match the public type:
    // File: A.java
    public class A {}

    Rule: One Java file → at most one public top-level type, and the filename must match it.
*/
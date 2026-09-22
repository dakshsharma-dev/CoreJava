package _05_OOP_Concepts;

// this explicitly refers to the current object's instance members, especially useful when a local variable/parameter has the same name as an instance variable.
class referToCurrentClassInstanceVariables{
    int a;
    int b;

//    Distinguishing instance variables from parameters with the same name
    public referToCurrentClassInstanceVariables(int a, int b){
        this.a = a;
        this.b = b;
    }
    public void display(int a, int b){
        System.out.println("Stored values: " + this.a + " and " + this.b + " and new values: " + a + " and " + b);
    }
    public void displayStoredValues(){
        System.out.println("Stored Values: " + a + " and " + b);
    }

//    this is not required when there is no naming conflict
    public void display(){
        System.out.println("Stored Values: " + this.a + " and " + this.b);
    }
}


// this() syntax is used for constructor chaining, where one constructor calls another constructor of the same class.
class invokeTheCurrentClassConstructor{
    int a;
    int b;

    public invokeTheCurrentClassConstructor(){
        this(10, 20);                                  // *************must be the first statement in constructor*************
        System.out.println("Inside default constructor");

    }public invokeTheCurrentClassConstructor(int a, int b){
        this.a = a;
        this.b = a;
        System.out.println("Inside parameterized constructor");
    }
    public void display(){
        System.out.println("a = " + a + " b = " + b);
    }
}


// returns the current object, enabling method chaining.
class returnTheCurrentClassInstance{
    String name;
    int age;

    public returnTheCurrentClassInstance setName(String a){
        this.name = a;
        return this;
    }
    public returnTheCurrentClassInstance setAge(int a){
        this.age = a;
        return this;
    }
    public void display(){
        System.out.println("Name = " + name + " and Age = " + age);
    }
}
public class _02_ThisKeyword {
    public static void main(String[] args) {
        referToCurrentClassInstanceVariables cciv = new referToCurrentClassInstanceVariables(10, 20);
        cciv.display();
        cciv.displayStoredValues();
        cciv.display(40, 50);

        invokeTheCurrentClassConstructor iccc = new invokeTheCurrentClassConstructor();
        iccc.display();

        returnTheCurrentClassInstance rcci = new returnTheCurrentClassInstance();
        rcci.setName("Daksh").setAge(21).display();                                  // method chaining
    }
}

package _10_Java8;

interface Employee{
    String getSalary();
    String getDesignation();
}

interface Admin{
    String getAdmin();
}

class ClassA {
    int val = 5;    // instance variable // declaration + initialization allowed in class
    // val = 50;    // executable statement not allowed DIRECTLY in class body

    // a) Modification of instance variables is allowed inside constructors, instance methods, static blocks, and instance initializer blocks.
    // b) changes the instance variable of that particular object, not just for that method.
    ClassA() {
        val = 10;
    }
    int getVal() {
        val = 20;
        return val;
    }
    int getFinalVal(){
        return val;    // return 20 -> demonstrates (b)
    }
}
// Same rule applies to Anonymous Inner Classes (AIC).
// Their instance variables can be modified inside their methods/constructors/initializer blocks.


public class _05_LocalVariableInLambdaAndAnonymous {
    public static int instanceVariableOfMainClass = 55;
    public static void main(String[] args){
        ClassA ca = new ClassA();
        System.out.println("Class val: " + ca.getVal());
        System.out.println("Class finalVal: " + ca.getFinalVal());


        // Anonymous Inner Class → creates an actual object & follows the same rule as a class
        Employee employee = new Employee() {
            int a = 5;                                    // this is an instance variable as this is a class(anonymous)
            @Override
            public String getSalary() {
                a = 2;
                return "1000000" + this.a;                // this can be used as 'a' is an instance variable not local variable
            }

//            a = 10000;                                  // executable statement not allowed DIRECTLY in class body

            @Override
            public String getDesignation() {
                return "ManagerLevel" + a;
            }
        };
        System.out.println(employee.getSalary());          // 10000002
        System.out.println(employee.getDesignation());     // ManagerLevel2


        // Lambdas doesn't create an actual object
        Admin admin = () -> {
            int a = 50000000;                                 // 'a' is a local variable of lambda expression not instance variable
            a = 80000000;                                     // local variable can be modified
            return "Admin: Daksh Sharma" + " & Salary = " + a;
        };
        System.out.println(admin.getAdmin());


        int abc = 1;                                          // local variable of main() method
        Admin admin1 = () -> {
            instanceVariableOfMainClass = 45;                 // instance variable of main class can be modified inside lambda expression
            // abc = 2;                                       // modification of 'abc' is not allowed as 'abc' was used in lambda expression
            return "Daksh Sharma" + abc;                      // Variable used(captured) in lambda expression should be final or effectively final
        };
        System.out.println(admin1.getAdmin());
        // abc = 2;                                           // modification of 'abc' is not allowed as 'abc' was used in lambda expression
    }
}

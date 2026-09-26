package _06_Interface;

// FUNCTIONAL INTERFACE ----> SAM(Single Abstract Method)  ----> has exactly 1 abstract method

@FunctionalInterface
interface func{
    void show();
}

// Way 1 of using show() method
class funcHelper implements func{
    public void show(){
        System.out.println("In show of funcHelper");
    }
}

public class _02_Functional_InterfaceOrSAM {
    public static void main(String[] args) {
        func fn1 = new funcHelper();
        fn1.show();                                                    // In show of funcHelper

        // Way 2 of using show() method using anonymous inner class
        func fn2 = new func(){
            public void show(){
                System.out.println("In show of func");
            }
        };
        // now to make the above code shorter and cleaner ----> lambda expression comes into picture (to make JAVA less verbose{verbose -> using more words than are necessary to express an idea})
        fn2.show();                                                    // In show of func
    }
}

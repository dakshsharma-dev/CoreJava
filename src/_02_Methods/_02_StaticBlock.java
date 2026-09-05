package _02_Methods;

class MobilePhone{
    String brand;
    int price;
    static String name;

    public MobilePhone(){
        brand = "";
        price = 200;
        // name = "phone"; // name is shared by all objects, so initializing it in a static block is more appropriate rather than a constructor because constructor will initialize it each time a object is created.
        System.out.println("In constructor");
    }

    // static block
    static{ // static block will be called before constructor and only for once irrespective of how many objects you created *****BECAUSE CLASS ONLY LOADS FOR ONCE INSIDE CLASS LOADER****** but objects are created again and again so constructor is called as many times as objects are created
        name = "Phone";
        System.out.println("In static block");
    }

    public void show(){
        System.out.println(brand + ": " + price + ": " + name);
    }
}


public class _02_StaticBlock {
    public static void main(String[] args) throws ClassNotFoundException{

        // NOTE: If you don't create the object it won't load the class as well but what if you want to load the class still (next line)
        Class.forName("MobilePhone"); // OUTPUT: In static block        {as only class is loaded, objects are not as of now}
        // Class is a built-in Java class representing metadata about classes and forName is a static method so can be accessed via just class name which is Class


        MobilePhone obj1 = new MobilePhone();
        obj1.brand = "Apple";
        obj1.price = 1500;
        MobilePhone.name = "SmartPhone";

        MobilePhone obj2 = new MobilePhone();
        obj2.brand = "OPPO";

        System.out.println(MobilePhone.name);
    }
}


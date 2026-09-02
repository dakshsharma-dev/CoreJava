package Basics;

// wrapper classes allow primitive data types to be represented as objects
public class _04_WrapperClasses {
    public static void main(String[] args){
        // AUTOBOXING: automatic conversion of primitive types into the object of their corresponding wrapper classes.

        char ch = 'p';
        Character charObj = ch;      // wrapper class is Character not Char

        /*
            WHAT ACTUALLY HAPPENS ?
            Java takes the value stored in ch and creates a Character object containing the same value, then assigns that object to charObj.
            ch itself does NOT become an object. ch remains a primitive char.
         */

        // Double c = ch;  // wrong -> A primitive value is autoboxed only into its corresponding wrapper class.


        // UNBOXING: automatic conversion of a wrapper class object back into its corresponding primitive type.
        Long lgObject = 3424324234324324L;
        long lg = lgObject;


        Integer a = 100;
        Integer b = 100;
        Integer c = 200;
        Integer d = 200;

        System.out.println(a == b);   // true
        System.out.println(c == d);   // false
        System.out.println(a.equals(b));   // true
        System.out.println(c.equals(d));   // true

        /*
            Integer is a wrapper class, so variables of type Integer store references to objects.
            Intuition:
            Since a, b, c and d are different objects, we might expect:
                a == b  -> false
                c == d  -> false
            because == compares object references, not values.

            However, Java caches Integer objects for values in the range -128 to 127.
                Integer a = 100;
                Integer b = 100;

            Both a and b refer to the same cached Integer object:
                     [Integer(100)]
                        ↑      ↑
                        a      b

            Therefore:
                a == b  -> true

            But 200 is outside the default cache range:
                Integer c = 200;
                Integer d = 200;

            Separate Integer objects are created:
                c -> [Integer(200)]
                d -> [Integer(200)]

            Therefore:
                c == d  -> false

            Rule:************************************[LEARNING]
            - == compares references for objects.
            - .equals() compares values.

            So:
                a.equals(b) -> true
                c.equals(d) -> true
        */

        // MAX and MIN
        System.out.println(Integer.MAX_VALUE);
        System.out.println(Integer.MIN_VALUE);
        System.out.println(Long.MAX_VALUE);
        System.out.println(Long.MIN_VALUE);

        // valueOf()

        Double p = Double.valueOf(100.99);    // primitive double → Double object
        Double q = Double.valueOf("200");     // String → Double object

        System.out.println(p);  // 100.99
        System.out.println(q);  // 200.0

        // toString()

        String s = Double.toString(12.34);
        System.out.println(s);
    }
}

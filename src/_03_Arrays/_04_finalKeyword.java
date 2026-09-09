package _03_Arrays;

import java.util.ArrayList;

public class _04_finalKeyword {
    public static void main(String[] args) {
        /*
             The final keyword is used to restrict changes and make code more secure and predictable.
             This helps in creating constant values, stable methods, and immutable classes.

             Final variable cannot be changed once assigned.(used to create constant variables)
             Final method cannot be overridden.
             Final class cannot be inherited or extended.
        */

        /*   VERY IMPORTANT POINT:
             C++ const ≠ Java final.
             Both can prevent reassignment, but they are not equivalent.
             C++ const can make an object/reference read-only;
             Java final only prevents reassignment (object itself may still be modified).
        */

        // 1. Final variable → can be assigned only once.
        final int x = 10;
        // x = 20; // error


        // 2. Final reference → reference can't point to another object, but the object itself can still be modified.
        final ArrayList<Integer> list = new ArrayList<>();
        ArrayList<Integer> ls = new ArrayList<>();
        list.add(10);                  // valid
        // list = new ArrayList<>();   // invalid
        // list = lt                   // invalid


        /* 3. Final method → cannot be overridden by a subclass.

            class A {
                final void m1() {
                    System.out.println("Final method");
                }
            }

            class B extends A {
                void m1() { } // compile-time error
            }
        */


        /* 4. Final class → cannot be extended.

            final class A {}
            class B extends A {} // invalid
        */
    }
}

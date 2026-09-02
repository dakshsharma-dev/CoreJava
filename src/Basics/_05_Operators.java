package Basics;

public class _05_Operators {
    public static void main(String[] args){
        // Java %(modulus) works with both integers and floating-point types; C++ % is only for integral types, use fmod() for floating-point values.

        // Bitwise Operator
        /*
            Bitwise operators work on:
            byte, short, int, long, char

            Boolean:
            &, |, ^ can also be used
         */
        int a = 5;
        int b = 7;

        // bitwise and
        // 0101 & 0111=0101 = 5
        System.out.println("a&b = " + (a & b));

        // bitwise or
        // 0101 | 0111=0111 = 7
        System.out.println("a|b = " + (a | b));

        // bitwise xor
        // 0101 ^ 0111=0010 = 2
        System.out.println("a^b = " + (a ^ b));

        // bitwise not
        // ~00000000 00000000 00000000 00000101=11111111 11111111 11111111 11111010 ( for a = 5)
        // ~ flips all bits. For a signed integer in two's complement: ~n = -(n + 1)            (Java uses two's complement for signed integer)
        System.out.println("~a = " + ~a);

        // Bit-Shift Operators (Shift Operators)
        // n << k   → multiply by 2^k (roughly)
        // n >> k   → divide by 2^k (for positive n)
        // 1. The left shift operator (<<): shifts the bits of a number to the left by a specified number of positions. Zeros are added to the right side.
        int i1 = 5 << 2;
        System.out.println(i1);  // 20

        // 2. Signed Right Shift Operator (>>): [ARITHMETIC RIGHT SHIFT] shifts bits to the right. The sign bit (MSB) is copied to fill vacant positions, preserving the number’s sign.
        int i2 = 5 >> 2;
        System.out.println(i2);  // 1
        int i5 = -5 >> 1;
        System.out.println(i5);  // -3

        // 3.  unsigned right shift operator (>>>): [LOGICAL RIGHT SHIFT] shifts bits to the right and fills the leftmost bits with 0, regardless of the sign.
        int num1 = 8;
        int num2 = -8;
        int i3 = num1 >>> 2;
        int i4 = num2 >>> 1;
        System.out.println(i3);   // 2
        System.out.println(i4);   // 2147483644


        // instanceof Operator:
        // instanceof operator is used for type checking. It can be used to test if an object is an instance of a class, a subclass, or an interface
        String str = "Hello";
        System.out.println(str instanceof String);  // true

        Object obj = 10;
        System.out.println(obj instanceof Integer); // true
        System.out.println(obj instanceof String);  // false



        /*
            OPERATOR PRECEDENCE

            Higher precedence → evaluated first

            1.  expr++, expr--
            2.  ++expr, --expr, +expr, -expr, ~, !
            3.  *, /, %
            4.  +, -
            5.  <<, >>, >>>
            6.  <, >, <=, >=, instanceof
            7.  ==, !=
            8.  &
            9.  ^
            10. |
            11. &&
            12. ||
            13. ?:
            14. =, +=, -=, *=, /=, %=, etc.

            Associativity:
            - Binary operators → generally Left to Right
              (except assignment operators → Right to Left)
            - Unary operators → Right to Left
        */
    }
}

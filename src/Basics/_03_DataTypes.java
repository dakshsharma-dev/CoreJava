package Basics;

public class _03_DataTypes {
    public static void main(String[] args){
        long a = 1338083903833820L;  // L needed
        float b = 34343.4334F;       // F needed
        /*
             why
             Because Java determines the type of the literal first, before assigning it.
             Integer literal → int by default
             Decimal literal → double by default
             So,
             long a = 1338083903833820; // ❌ integer literal is int and value doesn't fit in int
             float b = 34343.4334;      // ❌ Literal is double, and Java doesn't implicitly narrow double → float because it may lose precision.

             L and F tell the compiler: "Treat this literal as a long/float
             Lowercase l and f are also valid, but l is discouraged because it looks like 1
             Therefore, uppercase L and F are preferred
         */
    }
}

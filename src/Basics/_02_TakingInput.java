package Basics;

import java.util.Scanner;

/*
    Scanner class can read input from keyboard (console), files, strings, and data streams.
    Scanner's methods:

    nextInt() for whole numbers
    nextLine() for full text lines
    nextDouble() for decimal numbers
    next() for single words
    etc
 */

public class _02_TakingInput {
    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);

        System.out.print("Enter rollNo: ");
        int rollNo = Integer.parseInt(scn.nextLine());

        System.out.print("Enter name: ");
        String name = scn.nextLine();

        System.out.print("Enter Marks: ");
        double marks = Double.parseDouble(scn.nextLine());

        System.out.println("Student Information:");
        System.out.println("RollNo: " + rollNo);
        System.out.println("Name: " + name);
        System.out.println("Marks: " + marks);

        scn.close();
    }
}

/*
    public class _02_TakingInput {
        public static void main(String[] args){
            Scanner scn = new Scanner(System.in);

            System.out.print("Enter rollNo: ");
            int rollNo = scn.nextInt();

            scn.nextLine();                                           // consumes the newline character(look COMPLETE EXPLANATION)
            System.out.print("Enter name: ");
            String name = scn.nextLine();

            System.out.print("Student: " + rollNo + " " + name);

            scn.close();
        }
    }
 */

/*  COMPLETE EXPLANATION:

    Methods like nextInt(), nextDouble(), next(), etc. read a token instead of a full line,
    so they may leave the newline character ('\n') in the input buffer.

    nextInt() reads only the integer token.
    nextLine() reads everything from the current position until it encounters a newline.

    So, if you input 5 and press Enter ('\n'):
    - nextInt() reads only 5 and leaves '\n' in the buffer.
    - When nextLine() is called next, it immediately reads that leftover '\n'.
    - Since there are no characters before that '\n', nextLine() returns an empty string ("").

    Solutions:
    1. Consume the leftover newline before calling nextLine():
       sc.nextLine();

    2. Use nextLine() everywhere and parse when needed:
       int age = Integer.parseInt(sc.nextLine());
       double salary = Double.parseDouble(sc.nextLine());
*/
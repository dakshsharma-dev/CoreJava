package _09_Collections._04_QueueInterface;

/*
    1.
    Deque: Double Ended Queue -> can be used as Queue & Stack
    Insert → Front or Back
    Remove → Front or Back

    2.
    Methods
    Front
        addFirst(x)
        offerFirst(x)

        removeFirst()
        pollFirst()

        getFirst()
        peekFirst()

    Back:
        addLast(x)
        offerLast(x)

        removeLast()
        pollLast()

        getLast()
        peekLast()

    3.
     add/remove/get → exception    (Deque's get is similar to Queue's element)
     offer/poll/peek → special value

*/

import java.util.ArrayDeque;
import java.util.Deque;

public class _03_DequeInterface {
    public static void main(String[] args) {
        // Deque can behave as a stack too [Yes, Deque provide following methods specially for Stack usage]
        System.out.println("Deque as Stack");
        Deque<Integer> dq = new ArrayDeque<>();
        dq.push(4);
        dq.push(5);
        dq.push(6);

        System.out.println(dq.peek());
        System.out.println(dq.pop());
        System.out.println(dq.poll()); // pop and poll both works same


        // Deque
        System.out.println("Deque as ArrayQueue");
        Deque<Integer> d = new ArrayDeque<>();
        d.offerFirst(1);
        d.offerFirst(2);
        d.offerLast(3);
        d.offerLast(4);
        System.out.println(d);
        System.out.println(d.peekFirst());
        System.out.println(d.peekLast());
        System.out.println(d.pollFirst());
        System.out.println(d.pollLast());


        /*  Why is ArrayDeque generally preferred over Stack?

            Stack is a legacy class extending Vector.
            ArrayDeque implements Deque, supports stack operations efficiently, and is the modern recommended choice.
         */
    }
}

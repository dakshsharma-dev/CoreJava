package _09_Collections._04_QueueInterface;

/*
    1.
    Operation      Throws exception    Returns special value
    -------------  ------------------  ---------------------
    Insert         add(x)              offer(x)
    Remove head    remove()            poll() [return null on empty queue]
    Examine head   element()           peek() [return null on empty queue]

    developers primarily use: offer(), poll(), peek()


    2.
    Java Queue.offer()                               → C++ queue.push()
    Java Queue.poll()[also return the popped value]  → C++ queue.pop()[doesn't return the popped value] + front()
    Java Queue.peek()                                → C++ queue.front()

 */

import java.util.LinkedList;
import java.util.Queue;

public class _01_Introduction {
    public static void main(String[] args) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(1);
        q.offer(2);
        q.offer(3);

        System.out.println(q.poll()); // 1

        System.out.println(q.peek()); // 2

        System.out.println(q);        // [2, 3]

    }
}

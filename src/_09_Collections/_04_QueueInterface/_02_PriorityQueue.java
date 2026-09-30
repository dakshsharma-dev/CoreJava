package _09_Collections._04_QueueInterface;

/*
    offer() → O(log n)
    poll()  → O(log n)
    peek()  → O(1)


    Java's PriorityQueue is a min-heap by default
    C++'s priority_queue is a max-heap by default


    Java
    min-heap: Queue<Integer> q = new PriorityQueue<>();
    max-heap: Queue<Integer> q = new PriorityQueue<>(Comparator.reverseOrder());


    C++
    min-heap: priority_queue<int, vector<int>, greater<int>>;
    max-heap: priority_queue<int>

*/


import java.util.PriorityQueue;
import java.util.Queue;

public class _02_PriorityQueue {
    public static void main(String[] args) {
        Queue<Integer> q = new PriorityQueue<>();
        q.offer(3);
        q.offer(2);
        q.offer(1);

        System.out.println(q.peek()); // 1

        System.out.println(q.poll()); // 1

        System.out.println(q.size()); // 2

        System.out.println(q.contains(1)); // false

        System.out.println(q.isEmpty()); // false

        System.out.println("PQ elements:");
        while (!q.isEmpty()) {
            System.out.println(q.poll());
        }
    }
}

package _09_Collections._02_ListInterface;

/*
    ArrayList → not synchronised
    Vector    → synchronised
 */

import java.util.Stack;

public class _03_VectorAndStack {
    public static void main(String[] args) {
        Stack<Integer> st = new Stack<>();
        st.push(10);
        st.push(70);
        System.out.println(st.peek());
        st.pop();
        System.out.println(st.size());
        System.out.println(st.empty());
        /*
            Modern Java generally prefers:
            Deque<Integer> stack = new ArrayDeque<>();
            instead of:
            Stack<Integer> stack = new Stack<>();
            Why?
            Deque is designed for double-ended operations and **ArrayDeque** generally provides a better modern stack implementation.
         */
    }
}

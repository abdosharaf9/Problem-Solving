package MyCalendarI;

// https://leetcode.com/problems/my-calendar-i/

import java.util.ArrayList;

class Node {
    Node left, right;
    int start, end;

    public Node(int start, int end) {
        this.start = start;
        this.end = end;
    }
}

class MyCalendar {

    private Node root;

    public MyCalendar() {

    }

    public boolean book(int start, int end) {
        if (root == null) {
            root = new Node(start, end);
            return true;
        }

        Node cur = root;

        while (cur != null) {
            if (start >= cur.end) {
                if (cur.right == null) {
                    cur.right = new Node(start, end);
                    return true;
                }

                cur = cur.right;
            } else if (end <= cur.start) {
                if (cur.left == null) {
                    cur.left = new Node(start, end);
                    return true;
                }

                cur = cur.left;
            } else {
                return false;
            }
        }

        return false;
    }

    // Solution #2
    /*private final ArrayList<int[]> events;

    public MyCalendar() {
        events = new ArrayList<>();
    }

    public boolean book(int start, int end) {
        for (int[] event : events) {
            if (start < event[1] && end > event[0]) return false;
        }

        events.add(new int[]{start, end});
        return true;
    }*/
}

class Test {
    public static void main(String[] args) {
        MyCalendar cal = new MyCalendar();
        System.out.println(cal.book(10, 20));
        System.out.println(cal.book(15, 25));
        System.out.println(cal.book(20, 30));
    }
}
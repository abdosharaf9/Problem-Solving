package InsertGCDInLinkedList;

// https://leetcode.com/problems/insert-greatest-common-divisors-in-linked-list

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

class Solution {
    public ListNode insertGreatestCommonDivisors(ListNode head) {
        ListNode temp = head;

        while (temp.next != null) {
            ListNode newNode = new ListNode(gcd(temp.val, temp.next.val), temp.next);
            temp.next = newNode;
            temp = newNode.next;
        }

        return head;
    }

    private int gcd(int a, int b) {
        if (b == 0)
            return a;
        else
            return gcd(b, a % b);
    }
}

class Test {
    public static void main(String[] args) {
        Solution sol = new Solution();

        ListNode head = createLinkedList(new int[]{18, 6, 10, 3});
        print(sol.insertGreatestCommonDivisors(head));

        head = createLinkedList(new int[]{7});
        print(sol.insertGreatestCommonDivisors(head));
    }

    static ListNode createLinkedList(int[] arr) {
        ListNode head = new ListNode(arr[0]);
        ListNode temp = head;

        for (int i = 1; i < arr.length; i++) {
            temp.next = new ListNode(arr[i]);
            temp = temp.next;
        }

        return head;
    }

    static void print(ListNode head) {
        System.out.print("[");

        while (head != null) {
            if (head.next != null) System.out.print(head.val + ", ");
            else System.out.print(head.val);
            head = head.next;
        }

        System.out.println("]");
    }
}
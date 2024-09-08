package SplitLinkedListInParts;

// https://leetcode.com/problems/split-linked-list-in-parts/

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
    public ListNode[] splitListToParts(ListNode head, int k) {
        ListNode[] result = new ListNode[k];
        int count = 0;

        ListNode temp = head;
        while (temp != null) {
            count++;
            temp = temp.next;
        }

        int i = 0, currentCount = 0, partSize = count / k, firstAddOne = count % k;

        while (head != null) {
            temp = head;
            head = temp.next;
            temp.next = null;

            if (result[i] == null) {
                result[i] = temp;
            } else {
                ListNode currentTemp = result[i];
                while (currentTemp.next != null) {
                    currentTemp = currentTemp.next;
                }
                currentTemp.next = temp;
            }

            currentCount++;

            if ((i < firstAddOne && currentCount == partSize + 1) || (i >= firstAddOne && currentCount == partSize)) {
                i++;
                currentCount = 0;
            }
        }

        return result;
    }
}

class Test {
    public static void main(String[] args) {
        Solution sol = new Solution();

        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3)));
        print(sol.splitListToParts(head, 5));

        head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5, new ListNode(6, new ListNode(7, new ListNode(8, new ListNode(9, new ListNode(10))))))))));
        print(sol.splitListToParts(head, 3));
    }

    static void print(ListNode[] list) {
        for (ListNode x : list) {
            ListNode temp = x;

            if (temp == null) System.out.print(temp + ", ");

            while (temp != null) {
                System.out.print(temp.val + ", ");
                temp = temp.next;
            }

            System.out.println();
        }
    }
}
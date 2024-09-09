package SpiralMatrixIV;

// https://leetcode.com/problems/spiral-matrix-iv

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
    public int[][] spiralMatrix(int m, int n, ListNode head) {
        int[][] result = new int[m][n];
        int top = 0, bottom = m - 1, left = 0, right = n - 1;

        while (top <= bottom && left <= right) {
            for (int i = left; i <= right; i++) {
                if (head != null) {
                    result[top][i] = head.val;
                    head = head.next;
                } else {
                    result[top][i] = -1;
                }
            }
            top++;

            for (int i = top; i <= bottom; i++) {
                if (head != null) {
                    result[i][right] = head.val;
                    head = head.next;
                } else {
                    result[i][right] = -1;
                }
            }
            right--;

            if (top <= bottom) {
                for (int i = right; i >= left; i--) {
                    if (head != null) {
                        result[bottom][i] = head.val;
                        head = head.next;
                    } else {
                        result[bottom][i] = -1;
                    }
                }
                bottom--;
            }

            if (left <= right) {
                for (int i = bottom; i >= top; i--) {
                    if (head != null) {
                        result[i][left] = head.val;
                        head = head.next;
                    } else {
                        result[i][left] = -1;
                    }
                }
                left++;
            }
        }

        return result;
    }
}

class Test {
    public static void main(String[] args) {
        Solution sol = new Solution();

        int[] arr = {3, 0, 2, 6, 8, 1, 7, 9, 4, 2, 5, 5, 0};
        print(sol.spiralMatrix(3, 5, createLinkedList(arr)));

        arr = new int[]{0, 1, 2};
        print(sol.spiralMatrix(1, 4, createLinkedList(arr)));
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

    static void print(int[][] array) {
        for (int[] arr : array) {
            for (int x : arr) {
                System.out.print(x + " ");
            }
            System.out.println();
        }
    }
}

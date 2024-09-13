package XORQueriesOfASubarray;

// https://leetcode.com/problems/xor-queries-of-a-subarray/

class Solution {
    public int[] xorQueries(int[] arr, int[][] queries) {
        int[] res = new int[queries.length];
        int[] prefix = new int[arr.length + 1];
        prefix[0] = 0;

        for (int i = 0; i < arr.length; i++) {
            prefix[i + 1] = prefix[i] ^ arr[i];
        }

        for (int i = 0; i < queries.length; i++) {
            res[i] = prefix[queries[i][0]] ^ prefix[queries[i][1] + 1];
        }

        return res;
    }
}

class Test {
    public static void main(String[] args) {
        Solution sol = new Solution();

        print(sol.xorQueries(new int[]{1, 3, 4, 8}, new int[][]{{0, 1}, {1, 2}, {0, 3}, {3, 3}}));
        print(sol.xorQueries(new int[]{4, 8, 2, 10}, new int[][]{{2, 3}, {1, 3}, {0, 0}, {0, 3}}));
    }

    static void print(int[] arr) {
        System.out.print("[");
        for (int i = 0; i < arr.length; i++) {
            if (i == arr.length - 1) System.out.print(arr[i]);
            else System.out.print(arr[i] + ", ");
        }
        System.out.println("]");
    }
}
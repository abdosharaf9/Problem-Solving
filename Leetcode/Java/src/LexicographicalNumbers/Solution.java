package LexicographicalNumbers;

import java.util.ArrayList;
import java.util.List;

class Solution {

    /**
     * Solution 1
     */
    public List<Integer> lexicalOrder(int n) {
        List<Integer> result = new ArrayList<>();

        for (int i = 1; i < 10; i++) {
            dfs(n, i, result);
        }

        return result;
    }

    private void dfs(int n, int x, List<Integer> result) {
        if (x > n) return;

        result.add(x);
        x *= 10;

        for (int i = 0; i < 10; i++) {
            dfs(n, x + i, result);
        }
    }

    /** Solution 2 */
    /*public List<Integer> lexicalOrder(int n) {
        List<Integer> result = new ArrayList<>();
        int cur = 1;

        while (result.size() < n) {
            result.add(cur);
            if (cur * 10 <= n) {
                cur *= 10;
            } else {
                while (cur == n || cur % 10 == 9) {
                    cur /= 10;
                }

                cur++;
            }
        }

        return result;
    }*/
}

class Test {
    public static void main(String[] args) {
        Solution sol = new Solution();
        print(sol.lexicalOrder(13));
        print(sol.lexicalOrder(2));
    }

    private static void print(List<Integer> list) {
        for (int x : list) {
            System.out.print(x + ", ");
        }
        System.out.println();
    }
}
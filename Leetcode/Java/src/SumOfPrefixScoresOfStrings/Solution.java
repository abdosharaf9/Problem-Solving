package SumOfPrefixScoresOfStrings;

// https://leetcode.com/problems/sum-of-prefix-scores-of-strings/

import static utils.ArrayUtils.printArray;

class PrefixTreeNode {
    int count = 0;
    PrefixTreeNode[] children = new PrefixTreeNode[26];
}

class PrefixTree {
    private final PrefixTreeNode root = new PrefixTreeNode();

    void insert(String word) {
        PrefixTreeNode cur = root;

        for (char c : word.toCharArray()) {
            int i = c - 'a';
            if (cur.children[i] == null) {
                cur.children[i] = new PrefixTreeNode();
            }

            cur = cur.children[i];
            cur.count++;
        }
    }

    int getScore(String word) {
        PrefixTreeNode cur = root;
        int score = 0;

        for (char c : word.toCharArray()) {
            cur = cur.children[c - 'a'];
            score += cur.count;
        }

        return score;
    }
}

class Solution {
    public int[] sumPrefixScores(String[] words) {
        PrefixTree tree = new PrefixTree();
        int[] scores = new int[words.length];

        for (String word : words) {
            tree.insert(word);
        }

        for (int i = 0; i < words.length; i++) {
            scores[i] = tree.getScore(words[i]);
        }

        return scores;
    }
}

class Test {
    public static void main(String[] args) {
        Solution sol = new Solution();
        printArray(sol.sumPrefixScores(new String[]{"abc", "ab", "bc", "b"}));
        printArray(sol.sumPrefixScores(new String[]{"abcd"}));
    }
}
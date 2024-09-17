package UncommonWordsFromTwoSentences;

// https://leetcode.com/problems/uncommon-words-from-two-sentences/

import java.util.ArrayList;
import java.util.HashMap;

class Solution {
    public String[] uncommonFromSentences(String s1, String s2) {
        String[] sen1 = s1.split(" ");
        String[] sen2 = s2.split(" ");
        HashMap<String, Integer> counts = new HashMap<>();
        ArrayList<String> result = new ArrayList<>();

        for (String s : sen1) {
            counts.put(s, counts.getOrDefault(s, 0) + 1);
        }

        for (String s : sen2) {
            counts.put(s, counts.getOrDefault(s, 0) + 1);
        }

        for (HashMap.Entry<String, Integer> entry : counts.entrySet()) {
            if (entry.getValue() == 1) result.add(entry.getKey());
        }

        return result.toArray(new String[0]);
    }
}

class Test {
    public static void main(String[] args) {
        Solution sol = new Solution();
        print(sol.uncommonFromSentences("this apple is sweet", "this apple is sour"));
        print(sol.uncommonFromSentences("apple apple", "banana"));
    }

    private static void print(String[] arr) {
        for (String s : arr) {
            System.out.print(s + ", ");
        }
        System.out.println();
    }
}
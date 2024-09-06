package KeyboardRow;

// https://leetcode.com/problems/keyboard-row/

import java.util.ArrayList;

import static utils.ArrayUtils.printArray;

class Solution {
    public String[] findWords(String[] words) {
        String[] keyboardLines = {"qwertyuiop", "asdfghjkl", "zxcvbnm"};
        ArrayList<String> result = new ArrayList<>();

        for (String word : words) {
            for (String line : keyboardLines) {
                boolean included = true;

                for (char c : word.toLowerCase().toCharArray()) {
                    if (line.indexOf(c) < 0) {
                        included = false;
                        break;
                    }
                }

                if (included) {
                    result.add(word);
                    break;
                }
            }
        }

        return result.toArray(new String[]{});
    }
}

class Test {
    public static void main(String[] args) {
        Solution sol = new Solution();

        String[] arr = {"Hello", "Alaska", "Dad", "Peace"};
        printArray(sol.findWords(arr));

        arr = new String[]{"omk"};
        printArray(sol.findWords(arr));

        arr = new String[]{"adsdf", "sfd"};
        printArray(sol.findWords(arr));
    }
}
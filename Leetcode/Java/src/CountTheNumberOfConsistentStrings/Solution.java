package CountTheNumberOfConsistentStrings;

class Solution {
    public int countConsistentStrings(String allowed, String[] words) {
        int count = 0;

        for (String word : words) {
            boolean isAllowed = true;

            for (char c : word.toCharArray()) {
                if (allowed.indexOf(c) == -1) {
                    isAllowed = false;
                    break;
                }
            }

            if (isAllowed) count++;
        }

        return count;
    }
}


class Test {
    public static void main(String[] args) {
        Solution sol = new Solution();

        System.out.println(sol.countConsistentStrings("ab", new String[]{"ad", "bd", "aaab", "baa", "badab"}));
        System.out.println(sol.countConsistentStrings("abc", new String[]{"a","b","c","ab","ac","bc","abc"}));
        System.out.println(sol.countConsistentStrings("cad", new String[]{"cc", "acd", "b", "ba", "bac", "bad", "ac", "d"}));
    }
}
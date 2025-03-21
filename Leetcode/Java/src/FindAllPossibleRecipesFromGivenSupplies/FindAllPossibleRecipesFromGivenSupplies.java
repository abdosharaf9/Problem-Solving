package FindAllPossibleRecipesFromGivenSupplies;

// https://leetcode.com/problems/find-all-possible-recipes-from-given-supplies/

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static utils.ArrayUtils.printArray;

// Time: O(R + I + S), where R is the recipes list, I is the ingredients list,
// and S is the supplies list. This is the same as O(V + E) = O(n).
// Space: O(R + I) = O(n)
class Solution {

    // Store whether a recipe or ingredient can be made.
    private final HashMap<String, Boolean> canCook = new HashMap<>();
    // Map each recipe to its index in the recipes/ingredients list.
    private final HashMap<String, Integer> recipeIndex = new HashMap<>();

    public List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {
        // // Mark all supplies as directly can be cooked.
        for (String sup : supplies) {
            canCook.put(sup, true);
        }

        // Store the index of each recipe in the recipes/ingredients list.
        for (int i = 0; i < recipes.length; i++) {
            recipeIndex.put(recipes[i], i);
        }

        // Build the result list using DFS to decide whether we can make a recipe or not.
        List<String> res = new ArrayList<>();
        for (String r : recipes) {
            if (dfs(r, ingredients)) {
                res.add(r);
            }
        }

        return res;
    }

    // A recursive DFS function to determine if a recipe can be cooked.
    private boolean dfs(String r, List<List<String>> ingredients) {
        // If we have already determined if r can be cooked, return its value.
        if (canCook.containsKey(r)) {
            return canCook.get(r);
        }

        // If r is not a recipe or a supply, it cannot be cooked.
        if (!recipeIndex.containsKey(r)) {
            return false;
        }

        // Temporarily mark r as can't be cooked to detect cycles.
        canCook.put(r, false);

        // Check if all ingredients of r can be cooked.
        for (String ing : ingredients.get(recipeIndex.get(r))) {
            // If a single ingredient can't be cooked, we can't make r, so return false.
            if (!dfs(ing, ingredients)) {
                return false;
            }
        }

        // If all ingredients can be made, mark r as can be cooked, and return true.
        canCook.put(r, true);
        return canCook.get(r);
    }
}

class Test {
    public static void main(String[] args) {
        Solution sol = new Solution();

        printArray(
                sol.findAllRecipes(
                        new String[]{"bread"},
                        List.of(
                                List.of("yeast", "flour")
                        ),
                        new String[]{"yeast", "flour", "corn"}
                )
        );

        printArray(
                sol.findAllRecipes(
                        new String[]{"bread", "sandwich"},
                        List.of(
                                List.of("yeast", "flour"),
                                List.of("bread", "meat")
                        ),
                        new String[]{"yeast", "flour", "meat"}
                )
        );

        printArray(
                sol.findAllRecipes(
                        new String[]{"bread", "sandwich", "burger"},
                        List.of(
                                List.of("yeast", "flour"),
                                List.of("bread", "meat"),
                                List.of("sandwich", "meat", "bread")
                        ),
                        new String[]{"yeast", "flour", "meat"}
                )
        );
    }
}
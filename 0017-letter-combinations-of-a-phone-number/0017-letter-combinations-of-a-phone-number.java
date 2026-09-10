import java.util.ArrayList;
import java.util.List;

class Solution {
    // Map of phone keypad letters corresponding to digits 2-9
    private final String[] MAPPING = {
        "",     // 0
        "",     // 1
        "abc",  // 2
        "def",  // 3
        "ghi",  // 4
        "jkl",  // 5
        "mno",  // 6
        "pqrs", // 7
        "tuv",  // 8
        "wxyz"  // 9
    };

    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        
        // Handle edge case where input is empty
        if (digits == null || digits.length() == 0) {
            return result;
        }

        backtrack(result, digits, 0, new StringBuilder());
        return result;
    }

    private void backtrack(List<String> result, String digits, int index, StringBuilder current) {
        // Base case: If our built string reaches the length of digits, we found a full combination
        if (index == digits.length()) {
            result.add(current.toString());
            return;
        }

        // Get the letters for the current digit
        char digitChar = digits.charAt(index);
        String letters = MAPPING[digitChar - '0'];

        // Try every possible letter for this digit
        for (int i = 0; i < letters.length(); i++) {
            current.append(letters.charAt(i));              // 1. Choose: add the letter
            backtrack(result, digits, index + 1, current);  // 2. Explore: move to the next digit
            current.deleteCharAt(current.length() - 1);     // 3. Un-choose: remove the letter to backtrack
        }
    }
}


/**
 * Approach for Letter Combinations of a Phone Number (Backtracking / DFS):
 * 
 * 1. Keypad Mapping:
 *    - Create a lookup array or mapping where indices 2 through 9 correspond 
 *      to their respective letters on a telephone keypad (e.g., '2' -> "abc").
 * 
 * 2. Recursive Backtracking Function:
 *    - Define a helper function that tracks the current index of the digits string 
 *      we are processing and a StringBuilder holding our current letter combination path.
 * 
 * 3. Base Case:
 *    - When the current path length equals the length of the input digits string, 
 *      we have formed a valid complete combination. Convert it to a String, add it 
 *      to the result list, and return.
 * 
 * 4. Choose, Explore, Un-choose (The Backtrack Step):
 *    - Get the letters available for the digit at the current index.
 *    - Loop through each letter:
 *        a. Choose: Append the letter to your current working path.
 *        b. Explore: Recursively call the function for the next digit index (index + 1).
 *        c. Un-choose: Remove the last appended letter to clean up the path 
 *           before trying the next letter on that phone button.
 */
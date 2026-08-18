class Solution {
    public String gcdOfStrings(String str1, String str2) {
        // 1. Check if both strings build the exact same combined word
        if (!(str1 + str2).equals(str2 + str1)) {
            return "";
        }
        
        // 2. Find the GCD of their two lengths
        int length1 = str1.length();
        int length2 = str2.length();
        
        // Simple loop to find Greatest Common Divisor of two numbers
        while (length2 != 0) {
            int temp = length2;
            length2 = length1 % length2;
            length1 = temp;
        }
        
        // 3. Cut str1 to that size!
        return str1.substring(0, length1);
    }
}
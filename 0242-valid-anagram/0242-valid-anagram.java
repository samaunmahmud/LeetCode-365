class Solution {
    public boolean isAnagram(String s, String t) {
    
        if (s.length() != t.length()) {
            return false;
        }

        HashMap<Character, Integer> counter = new HashMap<>();

        
        for (char c : s.toCharArray()) {
            counter.put(c, counter.getOrDefault(c, 0) + 1);
        }


        for (char c : t.toCharArray()) {
            if (!counter.containsKey(c)) {
                return false;
            }
            counter.put(c, counter.get(c) - 1);
            
          
            if (counter.get(c) < 0) {
                return false;
            }
        }

        return true;
    }
}
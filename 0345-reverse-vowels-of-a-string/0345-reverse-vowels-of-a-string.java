class Solution {
    public String reverseVowels(String s) {
        char[] ch = s.toCharArray();
        int left = 0;
        int right = ch.length - 1;

        while (left < right) {
            while (left < right && !isVowel(ch[left])) {
                left++;
            }
            while (left < right && !isVowel(ch[right])) {
                right--;
            }

            // Swap vowels
            char temp = ch[left];
            ch[left] = ch[right];
            ch[right] = temp;

            left++;
            right--;
        }

        return new String(ch);
    }

    private boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' ||
               c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U';
    }
}









// public String reverseVowels(String s) {
//         Stack<Character> rev = new Stack<>();
//         char[] ch = s.toCharArray();

    
//         for (char c : ch) {
//             if (isVowel(c)) {
//                 rev.push(c);
//             }
//         }

       
//         for (int i = 0; i < ch.length; i++) {
//             if (isVowel(ch[i])) {
//                 ch[i] = rev.pop();
//             }
//         }

//         return new String(ch);
//     }

 
//     private boolean isVowel(char c) {
//         return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' ||
//                c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U';
//     }
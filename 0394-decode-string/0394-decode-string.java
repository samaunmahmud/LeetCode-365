class Solution {
    public String decodeString(String s) {

        Stack<Integer> countStack = new Stack<>();
        Stack<StringBuilder> stringStack = new Stack<>();

        StringBuilder currentString = new StringBuilder();

        int k =0;

        for(char c :s.toCharArray()){
            if(Character.isDigit(c)){
                k = k*10+(c-'0');

            }else if(c == '['){
                countStack.push(k);
                stringStack.push(currentString);
                 k=0;

                 currentString = new StringBuilder();
            }else if(c ==']'){
                int repeatTimes = countStack.pop();
                StringBuilder previousString = stringStack.pop();

                for(int i=0;i<repeatTimes;i++){
                previousString.append(currentString);
            }

            currentString =previousString;
        }else{
            currentString.append(c);
        }
        }
        return currentString.toString();

        
    }
}
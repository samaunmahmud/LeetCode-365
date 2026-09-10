class Solution {

    private final String[] MAPPING={
        "","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"
    };
















    public List<String> letterCombinations(String digits) {

        List<String> result = new ArrayList<>();


        if(digits == null||digits.length()==0){
            return result;
        }

        backtrack(result, digits, 0, new StringBuilder());
        return result;
        


    }






    private void backtrack(List<String> result, String digits, int index, StringBuilder current){

        if(index == digits.length()){
            result.add(current.toString());
            return;
        }

        char digitChar = digits.charAt(index);

        String letters = MAPPING[digitChar-'0'];

        for(int i =0;i<letters.length();i++){
            current.append(letters.charAt(i));
            backtrack(result,digits,index+1,current);
            current.deleteCharAt(current.length()-1);
        }
    }
}
class Solution {
    public String predictPartyVictory(String senate) {

        Queue<Integer> rSenate = new ArrayDeque<>();
        Queue<Integer> dSenate = new ArrayDeque<>();
        int rd =0;
        

        for(int j : senate.toCharArray()){
        



        if(j == 'R'){
            rd++;

            rSenate.add(rd);

        }else{
            rd++;
            dSenate.add(rd);
        }
        }



        while(!rSenate.isEmpty() && !dSenate.isEmpty()){
            if(rSenate.peek() < dSenate.peek()){
                int s = rSenate.poll();
                rSenate.add(s+rd);
                dSenate.poll();
            }else{
                int s = dSenate.poll();
                dSenate.add(s+rd);
                rSenate.poll();
            }



        }

        if(rSenate.isEmpty()){
            return "Dire";
        }


        return "Radiant";
        
    }
}
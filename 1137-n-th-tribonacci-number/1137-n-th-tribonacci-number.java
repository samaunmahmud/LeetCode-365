class Solution {
    public int tribonacci(int n) {
        if(n<=0){
            return 0;
        }
        if(n==1){
            return 1;
        }
        if(n==2){
            return 1;
        }

        int t0 =0;
        int t1=1;
        int t2=1;
        int current=0;

        for(int i=3;i<=n;i++){
            current = t0+t1+t2;
            t0=t1;
            t1=t2;
            t2=current;
        }

        return t2;


        


        
    }
}
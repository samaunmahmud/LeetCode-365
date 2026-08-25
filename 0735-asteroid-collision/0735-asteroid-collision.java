import java.util.Stack;

class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();

        for (int a : asteroids) {
            boolean destroyed = false;

            
            while (!stack.isEmpty() && stack.peek() > 0 && a < 0) {
                if (stack.peek() < -a) {
                    stack.pop(); 
                } else if (stack.peek() == -a) {
                    stack.pop(); 
                    destroyed = true;
                    break;
                } else {
              
                    destroyed = true;
                    break;
                }
            }

         
            if (!destroyed) {
                stack.push(a);
            }
        }


        int[] result = new int[stack.size()];
        

        int i=0;


        for(int k : stack){
            result[i]=k;
            i++;
        }

        return result;
    }
}
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {

    private int maxLen =0;
    public int longestZigZag(TreeNode root) {
        dfs(root, true, 0);

        dfs(root,false,0);

        return maxLen;
        
    }


    private void dfs(TreeNode node, boolean isLeft, int steps){
        if(node == null){
            return;
        }



        maxLen = Math.max(maxLen, steps);

        if(isLeft){
            dfs(node.right, false, steps+1);

            dfs(node.left, true, 1);
        }else{
            dfs(node.left, true, steps+1);
            dfs(node.right, false, 1);
        }
    }
}


/*


* **The Core Trick:** As you move down the tree, track the length of the *current* ZigZag path and the direction you just came from.
* **Two Choices at Every Node:**
1. **Alternate Direction (Continue):** If you just went **left**, going **right** continues the chain $\rightarrow$ `steps + 1`.
2. **Same Direction (Restart):** If you just went **left**, going **left** breaks the chain. But instead of giving up, start a brand-new path of length `1`.


* **Global Maximum:** Keep a running `maxLen` variable and update it at every single node (`maxLen = Math.max(maxLen, steps)`).

---

### Step-by-Step Traversal Analogy

Imagine walking down the tree with a counter in hand:

1. **Step Left:** You increment your counter to `1`.
2. **Next Step Right:** Alternating direction! Counter increases to `2`.
3. **Next Step Right Again:** Same direction! Counter **resets to `1**` (a new path starts).
4. **Result:** Keep track of the highest counter value reached anywhere in the tree.


 */
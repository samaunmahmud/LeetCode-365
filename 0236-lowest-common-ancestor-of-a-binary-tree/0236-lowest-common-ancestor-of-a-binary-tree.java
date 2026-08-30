/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        if(root == null){
            return null;
        }


        if(p == root || q == root){
            return root;
        }


        TreeNode n1 =lowestCommonAncestor(root.left, p, q);

        TreeNode n2 =lowestCommonAncestor(root.right,p,q);

        if(n1!= null && n2!= null){
         
            return root;
        }

        return n1 != null ? n1 : n2;


        
    }
}


/*

[Start: Current Function Call with a 'Node']
       │
       ▼
Is the Node == null? ────────( Yes )────────► [Return null (Hit bottom)]
       │
      ( No )
       │
       ▼
Is the Node == p OR Node == q? ──( Yes )──► [Return this Node (Found a target)]
       │
      ( No )
       │
       ▼
[Search Left Subtree]  ─────────────────────► [Get Result from Left (leftResult)]
       │
       ▼
[Search Right Subtree] ─────────────────────► [Get Result from Right (rightResult)]
       │
       │
       ├─────────────────────────────────────────┐
       │                                         │
       ▼                                         ▼
Is BOTH leftResult & rightResult              Is ONLY ONE of them
NOT NULL?                                     NOT NULL?
       │                                         │
     ( Yes )                                   ( Yes )
       │                                         │
       ▼                                         ▼
[Return THIS Node as the LCA]                 [Return the Non-Null Result]
       │                                         │
       └───────────────────┬─────────────────────┘
                           │
                           ▼
                 [End of Function Call]







                 Step 1: Diving to the Bottom (The Search)
When you call lowestCommonAncestor(root, p, q), the code immediately splits and dives all the way down the left and right branches until it hits the very bottom (null) or finds one of your targets (p or q).
Think of it like sending two scouts down different paths:
The left scout searches everything on the left.
The right scout searches everything on the right.
Step 2: Reporting Back (The Return Values)
As the scouts finish searching their respective paths, they report back to the node that sent them:
If a scout finds neither p nor q down that path, it reports back null (meaning: "Nothing here!").
If a scout stumbles upon p or q, it reports back that specific node object (meaning: "I found one!").
Step 3: The Meeting Point Magic
This is where the actual ancestor discovery happens. Imagine you are a parent node sitting in the middle of the tree, and you receive reports from both your children:
Your left child reports back: "I found node p down my path!"
Your right child reports back: "I found node q down my path!"
Because your left branch found p and your right branch found q, you realize something crucial: You are the exact junction where the two paths split. Therefore, you (root) must be their Common Ancestor. You immediately return yourself upward as the answer.
Step 4: Passing the Winner Upward
Once a node realizes it is the meeting point (or once a valid target bubble reaches the top), that node object is passed straight back up the call stack. Every parent above just passes that winning node upward until it finally reaches the very first function call you made, giving you your final answer.
*/

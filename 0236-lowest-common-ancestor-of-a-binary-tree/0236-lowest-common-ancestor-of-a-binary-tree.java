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
*/

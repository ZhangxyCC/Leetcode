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
    private int count = 0;
    public int pseudoPalindromicPaths (TreeNode root) {
        int[] values = new int[9];
        helper(values, root);
        return count;
    }
    public void helper(int[] values, TreeNode root){
        values[root.val - 1] += 1;
        System.out.println(root.val);
        if(root.left == null && root.right == null && isAns(values))  count += 1;
        if(root.left != null)   helper(values, root.left);
        
        if(root.right != null)   helper(values, root.right);
        values[root.val - 1] -= 1;

    }
    
    private boolean isAns(int[] values){
        int odd = 0; 
        for (int i = 0; i < 9; i++)  
        { 
            System.out.println(values[i]);
            if ((values[i] & 1) == 1) 
                odd++; 

            if (odd > 1) 
                return false; 
        }
        
        return true;
    }
    
}
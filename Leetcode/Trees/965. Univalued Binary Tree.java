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
    public boolean isUnivalTree(TreeNode root) {
        if(root==null){
            return true;
        }
        int key=root.val;
        boolean leftCheck=isUnivalTree(root.left);
        boolean rightCheck=isUnivalTree(root.right);
        if(root.left!=null && root.left.val!=key){
            return false;
        }
        if(root.right!=null && root.right.val!=key){
            return false;
        }
        return leftCheck && rightCheck;
    }
}

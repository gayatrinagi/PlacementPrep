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
    public void helper(TreeNode root,List<Integer> list){
        if(root==null) return;
        list.add(root.val);
        helper(root.left,list);
        helper(root.right,list);
    }
    public List<Integer> preorderTraversal(TreeNode root) {
         List<Integer> result=new ArrayList<>();
        helper(root,result);
        return result;
    }
}

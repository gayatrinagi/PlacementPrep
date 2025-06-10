class Solution {
    // Function to return sum of all nodes of a binary tree
    static int sumBT(Node root) {
       if(root==null){
           return 0;
       }
       int leftSum=sumBT(root.left);
       int rightSum=sumBT(root.right);
       return leftSum+rightSum+root.data;
        
    }
}

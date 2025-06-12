/*Complete the Given Function

Node is as follows:
class Node{
    int data;
    Node left,right;
    Node(int d){
        data=d;
        left=null;
        right=null;
    }
}*/

class Solution {
    int findSum(Node root){
        if(root==null){
            return 0;
        }
        int original=root.data;
        int leftSum=findSum(root.left);
        int rightSum=findSum(root.right);
        root.data=leftSum+rightSum;
        return leftSum+rightSum+original;
    }
    public void toSumTree(Node root) {
        findSum(root);
    }
}

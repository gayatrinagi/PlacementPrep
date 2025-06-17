/*
class Node
{
    int data;
    Node left, right;

    public Node(int d)
    {
        data = d;
        left = right = null;
    }
}
*/

class Solution {
    // Function to find the least absolute difference between any node
    // value of the BST and the given integer.
    static void inorder(Node root,ArrayList<Integer> seq){//approach 1
        if(root==null){
            return;
        }
        inorder(root.left,seq);
        seq.add(root.data);
        inorder(root.right,seq);
    }
    static int found(ArrayList<Integer> seq,int key){
        int min=Integer.MAX_VALUE;
        for(int i:seq){
            min=Math.min(min,Math.abs(i-key));
        }
        return min;
    }
    static int minDiff(Node root, int K) {
        ArrayList<Integer> result=new ArrayList<>();
        
        inorder(root,result);
        return found(result,K);
        
    }
}

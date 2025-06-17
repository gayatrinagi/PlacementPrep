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
/*approach2 starts here better approach
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


class Solution {
    // Function to find the least absolute difference between any node
    // value of the BST and the given integer.
    static int min(Node root,int k){
        if(root==null) return Integer.MAX_VALUE;
        int closest=root.data;
        while(root!=null){
        if(Math.abs(root.data-k)<Math.abs(closest-k)){
            closest=root.data;
        }
        if(k<root.data){
         root=root.left;
        }else if(k>root.data){
          root=root.right;
        }else{
            break;
        }
    }
    return Math.abs(closest - k);
    }
    static int minDiff(Node root, int K) {
        // Write your code here
        if(root==null){
            return Integer.MAX_VALUE;
        }
        return min(root,K);
    }
}
*/

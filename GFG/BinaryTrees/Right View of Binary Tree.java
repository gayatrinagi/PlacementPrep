/*Complete The Function Provided
Given Below is The Node Of Tree
class Node
{
    int data;
    Node left, right;
    public Node(int data)
    {
        this.data = data;
         left = right = null;
    }
}*/

class Solution {
    // Function to return list containing elements of right view of binary tree.
    ArrayList<Integer> rightView(Node root) {
        ArrayList<Integer> result=new ArrayList<>();
        if(root==null) return result;
        Queue<Node> q=new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            int size=q.size();
            for(int i=0;i<size;i++){
                Node curr=q.poll(); 
                if(i==0) result.add(curr.data);
                if(curr.right!=null) q.add(curr.right);
                if(curr.left!=null) q.add(curr.left);
            }
        }
        return result;
    }
}

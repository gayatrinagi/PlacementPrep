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
    // Function to return a list of integers denoting the node
    // values of both the BST in a sorted order.
    public void inorder(Node root,ArrayList<Integer> seq){
        if(root==null){
            return;
        }
        inorder(root.left,seq);
        seq.add(root.data);
        inorder(root.right,seq);
    }
    public ArrayList<Integer> mergeAL(ArrayList<Integer> sorted1,ArrayList<Integer> sorted2){
        int i=0;
        int j=0;
        ArrayList<Integer> result=new ArrayList<>();
        while(i<sorted1.size() && j<sorted2.size()){
            if(sorted1.get(i)<=sorted2.get(j)){
                result.add(sorted1.get(i));
                i++;
            }else{
                result.add(sorted2.get(j));
                j++;
            }
            
        }
        while(i<sorted1.size()){
            result.add(sorted1.get(i));
            i++;
        }
        while(j<sorted2.size()){
            result.add(sorted2.get(j)); 
            j++;
        }
        return result;
        
    }
    public Node createBST(ArrayList<Integer> BST,int start,int end){
        if(start>end){
            return null;
        }
        int mid=(start+end)/2;
        Node root=new Node(BST.get(mid));
        root.left=createBST(BST,start,mid-1);
        root.right=createBST(BST,mid+1,end);
        return root;
    }
    public ArrayList<Integer> merge(Node root1, Node root2) {
        // Write your code here
        ArrayList<Integer> sorted1=new ArrayList<>();
        inorder(root1,sorted1);
        ArrayList<Integer> sorted2=new ArrayList<>();
        inorder(root2,sorted2);
        ArrayList<Integer> result=mergeAL(sorted1,sorted2);
        return result;
         
        
    }
}

import java.util.*;
public class mirrorOfBinaryTree{
static class Node{
        int data;
        Node left,right;
        Node(int data){
           
            this.data=data;
            
            left=right=null;
        }
     }
  static Node createNode(int data) 
{ 
    return new Node(data); 
}    
static Node mirrorify(Node root){
    if(root==null){
        return null;
    }
    Node mirror=createNode(root.data);
    mirror.right=mirrorify(root.left);
    mirror.left=mirrorify(root.right);
    return mirror;
}
static void inorder(Node root){
    if(root==null){
        return;
    }
    inorder(root.left);
    System.out.print(root.data+" ");
    inorder(root.right);
}
public static void main(String[] args){ 

    Node tree = createNode(5); 
    tree.left = createNode(3); 
    tree.right = createNode(6); 
    tree.left.left = createNode(2); 
    tree.left.right = createNode(4); 

    // Print inorder traversal of the input tree 
    System.out.print("Inorder of original tree: "); 
    inorder(tree); 
    Node mirror = null; 
    mirror = mirrorify(tree); 

    // Print inorder traversal of the mirror tree 
    System.out.print("\nInorder of mirror tree: "); 
    inorder(mirror); 
} 
}










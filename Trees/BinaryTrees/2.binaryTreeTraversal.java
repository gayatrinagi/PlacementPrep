package dsaplacement;
import java.util.*;
public class binaryTrees {
	static class Node{//creating a node class
		int value;
		Node left;//left of node
		Node right;//right of node
		Node(int value){
			this.value=value;
			this.left=null;
			this.right=null;
		}
	}
	static class BinaryTree{
		static int index=-1;
		public static Node buildTree(int nodes[]) {
			index++;
			if(index>=nodes.length || nodes[index]==-1) {
				return null;
			}
			Node newNode=new Node(nodes[index]);//create a new node
			newNode.left=buildTree(nodes);//recursively builds leftsubtree 
			newNode.right=buildTree(nodes);//recursively builds rightsubtree
			return newNode;
			}
		public static void preorderTraversal(Node root) {//first root, left subtree, right subtree
			if(root==null) {
				return;
			}
			System.out.print(root.value+" ");
			preorderTraversal(root.left);
			preorderTraversal(root.right);
		}
		public static void inorderTraversal(Node root) {// left subtree,root, right subtree
			if(root==null) {
				return;
			}
			preorderTraversal(root.left);
			System.out.print(root.value+" ");
			preorderTraversal(root.right);
		}
		public static void postorderTraversal(Node root) {//left subtree,right subtree, root
			if(root==null) {
				return;
			}
			postorderTraversal(root.left);
			postorderTraversal(root.right);
			System.out.print(root.value+" ");
		}
		public static void levelorderTraversal(Node root) {//level wise 
			if(root==null) {
				return;
			}
			Queue<Node> que=new LinkedList<>();//create a queue ds for FIFO property
			que.add(root);//add the root 
			que.add(null);//add null
			while(!que.isEmpty()) {//check if queue is empty
				Node curr=que.remove();//since queue is not empty remove the node 
				if(curr==null) {//checks if node is null
					System.out.println();//this means the node is null and next line should be printed 
					if(que.isEmpty()) {
						break;
					}else {
						que.add(null);
					}
				}else {
					System.out.print(curr.value+" ");
					if(curr.left!=null) {
						que.add(curr.left);
					}
					if(curr.right!=null) {
						que.add(curr.right);
					}
				}
				
				
			}
			
		}
	}
    public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nodes= {1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};
		BinaryTree tree=new BinaryTree();
		Node root=tree.buildTree(nodes);
		System.out.println("Preorder Traversal");
		tree.preorderTraversal(root);
		System.out.println();
		System.out.println("Inorder Traversal");
		tree.inorderTraversal(root);
		System.out.println();
		System.out.println("Postorder Traversal");
		tree.postorderTraversal(root);
		System.out.println();
		System.out.println("Levelorder Traversal");
		tree.levelorderTraversal(root);
		
	}

}

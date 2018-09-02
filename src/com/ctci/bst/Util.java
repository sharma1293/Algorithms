package com.ctci.bst;

public class Util {

	/*
	 * Lower value is inserted to the left and equal or larger value is inserted to the right.
	 */
	public static Node insert(Node root,int val) {
		if(root == null){
            root = new Node(val);
        }
		else if(val<root.Data) {
			if(root.left!=null) {
				insert(root.left,val);
			}else {
				root.left	=	new Node(val);
			}
		}else {
			if(root.right!=null){
				insert(root.right,val);
			}else {
				root.right	=	new Node(val);
			}
		}
		return root;
	}
	
	/*
	 * PreOrder traversal, root->left->right
	 */
	public static void preOrder(Node root) {
		System.out.println(root.Data);
		if(root.left!=null)
			preOrder(root.left);
		if(root.right!=null)
			preOrder(root.right);
	}
	
	/*
	 * PostOrder traversal, left->right->root
	 */
	public static void postOrder(Node root) {
		if(root.left!=null)
			postOrder(root.left);
		if(root.right!=null)
			postOrder(root.right);
		System.out.println(root.Data);
	}
	
	/*
	 *InOrder traversal, left->root->right 
	 */
	public static void inOrder(Node root) {
		if(root.left!=null)
			inOrder(root.left);
		System.out.println(root.Data);
		if(root.right!=null)
			inOrder(root.right);
	}
	
	/*
	 * Height of BST.(Number of levels in BST)
	 */
	public static int height(Node root) {
		int leftBranchHeight	= 0;
		int rightBranchHeight	= 0;
		if(root.left!=null) {
			leftBranchHeight = height(root.left)+1;
		}
		if(root.right!=null) {
			rightBranchHeight = height(root.right)+1;
		}
		return (rightBranchHeight>leftBranchHeight)?rightBranchHeight:leftBranchHeight;
	}
}

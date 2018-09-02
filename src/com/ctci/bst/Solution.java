package com.ctci.bst;
public class Solution {
	public static void main(String[] args) {
		Node root = null;
		root = Util.insert(root, 1);
		root = Util.insert(root, 2);
		root = Util.insert(root, 5);
		root = Util.insert(root, 3);
		root = Util.insert(root, 4);
		root = Util.insert(root, 6);
		System.out.println("Pre Order:");
		Util.preOrder(root);
		System.out.println("Post Order");
		Util.postOrder(root);
		System.out.println("In Order:");
		Util.inOrder(root);
		System.out.println("Height of tree:");
		System.out.println(Util.height(root));
	}
}

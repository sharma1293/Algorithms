package com.ctci.bst;

//Node element for binary search tree.
public class Node {
	public int Data;
	public Node left;
	public Node right;
	Node(int Data){
		this.Data	=	Data;
		this.left	=	null;
		this.right	=	null;
	}
}

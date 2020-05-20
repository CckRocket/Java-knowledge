package com.data.tree;

public class RBTreeNode {
	private int data;
	private RBTreeNode left;
	private RBTreeNode right;
	private RBTreeNode parent;
	private Color color;
	
	public RBTreeNode(int theData) {
		this.data = theData;
		color = Color.RED;
	}
	public int getData() {
		return data;
	}
	public void setData(int data) {
		this.data = data;
	}
	public RBTreeNode getLeft() {
		return left;
	}
	public void setLeft(RBTreeNode left) {
		this.left = left;
	}
	public RBTreeNode getRight() {
		return right;
	}
	public void setRight(RBTreeNode right) {
		this.right = right;
	}
	public RBTreeNode getParent() {
		return parent;
	}
	public void setParent(RBTreeNode parent) {
		this.parent = parent;
	}
	public Color getColor() {
		return color;
	}
	public void setColor(Color color) {
		this.color = color;
	}
	public void setRed() {
		this.color = Color.RED;
	}
	public void setBlack() {
		this.color = Color.BLACK;
	}
	public boolean isBlack() {
		return (color == Color.BLACK)?true:false;
	}
	public boolean isRed() {
		return (color == Color.RED)?true:false;
	}
	public RBTreeNode getGrandpa() {
		if(parent == null) {
			return null;
		}
		return parent.parent;
	}
	public RBTreeNode getUncle() {
		RBTreeNode grandpa = getGrandpa();
		RBTreeNode parent = getParent();
		if(grandpa != null) {
			return (parent == grandpa.left) ? grandpa.right : grandpa.left;
		}
		return null;
	}
	
}

package com.data.tree;

import java.util.LinkedList;
import java.util.Queue;

public class RedBlackTree {
	private RBTreeNode root;

	public RBTreeNode getRoot() {
		return root;
	}

	public RedBlackTree() {
		root = null;
	}

	public void add(int insertVal) {
		//tree is empty
		if(root == null) {
			root = new RBTreeNode(insertVal);
			root.setBlack();
		}else {
			add(root, insertVal);
		}
	}
	private void add(RBTreeNode node, int insertVal) {
		//not allow same value
		if(insertVal == node.getData()) {
			return;
		}else if(insertVal < node.getData()) {	//left side
			if(node.getLeft() == null) {
				node.setLeft(new RBTreeNode(insertVal));
				node.getLeft().setParent(node);
				//balance tree only when parent node is red
				if(node.isRed()) {
					balance(node.getLeft());
				}
			}else {	
				add(node.getLeft(), insertVal);
			}
		}else { 	//right side
			if(node.getRight() == null) {
				node.setRight(new RBTreeNode(insertVal));
				node.getRight().setParent(node);
				if(node.isRed()) {
					balance(node.getRight());
				}
			}else {
				add(node.getRight(), insertVal);
			}
		}
	}

	private void balance(RBTreeNode curr) {
		RBTreeNode parent = curr.getParent();
		RBTreeNode grandpa = curr.getGrandpa();
		RBTreeNode uncle = curr.getUncle();
		//uncle exists
		if(uncle != null) {
			//current node is a leaf, change the color of parent and grandpa, recursively.
			if(curr.isRed() && parent.isRed() && uncle.isRed()) {
				parent.setBlack();
				uncle.setBlack();
				grandpa.setRed();
				balance(grandpa);
			}else if (curr.isRed() && parent.isRed() && uncle.isBlack()) {
				//Left-Left Pattern
				if(curr == parent.getLeft() && parent == grandpa.getLeft()) {
					rightRotate(parent, grandpa);
				//Right-Right Pattern
				}else if (curr == parent.getRight() && parent == grandpa.getRight()) {
					leftRotate(parent, grandpa);
				//Left-Right Pattern
				}else if (curr == parent.getRight() && parent == grandpa.getLeft()) {
					leftRotate(curr, parent);
					rightRotate(parent, grandpa);
				//Right-Left Pattern
				}else {
					rightRotate(curr, parent);
					leftRotate(parent, grandpa);
				}
			}
		}else { //uncle do not exist
			//parent is null: curr is root
			if(parent == null) {
				curr.setBlack();
			}else {
				//grandpa is null: parent is root
				if(grandpa == null) {
					parent.setBlack();
					//parent and grandpa exist
				}else {
					if(curr.isRed() && parent.isRed()) {
						//Left-Left
						if(curr == parent.getLeft() && parent == grandpa.getLeft()) {
							rightRotate(parent, grandpa);
							//Right-Right
						}else if (curr == parent.getRight() && parent == grandpa.getRight()) {
							leftRotate(parent, grandpa);
							//Left-Right
						}else if (curr == parent.getRight() && parent == grandpa.getLeft()) {
							leftRotate(curr, parent);
							rightRotate(parent, grandpa);
							//Right-left
						}else {
							rightRotate(curr, parent);
							leftRotate(parent, grandpa);
						}
						balance(grandpa);
					}
				}
			}
		}
	}
	/**
	 * @param p
	 * @param g
	 */
	private void leftRotate(RBTreeNode p, RBTreeNode g) {
		RBTreeNode pLeft = new RBTreeNode(g.getData());

		pLeft.setLeft(g.getLeft());
		if(pLeft.getLeft() != null) {
			pLeft.getLeft().setParent(pLeft);
		}

		pLeft.setRight(p.getLeft());
		if(pLeft.getLeft() != null) {
			pLeft.getRight().setParent(pLeft);
		}

		g.setData(p.getData());

		g.setRight(p.getRight());
		if(g.getRight() != null) {
			g.getRight().setParent(g);
		}
		
		g.setLeft(pLeft);
		pLeft.setParent(g);
	}

	private void rightRotate(RBTreeNode p, RBTreeNode g) {
		RBTreeNode pRight = new RBTreeNode(g.getData());

		pRight.setRight(g.getRight());
		if(pRight.getRight() != null) {
			pRight.getRight().setParent(pRight);
		}

		pRight.setLeft(p.getRight());
		if(pRight.getLeft() != null) {
			pRight.getLeft().setParent(pRight);
		}

		g.setData(p.getData());

		g.setLeft(p.getLeft());
		if(g.getLeft() != null) {
			g.getLeft().setParent(g);
		}

		g.setRight(pRight);
		pRight.setParent(g);
		/* 
		 g is black, originally. pRight is a new node, then is red.
		 the following code is not needed:
		 g.setBlack();
		 pRight.setRed();
		 */
	}

	public void dfs() {
		if(root == null) {
			return;
		}else {
			dfs(root);
		}
	}
	private void dfs(RBTreeNode node) {
		if(node.getLeft() != null) {
			dfs(node.getLeft());
		}
		System.out.println(node.getData() + " " + node.getColor().toString());
		if(node.getRight() != null) {
			dfs(node.getRight());
		}
	}

	public void bfs() {
		if(root == null) {
			return;
		}
		Queue<RBTreeNode> queue = new LinkedList<>();
		queue.add(root);
		while(!queue.isEmpty()) {
			RBTreeNode temp = queue.remove();
			System.out.println(temp.getData() + " " + temp.getColor().toString());
			if(temp.getLeft() != null) {
				queue.add(temp.getLeft());
			}
			if(temp.getRight() != null) {
				queue.add(temp.getRight());
			}
		}
	}
}

package com.data.tree;

public class AVLTree {
	private TreeNode root;
	
	public AVLTree() {
		root = null;
	}
	
	public AVLTree(TreeNode node) {
		root = node;
	}
	
	public AVLTree(int value) {
		root = new TreeNode(value);
	}

	public TreeNode getRoot() {
		return root;
	}
	
	public void setRoot(TreeNode root) {
		this.root = root;
	}
	
	/**
	 * add new node 
	 * recusive implement, easy for rotation
	 * @param insertNode
	 */
	public void add(TreeNode insertNode) {
		if(insertNode != null) {
			if(root == null) {
				root = insertNode;
			}else {
				add(root, insertNode);
			}
		}
	}
	//recusive function for add
	private void add(TreeNode node, TreeNode insertNode) {
		if(insertNode.getValue() < node.getValue()) {
			if(node.getLeft() == null) {
				node.setLeft(insertNode);
			}else {
				add(node.getLeft(), insertNode);
			}
		}else if (insertNode.getValue() > node.getValue()) {
			if(node.getRight() == null) {
				node.setRight(insertNode);
			}else {
				add(node.getRight(), insertNode);
			}
		}
		//recusive rotate to meet the AVL Tree requirement
		balance(node);
	}
	
	private void balance(TreeNode node) {
		int leftH = height(node.getLeft());
		int rightH = height(node.getRight());
		if(leftH - rightH > 1) {
			//left-left pattern: right rotation
			if(leftHeight(node.getLeft()) > rightHeight(node.getLeft())){
				rightRotate(node);
			//left-right pattern: left --> right rotation
			}else {
				leftRotate(node.getLeft());
				rightRotate(node);
			}
		}else if (rightH - leftH > 1) {
			//right-right pattern: left rotation
			if(rightHeight(node.getRight()) > leftHeight(node.getRight())){
				leftRotate(node);
			//right-left pattern: right --> left rotation
			}else {
				rightRotate(node.getRight());
				leftRotate(node);
			}
		}
	}
	
	public int height(TreeNode node) {
		if(node == null) {
			return 0;
		}else {
			return Math.max(height(node.getLeft()), height(node.getRight())) + 1;
		}
	}
	
	private int leftHeight(TreeNode node) {
		TreeNode leftNode = node.getLeft();
		if(leftNode == null) {
			return 0;
		}else {
			return height(leftNode);
		}
	}
	
	private int rightHeight(TreeNode node) {
		TreeNode rightNode = node.getRight();
		if(rightNode == null) {
			return 0;
		}else {
			return height(rightNode);
		}
	}
	
	private void leftRotate(TreeNode k2) {
		//k1,k2,t Definition: in Data Structures and Algorithm Analysis in Java
		TreeNode k1 = k2.getRight();
		TreeNode t = new TreeNode(k2.getValue());
		t.setLeft(k2.getLeft());
		t.setRight(k1.getLeft());
		k2.setValue(k1.getValue());
		k2.setRight(k1.getRight());
		k2.setLeft(t);
	}
	
	private void rightRotate(TreeNode k2) {
		TreeNode k1 = k2.getLeft();
		TreeNode t = new TreeNode(k2.getValue());
		t.setRight(k2.getRight());
		t.setLeft(k1.getRight());
		k2.setValue(k1.getValue());
		k2.setLeft(k1.getLeft());
		k2.setRight(t);
	}
	
	/**
	 * contains the target value
	 * @param target
	 * @return
	 */
	public TreeNode contains(int target) {
		return contains(root,target);
	}
	private TreeNode contains(TreeNode node, int target) {
		if(node == null) {
			return null;
		}
		if(node.getValue() == target) {
			return node;
		}else if (target < node.getValue()) {
			return contains(node.getLeft(), target);
		}else {
			return contains(node.getRight(), target);
		}
	}
	
	/**
	 * remove target node
	 * @param target
	 */
	public void remove(int target) {
		remove(null,root,target);
	}
	private void remove(TreeNode parent, TreeNode node, int target) {
		if(node == null) {
			return;
		}
		if(target < node.getValue()) {
			remove(node, node.getLeft(), target);
		}else if (target > node.getValue()) {
			remove(node, node.getRight(), target);
		}else {
			//remove leaf
			if(node.getLeft() == null && node.getRight() == null) {
				//target node as root
				if(parent == null) {
					node = null;
				//not root
				}else {
					if(parent.getLeft() == node) {
						parent.setLeft(null);
					}else {
						parent.setRight(null);
					}
				}
				//node have two children
			}else if (node.getLeft() != null && node.getRight() != null) {
				TreeNode minParentOfRightTree = node.getRight();
				while(minParentOfRightTree.getLeft() != null && minParentOfRightTree.getLeft().getLeft() != null) {
					minParentOfRightTree = minParentOfRightTree.getLeft();
				}
				int minValOfRightTree = 0;
				if(minParentOfRightTree.getLeft() == null) {
					minValOfRightTree = minParentOfRightTree.getValue();
				}else {
					minValOfRightTree = minParentOfRightTree.getLeft().getValue();
				}
				remove(null, root, minValOfRightTree);
				node.setValue(minValOfRightTree);
				//node have one child
			}else {
				TreeNode grandson = null;
				if(node.getLeft() != null) {
					grandson = node.getLeft();
				}else {
					grandson = node.getRight();
				}
				if(parent == null) {
					node = grandson;
				}else {
					if(parent.getLeft() == node) {
						parent.setLeft(grandson);
					}else {
						parent.setRight(grandson);
					}
				}
			}
		}
		//for balance
		balance(node);
	}
	/**
	 * inorderTraversal
	 */
	public void inorderTraversal() {
		inorder(root);
		System.out.println();
	}
	private void inorder(TreeNode node) {
		if(node == null) {
			return;
		}
		inorder(node.getLeft());
		System.out.print(node.getValue() + " ");
		inorder(node.getRight());
	}
}

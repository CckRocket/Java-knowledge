package com.data.tree;

public class BinarySortTree {
	private TreeNode root;
	
	public BinarySortTree() {
		root = null;
	}
	
	public BinarySortTree(TreeNode node) {
		root = node;
	}
	
	public BinarySortTree(int value) {
		root = new TreeNode();
		root.setValue(value);
	}
	
	/**
	 * add non-repetitive node 
	 * non-recursive, loop implementation
	 * @param insertNode
	 */
	public void add(TreeNode insertNode) {
		if(insertNode == null) {
			return;
		}
		if(root == null) {
			root = insertNode;
			return;
		}
		TreeNode treeNode = root;
		while(treeNode != null) {
			//if equals, do not add, return immediately
			if(treeNode.getValue() == insertNode.getValue()) {
				return;
			//insertNode is smaller than treeNode
			//check whether the left tree of treeNode is null 
			}else if (insertNode.getValue() < treeNode.getValue()) {
				if(treeNode.getLeft() == null) {
					treeNode.setLeft(insertNode);
					return;
				}else {
					treeNode = treeNode.getLeft();
				}
			//insertNode is larger than treeNode
			}else {
				if(treeNode.getRight() == null) {
					treeNode.setRight(insertNode);
					return;
				}else {
					treeNode = treeNode.getRight();
				}
			}
		}
	}
	
	/**
	 * contains node?
	 * @param target
	 * @return
	 */
	public TreeNode contains(int target) {
		return contains(root,target);
	}
	//recursive function for contains
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
	 * remove the target node
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
		//target node is found
		}else {
			//target node as a leaf
			if(node.getLeft() == null && node.getRight() == null) {
				//target node is root
				if(parent == null) {
					node = null;
				}else {
					if(parent.getLeft() == node) {
						parent.setLeft(null);
					}else {
						parent.setRight(null);
					}
				}
			//target node has two children
			//min node of right tree as new root of subtree
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

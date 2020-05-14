package com.data.tree;

public class Test {

	public static void main(String[] args) {
		BinarySortTree binarySortTree = new BinarySortTree();
		int[] arr = new int[] {7,10,9,8,20,5,6,1};
		for(int i : arr) {
			binarySortTree.add(new TreeNode(i));
		}
		System.out.println("BST tree");
		binarySortTree.inorderTraversal();
		binarySortTree.remove(1);
		binarySortTree.inorderTraversal();
		System.out.println("--------------------");
		System.out.println("AVL tree");
		AVLTree avlTree = new AVLTree();
		int[] arr1 = new int[] {20,10,30,12,14,15};
		for(int i : arr1) {
			avlTree.add(new TreeNode(i));
		}
		avlTree.inorderTraversal();
		System.out.println("height: " + avlTree.height(avlTree.getRoot()));
		avlTree.remove(30);
		avlTree.remove(15);
		avlTree.remove(20);
		System.out.println("root: " + avlTree.getRoot().getValue());
		avlTree.inorderTraversal();
	}

}

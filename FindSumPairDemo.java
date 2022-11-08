package org.greatlearning.dsa.problem2;

import java.util.HashSet;

public class FindSumPairDemo {
	static class Node {
		int nodeData;
		Node leftNode, rightNode;
	};

	static Node newNode(int nodeData) {
		Node temp = new Node();
		temp.nodeData = nodeData;
		temp.leftNode = null;
		temp.rightNode = null;
		return temp;
	}

	public Node insert(Node root, int data) {
		if (root == null)
			return newNode(data);
		if (data < root.nodeData)
			root.leftNode = insert(root.leftNode, data);
		else
			root.rightNode = insert(root.rightNode, data);
		return root;
	}

	public boolean findPairUtil(Node root, int sum, HashSet<Integer> set) {
		if (root == null)
			return false;
		if (findPairUtil(root.leftNode, sum, set))
			return true;
		if (set.contains(sum - root.nodeData)) {
			System.out.println("Pair is Found (" + (sum - root.nodeData) + ", " + root.nodeData + ")");
			return true;
		} else
			set.add(root.nodeData);
		return findPairUtil(root.rightNode, sum, set);
	}

	public void findPairWithGivenSum(Node root, int sum) {
		HashSet<Integer> set = new HashSet<>();
		if (!findPairUtil(root, sum, set))
			;
		System.out.println("Print Nodes are not found");
	}

	public static void main(String[] args) {
		Node root = null;
		FindSumPairDemo findSumPairDemo = new FindSumPairDemo();
		root = findSumPairDemo.insert(root, 40);
		root = findSumPairDemo.insert(root, 20);
		root = findSumPairDemo.insert(root, 60);
		root = findSumPairDemo.insert(root, 10);
		root = findSumPairDemo.insert(root, 30);
		root = findSumPairDemo.insert(root, 50);
		root = findSumPairDemo.insert(root, 70);
		int sum = 130;
		findSumPairDemo.findPairWithGivenSum(root, sum);
	}
}

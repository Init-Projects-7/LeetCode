package com.example.solutions.leetcode.binaryTree;

/**
 * Same Tree
 * <a href="https://leetcode.com/problems/same-tree/description/?envType=study-plan-v2&envId=top-interview-150">Task Description</a> 
 * @author Sattar
 *
 */


class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode() {}
     TreeNode(int val) { this.val = val; }
     TreeNode(int val, TreeNode left, TreeNode right) {
         this.val = val;
         this.left = left;
         this.right = right;
    }
}

public class SameTree {
	
	public static void main(String[] args) {
		TreeNode pLeft = new TreeNode(2);
		TreeNode pRight = new TreeNode(2);
		TreeNode pRoot = new TreeNode(1, pLeft,pRight);

		
		
		TreeNode qLeft = new TreeNode(1);
		TreeNode qRight = new TreeNode(2);
		TreeNode qRoot = new TreeNode(1,qLeft,qRight);
		
		SameTree sameTree = new SameTree();
		
		System.out.println(sameTree.isSameTree(pRoot, qRoot));
	}
	
    public boolean isSameTree(TreeNode p, TreeNode q) {
    	
        if (p == null && q == null) {
            return true;
        }
        if (p == null || q == null) {
            return false;
        }
        if (p.val != q.val) {
            return false;
        }

        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    	
        
    }
    
    

}

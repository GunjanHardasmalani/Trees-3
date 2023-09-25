// TC - O(n)
//SC - O(h)

import java.util.LinkedList;
import java.util.Queue;

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

class Solution {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root.left);
        q.add(root.right);

        while (!q.isEmpty()) {
            TreeNode left = q.poll();
            TreeNode right = q.poll();

            if (left == null && right == null) {
                continue;
            }

            if (left == null || right == null) {
                return false;
            }

            if (left.val != right.val) {
                return false;
            }
            q.add(left.left);
            q.add(right.right);
            q.add(left.right);
            q.add(right.left);
        }
        return true;
    }
}

public class Main {
    public static void main(String[] args) {
        // Create a binary tree for testing
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(3);

        // Create an instance of the Solution class
        Solution solution = new Solution();

        // Check if the tree is symmetric
        boolean isSymmetric = solution.isSymmetric(root);

        // Print the result
        System.out.println("Is the tree symmetric? " + isSymmetric);
    }
}

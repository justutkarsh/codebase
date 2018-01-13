package interviewbit;

/**
 * Created by utkarsh on 25-09-2016.
 */
public class SymmetricTree {

    //Definition for binary tree
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static class Solution {

        private boolean mirror(TreeNode x, TreeNode y) {
            if (x == null && y == null) return true;

            else if (x != null && y != null && x.val == y.val)
                return mirror(x.left, y.right) && mirror(x.right, y.left);

            else return false;


        }

        public int isSymmetric(TreeNode a) {

            if (a == null) return 1;
            else return mirror(a.left, a.right) ? 1 : 0;


        }
    }
}

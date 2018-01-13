package interviewcake;

/**
 * Created by utkarsh on 30-08-2016.
 * A tree is "superbalanced" if the difference between the depths
 * of any two leaf nodes ↴ is no greater than one.
 */
public class SuperBalancedBinaryTree {
    public static class BinaryTreeNode {

        public void setValue(int value) {
            BinaryTreeNode root = new BinaryTreeNode(14);
            root.insertLeft(5).insertRight(6).insertLeft(5);
            root.insertRight(6).insertRight(5);


        }

        public int value;
        public BinaryTreeNode left;
        public BinaryTreeNode right;

        public BinaryTreeNode(int value) {
            this.value = value;
        }

        public BinaryTreeNode insertLeft(int leftValue) {
            this.left = new BinaryTreeNode(leftValue);
            return this.left;
        }

        public BinaryTreeNode insertRight(int rightValue) {
            this.right = new BinaryTreeNode(rightValue);
            return this.right;
        }
    }
}

package companies.livspace;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Given a list of tree nodes, find whether this will form a binary tree
 * Node {
 * Node left;
 * Node right;
 * int val
 * }
 *
 * e.g. N1 N2 N3
 *
 * N1 - {
 * left -> N2
 * right -> N3
 * val -> 1
 * }
 *
 * N2 - {
 * left -> Null
 * right -> Null
 * val -> 2
 * }
 *
 * N3 - {
 * left -> Null
 * right -> Null
 * val -> 3
 * }
 */

public class BinaryTreeOrNot {

  static class Node {

    Node left;
    Node right;
    int data;
  }

  static class Solution {

    public Boolean putNode(Node n, Map m) {
      if (null != n.left) {
        if (m.containsKey(n.left)) {
          return false;
        }
        m.put(n.left, n);
      }
      if (null != n.right) {
        if (m.containsKey(n.right)) {
          return false;
        }
        m.put(n.right, n);
      }
      return true;
    }

    public Boolean isBinaryTree(List<Node> nodeList) {
      if (null == nodeList || nodeList.isEmpty()) {
        return false;
      }
      HashMap<Node, Node> nodeMap = new HashMap<>();
      for (Node n : nodeList) {
         if(!putNode(n,nodeMap)) return false;
      }
      for (Node n : nodeList) {

        int rootCount = 0;
        Node root;

        if (!nodeMap.containsKey(n)) {
          rootCount++;
          root = n;
        }

        if (rootCount > 1 && rootCount == 0) {
          return false;
        }
      }
      return true;
    }
  }

  public static void main(String[] args) {

    Node n1 = new Node();
    Node n2 = new Node();
    Node n3 = new Node();
    Node n4 = new Node();
    Node n5 = new Node();
    Node n6 = new Node();
    Node n7 = new Node();

    n1.left=n2;
    n1.right=n3;
    n2.left=n4;
    n2.right=n5;

    n3.left=n6;
    n3.right=n7;
    //n7.right=n3;

    List<Node> nodeList = Arrays.asList(n1,n2,n3,n4,n5,n6,n7);
    Solution s = new Solution();
    System.out.println(s.isBinaryTree(nodeList));
  }
}

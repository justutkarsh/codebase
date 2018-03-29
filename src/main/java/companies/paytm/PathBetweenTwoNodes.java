package companies.paytm;/*
  @author utkarsh 
*/

import datastructures.treesngraphs.BTreePrinter;
import datastructures.treesngraphs.BTreeTest;
import datastructures.treesngraphs.Node;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class PathBetweenTwoNodes {

  List<Node> leftList = new LinkedList<>();
  List<Node> rightList = new LinkedList<>();
  List<Node> result = new LinkedList<>();
  boolean flag = false;

  public static void main(String[] args) {

    Node root = BTreeTest.generateTree2();
    BTreePrinter.printNode(root);

    Node a = root.left.left;
//    System.out.println(a.data);
    Node b = root.left.right.right;
//    System.out.println(b.data);

    PathBetweenTwoNodes p = new PathBetweenTwoNodes();
    p.lowestCommonAncestor(root, a, b, new ArrayList<>());
//    p.result.stream().forEach(s -> System.out.print(s.data + ","));

    List<Node> nodes = p.lowestCommonAncestorPath(root, a, b);

    System.out.println("Answer --------------------");
    nodes.stream().map(n -> n.getData()).forEach(System.out::print);
  }

  public Node lowestCommonAncestor(Node root, Node p, Node q, List<Node> buffer) {
    if (root == null || root == p || root == q) {
      return root;
    }

    Node left = lowestCommonAncestor(root.left, p, q, leftList);
    Node right = lowestCommonAncestor(root.right, p, q, rightList);

    if (left != null && right == null) {
      if (buffer.isEmpty()) {
        buffer.add(left);
      }
      buffer.add(root);
    }

    if (right != null && left == null) {
      if (buffer.isEmpty()) {
        buffer.add(right);
      }
      buffer.add(root);
    }
    if (null != left && null != right) {
      result.addAll(leftList);
      result.add(root);
      Collections.reverse(rightList);
      result.addAll(rightList);
    }

    return left == null ? right : right == null ? left : root;
  }

  public List<Node> lowestCommonAncestorPath(Node root, Node p, Node q) {
    if (root == null) {
      return Collections.EMPTY_LIST;
    } else if (root == p) {
      LinkedList<Node> list = new LinkedList<>();
      list.add(p);
      return list;
    } else if (root == q) {
      LinkedList<Node> list = new LinkedList<>();
      list.add(q);
      return list;
    }

    List<Node> left = lowestCommonAncestorPath(root.left, p, q);
    List<Node> right = lowestCommonAncestorPath(root.right, p, q);

    if (!left.isEmpty() && !right.isEmpty()) {
      Collections.reverse(right);
      left.add(root);
      left.addAll(right);
      flag = true;
      return left;
    }

    if (!left.isEmpty()) {
      if (!flag) {
        left.add(root);
      }
      return left;
    }

    if (!right.isEmpty()) {
      if (!flag) {
        right.add(root);
      }
      return right;
    }

    return Collections.EMPTY_LIST;
  }

}


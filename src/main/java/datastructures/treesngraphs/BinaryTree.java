package datastructures.treesngraphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTree<T extends Comparable<?>> {

  static Node<Integer> ancestorNode = null;
  Node<T> root;

  public static void main(String[] args) {

  }

  @Deprecated
  private static void printTree(Node<Integer> root) {

    List<Node<Integer>> q1 = new ArrayList<Node<Integer>>();
    List<Node<Integer>> q2 = new ArrayList<Node<Integer>>();
    List<Node<Integer>> temp;
    q1.add(root);
    System.out.println(root.data);
    while (!(q1.isEmpty() && q2.isEmpty())) {
      q2 = levelPrinter(q1, q2);
      temp = q2;
      q2 = q1;
      q1 = temp;
      System.out.println();
    }

  }

  private static List<Node<Integer>> levelPrinter(List<Node<Integer>> q1,
      List<Node<Integer>> q2) {
    while (!q1.isEmpty()) {
      Node<Integer> n = q1.remove(0);
      if (n != null) {
        if (n.left != null) {
          q2.add(n.left);
          System.out.print(n.left.data + ",");
        }
        if (n.right != null) {
          q2.add(n.right);
          System.out.print(n.right.data);
        }
      }

    }
    return q2;
  }

  static void preOrder(Node<Integer> root) {
    if (root == null) {
      return;
    }
    System.out.print(root.data + ",");
    preOrder(root.left);
    preOrder(root.right);
  }

  static void inOrder(Node<Integer> root) {
    if (root == null) {
      return;
    }

    preOrder(root.left);
    System.out.print(root.data + ",");
    preOrder(root.right);
  }

  static void postOrder(Node<Integer> root) {
    if (root == null) {
      return;
    }

    preOrder(root.left);
    preOrder(root.right);
    System.out.print(root.data + ",");
  }

  static int height(Node<Integer> root) {
    if (root == null) {
      return 1;
    }
    return Math.max(height(root.left), height(root.right)) + 1;
  }

  static Boolean isBalanced(Node<Integer> root) {
    if (root == null || root.left == null || root.right == null) {
      return true;
    }

    if (Math.abs(height(root.left) - height(root.right)) > 1) {
      return false;
    } else {
      return isBalanced(root.left) && isBalanced(root.right);
    }

  }

  static// 1,2,3,4,5,6,7
  Node<Integer> generateTree(List<Integer> list, int low, int high) {
    if (low > high) {
      return null;
    }

    int mid = (low + high) / 2;
    Node<Integer> root = new Node<Integer>(list.get(mid));
    root.left = generateTree(list, low, mid - 1);
    root.right = generateTree(list, mid + 1, high);

    return root;

  }

  public static List<List<Node<Integer>>> levelTraversal(Node<Integer> root) {
    if (root == null) {
      return null;
    }

    List<List<Node<Integer>>> result = new ArrayList<List<Node<Integer>>>();
    List<Node<Integer>> list = new ArrayList<Node<Integer>>();

    list.add(root);
    result.add(list);

    while (!list.isEmpty()) {
      List<Node<Integer>> tempList = new ArrayList<Node<Integer>>();
      for (Node<Integer> n : list) {
        if (n != null) {

          if (n.left != null) {
            tempList.add(n.left);
          }
          if (n.right != null) {
            tempList.add(n.right);
          }
        }
      }

      result.add(tempList);
      list = tempList;

    }

    return result;

  }

  public static void levelTraverselTwoQ(Node<Integer> root) {
    Queue<Node> q1 = new LinkedList<Node>();
    Queue<Node> q2 = new LinkedList<Node>();
    q1.add(root);
    while (q1.size() != 0) {
      func(q1, q2);
      Queue temp;
      temp = q1;
      q1 = q2;
      q2 = temp;
    }

  }

  static void func(Queue q1, Queue q2) {
    while (q1.size() != 0) {
      Node element = (Node) q1.remove();
      System.out.print(element.data);
      if (element.left != null) {
        q2.add(element.left);
      }
      if (element.right != null) {
        q2.add(element.right);
      }


    }
    System.out.println();

  }

  public static Node<Integer> inorderSuccessor(PNode<Integer> node) {
    if (node == null) {
      return null;
    }

    Node parent = node.parent;
    if (parent == null) {
      return leftMost(node.right);
    }

    if (parent.left == node) {
      return parent;
    } else if (parent.right == node) {
      Node c = node.right;

      return leftMost(node);

    }
    return parent;

  }

  private static Node<Integer> leftMost(Node<Integer> node) {
    // TODO Auto-generated method stub
    if (node == null) {
      return null;
    }
    while (node.left != null) {
      node = node.left;
    }
    return node;
  }

  static int commonAncestorInt(Node<Integer> a, Node<Integer> b,
      Node<Integer> root) {
    if (root == null) {
      return 0;
    }

    int left = commonAncestorInt(a, b, root.left);
    int right = commonAncestorInt(a, b, root.right);

    if ((root == a || root == b) && (left == 1 || right == 1)) { //found one node
      return 2;
    } else if (root == a || root == b) {
      return 1;
    }
    if (left + right == 2) {
      ancestorNode = root;
    }
    if (left == 1 || right == 1) {
      return 1;
    } else {
      return 0;
    }

  }

  static public Node lowestCommonAncestor(Node root, Node p, Node q) {
    if (root == null || root == p || root == q) {
      return root;
    }
    Node left = lowestCommonAncestor(root.left, p, q);
    Node right = lowestCommonAncestor(root.right, p, q);
    return left == null ? right : right == null ? left : root;
  }


  @Deprecated
  static int cA(Node root, Node a, Node b) {
    if (root == null) {
      return 0;
    }

    int left = cA(root.left, a, b);
    int right = cA(root.right, a, b);
    if ((root == a || root == b) && (left == 1 || right == 1)) {
      return 2;
    }

    if (left + right == 2) {
      ancestorNode = root;
    }

    if (left == 1 || right == 1) {
      return 1;
    } else {
      return 0;
    }
  }

  @Deprecated
  public static int printPath(Node<Integer> root, int sum) {

    if (root == null) {
      return sum;
    }

    sum = sum - root.data;
    if (sum == 0) {
      System.out.println(root.data + ",");
      return 0;
    }

    if (root.left != null) {
      int fromleft = printPath(root.left, sum);
      if (fromleft == 0) {
        System.out.println(root.left.data + ",");
      }
    }
    if (root.right != null) {
      int fromright = printPath(root.right, sum);
      if (fromright == 0) {
        System.out.println(root.left.data + ",");
      }
    }
    return sum;

  }

  public static void printFullPaths(Node<Integer> root, int pathlen, int[] paths) {

    if (root == null) {
      return;
    }
    int data = root.data;
    paths[pathlen] = data;
    pathlen++;
    printFullPaths(root.left, pathlen, paths);
    printFullPaths(root.right, pathlen, paths);
    if (root.left == null && root.right == null) {
      printArray(0, pathlen, paths);
      return;
    }
  }

  public static void printAllPaths(Node<Integer> root, int pathlen, int[] paths) {

    if (root == null) {
      return;
    }

    int data = root.data;
    paths[pathlen] = data;
    pathlen++;
    printAllPaths(root.left, pathlen, paths);
    printAllPaths(root.right, pathlen, paths);
    printArray(0, pathlen, paths);
    return;

  }

  public static void printSumPaths(Node<Integer> root, int pathlen, int[] paths, int buffer,
      int sum) {
    if (root == null) {
      return;
    }
    int data = root.data;
    buffer += data;
    paths[pathlen] = data;
    pathlen++;
    if (buffer == sum) {
      printArray(0, pathlen, paths);
    }
    printSumPaths(root.left, pathlen, paths, buffer, sum);
    printSumPaths(root.right, pathlen, paths, buffer, sum);
    return;
  }

  //Optimized version
  public static void printAllSumPathsOptimal(Node<Integer> root, int pathlen, int[] paths,
      int sum) {

    if (root == null) {
      return;
    }

    int data = root.data;
    paths[pathlen] = data;

    int t = 0;
    for (int i = pathlen; i >= 0; i--) {
      t += paths[i];
      if (t == sum) {
        printArray(i, pathlen, paths);
      }
    }
    printAllSumPathsOptimal(root.left, pathlen + 1, paths, sum);
    printAllSumPathsOptimal(root.right, pathlen + 1, paths, sum);
    return;
  }

  public static void printAllSumPaths(Node<Integer> root, int pathlen, int[] paths, int buffer,
      int sum) {

    if (root == null) {
      return;
    }

    printSumPaths(root, pathlen, paths, buffer, sum);
    printSumPaths(root.left, pathlen, paths, buffer, sum);
    printSumPaths(root.right, pathlen, paths, buffer, sum);
  }

  private static void printArray(int start, int end, int[] paths) {
    for (int i = start; i <= end; i++) {
      System.out.print(paths[i] + ",");
    }
    System.out.println();
  }

  //optimized O(N)
  public static int[] getDiameter(Node root) {
    int[] result = new int[]{0, 0};    //1st element: diameter, 2nd: height
    if (root == null) {
      return result;
    }
    int[] leftResult = getDiameter(root.getLeft());
    int[] rightResult = getDiameter(root.getLeft());
    int height = Math.max(leftResult[1], rightResult[1]) + 1;
    int rootDiameter = leftResult[1] + rightResult[1] + 1;
    int leftDiameter = leftResult[0];
    int rightDiameter = rightResult[0];
    result[0] = Math.max(rootDiameter, Math.max(leftDiameter, rightDiameter));
    result[1] = height;

    return result;
  }

  //unoptimized
  private static int diameter(Node root) {

    if (root == null) {
      return 0;
    }

    int lh = height(root.left);
    int rh = height(root.right);
    int ldiameter = diameter(root.left);
    int rdiameter = diameter(root.right);

    return Math.max(Math.max(lh, rh), Math.max(ldiameter, rdiameter));

  }

  ArrayList<LinkedList<Node>> findLevelLinkList(Node root) {
    int level = 0;
    ArrayList<LinkedList<Node>> result = new ArrayList<LinkedList<Node>>();
    LinkedList<Node> list = new LinkedList<Node>();
    list.add(root);
    result.add(level, list);
    while (true) {
      list = new LinkedList<Node>();
      for (int i = 0; i < result.get(level).size(); i++) {
        Node n = result.get(level).get(i);
        if (n != null) {
          if (n.left != null) {
            list.add(n.left);
          }
          if (n.right != null) {
            list.add(n.right);
          }
        }
      }
      if (list.size() > 0) {
        result.add(level + 1, list);
      } else {
        break;
      }
      level++;
    }
    return result;
  }

  boolean superbalanched(Node<Integer> root, int minLeaf, int maxLeaf) {

    if (root == null) {
      return false;
    }

    if (root.left == null && root.right == null) {
      if (root.data < minLeaf) {
        minLeaf = root.data;
      } else if (root.data > maxLeaf) {
        maxLeaf = root.data;
      }

      return Math.abs(minLeaf - maxLeaf) <= 1;
    }

    boolean leftTree = superbalanched(root.left, minLeaf, maxLeaf);
    boolean rightTree = superbalanched(root.right, minLeaf, maxLeaf);

    return leftTree && rightTree;

  }

  Integer replaceWithLeftSubtreeSum(Node<Integer> root) {
    if (root == null) {
      return 0;
    }

    if (root.left == null && root.right == null) {
      return root.data;
    }
    int leftData, rightData;
    leftData = replaceWithLeftSubtreeSum(root.getLeft());

    rightData = replaceWithLeftSubtreeSum(root.getRight());

    root.data += root.getLeft().getData();

    return root.data + root.getRight().getData();
  }


  void btree2Dll(Node<Integer> root) {

    if (root == null) {
      return;
    }

    btree2Dll(root.left);

    btree2Dll(root.right);
  }


}




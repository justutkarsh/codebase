package treesngraphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTree<T extends Comparable<?>> {

  Node<T> root;

  public static void main(String[] args) {

    // Node<Integer> root = new Node<Integer>(2);
    // Node<Integer> n11 = new Node<Integer>(7);
    // Node<Integer> n12 = new Node<Integer>(5);
    // Node<Integer> n21 = new Node<Integer>(2);
    // Node<Integer> n22 = new Node<Integer>(6);
    // Node<Integer> n23 = new Node<Integer>(3);
    // Node<Integer> n24 = new Node<Integer>(6);
    // Node<Integer> n31 = new Node<Integer>(5);
    // Node<Integer> n32 = new Node<Integer>(8);
    // Node<Integer> n33 = new Node<Integer>(4);
    // Node<Integer> n34 = new Node<Integer>(5);
    // Node<Integer> n35 = new Node<Integer>(8);
    // Node<Integer> n36 = new Node<Integer>(4);
    // Node<Integer> n37 = new Node<Integer>(5);
    // Node<Integer> n38 = new Node<Integer>(8);
    //
    // root.left = n11;
    // root.right = n12;
    //
    // n11.left = n21;
    // n11.right = n22;
    // n12.left = n23;
    // n12.right = n24;
    //
    // n21.left = n31;
    // n21.right = n32;
    // n22.left = n33;
    // n22.right = n34;
    // n23.left = n35;
    // n23.right = n36;
    // n24.left = n37;
    // n24.right = n38;

    // printTree(root);
    // preOrder(root);
    // inOrder(root);
    // postOrder(root);

    // BTreePrinter.printNode(root);

    // System.out.println(isBalanced(root));

    // List<Integer> list = Arrays.asList(1,2,3,4,5,6,7,8,9,19);
    // Node<Integer> n = generateTree(list,0,9);
    // // printTree(n);
    // BTreePrinter.printNode(n);
    //
    // List<List<Node<Integer>>> result=levelTraversal(root);
    // for(List<Node<Integer>>l:result){
    // for(Node<Integer>t:l){
    // System.out.print(t.data+",");
    // }
    // System.out.println();
    //
    // }

    PNode<Integer> root1 = new PNode<Integer>(1);
    PNode<Integer> pnn11 = new PNode<Integer>(2);
    PNode<Integer> pnn12 = new PNode<Integer>(3);
    PNode<Integer> pnn21 = new PNode<Integer>(4);
    PNode<Integer> pnn22 = new PNode<Integer>(5);
    PNode<Integer> pnn23 = new PNode<Integer>(6);
    PNode<Integer> pnn24 = new PNode<Integer>(7);
    PNode<Integer> pnn31 = new PNode<Integer>(8);

    root1.left = pnn11;
    root1.right = pnn12;
    root1.parent = null;

    pnn11.left = pnn21;
    pnn11.right = pnn22;
    pnn11.parent = root1;

    pnn12.left = pnn23;
    pnn12.right = pnn24;
    pnn12.parent = root1;

    pnn21.left = pnn31;
    pnn21.parent = pnn11;
    pnn22.parent = pnn11;

    pnn31.parent = pnn21;

    BTreePrinter.printNode(root1);

    // List<Integer> paths = new ArrayList<Integer>();

    int[] paths = new int[10];
    //sumPaths(root1, 0, paths);

    //printAllPaths(root1,0,paths);

    //	printSumPaths(root1,0,paths,0,7);
    //printAllSumPathsOptimal(root1,0,paths,7);

    //levelTraverselTwoQ(root1);



    // List<List<Node<Integer>>> result1=levelTraversal(root1);
    // for(List<Node<Integer>>l:result1){
    // for(Node<Integer>t:l){
    // System.out.print(t.data+",");
    // }
    // System.out.println();
    //
    // }
    //

    // Node<Integer> succ = inorderSuccessor(pnn11);
    // System.out.println(succ.data);

    // commonAncestor(pnn31, pnn23, root1);
    // System.out.println(ancestorNode.data);
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
    System.out.println(root.data);
    preOrder(root.left);
    preOrder(root.right);
  }

  static void inOrder(Node<Integer> root) {
    if (root == null) {
      return;
    }

    preOrder(root.left);
    System.out.println(root.data);
    preOrder(root.right);
  }

  static void postOrder(Node<Integer> root) {
    if (root == null) {
      return;
    }

    preOrder(root.left);
    preOrder(root.right);
    System.out.println(root.data);
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

  ArrayList<LinkedList<Node>> findLevelLinkList(Node root) {
    int level = 0;
    ArrayList<LinkedList<Node>> result = new ArrayList<LinkedList<Node>>();
    LinkedList<Node> list = new LinkedList<Node>();
    list.add(root);
    result.add(level, list);
    while (true) {
      list = new LinkedList<Node>();
      for (int i = 0; i < result.get(level).size(); i++) {
        Node n = (Node) result.get(level).get(i);
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

  static Node<Integer> ancestorNode = null;

  static int commonAncestor(Node<Integer> a, Node<Integer> b,
      Node<Integer> root) {
    if (root == null) {
      return 0;
    }

    int left = commonAncestor(a, b, root.left);
    int right = commonAncestor(a, b, root.right);

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

      if (Math.abs(minLeaf - maxLeaf) > 1) {
        return false;
      } else {
        return true;
      }
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



  void btree2Dll(Node<Integer> root){

    if(root == null) return;

    btree2Dll(root.left);


    btree2Dll(root.right);
  }
}




class PNode<T extends Comparable<?>> extends Node<T> {

  public PNode(T data) {
    super(data);
  }

  Node<T> parent;

}

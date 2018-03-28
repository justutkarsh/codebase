package datastructures.treesngraphs;

import static datastructures.treesngraphs.BinaryTree.commonAncestor;
import static datastructures.treesngraphs.BinaryTree.inOrder;
import static datastructures.treesngraphs.BinaryTree.postOrder;
import static datastructures.treesngraphs.BinaryTree.preOrder;


public class BTreeTest {

  public static Node<Integer> generateTree2() {
    Node<Integer> root = new Node<Integer>(2);
    Node<Integer> n11 = new Node<Integer>(7);
    Node<Integer> n12 = new Node<Integer>(5);
    Node<Integer> n21 = new Node<Integer>(2);
    Node<Integer> n22 = new Node<Integer>(6);
    Node<Integer> n23 = new Node<Integer>(9);
    Node<Integer> n31 = new Node<Integer>(5);
    Node<Integer> n32 = new Node<Integer>(8);
    Node<Integer> n33 = new Node<Integer>(4);

    root.left = n11;
    root.right = n12;

    n11.left = n21;
    n11.right = n22;

    n12.right = n23;
    n22.left = n31;
    n22.right = n32;

    n23.left = n33;

    return root;
  }

  static Node generateTree() {
    Node<Integer> root = new Node<Integer>(2);
    Node<Integer> n11 = new Node<Integer>(7);
    Node<Integer> n12 = new Node<Integer>(5);
    Node<Integer> n21 = new Node<Integer>(2);
    Node<Integer> n22 = new Node<Integer>(6);
    Node<Integer> n23 = new Node<Integer>(3);
    Node<Integer> n24 = new Node<Integer>(6);
    Node<Integer> n31 = new Node<Integer>(5);
    Node<Integer> n32 = new Node<Integer>(8);
    Node<Integer> n33 = new Node<Integer>(4);
    Node<Integer> n34 = new Node<Integer>(5);
    Node<Integer> n35 = new Node<Integer>(8);
    Node<Integer> n36 = new Node<Integer>(4);
    Node<Integer> n37 = new Node<Integer>(5);
    Node<Integer> n38 = new Node<Integer>(8);

    root.left = n11;
    root.right = n12;

    n11.left = n21;
    n11.right = n22;
    n12.left = n23;
    n12.right = n24;

    n21.left = n31;
    n21.right = n32;
    n22.left = n33;
    n22.right = n34;
    n23.left = n35;
    n23.right = n36;
    n24.left = n37;
    n24.right = n38;
    return root;
  }

  public static PNode<Integer> generateParentTree() {
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
    return root1;
  }

  public static void main(String[] args) {

    BTreeTest bt = new BTreeTest();
    //bt.testPrintTree();
    bt.testCommonAncestor();

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

    //  PNode<Integer> root1 = BTreeTest.generateParentTree();

//    BTreePrinter.printNode(root1);

    // List<Integer> paths = new ArrayList<Integer>();

    //int[] paths = new int[10];
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

  private void testPrintTree() {

    Node root = BTreeTest.generateTree2();
    BTreePrinter.printNode(root);

    preOrder(root);
    System.out.println();
    inOrder(root);
    System.out.println();
    postOrder(root);
  }

  private void testCommonAncestor() {

    Node root = BTreeTest.generateTree2();
    BTreePrinter.printNode(root);

    Node a = root.left.right.right;
    System.out.println(a.data);
    Node b = root.right.right.left;
    System.out.println(b.data);
    // Node ca = lowestCommonAncestor(root, a, b);

    Node ca = commonAncestor(a, b, root);

    System.out.println(ca.data);


  }
}



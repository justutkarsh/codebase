package interviewbit;

import treesngraphs.BTreePrinter;
import treesngraphs.BTreePrinterTest;
import treesngraphs.BinaryTree;
import treesngraphs.Node;

import java.util.Arrays;
import java.util.List;

/**
 * Created by utkarsh on 25-09-2016.
 */
public class SortedArrayToBST {


        public static void main(String[] args) {
            List<Integer> list = Arrays.asList(0,1,2,3,4,5,6,7,8,9);
            Solution s = new Solution();
            Node root = s.sortedArrayToBST(list,0,list.size()-1);
           // root.print(root);
            BTreePrinter.printNode(root);
        }

     static class Solution {
        public Node sortedArrayToBST(final List<Integer> a,int l, int h) {
            int mid = l + (h - l) / 2;
            if (l > h) return null;
            Node root = new Node(a.get(mid));
            root.setLeft(sortedArrayToBST(a,l,mid-1));
            root.setRight(sortedArrayToBST(a,mid + 1, h));
            return root;
        }


    }
}



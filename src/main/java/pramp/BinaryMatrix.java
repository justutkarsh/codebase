package pramp;

/**
 * Created by utkarsh on 17/12/17.
 */

public class BinaryMatrix {


  static class Solution {

    static int getNumberOfIslands(int[][] binaryMatrix) {
      // your code goes here
      int count = 0;
      for (int row = 0; row < binaryMatrix.length; row++) {
        System.out.println();

        for (int col = 0; col < binaryMatrix[0].length; col++) {

          System.out.println(binaryMatrix[row][col]);
          if (binaryMatrix[row][col] == 1)

          {
            if (row == 0 || binaryMatrix[row - 1][col] != 0) {
              if (col == 0 || binaryMatrix[row][col - 1] != 0) {
                count++;
              }
            }
          }

        }
      }

      return count;

    }

    public static void main(String[] args) {
      Solution s = new Solution();

      int [][] binaryMatrix = {{0,    1,    0,    1,    0},
                               {0,    0,    1,    1,    1},
                               {1,    0,    0,    1,    0},
                               {0,    1,    1,    0,    0},
                               {1,    0,    1,    0,    1} };
      System.out.println(s.getNumberOfIslands(binaryMatrix));
    }

  }
}

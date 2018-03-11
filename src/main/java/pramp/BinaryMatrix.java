package pramp;

import java.util.LinkedList;
import java.util.Queue;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Created by utkarsh on 17/12/17.
 */

public class BinaryMatrix {


  static class Solution {


    static int getNumberOfIslands(int[][] binaryMatrix) {
      int count = 0;
      for (int row = 0; row < binaryMatrix.length; row++) {
        for (int col = 0; col < binaryMatrix[0].length; col++) {
          if (binaryMatrix[row][col] == 1) {
            markIslandBFS(binaryMatrix, row, col);
            count++;
          }
        }
      }
      return count;
    }

    private static void markIsland(int[][] binaryMatrix, int row, int col) {
      if (!isValid(binaryMatrix, row, col) || binaryMatrix[row][col] != 1) {
        return;
      }

      int[][] directions = {{0, 1}, {0, -1}, {-1, 0}, {1, 0}};
      if (binaryMatrix[row][col] == 1) {
        binaryMatrix[row][col] = -1;
      }

      for (int i = 0; i < directions.length; i++) {

        int adjacentrow = row + directions[i][0];
        int adjacentcol = col + directions[i][1];
        if (isValid(binaryMatrix, adjacentrow, adjacentcol)) {
          markIsland(binaryMatrix, adjacentrow, adjacentcol);
        }

      }


    }

    @Data
    @AllArgsConstructor
    static class Vertex {

      int x;
      int y;
    }

    private static void markIslandBFS(int[][] binaryMatrix, int row, int col) {
      if (!isValid(binaryMatrix, row, col) || binaryMatrix[row][col] != 1) {
        return;
      }

      int[][] directions = {{0, 1}, {0, -1}, {-1, 0}, {1, 0}};
      if (binaryMatrix[row][col] == 1) {
        binaryMatrix[row][col] = -1;
      }

      Queue<Vertex> queue = new LinkedList<>();
      queue.add(new Vertex(row, col));

      while (!queue.isEmpty()) {

        Vertex currentVertex = queue.poll();
        for (int i = 0; i < directions.length; i++) {

          int adjacentrow = currentVertex.getX() + directions[i][0];
          int adjacentcol = currentVertex.getY() + directions[i][1];
          if (isValid(binaryMatrix, adjacentrow, adjacentcol)) {
            if (binaryMatrix[adjacentrow][adjacentcol] == 1) {
              binaryMatrix[adjacentrow][adjacentcol] = -1;
              queue.add(new Vertex(adjacentrow, adjacentcol));
            }

          }
        }
      }
    }

    private static boolean isValid(int[][] binaryMatrix, int row, int col) {

      if (row < 0 || col < 0 || row > binaryMatrix.length - 1 || col > binaryMatrix[0].length - 1) {
        return false;
      }
      return true;
    }

    public static void main(String[] args) {
      Solution s = new Solution();

      int[][] binaryMatrix = {{0, 1, 0, 1, 0},
          {0, 0, 1, 1, 1},
          {1, 0, 0, 1, 0},
          {0, 1, 1, 0, 0},
          {1, 0, 1, 0, 1}};

      System.out.println(binaryMatrix);
      System.out.println(s.getNumberOfIslands(binaryMatrix));
      System.out.println(binaryMatrix);
    }

  }
}

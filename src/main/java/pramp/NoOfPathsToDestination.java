package pramp;

/**
 * Created by utkarsh on 15/01/18.
 */
public class NoOfPathsToDestination {


  static class Solution {

    static int numOfPathsToDest(int n) {
      // your code goes here
      if (n == 1 || n == 0) {
        return n;
      }

      return move(n - 1, n - 1, 0);


    }

    //0,0 - > n,n
    static int move(int x, int y, int paths) {

      if (x < 0 || y < 0) {
        return 0;
      }

      if (y > x) {
        return 0;
      }

      if (x == 1 && y == 0) {
        return 1;
      }

      paths += move(x, y - 1, paths) + move(x - 1, y, paths);

      return paths;


    }

    public static void main(String[] args) {

    }

  }

  static class OptimizedSolution {

    static int numOfPathsToDest(int n) {
      // your code goes here
      if (n == 1 || n == 0) {
        return n;
      }

      Integer[][] data = new Integer[n][n];

      return move(n - 1, n - 1, 0, data);


    }

    //0,0 - > n,n
    static int move(int x, int y, int paths, Integer[][] data) {

      if (x < 0 || y < 0) {
        return 0;
      }

      if (null != data[x][y]) {
        return data[x][y];
      }

      if (y > x) {
        return 0;
      }

      if (x == 1 && y == 0) {
        return 1;
      }

      paths += move(x, y - 1, paths, data) + move(x - 1, y, paths, data);

      if (null == data[x][y]) {
        data[x][y] = paths;
      }
      return paths;


    }

    public static void main(String[] args) {

    }

  }

}

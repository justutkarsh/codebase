package companies.vizury;

/**
 * Created by utkarsh on 14-09-2016.
 */
public class KCointPath {

    public static void main(String[] args) {
        int[][] M = {{1, 2, 3}, {4, 2, 2}, {5, 3, 1}};
        int R = M.length, C = M[0].length;

        System.out.println(findPaths(M, 0, 0, 9));
        //  System.out.println(findPathsDP(M,R,9));

    }
//[ 1 2 3
//  4 2 2
//  5 3 1 ]
//
//    k = 9
//    no of paths = 2
//            1->2->2->3->1
//            1->2->3->2->1

    //findPaths(i,j,k) = number of ways of finding paths from i,j to R,C collecting k coints

    static int findPathsNattu(int[][] M, int i, int j, int k) {
        int R = M.length, C = M[0].length;
        if (i < R && j < C) {
            k = k - M[i][j];
            if (i == R - 1 && j == C - 1 && k == 0)
                return 1;
            else
                return findPaths(M, i + 1, j, k) + findPaths(M, i, j + 1, k);

        } else return 0;
    }

    static int findPaths(int[][] M, int i, int j, int k) {
        int R = M.length, C = M[0].length;
        if (i < R && j < C) {
            if (i == R - 1 && j == C - 1 && k == M[i][j])
                return 1;
            else
                return findPaths(M, i + 1, j, k) + findPaths(M, i, j + 1, k);

        } else return 0;
    }


//    int[][] buffer;
//[1 2 3
// 4 2 2
// 5 3 1]
//
//
//    buffer[1][1]=buffer[0][1]+buffer[1][0]
//            =buffer[-1][1]+buffer[0][0]+buffer[0][0]+buffer[0][-1]
//
//


    //  buffer[0][0]=0;

    static int findPathsDP(int[][] M, int buffer[][][], int i, int j, int k) {
        if (i < 0 || j < 0) return 0;
        if (i == 0 && j == 0) {
            if (k == M[i][j]) {
                return 1;
            }
        }
        if (buffer[i][j][k] != 0)
            return buffer[i][j][k];

        buffer[i][j][k] = findPathsDP(M, buffer, i - 1, j, k - M[i][j])
                + findPathsDP(M, buffer, i, j - 1, k - M[i][j]);
        return buffer[i][j][k];
    }


}

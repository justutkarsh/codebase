package companies.amazon;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by utkarsh on 12-09-2016.
 */
// Java program to count islands in boolean 2D matrix

class Islands {
    //No of rows and columns
    private int ROW = 5, COL = 5;

    public Islands(int ROW, int COL) {
        this.ROW = ROW;
        this.COL = COL;
    }

    // A function to check if a given cell (row, col) can
    // be included in DFS
    boolean isSafe(int M[][], int row, int col,
                   boolean visited[][]) {
        // row number is in range, column number is in range
        // and value is 1 and not yet visited
        return (row >= 0) && (row < ROW) &&
                (col >= 0) && (col < COL) &&
                (M[row][col] == 1 && !visited[row][col]);
    }


    // A utility function to do DFS for a 2D boolean matrix.
    // It only considers the 8 neighbors as adjacent vertices
    void DFS(int M[][], int row, int col, boolean visited[][]) {
        // These arrays are used to get row and column numbers
        // of 8 neighbors of a given cell


        int rowNbr[] = new int[]{-1, -1, -1, 0, 0, 1, 1, 1};
        int colNbr[] = new int[]{-1, 0, 1, -1, 1, -1, 0, 1};

        // Mark this cell as visited
        visited[row][col] = true;

        // Recur for all connected neighbours
        for (int k = 0; k < 8; ++k)
            if (isSafe(M, row + rowNbr[k], col + colNbr[k], visited))
                DFS(M, row + rowNbr[k], col + colNbr[k], visited);

    }

    void DFS1(int M[][], int row, int col, boolean visited[][],int size) {
        // These arrays are used to get row and column numbers
        // of 8 neighbors of a given cell

        int rowNbr[] = new int[]{-1, -1, -1, 0, 0, 1, 1, 1};
        int colNbr[] = new int[]{-1, 0, 1, -1, 1, -1, 0, 1};

        // Mark this cell as visited
        size++;
        if(size>maxSize)
            maxSize=size;

        visited[row][col] = true;

        // Recur for all connected neighbours
        for (int k = 0; k < 8; ++k)
            if (isSafe(M, row + rowNbr[k], col + colNbr[k], visited)){
                DFS1(M, row + rowNbr[k], col + colNbr[k], visited,size);
            }

    }

    void BFSUsingQueue(int M[][], int row, int col, boolean visited[][],int size) {
        // These arrays are used to get row and column numbers
        // of 8 neighbors of a given cell
        Queue<Integer> queue = new LinkedList<>();
        int rowNbr[] = new int[]{-1, -1, -1, 0, 0, 1, 1, 1};
        int colNbr[] = new int[]{-1, 0, 1, -1, 1, -1, 0, 1};

        // Mark this cell as visited
        size++;
        if(size>maxSize)
            maxSize=size;

        visited[row][col] = true;

        // Recur for all connected neighbours
        queue.offer(M[row][col]);
        while(!queue.isEmpty())


            for (int k = 0; k < 8; ++k)
            if (isSafe(M, row + rowNbr[k], col + colNbr[k], visited)){
                DFS1(M, row + rowNbr[k], col + colNbr[k], visited,size);
            }

    }


    // The main function that returns count of islands in a given
    //  boolean 2D matrix
    int countIslands(int M[][]) {
        // Make a bool array to mark visited cells.
        // Initially all cells are unvisited
        boolean visited[][] = new boolean[ROW][COL];


        // Initialize count as 0 and travese through the all cells
        // of given matrix
        int count = 0;
        for (int i = 0; i < ROW; ++i)
            for (int j = 0; j < COL; ++j)
                if (M[i][j] == 1 && !visited[i][j]) // If a cell with
                {                                 // value 1 is not
                    // visited yet, then new island found, Visit all
                    // cells in this island and increment island count
                    DFS(M, i, j, visited);
                    ++count;
                }

        return count;
    }


    int size = 0,maxSize=Integer.MIN_VALUE;
    int largestIsland(int M[][]) {

        // Make a bool array to mark visited cells.
        // Initially all cells are unvisited
        boolean visited[][] = new boolean[ROW][COL];


        // Initialize count as 0 and travese through the all cells
        // of given matrix

        for (int i = 0; i < ROW; ++i)
            for (int j = 0; j < COL; ++j)
                if (M[i][j] == 1 && !visited[i][j]) // If a cell with
                {                                 // value 1 is not
                    // visited yet, then new island found, Visit all
                    // cells in this island and increment island count
                    DFS1(M, i, j, visited,0);
                }

        return maxSize;
    }


    int largestIslandUsingQueue(int M[][]) {

        // Make a bool array to mark visited cells.
        // Initially all cells are unvisited
        boolean visited[][] = new boolean[ROW][COL];


        // Initialize count as 0 and travese through the all cells
        // of given matrix

        for (int i = 0; i < ROW; ++i)
            for (int j = 0; j < COL; ++j)
                if (M[i][j] == 1 && !visited[i][j]) // If a cell with
                {                                 // value 1 is not
                    // visited yet, then new island found, Visit all
                    // cells in this island and increment island count
                    DFS1(M, i, j, visited,0);
                }

        return maxSize;
    }


}

public class LargestRegionMatrix {

    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        //rows
//        int M = scanner.nextInt();
//
//        int N = scanner.nextInt();
//
//        int [][] matrix = new int[M][N];
//
//        for (int i = 0; i < M; i++) {
//            for(int j=0;j<N;j++)
//            {
//                matrix[i][j]=scanner.nextInt();
//            }
//        }

        int temp[][] = new int[][]{
                {1, 1, 0, 0, 0},
                {0, 1, 1, 0, 1},
                {1, 0, 0, 1, 1},
                {0, 0, 0, 0, 0},
                {1, 0, 1, 0, 1}
        };

        // matrix = temp;
      //  temp = new int[][]{{1, 1}, {1, 1}};
        System.out.println(Arrays.deepToString(temp));

        // Islands I = new Islands(M,N);
        Islands I = new Islands(temp.length, temp[0].length);
        System.out.println("Maximum island is: " + I.largestIsland(temp));

    }
}

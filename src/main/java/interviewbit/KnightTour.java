package interviewbit;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by utkarsh on 20-09-2016.
 */
public class KnightTour {

    public static void main(String[] args) {
        Solution s = new Solution();
     //   System.out.println(s.knight(8, 8, 1, 1, 8, 8));
     //   System.out.println(s.knight(1, 1, 1, 1, 1, 1));
         System.out.println(s.knight(2, 20, 1,18, 1,5));
    }

    static class Solution {
        static class K {
            public int x, y;

            @Override
            public String toString() {
                return "(" + x + "," + y + ")";
            }

            public K(int x, int y) {
                this.x = x;
                this.y = y;
            }
        }

        public int knight(int N, int M, int x1, int y1, int x2, int y2) {

            boolean visited[][] = new boolean[N + 1][M + 1];
            int vert[] = {-2, -2, -1, -1, 1, 1, 2, 2};
            int hor[] = {1, -1, 2, -2, 2, -2, 1, -1};

            int count = 0;
            Queue<K> queue = new LinkedList<>();
            K k = new K(x1, y1);


            queue.offer(k);
            queue.offer(null);

            while (!queue.isEmpty()) {
                K element = queue.poll();
                if (element == null) {
                    if(!queue.isEmpty())
                    queue.offer(null);
                    count++;
                    System.out.println(Arrays.deepToString(queue.toArray()));
                } else {

                    if (element.x == x2 && element.y == y2) return count;
                    visited[element.x][element.y] = true;
                    for (int i = 0; i < 8; i++) {
                        int newx = element.x + hor[i];
                        int newy = element.y + vert[i];
                        if (newx <= N && newx > 0 && newy <= M && newy > 0 && !visited[newx][newy]) {
                            queue.offer(new K(newx, newy));
                        }
                    }
                }
            }
            return -1;
        }
    }
}


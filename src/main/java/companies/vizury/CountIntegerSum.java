package companies.vizury;

/**
 * Created by utkarsh on 21-09-2016.
 */
public class CountIntegerSum {
    //8,3    6,1,1

    static int ways(int n, int c, int min) {
        int ways = 0;

        if (c == 1) return 1;

        for (int i = min; i < n; i++) {
            ways += ways(n - i, c - 1, i);

        }
        return ways;


    }

    public static void main(String[] args) {

        System.out.println(ways(8, 3, 1));
    }


}

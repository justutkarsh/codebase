package interviewcake;

import java.util.Arrays;
import java.util.Set;

/**
 * Created by utkarsh on 26-08-2016.
 */
public class CoinChange {
    /*
for amount=4 (4¢) and denominations=[1,2,3](11¢, 22¢ and 33¢),
 your program would output 4—the number of ways to make 44¢ with those denominations:
1¢, 1¢, 1¢, 1¢
1¢, 1¢, 2¢
1¢, 3¢
2¢, 2¢



     http://algorithms.tutorialhorizon.com/files/2015/06/Coin-Change-Problem.jpg*/


    public static void main(String[] args) {

        int amount = 5;
        int[] denominations = {1, 2, 3};

       System.out.println(make(amount, denominations));
        System.out.println(makeOptimizedStorage(amount, denominations));



        amount = 10;
        denominations = new int[]{2, 5, 3, 6};

       // System.out.println(make(amount, denominations));
        System.out.println(makeOptimizedStorage(amount, denominations));



    }

    private static int make(int amount, int[] coins) {
        int[][] dynamicstorage = new int[coins.length + 1][amount + 1];

        for (int i = 0; i <= coins.length; i++) {
            dynamicstorage[i][0] = 1;
        }

        //this might be unnecessary as by default arrays are initialized to 0
        for (int i = 1; i <= amount; i++) {
            dynamicstorage[0][i] = 0;
        }

        print(dynamicstorage);
        System.out.println("------");

        for (int i = 1; i <= coins.length; i++) {
            for (int j = 1; j <= amount; j++) {
                if (j < coins[i - 1])
                    dynamicstorage[i][j] = dynamicstorage[i - 1][j];
                else
                    dynamicstorage[i][j] = dynamicstorage[i - 1][j] + dynamicstorage[i][j - coins[i - 1]];

                print(dynamicstorage);
                System.out.println("------");
            }
        }
        return dynamicstorage[coins.length][amount];


    }


    private static int makeOptimizedStorage(int amount, int[] coins) {
        int[] dynamicstorage = new int[amount + 1];
        dynamicstorage[0] = 1;
        for (int i = 1; i <= coins.length; i++) {
            System.out.println(Arrays.toString(dynamicstorage));
            System.out.println("----");

            for (int j = coins[i-1]; j <= amount; j++) {
                //if(j>=coins[i-1]) //to avoid this condition we are looping from j=i
                dynamicstorage[j] = dynamicstorage[j] + dynamicstorage[j - coins[i - 1]];
            }
        }
        return dynamicstorage[amount];
    }

    private static void print(int[][] arr) {
        for (int[] l : arr) {
            System.out.println(Arrays.toString(l));
        }
    }
}

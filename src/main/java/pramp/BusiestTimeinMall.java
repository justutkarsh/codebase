package pramp;

/**
 * Created by utkarsh on 07/01/18.
 */


public class BusiestTimeinMall {



  static class Solution {

    static int findBusiestPeriod(int[][] data) {
      // your code goes here

      int currentTimeStamp=-1,currSum=0,earliestTimeStamp = -1,maxSum=Integer.MIN_VALUE;

      for(int i=0;i<data.length;i++)
      {



        if(data[i][2] == 1){
          currSum+=data[i][1];

        } else{
          currSum-=data[i][1];
        }

        if(i < data.length-1 && data[i][0] == data[i+1][0])
          continue;

        if(currSum>maxSum)
        {
          maxSum=currSum;
          earliestTimeStamp = data[i][0];
        }


      }
      return earliestTimeStamp;
    }

    public static void main(String[] args) {

    }

  }


}

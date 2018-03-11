package pramp;

/**
 * Created by utkarsh on 02/02/18.
 */


public class DeletionDistance {

  static class Solution {


    //L=find the maximum lengthe subsequence
    // A+B-2*L

    static int deletionDistance(String str1, String str2) {
      // your code goes here

      int maxSequence = maxLengthSubSequence(str1,str2);
      return str1.length()+ str2.length()-2*maxSequence;

    }


    //dog & frog
    //cat & cadog
    static int maxLengthSubSequence(String str1, String str2){

      if(str1==null || str1.length()==0 || str2 == null || str2.length() == 0 ) return 0;

      if(str1.charAt(0) == str2.charAt(0))
      {

        return 1+ maxLengthSubSequence(str1.substring(1),str2.substring(1));

      }

      else{

        return Math.max(maxLengthSubSequence(str1,str2.substring(1)),
            maxLengthSubSequence(str1.substring(1),str2));


      }




    }

    public static void main(String[] args) {

    }

  }

}

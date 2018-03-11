package pramp;
/**
 * Created by utkarsh on 13/02/18.
 */
public class BracketMatch {


  static class Solution {
    //
    static int bracketMatch(String text) {
      // your code goes here
      //just.utkarsh@gmail.com

      int close=0,open=0;


      for(char c:text.toCharArray()){


        if(c=='(') open++;
        if(c==')')
        {
          close++;
          if(open>=close){
            open--;
            close--;
          }
        }



      }
      return open+close;


    }

    public static void main(String[] args) {

    }

  }
}

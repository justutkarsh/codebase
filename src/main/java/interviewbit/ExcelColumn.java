package interviewbit;

/**
 * Created by utkarsh on 16-10-2016.
 */
public class ExcelColumn {
    static class Solution {
        public int titleToNumber(String a) {

            char[] buffer = a.toCharArray();
            int result =0,j=0;
            for(int i=buffer.length-1;i>=0;i--){
                int digit = buffer[i]-'A'+1;
                result = (int) (result + (Math.pow(26,j))*digit);
                j=j+1;
            }
            return result;
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.titleToNumber("A"));
    }
}

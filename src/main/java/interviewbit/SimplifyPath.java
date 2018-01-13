package interviewbit;

import java.util.LinkedList;
import java.util.Stack;

/**
 * Created by utkarsh on 20-09-2016.
 */
public class SimplifyPath {

    static class Solution {
        public static void main(String[] args) {
            Solution s = new Solution();
            String buffer = "/a/./b/../../c/";
            buffer="/a/b/c/..";
            System.out.println(s.simplifyPath(buffer));
        }

        public String simplifyPath(String a) {
            String[] buffer = a.split("/");
            Stack<String> stack = new Stack<>();
            StringBuffer sb = new StringBuffer();
            for (String s : buffer) {
                if ("".equals(s)) {
                    if (!stack.isEmpty()) stack.pop();
                }
                    else if (".".equals(s)) continue;
                    else if (!s.isEmpty()) {
                        stack.push(s);
                    }

            }
           if(stack.isEmpty()) sb.append("/");
            while (!stack.isEmpty()) {
                sb.insert(0,stack.pop());
                sb.insert(0,"/");
            }
         return sb.toString();
        }
    }
}

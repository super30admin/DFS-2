import java.util.*;
// Time Complexity : O(N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
public class DecodeString {
    public String decodeString(String s) {
        Stack<String> str = new Stack<>();
        Stack<Integer> num = new Stack<>();
        int curNum =0;
        String curStr = "";
        int size = s.length();
        for(int index =0; index < size; index++){
            char ch = s.charAt(index);
            if(Character.isDigit(ch)){
                curNum = (curNum * 10) + (ch - '0');
            }
            else if(ch == '['){
                num.push(curNum);
                str.push(curStr);
                curNum = 0;
                curStr = "";
            }
            else if(ch == ']'){
                StringBuffer newStr = new StringBuffer();
                int times = num.pop();
                for(int i = 0; i < times; i++){
                    newStr.append(curStr);
                }
                curStr = str.pop() + newStr; 
            }
            else {
                curStr +=  ch;
            }
        }
        return curStr;
    }
}
// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : Yes


// Your code here along with comments explaining your approach
import java.util.*;

public class DecodeString {

        public String decodeString(String s) {
    
            Stack<Integer> numSt = new Stack<>();
            Stack<StringBuilder> strSt = new Stack<>();
            StringBuilder currStr = new StringBuilder();
            int currNum = 0;
    
            for (char ch : s.toCharArray()){
                if (Character.isDigit(ch)){
                    currNum = currNum *10 + ch - '0';
                } else if (ch == '['){
                    strSt.push(currStr);
                    numSt.push(currNum);
                    currStr = new StringBuilder();
                    currNum = 0;
                } else if (ch == ']'){
                    int cnt = numSt.pop();
                    StringBuilder re = new StringBuilder();
                    for (int i =0;i<cnt;i++){
                        re.append(currStr);
                    }
                    StringBuilder parent = strSt.pop();
                    currStr = parent.append(re);
    
                    
                } else {
                    currStr.append(ch);
                }
            }
        return currStr.toString();
        }
    
    
}

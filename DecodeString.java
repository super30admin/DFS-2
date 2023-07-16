// Time Complexity : O(l) where l is the length of the decoded string
// Space Complexity : O(l) where l is the length of the decoded string
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :
import java.util.Stack;

public class DecodeString {
    public String decodeString(String s) {
        Stack<Integer> numst = new Stack<>();
        Stack<StringBuilder> strst = new Stack<>();

        StringBuilder currStr = new StringBuilder();
        int currNum = 0;

        for(int i =0; i < s.length(); i++){
            Character c = s.charAt(i);
            //digit
            if(Character.isDigit(c)){
                currNum = currNum * 10 + c -'0';
            }
            else if(c == '['){
                numst.push(currNum);
                strst.push(currStr);

                //reset
                currNum = 0;
                currStr = new StringBuilder();
            }
            else if(c == ']'){
                int count = numst.pop();
                StringBuilder child = new StringBuilder();
                for(int k =0; k < count; k++){
                    child = child.append(currStr);
                }
                currStr = strst.pop().append(child);
            }
            else if(Character.isLetter(c)){
                currStr.append(c);
            }
        }
        return currStr.toString();
    }

    //recursive implementation
    class DecodeStringRecursive {
        private int idx;

        public String decodeString(String s) {
            StringBuilder currStr = new StringBuilder();
            int currNum = 0;
            while (idx < s.length()) {

                Character c = s.charAt(idx);
                idx++;

                if (Character.isDigit(c)) {
                    currNum = currNum * 10 + c - '0';
                } else if (c == '[') {
                    String child = decodeString(s);
                    StringBuilder newStr = new StringBuilder();
                    for (int k = 0; k < currNum; k++) {
                        newStr.append(child);
                    }
                    currStr.append(newStr);
                    currNum = 0;
                } else if (c == ']') {
                    return currStr.toString();
                } else if (Character.isLetter(c)) {
                    currStr.append(c);
                }
            }
            return currStr.toString();
        }
    }
}

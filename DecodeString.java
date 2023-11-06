// Time Complexity :O(Length of Output String)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None

public class DecodeString {
    class Solution {
        public String decodeString(String s) {
            Stack<Integer> numStack = new Stack<>();
            Stack<StringBuilder> strStack = new Stack<>();
            StringBuilder str = new StringBuilder();
            int num = 0;

            int strLen = s.length();

            for(int i = 0; i < strLen; i++){
                char c = s.charAt(i);
                if(Character.isDigit(c)){
                    num = (num * 10) + (int)c - '0';
                }
                else if(c == '['){
                    numStack.push(num);
                    strStack.push(str);
                    num = 0;
                    str = new StringBuilder();
                }
                else if(c == ']'){
                    int poppedNum = numStack.pop();
                    StringBuilder baby = new StringBuilder();
                    for(int j = 0; j < poppedNum; j++){
                        baby.append(str);
                    }
                    str = strStack.pop().append(baby);
                }
                else{
                    str.append(c);
                }
            }
            return str.toString();
        }
    }
}
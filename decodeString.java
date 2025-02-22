// Problem2 (https://leetcode.com/problems/decode-string/)

// Time Complexity : O(m + n) where m is product of numbers of string and n is length of the string
// Space Complexity : O(m + n) 
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// Your code here along with comments explaining your approach in three sentences only
/*
 * Here, two stacks are created one for storing the numbers and other for storing the strings. While moving the string, if char at
 * place is digit then compute currNum, if it is [ the  add currNum to num stack and currStr to string stack and change currNum to
 * 0 and currStr to empty, if char is ] then take the number out of num stack and append currStr to child num times and  take str 
 * out of strst and add present currStr to it and if ch is a char just append it to currStr. Finally, return currStr.
 */
class Solution {
    public String decodeString(String s) {
        Stack<Integer> numSt = new Stack<>();
        Stack<StringBuilder> strSt = new Stack<>();
        int currNum = 0;
        StringBuilder currStr = new StringBuilder();
        for(int i = 0; i<s.length();i++){
            char ch = s.charAt(i);
            if(Character.isDigit(ch)){
                currNum = currNum * 10 + ch-'0';
            }
            else if(ch == '['){
                numSt.push(currNum);
                strSt.push(currStr);
                currNum = 0;
                currStr = new StringBuilder();
            }
            else if(ch == ']'){
                int num  = numSt.pop();
                StringBuilder child = new StringBuilder();
                for(int j = 0;j<num;j++){
                    child.append(currStr);
                }
                currStr = strSt.pop();
                currStr.append(child);
            }
            else{
                currStr.append(ch);
            }
        }

        return currStr.toString();

    }
}

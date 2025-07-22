import java.util.Stack;

/*
Approach - Iterative with Stack
Time Complexity - O(N) * product of num where N is length of String
Space Complexity - O(N)
Did this code successfully run on Leetcode :  Yes
Any problem you faced while coding this :  No
*/
public class DecodeString_LC_394 {
    public String decodeString(String s) {
        Stack<Integer> numStack = new Stack<>();
        Stack<StringBuilder> strStack = new Stack<>();
        int n = s.length();
        int num = 0;
        StringBuilder  curStr = new StringBuilder();
        for(int i = 0; i<n ; i++){
            char c = s.charAt(i);
            if(Character.isDigit(c)) { //char is digit
                num = num * 10 + c-'0';
            } else if(c == ']') { // we need to process the string and combine with parent
                int cnt = numStack.pop();
                StringBuilder decodedString = new StringBuilder();
                for(int k = 0; k<cnt; k++) {
                    decodedString.append(curStr);
                }
                curStr = strStack.pop().append(decodedString);

            } else if(c == '[') { // we need to restore curString to empty and num to 0 for incoming string
                strStack.push(curStr);
                numStack.push(num);
                curStr = new StringBuilder();
                num =0;

            } else { //its character append it to curString
                curStr.append(c);
            }
        }
        return curStr.toString();
    }
}
/* Recursive

class Solution {
    int i = 0;
    public String decodeString(String s) {
        int n = s.length();
        int num = 0;
        StringBuilder  curStr = new StringBuilder();
        while(i < n) {
            char c = s.charAt(i);
            if(Character.isDigit(c)) {
                num = num * 10 + c - '0';
                i++;
            } else if(c == '[') {
                i++;
                String child = decodeString(s);
                StringBuilder decodedString = new StringBuilder();
                for(int k = 0 ; k < num; k++) {
                    decodedString.append(child);
                }
                //combine with  parent
                curStr.append(decodedString);
                num = 0;


            } else if(c == ']') { //baby finished return to main parent
                i++;
                return curStr.toString();

            } else {
                curStr.append(c);
                i++;
            }
        }
        return curStr.toString();
    }
} */
// Time Complexity : O(n) - length of output string
// Space Complexity : O(m) - no. of openning brackets
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

//https://leetcode.com/problems/decode-string/
//394. Decode String

class Solution {
    public String decodeString(String s) {
        Stack<StringBuilder> str = new Stack<StringBuilder>();
        Stack<Integer> number = new Stack<Integer>();
        StringBuilder currStr = new StringBuilder();
        // currStr.append("");
        int num = 0;

        // iterate through the string s

        for (int j = 0; j < s.length(); j++) {
            char c = s.charAt(j);
            if (Character.isDigit(c)) {
                num = num * 10 + c - '0';
            } else if (c == '[') {
                str.push(currStr);
                number.push(num);
                // rest currStr and num
                num = 0;
                currStr = new StringBuilder();
            } else if (c == ']') {
                int n = number.pop();
                StringBuilder temp = new StringBuilder();
                for (int i = 0; i < n; i++) {
                    temp.append(currStr);
                }
                StringBuilder parent = str.pop();
                currStr = parent.append(temp);
            } else {
                currStr.append(c);
            }
        }

        return currStr.toString();
    }
}

/*
 * class Solution {
 * public String decodeString(String s) {
 * Stack<StringBuilder> str = new Stack<StringBuilder>();
 * Stack<Integer> number = new Stack<Integer>();
 * StringBuilder currStr = new StringBuilder();
 * currStr.append("");
 * int num = 0;
 * char[] chars = s.toCharArray();
 * //iterate through the string s
 * 
 * for(char c : chars){
 * if(Character.isDigit(c)){
 * num = (int)c;
 * }else if(c == '['){
 * str.push(currStr);
 * number.push(num);
 * //rest currStr and num
 * num = 0;
 * currStr = new StringBuilder();
 * currStr.append("");
 * }else if(c == ']'){
 * int n = number.pop();
 * for(int i = 0; i < n-1; i++){
 * currStr.append(currStr);
 * }
 * currStr.append(str.pop());
 * }else{
 * currStr.append(c);
 * }
 * }
 * return currStr.toString();
 * }
 * }
 */

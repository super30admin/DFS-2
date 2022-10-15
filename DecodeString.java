//iterative, bfs
// Time Complexity : O(n*k) n = length of string, k = max number in string
// Space Complexity : O(n)
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :
class Solution {
    public String decodeString(String s) {
        if(s == null || s.length() == 0) return s;

        Stack<StringBuilder> strStack = new Stack<>();
        Stack<Integer> numStack = new Stack<>();

        int num = 0;
        StringBuilder currStr = new StringBuilder();

        char[] charArr = s.toCharArray();

        for(char c : charArr) {
            if(Character.isDigit(c)) {
                num = num*10 + (c - '0');
            }
            else if(c == '['){
                numStack.push(num);
                strStack.push(currStr);
                num = 0;
                currStr = new StringBuilder();
            }
            else if(c == ']') {
                int popNum = numStack.pop();
                StringBuilder newStr = new StringBuilder();
                for(int i = 0; i<popNum; i++) {
                    newStr.append(currStr);
                }
                currStr = strStack.pop().append(newStr);
            } else {
                currStr.append(c);
            }
        }
        return currStr.toString();
    }
}

// Time Complexity :  O(n*k) where n is length of string and k is maximum number given in string
// Space Complexity : O(n)
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :

class Solution {
    int i;
    public String decodeString(String s) {
        if(s == null || s.length() == 0) return s;

        int num = 0;
        StringBuilder currStr = new StringBuilder();

        while(i<s.length()) {
            char c = s.charAt(i);
            if(Character.isDigit(c)) {
                num = num*10 + (c - '0');
                i++;
            }
            else if(c == '['){
                i++;
                String decoded = decodeString(s);

                StringBuilder newStr = new StringBuilder();
                for(int j = 0; j<num; j++) {
                    newStr.append(decoded);
                }
                currStr.append(newStr);
                num = 0;
            }
            else if(c == ']') {
                i++;
                return currStr.toString();
            } else {
                currStr.append(c);
                i++;
            }
        }
        return currStr.toString();
    }
}
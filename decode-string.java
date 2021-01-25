// recursive solution
// Time Complexity : O(x*y) x is string length and y is max length of [] type substrings
// Space Complexity : O(n) where n is length of string;
// Did this code successfully run on Leetcode : Yes

class Solution {
    int i=0;
    public String decodeString(String s) {
        if(s == null || s.length() == 0)
            return s;
        StringBuilder currStr = new StringBuilder();
        int num = 0;
        while(i < s.length()){
            char c = s.charAt(i);
            if(Character.isDigit(c)){
                num = num*10 + c - '0';
                i++;
            }
            else if(c == '['){
                i++;
                String innerStr = decodeString(s);
                StringBuilder newStr = new StringBuilder();
                for(int x=0; x<num ; x++)
                    currStr.append(innerStr);
                num = 0;
            }
            else if(c == ']'){
                i++;
                return currStr.toString();
            }
            else{
                currStr.append(c);
                i++;
            }
        }
        return currStr.toString();
    }
}
/*
// Time Complexity : O(x*y) x is string length and y is max length of [] type substrings
// Space Complexity : O(m + n) where m is size of string stack and n is size of num stack
// Did this code successfully run on Leetcode : Yes

class Solution {
    public String decodeString(String s) {
        if(s == null || s.length() == 0)
            return s;
        Stack<Integer> numStack = new Stack<>();
        Stack<StringBuilder> strStack = new Stack<>();
        StringBuilder currStack = new StringBuilder();
        int num = 0;
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(Character.isDigit(c)){
                num = num*10 + c - '0';
            }
            else if(c == '['){
                numStack.add(num);
                strStack.add(currStack);
                num = 0;
                currStack = new StringBuilder();
            }
            else if(c == ']'){
                int t = numStack.pop();
                StringBuilder tempStr = new StringBuilder();
                for(int x=0; x<t ; x++)
                    tempStr.append(currStack);
                currStack = strStack.pop().append(tempStr);
            }
            else{
                currStack.append(c);
            }
        }
        return currStack.toString();
    }
}
*/
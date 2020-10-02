// Time Complexity : O(n) where n is the length of string
// Space Complexity :O(n)
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :

// Your code here along with comments explaining your approach
/*
 we basically maintain two stacks and two placeholder currnum and currstr


 when we encounter 
 1) number we get the whole number
 2) [ we push the num and str to their respective stacks and reset the currNum and currstr
 since we have encountered a new problem
 3) ] we get the stored currnum and currstr and append it currnum times accordingly
 4) else we just add to the currstr


 
/*
class Solution {
    public String decodeString(String s) {

        Stack<String> strStack = new Stack<>();
        Stack<Integer> intStack = new Stack<>();
        String currStr = "";
        int currNum = 0;

        for (int idx = 0; idx < s.length(); idx++) {

            char ch = s.charAt(idx);

            if (Character.isDigit(ch)) {
                currNum = currNum * 10 + ch - '0';

            } else if (ch == '[') {

                strStack.push(currStr);
                intStack.push(currNum);
                currNum = 0;
                currStr = "";

            } else if (ch == ']') {
                String prev = strStack.pop();
                int times = intStack.pop();
                String temp = "";
                temp = temp + prev;
                for (int i = 0; i < times; i++) {
                    temp += currStr;
                }
                currStr = temp;
            } else
                currStr = currStr + ch;

        }
        return currStr;
    }

}
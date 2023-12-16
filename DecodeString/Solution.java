// Time Complexity :  O(k*l) -> O(L) where L is length of resultant string
// Space Complexity : O(L)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

/**
 * Using 2 stacks
 */
class Solution {
    public String decodeString(String s) {

        Stack<StringBuilder> strSt = new Stack<>();
        Stack<Integer> numSt = new Stack<>();

        int currNum = 0;
        StringBuilder currStr = new StringBuilder();

        for(int i=0; i<s.length(); i++) {
            char c = s.charAt(i);

            if(Character.isDigit(c)) {
                currNum = currNum * 10 + c - '0';
            }
            else if(c == '[') {
                strSt.push(currStr);
                numSt.push(currNum);
                currNum = 0;
                currStr = new StringBuilder();
            }
            else if(c == ']') {
                StringBuilder temp = new StringBuilder();
                int num = numSt.pop();
                for(int j=0; j<num; j++) {
                    temp.append(currStr);
                }

                currStr = strSt.pop();
                currStr.append(temp);
            }
            else {
                currStr.append(c);
            }
        }

        return currStr.toString();
    }
}

/**
 * Using recursion
 */

/*
// Time Complexity :  O(k*l) -> O(L) where L is length of resultant string
// Space Complexity : O(L)
class Solution {

    int i=0;
    public String decodeString(String s) {

        int currNum = 0;
        StringBuilder currStr = new StringBuilder();

        while(i < s.length()) {
            char c = s.charAt(i);
            i++;
            if(Character.isDigit(c)) {
                currNum = currNum * 10 + c - '0';
            }
            else if(c == '[') {
                String result = decodeString(s);
                for(int i=0; i<currNum; i++) {
                    currStr.append(result);
                }
                currNum = 0;
            }
            else if(c == ']') {
                return currStr.toString();
            }
            else {
                currStr.append(c);
            }
        }

        return currStr.toString();
    }
}*/

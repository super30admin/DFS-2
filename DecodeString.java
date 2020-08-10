/** 
Problem: Decode string
Did it run on LeetCode: Yes

Time Complexity : O(n), where n is the length of the given string
Space Complexity : O(n), where n is the length of the given string

Approach:
1. We use 2 stacks, one for numbers, and one for strings.
2. Whenever, we encounter an opening bracket, we push the numbers into number stack and string into string stack and make them 0, and empty, respectively.
3. Now, when we encounter a closing bracket, we pop the number from the top of number stack, and append the current string those many number of times.
4. Later, we pop the top of the string stack and append it to the current string.
*/


class Solution {
    public String decodeString(String s) {
        StringBuilder currStr = new StringBuilder();
        if(s == null || s.length() == 0) {
            return currStr.toString();
        }
        int num = 0;
        Stack<Integer> numStack = new Stack<>();
        Stack<StringBuilder> strStack = new Stack<>();
        for(int i = 0; i<s.length(); i++) {
            char c = s.charAt(i);
            if(Character.isDigit(c)) {
                num = num * 10 + c - '0';
            }
            else if(c == '[') {
                numStack.push(num);
                strStack.push(currStr);
                num = 0;
                currStr = new StringBuilder();
            }
            else if(c==']') {
                int numOfTimes = numStack.pop();
                StringBuilder newString = new StringBuilder();
                for(int k = 0; k < numOfTimes; k++) {
                    newString.append(currStr);
                }
                currStr = strStack.pop().append(newString);
            }
            else {
                currStr.append(c);
            }
        }
        return currStr.toString();
    }
}
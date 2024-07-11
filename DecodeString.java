// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
class Solution {
  public String decodeString(String s) {
    if(s == null || s.length() == 0) return "";

    Stack<StringBuilder> strStack = new Stack<>();
    Stack<Integer> numStack = new Stack<>();
    int num = 0;
    StringBuilder current = new StringBuilder();

    for(int i = 0; i<s.length(); i++) {
      char c = s.charAt(i);
      // If character is a digit, convert it to a number.
      if(Character.isDigit(c)) {
        num = num*10 + (c - '0');
      // If character is '[', push num and string into stack & reinitialise.
      }else if(c == '[') {
        numStack.push(num);
        num = 0;
        strStack.push(current);
        current = new StringBuilder();
      // If character is ']', pop num from stack and create new stack.
      // Append to new string and adjust current.
      }else if(c == ']') {
        int times = numStack.pop();
        StringBuilder newStr = new StringBuilder();
        for(int j = 0; j<times; j++) {
          newStr.append(current);
        }
        current = strStack.pop().append(newStr);
      // If character is an alphabet, append to string.
      }else {
        current.append(c);
      }
    }

    return current.toString();
  }
}
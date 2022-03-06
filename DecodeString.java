// TC: O(x*y) where is x is max product and y is max string length
// SC: O(x*y) 

// Approach: Push all the elments into stack till we see a closing bracket.
// Once we see a closing bracket, keep popping and adding it to a String until
// we find an opening bracket. At the opening bracket, we pop it out. 
// We keep popping till we keep finding numbers and keep storing them in digit.
// Then we create a string by mutliplying digit times the string. 
// We push this string back to the stack and continue iterating out original string
// and do the same thing again.

// LC- 394. Decode String

import java.util.*;

public class DecodeString {
  public String decodeString(String s) {
    if (s == null || s.length() == 0) {
      return "";
    }

    Stack<Character> stack = new Stack<>();

    for (int i = 0; i < s.length(); i++) {
      char ch = s.charAt(i);

      if (ch == ']') {
        // get String
        String curr = "";
        while (!stack.isEmpty() && stack.peek() != '[') {
          curr = stack.pop() + curr;
        }

        String newStr = "";

        // get number
        String digit = "";
        if (!stack.isEmpty()) {
          stack.pop();

          while (!stack.isEmpty() && Character.isDigit(stack.peek())) {
            digit = stack.pop() + digit;
          }

          int num = Integer.parseInt(digit);

          // get number * String

          for (int j = 0; j < num; j++) {
            newStr = newStr + curr;
          }

          curr = newStr;
        }

        // push back to stack
        for (int j = 0; j < curr.length(); j++) {
          stack.push(curr.charAt(j));
        }

      } else {
        stack.push(ch);
      }
    }

    String result = "";
    while (!stack.isEmpty()) {
      result = stack.pop() + result;
    }

    return result;
  }
}

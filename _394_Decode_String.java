/**** Method 1 ****/
//Time Complexity: O(n*k(max repeat count))
//Space Complexity: O(n*k)

//Successfully submitted in LeetCode

//As we loop through the string, we build numbers and characters until we hit an opening bracket. Then we push the number and current string into stacks and start fresh to build the enclosed string. When we hit a closing bracket, we pop the count and previous string, repeat the inner string, and stitch it back to continue.

import java.util.Stack;

public class _394_Decode_String {

  public String decodeString(String s) {
    Stack<Integer> stackInt = new Stack<>();

    Stack<StringBuilder> stackChar = new Stack<>();

    int n = 0;

    StringBuilder stb = new StringBuilder();

    for (char c : s.toCharArray()) {
      if (Character.isDigit(c)) {
        n = n * 10 + (c - '0');
      } else if (c == '[') {
        stackInt.push(n);
        n = 0;
        stackChar.push(stb);
        stb = new StringBuilder();
      } else if (c == ']') {
        int k = stackInt.pop();
        StringBuilder temp = stb;
        stb = stackChar.pop();
        while (k > 0) {
          stb.append(temp);
          k--;
        }
      } else {
        stb.append(c);
      }
    }

    return stb.toString();
  }
}

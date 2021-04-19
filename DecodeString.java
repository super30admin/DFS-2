// Time Complexity :O(Maxk*n)
// Space Complexity :O(Maxk*n)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :

// Your code here  with comments explaining your approach

class Solution {
  public String decodeString(String s) {
    Stack<Integer> counts = new Stack<>();
    Stack<String> result = new Stack<>();
    String res = "";
    int i = 0;

    while (i < s.length()) {
      if (Character.isDigit(s.charAt(i))) {
        int count = 0;
        // Check the value of digits and push in to stack
        while (Character.isDigit(s.charAt(i))) {
          count = 10 * count + (s.charAt(i) - '0');
          i++;
        }
        counts.push(count);
      }
      // push the string res identified so far
      else if (s.charAt(i) == '[') {
        result.push(res);
        res = "";
        i++;
      }
      // pop the count
      // append the string to a stringbuilder for count times
      // add the string to the res
      else if (s.charAt(i) == ']') {
        StringBuilder sb = new StringBuilder(result.pop());
        int count = counts.pop();
        for (int j = 0; j < count; j++) {
          sb.append(res);
        }
        res = sb.toString();
        i++;
      }
      // when s character is found add to res
      else {
        res += s.charAt(i);
        i++;
      }
    }
    return res;
  }
}
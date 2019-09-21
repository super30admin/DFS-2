/**
 * LeetCode Execution: No Problem
 * 
 * Time Complexity: O(n) n -> length of Sring
 * Space Complexity: O(n) for Recursion Stack
 * 
 * Case Missed: When we have double digits
 * 
 * Approach: Start pushing the characters into the stack, the processing begins when we encouter an ']'
 *           To process string we start popping and build a sub string, then extract the count associated with that string and generate theh string
 *            Push back the string to the stack (to take care of nested strings)
 * 
 * Personal Note: I liked the question and they it made me think about the solution/edge cases. I dry ran a program numerous times.
 *                Learned something novel while solving this question.
 */


class Solution {
  public String decodeString(String s) {
      
      if (s.length() < 1) return s;
      
      Stack<Character> stc = new Stack<>(); 
      
      char[] c = s.toCharArray();
      
      StringBuilder str = new StringBuilder();
      
      for (int i = 0; i < c.length; i++) {
          if (c[i] == ']') {
              stringHelper(stc);
          } else {
              stc.push(c[i]);
          }
      }
      
      // Empty Stack Here
      
      while(!stc.isEmpty()) {
          str.insert(0, Character.toString(stc.pop()));
      }
      
      return str.toString();
      
  }
  
  private void stringHelper(Stack<Character> s) {
      
      StringBuilder str = new StringBuilder();
      
      while(s.peek() != '[' && !s.isEmpty()) {
          str.insert(0, Character.toString(s.pop()));
      }
      
      // Popping Opening [
      s.pop();
      
      // Case for Double Digit
      StringBuilder ctr = new StringBuilder();
      
      while (!s.isEmpty() && Character.isDigit(s.peek())) {
          ctr.insert(0, Character.toString(s.pop()));
      }
      
      StringBuilder mainStr = new StringBuilder();
      int count = Integer.parseInt(ctr.toString());   
      
      for (int i = 0; i < count; i++) {
          mainStr.append(str);
      }
      
      //Push Back into the Stack (to take care of the nested strings)
      char[] c = (mainStr.toString()).toCharArray();
      
      for (int i = 0; i < c.length; i++) {
          s.push(c[i]);
      }
  }
}
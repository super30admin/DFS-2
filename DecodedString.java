// almost similar to nested list problem
// can be done both with dfs and bfs
// edge case: if length is 1, then 1 character or 1 integer -> s is a valid input
// maximum length of string is 30, such less number usually indicates brute force solution will work
// integers are range from 1 to 300
// constaints: none
// we need to handle the number in the string, so charAt(i) - '0'..if double or triple digit integer - handle with while

/*
    dfs 
    tc: O(l) l-> length of the string
    sc: O(l) {if input like 2[abc]}

    structure of code : dfs
    1. maintain two stacks of numbers and string 
    2. in the for loop iterating through the entire string 
    3. we know there will be a leading integer to an open bracket, so add integer to num stack and previous formed string to string stack
    4. when open bracket, pop the num stack get number append the currStr to string builder that many times and then append to currStr
    5. when i get a closed bracket, pop num and string and store it in the strings stack 
    6. pop and append to new string builder in the end
*/

class Solution {

  public String decodeString(String s) {
    Stack<Integer> num = new Stack<>();
    Stack<String> strings = new Stack<>();
    String currStr = "";
    int currNum = 0;

    for (int i = 0; i < s.length(); i++) {
      char c = s.charAt(i);
      if (Character.isDigit(c)) {
        currNum = currNum * 10 + c - '0';
      } else if (c == '[') {
        num.push(currNum);
        strings.push(currStr);
        currNum = 0;
        currStr = "";
      } else if (c == ']') {
        int times = num.pop();
        StringBuilder newstr = new StringBuilder();
        for (int k = 0; k < times; k++) {
          newstr.append(currStr);
        }
        currStr = strings.pop();
        currStr += newstr;
      } else {
        currStr += c;
      }
    }

    return currStr;
  }
}

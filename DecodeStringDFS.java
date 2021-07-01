//Time Complexity - O(nk)  where k is the maximum number in the string
//Space complexity - O(nk)


class Solution {
    public String decodeString(String s) {
      
      //null case
      if(s == null || s.length() == 0) return s;
      int num = 0;
      Stack<Integer> numStack = new Stack<>();
      Stack<StringBuilder> strStack = new Stack<>();
      StringBuilder currStr = new StringBuilder();
      for(int i=0;i<s.length();i++) {
        char c = s.charAt(i);
        if(Character.isDigit(c)) { // update the currStr
          num = num * 10 + c-'0';
        } else if(c =='[') { // push the num and curr str on stack
          numStack.push(num);
          strStack.push(currStr);
          num = 0;
          currStr = new StringBuilder();
        } else if(c == ']') { // pop the elements from both the stack and upadte  current str
          //num of times the string to be repeated
          int times = numStack.pop();
          StringBuilder newString = new StringBuilder();
          //repeat the str
          for(int j = 0 ; j< times; j++) {
            newString.append(currStr);
          }
          //append newley created string with its parent str
          StringBuilder parent  = strStack.pop();
          currStr = parent.append(newString);
        } else {
          currStr.append(c);
        }
      }
      return currStr.toString();
        
    }
}
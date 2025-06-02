// Time Complexity :O(n);
// Space Complexity :O(n);
class Solution {
    public String decodeString(String s) {
      Stack <Integer> num = new Stack<>();
      Stack <String> str = new Stack<>();
      String currStr = "";
      int currNum = 0;
      for(int i = 0; i < s.length(); i++){
          char c = s.charAt(i);
          if(Character.isDigit(c)){
              currNum = currNum * 10 + c - '0';
          } else if (c == '['){
              num.push(currNum);
              str.push(currStr);
              currNum = 0;
              currStr = "";
          } else if ( c == ']'){
              int times = num.pop();
              StringBuilder newStr = new StringBuilder();
              for(int j = 0;j < times; j++){
                   newStr.append(currStr);
              }
              currStr = str.pop();
              currStr += newStr;
          } else {
              currStr += c;
          }
      }
        return currStr;
    }
}


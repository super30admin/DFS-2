//using two stacks: one for counts and one for strings.
//build the decoded string by pushing/popping at each [ and ], repeating substrings as specified.
//Time complexity: O(n * k)
//Space complexity: O(n)

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

              // At the starting of square bracket push the past strings in string stack and num for future string in num stack

              num.push(currNum);

              str.push(currStr);

              currNum = 0;

              currStr = "";

          } else if ( c == ']'){

              // At end of square bracket process the past string

              int times = num.pop();

              StringBuilder newStr = new StringBuilder(); // newString = ""

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
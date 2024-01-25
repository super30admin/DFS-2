// Time Complexity : O(L)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes

import java.util.Stack;


public class StringDecode {
    public String decodeString(String s) {

      Stack<Integer> nextNo = new Stack <Integer>();
      Stack <StringBuilder> nextString = new Stack <StringBuilder>();

      int currNo = 0;
      StringBuilder currString =new StringBuilder();

      for(int i =0; i < s.length(); i++){
        char c = s.charAt(i);

        if(Character.isDigit(c)){
          currNo =  10*currNo + c -'0';
        }
        else if (c == ']'){
          int n =nextNo.pop();
          StringBuilder b = new StringBuilder();
          while(n>0){
            b.append(currString);
            n--;
          }
          currString = nextString.pop();
          currString = currString.append(b);
        }
        else if (c == '['){
          nextString.push(currString);
          currString =new StringBuilder();;
          nextNo.push(currNo);
          currNo=0;
        }
        else{
          currString= currString.append(c);
        }
      }
      return currString.toString() ;
    }
  }
